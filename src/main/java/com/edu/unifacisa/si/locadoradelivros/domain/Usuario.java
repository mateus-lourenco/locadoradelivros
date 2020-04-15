package br.edu.unifacisa.si.locadoradelivros.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	private String nome;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(unique = true, nullable = false)
	private String login;
	
	@Transient
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	private List<Livro> livros = new ArrayList<Livro>();
	
	@OneToMany(mappedBy = "usuario")
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

}
