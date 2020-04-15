package br.edu.unifacisa.si.locadoradelivros.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 1000)
	private Integer id;
	
	@Column(length = 200)
	private String nome;

	@ManyToMany(mappedBy = "autores", cascade = CascadeType.ALL)
	private List<Livro> livros;

}
