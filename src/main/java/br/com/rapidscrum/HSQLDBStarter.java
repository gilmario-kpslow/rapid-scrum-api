/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;

/**
 *
 * @author gilmario
 */
public class HSQLDBStarter {

    public static void main(String[] args) throws Exception {

        HsqlProperties p = new HsqlProperties();
        p.setProperty("server.database.0", "file:db/rapidscrumdb");
        p.setProperty("server.dbname.0", "rapidscrumdb");
        // set up the rest of properties

        // alternative to the above is
        Server server = new Server();
        server.setProperties(p);
        server.start();

    }
//server.setLogWriter(null); // can use custom writer
// server.setErrWriter(null); // can use custom writer

}
