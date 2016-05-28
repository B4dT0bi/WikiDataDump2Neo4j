package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.*;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class FilmNodeCreator extends SimpleNameAndIdNodeCreator implements NodeCreator {

    public FilmNodeCreator() {
        super(InstanceOf.FILM.getIntName());
    }

    public void createNode(WikiDataEntry entry, Session session) {
        super.createNode(entry, session);
        if (LinkHelper.hasProperty(entry, Properties.DURATION)) {
            String value = EntityHelper.getQuantity(entry, Properties.DURATION);
            if (value != null) {
                addProperty(entry, "duration", value, session);
            }
        }
        if (LinkHelper.hasProperty(entry, Properties.PUBLICATION_DATE)) {
            String value = EntityHelper.getDate(entry, Properties.PUBLICATION_DATE);
            if (value != null) {
                addProperty(entry, "publication_date", value, session);
            }
        }
        LinkHelper.linkNodes(entry, Properties.DIRECTOR, label, "Person", "IS_DIRECTOR_OF", LinkHelper.LinkDirection.LEFT, session);
        LinkHelper.linkNodes(entry, Properties.SCREENWRITER, label, "Person", "IS_SCREENWRITER_OF", LinkHelper.LinkDirection.LEFT, session);
        LinkHelper.linkNodes(entry, Properties.PRODUCER, label, "Person", "IS_PRODUCER_OF", LinkHelper.LinkDirection.LEFT, session);
        LinkHelper.linkNodes(entry, Properties.CAST_MEMBER, label, "Person", "IS_CAST_MEMBER_OF", LinkHelper.LinkDirection.LEFT, session);
        LinkHelper.linkNodes(entry, Properties.COMPOSER, label, "Person", "IS_COMPOSER_OF", LinkHelper.LinkDirection.LEFT, session);
        LinkHelper.linkNodes(entry, Properties.COUNTRY_OF_ORIGIN, label, "Country", "ORIGINATES_IN", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.GENRE, label, "FilmGenre", "BELONGS_TO", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.FILMING_LOCATION, label, "City", "WAS_FILMED_AT", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.FILMING_LOCATION, label, "Country", "WAS_FILMED_AT", LinkHelper.LinkDirection.RIGHT, session);

    }
}
