package br.com.rapidscrum;

import br.com.rapidscrum.credencial.Credencial;
import br.com.rapidscrum.credencial.CredencialService;
import br.com.rapidscrum.seguranca.UsuarioDetalhesService;
import br.com.rapidscrum.usuario.Usuario;
import br.com.rapidscrum.usuario.UsuarioService;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RapidscrumApplication {

    public static void main(String... args) throws Exception {
        SpringApplication.run(RapidscrumApplication.class, args);
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

}
