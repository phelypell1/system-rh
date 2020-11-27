package br.com.rhsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rhsystem.model.Cidades;

@Repository
public interface CidadesRepository extends CrudRepository<Cidades, Long>{

}
