package br.com.rapidscrum.core.generic;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 *
 * @author 008647c6
 */
public class QueryModel {

    private Integer pagina;
    private Integer limite;
    private String ordenacao;
    private Sort.Direction direcionamento;

    public QueryModel() {
    }

    public QueryModel(Map<String, String> queryMap) {
        this.pagina = Integer.parseInt(Optional.ofNullable(queryMap.get("pagina")).orElse("0"));
        this.limite = Integer.parseInt(Optional.ofNullable(queryMap.get("limite")).orElse(Integer.toString(Integer.MAX_VALUE)));
        this.ordenacao = queryMap.get("ordenacao");
        this.direcionamento = Sort.Direction.valueOf(Optional.ofNullable(queryMap.get("direcionamento")).orElse("ASC"));
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getLimite() {
        if (Objects.isNull(limite) || limite <= 0) {
            return Integer.MAX_VALUE;
        }
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public String getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
    }

    public Sort.Direction getDirecionamento() {
        return direcionamento;
    }

    public void setDirecionamento(Sort.Direction direcionamento) {
        this.direcionamento = direcionamento;
    }

    public PageRequest pageOf() {
        if (Objects.nonNull(ordenacao)) {
            return PageRequest.of(pagina, limite, direcionamento, ordenacao);
        }
        return PageRequest.of(pagina, limite);
    }

}
