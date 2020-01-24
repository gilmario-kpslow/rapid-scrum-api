package br.com.rapidscrum;

import java.io.IOException;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

//@EnableAuthorizationServer
@SpringBootApplication
public class RapidscrumApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RapidscrumApplication.class);
    }

    private static void iniciandoDb() throws IOException, ServerAcl.AclFormatException {
        System.out.println("INiciando BANCO DE DADOS");
        HsqlProperties p = new HsqlProperties();
        p.setProperty("server.database.0", "file:db/rapidscrumdb");
        p.setProperty("server.dbname.0", "rapidscrumdb");

        p.setProperty(".html", "text/html");

        // set up the rest of properties
        // alternative to the above is
        Server server = new Server();
        server.setProperties(p);
        server.setWebRoot("/");
        server.setSilent(true);
        server.setPort(9001);
        server.start();
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
            //new RapidscrumApplication().iniciandoDb();
            System.out.println("OK-------------------------------");
//              initUsers(userRepository, passwordEncoder);;
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
