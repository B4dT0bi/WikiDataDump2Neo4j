package de.badtobi.wikidatadump2neo4j.nodecreators;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import org.neo4j.driver.v1.Session;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public interface NodeCreator {
    void createNode(WikiDataEntry entry, Session session);
}
