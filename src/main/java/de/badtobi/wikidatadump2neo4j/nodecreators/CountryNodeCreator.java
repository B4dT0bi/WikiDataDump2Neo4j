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
        if (LinkHelper.hasProperty(entry, Properties.PUBLICATION_DATE)) {
            String value = EntityHelper.getDate(entry, Properties.PUBLICATION_DATE);
            if (value != null) {
                addProperty(entry, "publication_date", value, session);
            }
        }
        LinkHelper.linkNodes(entry, Properties.ANTHEM, label, InstanceOf.MUSIC_SONG.getIntName(), "HAS_ANTHEM", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.CURRENCY, label, "Person", "WRITTEN_BY", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.PRODUCER, label, "Person", "PRODUCED_BY", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.CAST_MEMBER, label, "Person", "HAS_CAST_MEMBER_OF", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.COMPOSER, label, "Person", "IS_COMPOSER_OF", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.COUNTRY_OF_ORIGIN, label, "Country", "ORIGINATES_IN", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.GENRE, label, "FilmGenre", "BELONGS_TO", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.FILMING_LOCATION, label, "City", "WAS_FILMED_AT", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.FILMING_LOCATION, label, "Country", "WAS_FILMED_AT", LinkHelper.LinkDirection.RIGHT, session);

    }
}
