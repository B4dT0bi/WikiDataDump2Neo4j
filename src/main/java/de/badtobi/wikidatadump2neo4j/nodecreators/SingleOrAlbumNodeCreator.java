package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.EntityHelper;
import de.badtobi.wikidatadump2neo4j.helper.InstanceOf;
import de.badtobi.wikidatadump2neo4j.helper.LinkHelper;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class SingleOrAlbumNodeCreator extends SimpleNameAndIdNodeCreator implements NodeCreator {

    public SingleOrAlbumNodeCreator(String label) {
        super(label);
    }

    public void createNode(WikiDataEntry entry, Session session) {
        super.createNode(entry, session);
        LinkHelper.linkNodes(entry, Properties.PERFORMER, label, InstanceOf.MUSIC_BAND.getIntName(), "PERFORMED_BY", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.PERFORMER, label, InstanceOf.HUMAN.getIntName(), "PERFORMED_BY", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.GENRE, label, InstanceOf.MUSIC_GENRE.getIntName(), "BELONGS_TO", LinkHelper.LinkDirection.RIGHT, session);

        if (LinkHelper.hasProperty(entry, Properties.PUBLICATION_DATE)) {
            String value = EntityHelper.getDate(entry, Properties.PUBLICATION_DATE);
            if (value != null) {
                addProperty(entry, "publication_date", value, session);
            }
        }

    }
}
