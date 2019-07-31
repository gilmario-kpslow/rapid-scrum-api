package br.com.rapidscrum.rapidscrum;

import java.io.IOException;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RapidscrumApplication {

    public static void main(String[] args) throws Exception {
        System.setProperty("spring.devtools.restart.enabled", "true");
        new RapidscrumApplication().iniciandoDb();
        SpringApplication.run(RapidscrumApplication.class, args);
    }

    private void iniciandoDb() throws IOException, ServerAcl.AclFormatException {
        HsqlProperties p = new HsqlProperties();
        p.setProperty("server.database.0", "file:db/rapidscrumdb");
        p.setProperty("server.dbname.0", "rapidscrumdb");
        // set up the rest of properties

        // alternative to the above is
        Server server = new Server();
        server.setProperties(p);
        server.setLogWriter(null); // can use custom writer
        server.setErrWriter(null); // can use custom writer
        server.start();
    }

}
