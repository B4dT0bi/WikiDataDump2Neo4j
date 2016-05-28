package de.badtobi.wikidatadump2neo4j.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by b4dt0bi on 29.05.16.
 */
public class UnitConverter {
    private static Map<String, String> unitMap = new HashMap<String, String>();

    static {
        unitMap.put("Q712226", " km²"); // square kilometre
        unitMap.put("Q828224", " km"); // kilometre
        unitMap.put("Q11573", " m"); // metre
        unitMap.put("Q7727", " minute");
        unitMap.put("Q4243638", " km³"); // cubic kilometre
    }

    public static String convert(String input) {
        if (input == null) return null;
        int qPos = input.lastIndexOf("Q");
        if (qPos > 0) {
            String tmp = unitMap.get(input.substring(qPos).trim());
            if (tmp != null) return tmp;
        }
        System.out.println("Unknown unit : " + input);
        return input;
    }
}
