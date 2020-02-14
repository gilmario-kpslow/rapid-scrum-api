package br.com.rapidscrum;

import br.com.rapidscrum.credencial.Credencial;
import br.com.rapidscrum.credencial.CredencialService;
import br.com.rapidscrum.seguranca.UsuarioDetalhes;
import br.com.rapidscrum.seguranca.UsuarioDetalhesService;
import br.com.rapidscrum.usuario.Usuario;
import br.com.rapidscrum.usuario.UsuarioService;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RapidscrumApplication implements ApplicationContextInitializer, ApplicationListener<ContextClosedEvent> {

    public static void main(String... args) throws Exception {
        String string = new BCryptPasswordEncoder(12).encode("123456789");

        SpringApplication app = new SpringApplication(RapidscrumApplication.class);
        app.addInitializers(new RapidscrumApplication());
        app.addListeners(new RapidscrumApplication());
        app.run(args);
    }

    @Bean
    CommandLineRunner init(UsuarioService service, PasswordEncoder passwordEncoder, CredencialService credencialService, UsuarioDetalhesService detalhesService) {
        return args -> {
            Optional<Boolean> existe = service.existsByUsername("rapidadmin");
            if (!existe.get()) {
                Usuario admin = new Usuario();
                admin.setEmail("admin@gmail.com");
                admin.setNome("Admin");
                admin.setUsername("rapidadmin");
                admin.setNomeCompleto("Usuario Administrador da Silva 350");

                service.salvar(admin);

                Credencial credencial = credencialService.create(admin, "123456789");

            }

        };
    }

    @Override
    public void initialize(ConfigurableApplicationContext c) {
        HSQLDBStarter.start();
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent e) {
        HSQLDBStarter.restart();
    }

}
