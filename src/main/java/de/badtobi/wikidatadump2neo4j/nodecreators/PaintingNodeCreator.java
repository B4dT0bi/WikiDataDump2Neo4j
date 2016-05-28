package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import de.badtobi.wikidatadump2neo4j.helper.EntityHelper;
import de.badtobi.wikidatadump2neo4j.helper.InstanceOf;
import de.badtobi.wikidatadump2neo4j.helper.LinkHelper;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class PaintingNodeCreator extends SimpleNameAndIdNodeCreator implements NodeCreator {

    public PaintingNodeCreator() {
        super(InstanceOf.PAINTING.getIntName());
    }

    public void createNode(WikiDataEntry entry, Session session) {
        super.createNode(entry, session);
        LinkHelper.linkNodes(entry, Properties.CREATOR, label, InstanceOf.HUMAN.getIntName(), "CREATED_BY", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.COUNTRY_OF_ORIGIN, label, InstanceOf.COUNTRY.getIntName(), "ORIGINATES_IN", LinkHelper.LinkDirection.RIGHT, session);
        LinkHelper.linkNodes(entry, Properties.GENRE, label, InstanceOf.PAINTING_GENRE.getIntName(), "BELONGS_TO", LinkHelper.LinkDirection.RIGHT, session);

        if (LinkHelper.hasProperty(entry, Properties.INCEPTION)) {
            String value = EntityHelper.getDate(entry, Properties.INCEPTION);
            if (value != null) {
                addProperty(entry, "created_on", value, session);
            }
        }

    }
}
