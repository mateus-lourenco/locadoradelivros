package br.edu.unifacisa.si.locadoradelivros.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Resenha;

@RepositoryRestResource(collectionResourceRel = "resenha", path = "resenhas")
public interface ResenhaRepository extends PagingAndSortingRepository<Resenha, Integer>{

}
