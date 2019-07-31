/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum.core.generic;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gilmario
 * @param <T>
 */
public interface GenericRepository<T extends GenericEntity> extends JpaRepository<T, Long> {

}
