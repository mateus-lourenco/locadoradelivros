package br.edu.unifacisa.si.locadoradelivros.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Editora;

@RepositoryRestResource(collectionResourceRel = "usuario", path = "usuarios")
public interface EditoraRepository extends PagingAndSortingRepository<Editora, Integer>{

}
