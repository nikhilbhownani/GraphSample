package factory;
import models.UserGraph;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import com.typesafe.config.ConfigFactory;

public class Neo4jSessionFactory {
    static Configuration configuration = new Configuration();
    static SessionFactory sessionFactory;
    static Neo4jSessionFactory factory = new Neo4jSessionFactory();
    public static Neo4jSessionFactory getInstance() {
        String boltUri = ConfigFactory.load().getString("neo4j.bolt.uri");
        String boltEncryption = ConfigFactory.load().getString("neo4j.bolt.encryption");
        configuration.driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.bolt.driver.BoltDriver")
                .setURI(boltUri)
                .setEncryptionLevel(boltEncryption);
        
        sessionFactory = new SessionFactory(configuration, "models");

        return factory;
    }

    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}
