package br.com.rapidscrum.rapidscrum.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "modulo")
public class Modulo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "modulo_generator"
	)
	@GenericGenerator(
		name = "modulo_generator",
		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters = {
			@Parameter(name = "sequence_name", value = "modulo_sequence"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"),
			@Parameter(name = "optmizer", value = "pooled-lo")
		}
	)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "sistema_id", referencedColumnName = "id")
	private Sistema sistema;

	public Modulo() {
		super();
	}

	public Modulo(Long id, String nome, String descricao, Sistema sistema) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modulo other = (Modulo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
