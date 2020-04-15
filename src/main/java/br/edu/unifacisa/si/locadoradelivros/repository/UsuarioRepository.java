package br.edu.unifacisa.si.locadoradelivros.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Usuario;


@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios", exported = true)
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {

	List<Usuario> findAll();

	Optional<Usuario> findById(@Param("id") Integer id);

	Usuario findByNomeOrderByNome(@Param("nome") String nome);
	
	Usuario findByEmail(@Param("email") String email);
	
	Usuario findByLogin(@Param("login") String login);
	
}
