package br.edu.unifacisa.si.locadoradelivros.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Emprestimo;

@RepositoryRestResource(collectionResourceRel = "emprestimos", path = "emprestimos", exported = true)
public interface EmprestimoRepository extends PagingAndSortingRepository<Emprestimo, Integer> {
	
	List<Emprestimo> findAll();
	
	Optional<Emprestimo> findById(@Param("id") Integer id);
	
	@Query("SELECT e.id, e.dataEmprestimo, e.dataDevolucao, u.nome, l.titulo "
			+ "FROM Emprestimo e "
			+ "INNER JOIN e.usuario u "
			+ "INNER JOIN e.livro l "
			+ "WHERE e.dataEmprestimo = :dataEmprestimo")
	List<Emprestimo> findByDataEmprestimo (@Param("dataEmprestimo") Date dataEmprestimo);
	
	@Query("SELECT e.id, e.dataEmprestimo, e.dataDevolucao, u.nome, l.titulo "
			+ "FROM Emprestimo e "
			+ "INNER JOIN e.usuario u "
			+ "INNER JOIN e.livro l "
			+ "WHERE e.dataDevolucao = :dataDevolucao")
	List<Emprestimo> findByDataDevolucao (@Param("dataDevolucao") Date dataDevolucao);
	
	@Query("SELECT e.id, e.dataEmprestimo, e.dataDevolucao, u.nome, l.titulo "
			+ "FROM Emprestimo e "
			+ "INNER JOIN e.usuario u "
			+ "INNER JOIN e.livro l "
			+ "WHERE u.nome = :nomeUsuario")
	List<Emprestimo> findByNomeUsuarioOrderByNomeUsuario (@Param("nomeUsuario") String nomeUsuario);
	

	@Query("SELECT e.id, e.dataEmprestimo, e.dataDevolucao, u.nome, l.titulo "
			+ "FROM Emprestimo e "
			+ "INNER JOIN e.usuario u "
			+ "INNER JOIN e.livro l "
			+ "WHERE l.titulo = :tituloLivro")
	List<Emprestimo> findByTituloLivroOrderByTituloLivro (@Param("tituloLivro") String tituloLivro);
	
}
