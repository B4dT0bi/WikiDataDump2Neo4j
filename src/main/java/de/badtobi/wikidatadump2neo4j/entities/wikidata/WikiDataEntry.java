
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class WikiDataEntry {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("labels")
    @Expose
    private Map<String, Label> labels = new HashMap<String, Label>();

    @SerializedName("descriptions")
    @Expose
    private Map<String, Description> descriptions = new HashMap<String, Description>();

    @SerializedName("aliases")
    @Expose
    private Map<String, List<Alias>> aliases = new HashMap<String, List<Alias>>();

    @SerializedName("claims")
    @Expose
    private Map<String, List<Claim>> claims = new HashMap<String, List<Claim>>();

    @SerializedName("sitelinks")
    @Expose
    private Map<String, SiteLink> sitelinks = new HashMap<String, SiteLink>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Label> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Label> labels) {
        this.labels = labels;
    }

    public Map<String, Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Map<String, Description> descriptions) {
        this.descriptions = descriptions;
    }

    public Map<String, List<Alias>> getAliases() {
        return aliases;
    }

    public void setAliases(Map<String, List<Alias>> aliases) {
        this.aliases = aliases;
    }

    public Map<String, List<Claim>> getClaims() {
        return claims;
    }

    public void setClaims(Map<String, List<Claim>> claims) {
        this.claims = claims;
    }

    public Map<String, SiteLink> getSitelinks() {
        return sitelinks;
    }

    public void setSitelinks(Map<String, SiteLink> sitelinks) {
        this.sitelinks = sitelinks;
    }

    @Override
    public String toString() {
        return "WikiDataEntry{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", labels=" + labels +
                ", descriptions=" + descriptions +
                ", aliases=" + aliases +
                ", claims=" + claims +
                ", sitelinks=" + sitelinks +
                '}';
    }
}
