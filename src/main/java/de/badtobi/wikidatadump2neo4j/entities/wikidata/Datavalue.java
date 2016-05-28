
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Datavalue {

    @SerializedName("value")
    @Expose
    private Object value; // TODO : value needs to be dynamic (example : "datavalue":{"value":{"entity-type":"item","numeric-id":323},"type":"wikibase-entityid"})
    @SerializedName("type")
    @Expose
    private String type;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Datavalue{" +
//                "value='" + value + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
