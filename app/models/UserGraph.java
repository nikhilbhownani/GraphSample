package models;


import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class UserGraph {

    @Index(unique = true)
    @Property(name = "qualificationId")
    public String userId;

    @Property(name = "name")
    public String name;

    public UserGraph(String name) {
        this.name = name;
    }
}
