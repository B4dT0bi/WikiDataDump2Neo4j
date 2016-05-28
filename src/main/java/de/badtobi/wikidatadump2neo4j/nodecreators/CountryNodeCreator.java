package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.EntityHelper;
import de.badtobi.wikidatadump2neo4j.helper.InstanceOf;
import de.badtobi.wikidatadump2neo4j.helper.LinkHelper;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class CountryNodeCreator extends SimpleNameAndIdNodeCreator implements NodeCreator {

    public CountryNodeCreator() {
        super(InstanceOf.COUNTRY.getIntName());
    }

    public void createNode(WikiDataEntry entry, Session session) {
        super.createNode(entry, session);
        if (LinkHelper.hasProperty(entry, Properties.COUNTRY_CALLING_CODE)) {
            String value = EntityHelper.getString(entry, Properties.COUNTRY_CALLING_CODE);
            if (value != null) {
                addProperty(entry, "calling_code", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.LICENSE_PLATE)) {
            String value = EntityHelper.getString(entry, Properties.LICENSE_PLATE);
            if (value != null) {
                addProperty(entry, "license_plate", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.INCEPTION)) {
            String value = EntityHelper.getDate(entry, Properties.INCEPTION);
            if (value != null) {
                addProperty(entry, "inception", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.AREA)) {
            String value = EntityHelper.getQuantity(entry, Properties.AREA);
            if (value != null) {
                addProperty(entry, "area", value, session);
            }
        }
        LinkHelper.linkNodes(entry, Properties.ANTHEM, label, InstanceOf.MUSIC_SONG.getIntName(), "HAS_ANTHEM", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.CURRENCY, label, InstanceOf.CURRENCY.getIntName(), "HAS_CURRENCY", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.SHARES_BORDER_WITH, label, InstanceOf.COUNTRY.getIntName(), "SHARES_BOARDER_WITH", LinkHelper.LinkDirection.BOTH, session);
        LinkHelper.linkNodes(entry, Properties.CONTINENT, label, InstanceOf.CONTINENT.getIntName(), "LOCATED_ON", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.HEAD_OF_STATE, label, "Person", "IS_HEAD_OF_STATE", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.HEAD_OF_GOVERNMENT, label, "Country", "IS_HEAD_OF_GOVERNMENT", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.CAPITAL, label, InstanceOf.CITY.getIntName(), "IS_CAPITAL_OF", LinkHelper.LinkDirection.LEFT, session);
        LinkHelper.linkNodes(entry, Properties.FILMING_LOCATION, label, "City", "WAS_FILMED_AT", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.FILMING_LOCATION, label, "Country", "WAS_FILMED_AT", LinkHelper.LinkDirection.RIGHT, session);

    }
}
