package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.EntityHelper;
import de.badtobi.wikidatadump2neo4j.helper.InstanceOf;
import de.badtobi.wikidatadump2neo4j.helper.LinkHelper;
import de.badtobi.wikidatadump2neo4j.helper.ValueHelper;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class FictionalPersonNodeCreator implements NodeCreator {

    private final static String label = InstanceOf.FICTIONAL_HUMAN.getIntName();

    public void createNode(WikiDataEntry entry, Session session) {
        String name = EntityHelper.getLabel(entry);
        if (name == null) return; // do not add non english names
        session.run("MERGE (p:" + label + " {name:" + ValueHelper.escape(name) + ", " +
                "id:" + ValueHelper.escape(entry.getId()) + "}) RETURN p");

        LinkHelper.linkNodes(entry, Properties.GENDER, label, "Gender", "HAS_GENDER", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.FATHER, label, label, "IS_CHILD", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.MOTHER, label, label, "IS_CHILD", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.CHILD, label, label, "HAS_CHILD", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.SISTER, label, label, "HAS_SISTER", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.BROTHER, label, label, "HAS_BROTHER", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.SPOUSE, label, label, "IS_SPOUSE", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.PROFESSION, label, "Profession", "WORKS_AS", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.PLACE_OF_BIRTH, label, "City", "BORN_IN", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.PLACE_OF_BIRTH, label, "Country", "BORN_IN", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.COUNTRY_OF_CITIZENSHIP, label, "Country", "CITIZEN_OF", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.NATIVE_LANGUAGE, label, "Language", "NATIVE_LANGUAGE", LinkHelper.LinkDirection.RIGHT, session);
    }
}
