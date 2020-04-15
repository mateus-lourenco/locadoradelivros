package br.edu.unifacisa.si.locadoradelivros.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Autor;

@RepositoryRestResource(collectionResourceRel = "autores", path = "autores", exported = true)
public interface AutorRepository extends PagingAndSortingRepository<Autor, Integer> {
	
	List<Autor> findAll();
	
	Optional<Autor> findById(@Param("id") Integer id);
	
	@Query("SELECT a.id, a.nome "
			+ "FROM Autor a "
			+ "INNER JOIN a.livros l "
			+ "WHERE l.titulo = :tituloLivro")
	List<Autor> findByTituloLivro(@Param("tituloLivro") String tituloLivro);

}
