
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class SiteLink {

    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("badges")
    @Expose
    private List<Object> badges = new ArrayList<Object>();

    /**
     * @return The site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site The site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The badges
     */
    public List<Object> getBadges() {
        return badges;
    }

    /**
     * @param badges The badges
     */
    public void setBadges(List<Object> badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return "SiteLink{" +
                "site='" + site + '\'' +
                ", title='" + title + '\'' +
                ", badges=" + badges +
                '}';
    }
}
