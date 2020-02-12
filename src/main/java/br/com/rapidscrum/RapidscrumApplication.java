package br.com.rapidscrum;

import br.com.rapidscrum.usuario.Usuario;
import br.com.rapidscrum.usuario.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RapidscrumApplication implements ApplicationContextInitializer {

    public static void main(String... args) throws Exception {
        SpringApplication app = new SpringApplication(RapidscrumApplication.class);
        app.addInitializers(new RapidscrumApplication());
        app.run(args);
    }

    @Bean
    CommandLineRunner init(UsuarioService service) {
        return args -> {
            Usuario admin = new Usuario();
            admin.setEmail("admin@gmail.com");
            admin.setNome("Admin");
            admin.setUsername("Admin");
            admin.setNomeCompleto("Usuario Administrador da Silva");
        };
    }

    @Override
    public void initialize(ConfigurableApplicationContext c) {
        HSQLDBStarter.start();
    }

}
