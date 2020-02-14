package br.com.rapidscrum.credencial;

import br.com.rapidscrum.usuario.Usuario;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author gilmario
 */
@Service
public class CredencialService {

    @Autowired
    private CredencialRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Credencial create(Usuario usuario, String password) {
        Credencial credencial = new Credencial();
        credencial.setAtivo(true);
        credencial.setUsuario(usuario);
        credencial.setValidadeSenha(LocalDateTime.now().plusDays(30));
        credencial.setPassword(passwordEncoder.encode(password));
        repository.save(credencial);
        return credencial;
    }

}
