package br.edu.unifacisa.si.locadoradelivros.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emprestimos")
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 1000)
	private Integer id;
	
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Livro livro;
	
}
