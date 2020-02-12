package br.com.rapidscrum;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;

/**
 *
 * @author gilmario
 */
public class HSQLDBStarter {

    private static Server server;

    public static void start() {
        HsqlProperties p = new HsqlProperties();
        p.setProperty("server.database.0", "file:db/rapidscrumdb");
        p.setProperty("server.dbname.0", "rapidscrumdb");
        server = new Server();
        try {
            server.setProperties(p);
        } catch (IOException ex) {
            Logger.getLogger(HSQLDBStarter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServerAcl.AclFormatException ex) {
            Logger.getLogger(HSQLDBStarter.class.getName()).log(Level.SEVERE, null, ex);
        }
        server.start();
    }
}
