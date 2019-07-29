package br.com.rapidscrum.rapidscrum;

import java.io.IOException;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RapidscrumApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(RapidscrumApplication.class, args);
    }

    private void iniciandoDb() throws IOException, ServerAcl.AclFormatException {
        HsqlProperties p = new HsqlProperties();
        p.setProperty("server.database.0", "file:rapiddb");
        p.setProperty("server.dbname.0", "rapiddb");
        // set up the rest of properties

        // alternative to the above is
        Server server = new Server();
        server.setProperties(p);
        server.setLogWriter(null); // can use custom writer
        server.setErrWriter(null); // can use custom writer
        server.start();
    }

}
