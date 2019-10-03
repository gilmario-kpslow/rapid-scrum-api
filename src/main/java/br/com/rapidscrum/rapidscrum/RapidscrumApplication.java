package br.com.rapidscrum.rapidscrum;

import java.io.IOException;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RapidscrumApplication extends SpringBootServletInitializer {

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

    @Bean
    CommandLineRunner init() {
        return args -> {
//            initUsers(userRepository, passwordEncoder);;
            //initProdutos(produtoRepository);
        };
    }

//    private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        Usuario admin = new Usuario();
//        admin.setEmail("admin@gmail.com");
//        admin.setPassword(passwordEncoder.encode("123456"));
//        admin.setProfile(ProfileEnum.ROLE_ADMIN);
//
//        Usuario find = userRepository.findByEmail("admin@gmail.com");
//        if (Objects.isNull(find)) {
//            userRepository.save(admin);
//        }
//    }
}
