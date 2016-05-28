package de.badtobi.wikidatadump2neo4j.helper;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class ValueHelper {
    public static String formatDate(String input) {
        if (input == null) return null;
        String result = input;
        if (result.startsWith("+")) result = result.substring(1);
        if (result.contains("T")) result = result.substring(0, result.indexOf("T"));
        return result;
    }

    public static String escape(String input) {
        if (input == null) return null;
        String result = input.replace("\\", "\\\\").replace("\'", "\\\'");
        return "'" + result + "'";
    }
}
