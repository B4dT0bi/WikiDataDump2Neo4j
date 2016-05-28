package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.EntityHelper;
import de.badtobi.wikidatadump2neo4j.helper.InstanceOf;
import de.badtobi.wikidatadump2neo4j.helper.LinkHelper;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class RiverNodeCreator extends SimpleNameAndIdNodeCreator implements NodeCreator {

    public RiverNodeCreator() {
        super(InstanceOf.RIVER.getIntName());
    }

    public void createNode(WikiDataEntry entry, Session session) {
        super.createNode(entry, session);
        if (LinkHelper.hasProperty(entry, Properties.LENGTH)) {
            String value = EntityHelper.getQuantity(entry, Properties.LENGTH);
            if (value != null) {
                addProperty(entry, "length", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.DISCHARGE)) {
            String value = EntityHelper.getQuantity(entry, Properties.DISCHARGE);
            if (value != null) {
                addProperty(entry, "discharge", value, session);
            }
        }
        LinkHelper.linkNodes(entry, Properties.CONTINENT, label, InstanceOf.CONTINENT.getIntName(), "LOCATED_ON", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.COUNTRY, label, InstanceOf.COUNTRY.getIntName(), "LOCATED_IN", LinkHelper.LinkDirection.RIGHT, session);

    }
}
