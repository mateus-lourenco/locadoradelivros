package br.edu.unifacisa.si.locadoradelivros.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 100)
	private String titulo;
	
	@Column(length = 4)
	private int anoPub;

	@Column(unique = true, nullable = true)
	private String isbn;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	@ManyToOne
	private Editora editora;

	@ManyToMany
	private List<Autor> autores = new ArrayList<Autor>();
	
	@OneToMany(mappedBy = "livro")
	private List<Resenha> resenhas = new ArrayList<Resenha>();

}
