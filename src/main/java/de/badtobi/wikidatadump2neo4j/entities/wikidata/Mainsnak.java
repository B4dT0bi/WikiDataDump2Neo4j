
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Mainsnak {

    @SerializedName("snaktype")
    @Expose
    private String snaktype;
    @SerializedName("property")
    @Expose
    private String property;
    @SerializedName("datavalue")
    @Expose
    private Datavalue datavalue;
    @SerializedName("datatype")
    @Expose
    private String datatype;

    /**
     * @return The snaktype
     */
    public String getSnaktype() {
        return snaktype;
    }

    /**
     * @param snaktype The snaktype
     */
    public void setSnaktype(String snaktype) {
        this.snaktype = snaktype;
    }

    /**
     * @return The property
     */
    public String getProperty() {
        return property;
    }

    /**
     * @param property The property
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @return The datavalue
     */
    public Datavalue getDatavalue() {
        return datavalue;
    }

    /**
     * @param datavalue The datavalue
     */
    public void setDatavalue(Datavalue datavalue) {
        this.datavalue = datavalue;
    }

    /**
     * @return The datatype
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * @param datatype The datatype
     */
    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    @Override
    public String toString() {
        return "Mainsnak{" +
                "snaktype='" + snaktype + '\'' +
                ", property='" + property + '\'' +
                ", datavalue=" + datavalue +
                ", datatype='" + datatype + '\'' +
                '}';
    }
}
