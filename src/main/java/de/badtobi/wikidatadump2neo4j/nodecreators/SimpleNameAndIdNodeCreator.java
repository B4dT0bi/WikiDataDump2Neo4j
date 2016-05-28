package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.EntityHelper;
import de.badtobi.wikidatadump2neo4j.helper.ValueHelper;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class SimpleNameAndIdNodeCreator implements NodeCreator {
    protected String label;

    public SimpleNameAndIdNodeCreator(String label) {
        this.label = label;
    }

    public void createNode(WikiDataEntry entry, Session session) {
        String name = EntityHelper.getLabel(entry);
        if (name == null) return;

        session.run("MERGE (c:" + label + " {name:" + ValueHelper.escape(name) + ", " +
                "id:" + ValueHelper.escape(entry.getId()) + "}) RETURN c");
    }

    public void addProperty(WikiDataEntry entry, String propName, String propValue, Session session) {
        String name = EntityHelper.getLabel(entry);
        if (name == null) return;

        session.run("MATCH (c:" + label + " {name:" + ValueHelper.escape(name) + ", " +
                "id:" + ValueHelper.escape(entry.getId()) + "}) SET c." + propName + " = " + ValueHelper.escape(propValue) + " RETURN c");
    }
}
