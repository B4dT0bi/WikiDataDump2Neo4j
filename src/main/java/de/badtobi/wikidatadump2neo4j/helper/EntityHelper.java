package de.badtobi.wikidatadump2neo4j.helper;

import de.badtobi.wikidatadump2neo4j.entities.wikidata.Claim;
import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;

import java.util.*;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class EntityHelper {
    private static final String[] languagesToImport = {"en", "en-gb", "en-us"};

    public static String getLabel(WikiDataEntry entry) {
        for (String language : languagesToImport) {
            if (entry.getLabels().containsKey(language)) return entry.getLabels().get(language).getValue();
        }
        return null;
    }

    public static String getDescription(WikiDataEntry entry) {
        for (String language : languagesToImport) {
            if (entry.getDescriptions().containsKey(language)) return entry.getDescriptions().get(language).getValue();
        }
        return null;
    }

    public static String getDate(WikiDataEntry entry, String property) {
        List<Claim> claimList = entry.getClaims().get(property);
        String result = null;
        try {
            if (claimList != null && !claimList.isEmpty()) {
                Claim claim = claimList.get(0);
                if (claim.getMainsnak().getDatatype().equals("time")) {
                    Map<String, String> valueMap = (Map) claim.getMainsnak().getDatavalue().getValue();
                    result = ValueHelper.formatDate(valueMap.get("time"));
                }
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("npe on : " + claimList.get(0).getMainsnak());
            System.out.println("entity : " + entry);
        }
        return result;
    }

    public static String getQuantity(WikiDataEntry entry, String property) {
        List<Claim> claimList = entry.getClaims().get(property);
        String result = null;
        try {
            if (claimList != null && !claimList.isEmpty()) {
                Claim claim = claimList.get(0);
                if (claim.getMainsnak().getDatatype().equals("quantity")) {
                    Map<String, String> valueMap = (Map) claim.getMainsnak().getDatavalue().getValue();
                    result = valueMap.get("amount");
                }
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("npe on : " + claimList.get(0).getMainsnak());
            System.out.println("entity : " + entry);
        }
        return result;
    }

    public static Set<String> getLinkedIds(WikiDataEntry entry, String property) {
        Set<String> result = new HashSet<String>();
        try {
            for (Claim claim : entry.getClaims().get(property)) {
                if ("wikibase-item".equals(claim.getMainsnak().getDatatype())) {
                    Object o = claim.getMainsnak().getDatavalue().getValue();
                    if (o instanceof Map) {
                        Map<String, Object> valueMap = (Map) o;
                        if (valueMap.containsKey("entity-type")) {
                            if (((String) valueMap.get("entity-type")).equals("item")) {
                                String id = ((Double) valueMap.get("numeric-id")).toString();
                                if (id != null) {
                                    if (id.contains(".")) {
                                        result.add("Q" + id.split("\\.")[0]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException npe) {

        }
        return result;
    }
}
