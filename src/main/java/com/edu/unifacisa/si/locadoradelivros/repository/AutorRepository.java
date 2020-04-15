package br.edu.unifacisa.si.locadoradelivros.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Autor;

@RepositoryRestResource(collectionResourceRel = "autor", path = "autores")
public interface AutorRepository extends PagingAndSortingRepository<Autor, Integer>{

}
