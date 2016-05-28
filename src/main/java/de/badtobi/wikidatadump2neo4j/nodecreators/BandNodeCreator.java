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
public class BandNodeCreator extends SimpleNameAndIdNodeCreator implements NodeCreator {

    public BandNodeCreator() {
        super(InstanceOf.MUSIC_BAND.getIntName());
    }

    public void createNode(WikiDataEntry entry, Session session) {
        super.createNode(entry,session);
        LinkHelper.linkNodes(entry, Properties.HAS_PART, label, InstanceOf.HUMAN.getIntName(), "HAS_MEMBER", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.HAS_PART, label, InstanceOf.HUMAN.getIntName(), "IS_MEMBER", LinkHelper.LinkDirection.LEFT, session);
        LinkHelper.linkNodes(entry, Properties.GENRE, label, InstanceOf.MUSIC_GENRE.getIntName(), "BELONGS_TO", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.COUNTRY_OF_ORIGIN, label, InstanceOf.COUNTRY.getIntName(), "ORIGINATES_IN", LinkHelper.LinkDirection.RIGHT, session);
        if (LinkHelper.hasProperty(entry, Properties.INCEPTION)) {
            String value = EntityHelper.getDate(entry, Properties.INCEPTION);
            if (value != null) {
                addProperty(entry, "founded", value, session);
            }
        }

    }
}
