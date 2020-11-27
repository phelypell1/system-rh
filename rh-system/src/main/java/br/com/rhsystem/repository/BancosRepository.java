package br.com.rhsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rhsystem.model.Bancos;

@Repository
public interface BancosRepository extends CrudRepository<Bancos, Long>{

}
