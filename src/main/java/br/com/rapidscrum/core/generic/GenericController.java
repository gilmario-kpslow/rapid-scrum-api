/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.core.generic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gilmario
 * @param <E>
 * @param <R>
 * @param <S>
 */
public abstract class GenericController<E extends GenericEntity, R extends JpaRepository<E, Long>, S extends GenericService<E, R>> {

    @Autowired
    protected S service;

    public S getService() {
        return service;
    }

    @PostMapping
    public E salvar(@RequestBody E e) {
        return this.service.salvar(e);
    }

    @PutMapping
    public E atualizar(@RequestBody E e) {
        return this.service.salvar(e);
    }

    @GetMapping
    public List<E> listar() {
        return this.service.listar();
    }

    @GetMapping(value = "ordenado")
    public List<E> listar(@RequestParam(value = "ordem") String ordem) {
        return this.service.listar(stringToSort(ordem));
    }

    @GetMapping(path = "{id}")
    public E encontrarPor(@PathVariable Long id) {
        return this.service.encontrarPor(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id) {
        this.service.deleteById(id);
    }

    private Sort stringToSort(String ordenacao) {
        String[] lista = ordenacao.split("\\,");
        List<Sort.Order> c = Arrays.asList(lista).stream()
                .filter(s -> s.trim().length() > 0)
                .map(s -> Sort.Order.asc(s)).collect(Collectors.toList());
        return Sort.by(c);
    }
}
