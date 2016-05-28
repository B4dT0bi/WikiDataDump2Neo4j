
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Snaks {

    @Expose
    private List<Snak> snak = new ArrayList<Snak>();

    /**
     * 
     * @return
     *     The p143
     */
    public List<Snak> getSnak() {
        return snak;
    }

    /**
     * 
     * @param snak
     *     The P143
     */
    public void setSnak(List<Snak> snak) {
        this.snak = snak;
    }

}
