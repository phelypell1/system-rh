package br.com.rhsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rhsystem.model.Estados;

@Repository
public interface EstadosRepository extends CrudRepository<Estados, Long>{

}
