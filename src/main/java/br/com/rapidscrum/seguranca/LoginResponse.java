package br.com.rapidscrum.seguranca;

/**
 *
 * @author gilmario
 */
public class LoginResponse {

    private final String token;

    private final String nome;

    public LoginResponse(String token, String nome) {
        this.token = token;
        this.nome = nome;
    }

    public String getToken() {
        return token;
    }

    public String getNome() {
        return nome;
    }

}
