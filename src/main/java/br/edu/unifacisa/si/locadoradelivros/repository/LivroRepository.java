package br.edu.unifacisa.si.locadoradelivros.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Livro;

@RepositoryRestResource(collectionResourceRel = "livros", path = "livros", exported = true)
public interface LivroRepository extends PagingAndSortingRepository<Livro, Integer> {

	Optional<Livro> findById(@Param("id") Integer id);

	Optional<Livro> findByTitulo(@Param("titulo") String titulo);

	@Query("SELECT l.id, l.titulo, l.anoPub, l.isbn "
			+ "FROM Livro l "
			+ "WHERE anoPub = :anoPub")
	List<Livro> findByAnoPub(@Param("anoPub") Date anoPub);
	
	@Query("SELECT l.id, l.titulo, l.anoPub, l.isbn " 
			+ "FROM Livro l " 
			+ "INNER JOIN l.autores a "
			+ "WHERE a.nome = :nomeAutor")
	List<Livro> findByNomeAutorOrderByTitulo(@Param("nomeAutor") String nomeAutor);

	@Query("SELECT l.id, l.titulo, l.anoPub, l.isbn " 
			+ "FROM Livro l " 
			+ "INNER JOIN l.editora e "
			+ "WHERE e.nome = :nomeEditora")
	List<Livro> findByNomeEditora(@Param("nomeEditora") String nomeEditora);
	
}
