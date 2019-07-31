/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum.core.generic;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

/**
 *
 * @author gilmario
 * @param <E>
 * @param <R>
 */
public abstract class GenericService<E extends GenericEntity, R extends GenericRepository<E>> {

    @Autowired
    protected R repository;

    public E salvar(E e) {
        return this.repository.save(e);
    }

    public void deletar(E e) {
        this.repository.delete(e);
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public List<E> listar() {
        return this.repository.findAll();
    }

    public List<E> listar(Sort sort) {
        return this.repository.findAll(sort);
    }

    public Optional<E> encontrarPor(Long id) {
        return this.repository.findById(id);
    }

}
