package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.EntityHelper;
import de.badtobi.wikidatadump2neo4j.helper.InstanceOf;
import de.badtobi.wikidatadump2neo4j.helper.LinkHelper;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class SeaOrLakeNodeCreator extends SimpleNameAndIdNodeCreator implements NodeCreator {

    public SeaOrLakeNodeCreator(InstanceOf instanceOf) {
        super(instanceOf.getIntName());
    }

    public void createNode(WikiDataEntry entry, Session session) {
        super.createNode(entry, session);
        LinkHelper.linkNodes(entry, Properties.BASIN_COUNTRY, label, InstanceOf.COUNTRY.getIntName(), "BASIN_COUNTRY", LinkHelper.LinkDirection.RIGHT, session);
        if (LinkHelper.hasProperty(entry, Properties.LENGTH)) {
            String value = EntityHelper.getQuantity(entry, Properties.LENGTH);
            if (value != null) {
                addProperty(entry, "length", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.WIDTH)) {
            String value = EntityHelper.getQuantity(entry, Properties.WIDTH);
            if (value != null) {
                addProperty(entry, "width", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.PERIMETER)) {
            String value = EntityHelper.getQuantity(entry, Properties.PERIMETER);
            if (value != null) {
                addProperty(entry, "perimeter", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.AREA)) {
            String value = EntityHelper.getQuantity(entry, Properties.AREA);
            if (value != null) {
                addProperty(entry, "area", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.VOLUME_AS_QUANTITY)) {
            String value = EntityHelper.getQuantity(entry, Properties.VOLUME_AS_QUANTITY);
            if (value != null) {
                addProperty(entry, "volume", value, session);
            }
        }

    }
}
