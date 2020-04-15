package br.edu.unifacisa.si.locadoradelivros.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.unifacisa.si.locadoradelivros.domain.Emprestimo;

@RepositoryRestResource(collectionResourceRel = "emprestimo", path = "emprestimos")
public interface EmprestimoRepository extends PagingAndSortingRepository<Emprestimo, Integer> {

}
