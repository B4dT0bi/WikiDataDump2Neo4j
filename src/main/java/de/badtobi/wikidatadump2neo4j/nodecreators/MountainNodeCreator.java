package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.EntityHelper;
import de.badtobi.wikidatadump2neo4j.helper.InstanceOf;
import de.badtobi.wikidatadump2neo4j.helper.LinkHelper;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class MountainNodeCreator extends SimpleNameAndIdNodeCreator implements NodeCreator {

    public MountainNodeCreator() {
        super(InstanceOf.MOUNTAIN.getIntName());
    }

    public void createNode(WikiDataEntry entry, Session session) {
        super.createNode(entry, session);
        if (LinkHelper.hasProperty(entry, Properties.ELEVATION_ABOVE_SEA_LEVEL)) {
            String value = EntityHelper.getQuantity(entry, Properties.ELEVATION_ABOVE_SEA_LEVEL);
            if (value != null) {
                addProperty(entry, "elevation_above_sea_level", value, session);
            }
        }
        LinkHelper.linkNodes(entry, Properties.CONTINENT, label, InstanceOf.CONTINENT.getIntName(), "LOCATED_ON", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.COUNTRY, label, InstanceOf.COUNTRY.getIntName(), "LOCATED_IN", LinkHelper.LinkDirection.RIGHT, session);
    }
}
