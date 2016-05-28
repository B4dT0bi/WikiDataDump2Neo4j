package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.EntityHelper;
import de.badtobi.wikidatadump2neo4j.helper.InstanceOf;
import de.badtobi.wikidatadump2neo4j.helper.LinkHelper;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class SkyscraperNodeCreator extends SimpleNameAndIdNodeCreator implements NodeCreator {

    public SkyscraperNodeCreator() {
        super(InstanceOf.SKYSCRAPER.getIntName());
    }

    public void createNode(WikiDataEntry entry, Session session) {
        super.createNode(entry, session);
        LinkHelper.linkNodes(entry, Properties.STRUCTURAL_ENGINEER, label, InstanceOf.HUMAN.getIntName(), "ENGINEERED_BY", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.COUNTRY, label, InstanceOf.COUNTRY.getIntName(), "LOCATED_AT", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.LOCATION, label, InstanceOf.CITY.getIntName(), "LOCATED_AT", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.ARCHITECTURAL_STYLE, label, InstanceOf.ARCHITECTURAL_STYLE.getIntName(), "BELONGS_TO", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.ARCHITECT, label, InstanceOf.HUMAN.getIntName(), "PLANNED_BY", LinkHelper.LinkDirection.RIGHT, session);

        if (LinkHelper.hasProperty(entry, Properties.DATE_OF_OFFICIAL_OPENING)) {
            String value = EntityHelper.getDate(entry, Properties.DATE_OF_OFFICIAL_OPENING);
            if (value != null) {
                addProperty(entry, "date_of_official_opening", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.FLOORS_ABOVE_GROUND)) {
            String value = EntityHelper.getDate(entry, Properties.FLOORS_ABOVE_GROUND);
            if (value != null) {
                addProperty(entry, "floors_above_ground", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.NUMBER_OF_ELEVATORS)) {
            String value = EntityHelper.getDate(entry, Properties.NUMBER_OF_ELEVATORS);
            if (value != null) {
                addProperty(entry, "number_of_elevators", value, session);
            }
        }

    }
}
