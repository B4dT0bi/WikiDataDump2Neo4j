
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import de.badtobi.wikidatadump2neo4j.entities.wikidata.Datavalue;

@Generated("org.jsonschema2pojo")
public class Qualifier {

    @SerializedName("snaktype")
    @Expose
    private String snaktype;
    @SerializedName("property")
    @Expose
    private String property;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("datavalue")
    @Expose
    private Datavalue datavalue;
    @SerializedName("datatype")
    @Expose
    private String datatype;

    /**
     * 
     * @return
     *     The snaktype
     */
    public String getSnaktype() {
        return snaktype;
    }

    /**
     * 
     * @param snaktype
     *     The snaktype
     */
    public void setSnaktype(String snaktype) {
        this.snaktype = snaktype;
    }

    /**
     * 
     * @return
     *     The property
     */
    public String getProperty() {
        return property;
    }

    /**
     * 
     * @param property
     *     The property
     */
    public void setProperty(String property) {
        this.property = property;
    }

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
     *     The datavalue
     */
    public Datavalue getDatavalue() {
        return datavalue;
    }

    /**
     * 
     * @param datavalue
     *     The datavalue
     */
    public void setDatavalue(Datavalue datavalue) {
        this.datavalue = datavalue;
    }

    /**
     * 
     * @return
     *     The datatype
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * 
     * @param datatype
     *     The datatype
     */
    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

}
