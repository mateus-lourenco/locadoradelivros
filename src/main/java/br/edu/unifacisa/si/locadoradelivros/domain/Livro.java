package br.edu.unifacisa.si.locadoradelivros.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 1000)
	private Integer id;

	@Column(length = 255)
	private String titulo;

	@Column(length = 4)
	private int anoPub;

	@Column(unique = true, length = 100, nullable = true)
	private String isbn;

	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	@OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	@ManyToOne(cascade = CascadeType.ALL)
	private Editora editora;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Autor> autores = new ArrayList<Autor>();

	@OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
	private List<Resenha> resenhas = new ArrayList<Resenha>();

}
