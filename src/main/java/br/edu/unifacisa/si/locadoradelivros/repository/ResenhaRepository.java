package br.edu.unifacisa.si.locadoradelivros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Resenha;

@RepositoryRestResource(collectionResourceRel = "resenhas", path = "resenhas", exported = false)
public interface ResenhaRepository extends PagingAndSortingRepository<Resenha, Integer> {
	
	List<Resenha> findAll();
	
	Resenha findResenhaById(@Param("id") Integer id);
	
	@Query("SELECT r.id, r.texto, r.nota "
			+ "FROM Resenha r "
			+ "INNER JOIN  r.livro l "
			+ "WHERE l.titulo = :titulo")
	List<Resenha> findResenhaByTituloLivro(@Param("titulo") String tituloLivro);
	
	Resenha findResenhaByNota(@Param("nota") int nota);

}
