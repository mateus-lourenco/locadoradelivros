package br.edu.unifacisa.si.locadoradelivros.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Usuario;


@RepositoryRestResource(collectionResourceRel = "usuario", path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {

	List<Usuario> findAll();

	Usuario findByNomeOrderByNome(@Param("nome") String nome);

	@Query("SELECT u.nome FROM Usuario u WHERE u.id = :id")
	Optional<Usuario> findById(@Param("id") Integer id);

}
