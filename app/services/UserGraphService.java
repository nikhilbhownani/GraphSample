package services;


import factory.Neo4jSessionFactory;
import models.UserGraph;
import org.neo4j.ogm.session.Session;

public class UserGraphService {
    protected Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();
    private static UserGraphService userGraphService;

    public static UserGraphService getSharedInstance() {
        if (userGraphService == null) {
            userGraphService = new UserGraphService();
        }
        return userGraphService;
    }
    public Iterable<UserGraph> findAll() {
        return session.loadAll(UserGraph.class, 1);
    }

    public UserGraph find(Long id) {
        return session.load(UserGraph.class, id, 1);
    }


    public UserGraph createOrUpdate(UserGraph entity) {
        session.save(entity);
        return find(Long.parseLong(entity.userId));
    }

}
