package br.edu.unifacisa.si.locadoradelivros.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "editoras")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 1000)
	private Integer id;
	
	@Column(length = 200)
	private String nome;

	@OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
	private List<Livro> livros = new ArrayList<Livro>();
}
