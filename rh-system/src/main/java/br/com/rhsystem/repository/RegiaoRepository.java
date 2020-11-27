package br.com.rhsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rhsystem.model.Regiao;

@Repository
public interface RegiaoRepository extends CrudRepository<Regiao, Long> {

}
