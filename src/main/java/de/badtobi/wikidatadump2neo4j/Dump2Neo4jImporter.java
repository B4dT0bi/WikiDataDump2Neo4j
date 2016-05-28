package de.badtobi.wikidatadump2neo4j;

import de.badtobi.jsondumpreader.reader.CompressedDumpIterator;
import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.InstanceOf;
import de.badtobi.wikidatadump2neo4j.helper.LinkHelper;
import org.apache.commons.compress.compressors.CompressorException;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * Reads a wikidata dump and convert JSON String to Java Object and saving Data into Neo4j Database.
 *
 * @author Tobias Boese
 */
public class Dump2Neo4jImporter {


    public static void main(String[] args) throws FileNotFoundException, CompressorException {
        if (args.length < 3) {
            System.out.println("arguments : dumpfile neo4jUser neo4jPassword");
            System.exit(4);
        }
        Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic(args[1], args[2]));

        NodeCreatorFactory nodeCreatorFactory = new NodeCreatorFactory();

        Iterator<WikiDataEntry> iterator = new CompressedDumpIterator<WikiDataEntry>(args[0], WikiDataEntry.class);
        while (iterator.hasNext()) {
            WikiDataEntry entry = iterator.next();
            InstanceOf instanceOf = LinkHelper.getInstanceOf(entry);
            if (instanceOf != null) {
                Session session = driver.session();
                //System.out.println("Found " + instanceOf + " : " + EntityHelper.getLabel(entry));
                nodeCreatorFactory.createNode(entry, session, instanceOf);
                session.close();
            }
        }
        driver.close();
    }

}
