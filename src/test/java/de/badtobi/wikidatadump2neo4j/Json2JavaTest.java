package de.badtobi.wikidatadump2neo4j;

import com.google.gson.Gson;
import de.badtobi.jsondumpreader.DumpReader;
import de.badtobi.jsondumpreader.DumpReaderFactory;
import de.badtobi.wikidatadump2neo4j.entities.wikidata.WikiDataEntry;
import org.junit.Test;

/**
 * Created by b4dt0bi on 25.05.16.
 */
public class Json2JavaTest {
    @Test
    public void testJson2Java() {
        DumpReader dumpReader = DumpReaderFactory.getUncompressedDumpReader(getClass().getResourceAsStream("wikidatadumpsample.json"));
        Gson gson = new Gson();
        dumpReader.nextJsonLine();
        String jsonString = dumpReader.nextJsonLine();
        jsonString = jsonString.substring(0, jsonString.length() - 1);
        WikiDataEntry wikiDataEntry = gson.fromJson(jsonString, WikiDataEntry.class);
        System.out.println(wikiDataEntry.toString());
    }
}
