
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Reference {

    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("snaks")
    @Expose
    private Snaks snaks;
    @SerializedName("snaks-order")
    @Expose
    private List<String> snaksOrder = new ArrayList<String>();

    /**
     * 
     * @return
     *     The hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * 
     * @param hash
     *     The hash
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * 
     * @return
     *     The snaks
     */
    public Snaks getSnaks() {
        return snaks;
    }

    /**
     * 
     * @param snaks
     *     The snaks
     */
    public void setSnaks(Snaks snaks) {
        this.snaks = snaks;
    }

    /**
     * 
     * @return
     *     The snaksOrder
     */
    public List<String> getSnaksOrder() {
        return snaksOrder;
    }

    /**
     * 
     * @param snaksOrder
     *     The snaks-order
     */
    public void setSnaksOrder(List<String> snaksOrder) {
        this.snaksOrder = snaksOrder;
    }

}
