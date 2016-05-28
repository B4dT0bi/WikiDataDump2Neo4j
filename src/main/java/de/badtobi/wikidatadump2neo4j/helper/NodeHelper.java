package de.badtobi.wikidatadump2neo4j.helper;

import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 * Created by b4dt0bi on 27.05.16.
 */
public class NodeHelper {
    public static boolean nodeExists(String node, String id, Session session) {
        StatementResult result = session.run("MATCH (a:" + node + ") WHERE a.id = '" + id + "' RETURN a.name AS name");

        return result.hasNext();
    }
}
