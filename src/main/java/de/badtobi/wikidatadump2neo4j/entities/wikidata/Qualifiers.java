
package de.badtobi.wikidatadump2neo4j.entities.wikidata;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Qualifiers {

    @Expose
    private List<Qualifier> qualifier = new ArrayList<Qualifier>();

    /**
     * @return The p304
     */
    public List<Qualifier> getQualifier() {
        return qualifier;
    }

    /**
     * @param qualifier The P304
     */
    public void setQualifier(List<Qualifier> qualifier) {
        this.qualifier = qualifier;
    }

    @Override
    public String toString() {
        return "Qualifiers{" +
                "qualifier=" + qualifier +
                '}';
    }
}
