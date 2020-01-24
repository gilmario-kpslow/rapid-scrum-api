package br.com.rapidscrum.core.generic;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gilmario
 * @param <E>
 * @param <R>
 */
public abstract class GenericService<E extends GenericEntity, R extends JpaRepository<E, Long>> {

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

    public Page<E> listar(Map<String, String> queryParam) throws Exception {
        QueryModel query = new QueryModel(queryParam);
        E model = GenericUtils.queryParaModel(queryParam, GenericUtils.getClassModel(this.getClass()));
        Example<E> example = Example.of(model, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        PageRequest page = PageRequest.of(query.getPagina(), query.getLimite(), query.getDirecionamento(), query.getOrdenacao());
        return this.repository.findAll(example, page);
    }

    public Optional<E> encontrarPor(Long id) {
        return this.repository.findById(id);
    }

}
