package br.edu.unifacisa.si.locadoradelivros.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Editora;

@RepositoryRestResource(collectionResourceRel = "editoras", path = "editoras", exported = false)
public interface EditoraRepository extends PagingAndSortingRepository<Editora, Integer> {
	
	List<Editora> findAll();
	
	Optional<Editora> findById (@Param("id") Integer id);
	
	@Query("SELECT id, nome "
			+ "FROM Editora "
			+ "WHERE nome = :nomeEditora")
	Optional<Editora> findByNomeOrderByNome(@Param("nomeEditora") String nomeEditora);
	
	@Query("SELECT e.id, e.nome "
			+ "FROM Editora e "
			+ "INNER JOIN e.livros l "
			+ "WHERE l.titulo = :tituloLivro")
	Editora findByTituloLivroOrderByNome(@Param("tituloLivro") String tituloLivro);
}
