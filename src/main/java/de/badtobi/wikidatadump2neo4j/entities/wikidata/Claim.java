
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Claim {

    @SerializedName("mainsnak")
    @Expose
    private Mainsnak mainsnak;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("rank")
    @Expose
    private String rank;

    /**
     * @return The mainsnak
     */
    public Mainsnak getMainsnak() {
        return mainsnak;
    }

    /**
     * @param mainsnak The mainsnak
     */
    public void setMainsnak(Mainsnak mainsnak) {
        this.mainsnak = mainsnak;
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

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank The rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "mainsnak=" + mainsnak +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
