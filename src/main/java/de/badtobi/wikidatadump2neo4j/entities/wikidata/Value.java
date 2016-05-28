
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Value {

    @SerializedName("entity-type")
    @Expose
    private String entityType;
    @SerializedName("numeric-id")
    @Expose
    private Integer numericId;

    /**
     * 
     * @return
     *     The entityType
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * 
     * @param entityType
     *     The entity-type
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * 
     * @return
     *     The numericId
     */
    public Integer getNumericId() {
        return numericId;
    }

    /**
     * 
     * @param numericId
     *     The numeric-id
     */
    public void setNumericId(Integer numericId) {
        this.numericId = numericId;
    }

}
