package br.com.rapidscrum.healt;

import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gilmario
 */
@RestController
@RequestMapping
public class VersaoController {

    private Versao versao;

    public VersaoController(BuildProperties properties) {
        versao = new Versao();
        versao.setNome(properties.getName());
        versao.setArtefato(properties.getArtifact());
        versao.setGrupo(properties.getGroup());
        versao.setVersao(properties.getVersion());
        versao.setDataBuild(LocalDateTime.ofInstant(properties.getTime(), ZoneId.systemDefault()));
    }

    @GetMapping(value = {"", "healt", "status", "versao"})
    public Versao getInfo() {
        return versao;
    }

}
