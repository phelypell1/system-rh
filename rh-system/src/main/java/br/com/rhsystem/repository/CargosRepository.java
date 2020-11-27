package br.com.rhsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rhsystem.model.Cargos;

@Repository
public interface CargosRepository extends CrudRepository<Cargos, Long>{

}
