package de.badtobi.wikidatadump2neo4j.helper;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.Claim;
import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import org.neo4j.driver.v1.Session;

import java.util.Map;
import java.util.Set;

/**
 * LinkHelper class can be used to easily verify if a WikiDataEntry has a specific link.
 *
 * @author Tobias Boese
 */
public class LinkHelper {
    public final static String PROPERTY_INSTANCE_OF = "P31";

    /**
     * Checks if the given Entry is an instance of Country.
     *
     * @param entry the WikiDataEntry
     * @return true if it is a Country
     */
    public static boolean isCountry(WikiDataEntry entry) {
        return hasLink(entry, PROPERTY_INSTANCE_OF, InstanceOf.COUNTRY.getIds());
    }

    public static boolean isHuman(WikiDataEntry entry) {
        return hasLink(entry, PROPERTY_INSTANCE_OF, InstanceOf.HUMAN.getIds());
    }

    public static boolean isCity(WikiDataEntry entry) {
        return hasLink(entry, PROPERTY_INSTANCE_OF, InstanceOf.CITY.getIds());
    }

    public static boolean isProfession(WikiDataEntry entry) {
        return hasLink(entry, PROPERTY_INSTANCE_OF, InstanceOf.PROFESSION.getIds());
    }

    public static InstanceOf getInstanceOf(WikiDataEntry entry) {
        if (!hasProperty(entry, PROPERTY_INSTANCE_OF)) return null;
        try {
            for (Claim claim : entry.getClaims().get(PROPERTY_INSTANCE_OF)) {
                if ("wikibase-item".equals(claim.getMainsnak().getDatatype())) {
                    Object o = claim.getMainsnak().getDatavalue().getValue();
                    if (o instanceof Map) {
                        Map<String, Object> valueMap = (Map) o;
                        if (valueMap.containsKey("entity-type")) {
                            if (((String) valueMap.get("entity-type")).equals("item")) {
                                String id = ((Double) valueMap.get("numeric-id")).toString();
                                if (id != null) {
                                    if (id.contains(".")) {
                                        id = "Q" + id.split("\\.")[0];
                                        InstanceOf result = InstanceOf.getById(id);
                                        if (result != null) return result;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException npe) {

        }
        return null;
    }

    /**
     * Checks a given WikiDataEntry if it has a specific property.
     *
     * @param entry the WikiDataEntry
     * @param prop  the Property id (e.g. "P31" for instance of)
     * @return true if the entry has this property
     */
    public static boolean hasProperty(WikiDataEntry entry, String prop) {
        return entry.getClaims().containsKey(prop);
    }

    public static boolean hasLink(WikiDataEntry entry, String prop, String[] ids) {
        for (String id : ids) {
            if (hasLink(entry, prop, id)) return true;
        }
        return false;
    }

    /**
     * Check the given entry if there is a link between entry --Prop--> id.
     *
     * @param entry the WikiDataEntry
     * @param prop  the Property of the link (e.g. P31 for "instance of")
     * @param id    the link target (e.g. Q6256 for a Country)
     * @return true if a link with a given Property and target could be found
     */
    public static boolean hasLink(WikiDataEntry entry, String prop, String id) {
        if (!hasProperty(entry, prop)) return false;
        try {
            String tmpId = id + ".0";
            for (Claim claim : entry.getClaims().get(prop)) {
                if ("wikibase-item".equals(claim.getMainsnak().getDatatype())) {
                    Object o = claim.getMainsnak().getDatavalue().getValue();
                    if (o instanceof Map) {
                        Map<String, Object> valueMap = (Map) o;
                        if (valueMap.containsKey("entity-type")) {
                            if (((String) valueMap.get("entity-type")).equals("item")) {
                                if (tmpId.equals("Q" + ((Double) valueMap.get("numeric-id")))) return true;
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException npe) {

        }
        return false;
    }

    public enum LinkDirection {
        LEFT,
        RIGHT,
        BOTH
    }

    public static void linkNodes(WikiDataEntry entry, String property, String nodeLeft, String nodeRight, String linkName, LinkDirection direction, Session session) {
        Set<String> nodeIds = EntityHelper.getLinkedIds(entry, property);
        for (String nodeId : nodeIds) {
            if (NodeHelper.nodeExists(nodeRight, nodeId, session)) {
                session.run("MATCH (p:" + nodeLeft + " {id:'" + entry.getId() + "'}), (g:" + nodeRight + " {id:'" + nodeId + "'}) MERGE (p)" + (direction == LinkDirection.RIGHT ? "" : "<") + "-[:" + linkName + "]-" + (direction == LinkDirection.LEFT ? "" : ">") + "(g)");
            }
        }
    }

}
