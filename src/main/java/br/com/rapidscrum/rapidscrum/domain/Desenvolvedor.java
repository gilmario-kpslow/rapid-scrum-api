package br.com.rapidscrum.rapidscrum.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "desenvolvedor")
public class Desenvolvedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "desenvolvedor_generator"
	)
	@GenericGenerator(
		name = "desenvolvedor_generator",
		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters = {
			@Parameter(name = "sequence_name", value = "desenvolvedor_sequence"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"),
			@Parameter(name = "optmizer", value = "pooled-lo")
		}
	)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "nickname", nullable = false, length = 20)
	private String nickname;
	
	@Column(name = "email", nullable = false, length = 30)
	private String email;

	public Desenvolvedor() {
		super();
	}

	public Desenvolvedor(Long id, String nome, String nickname, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.nickname = nickname;
		this.email = email;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		Desenvolvedor other = (Desenvolvedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
