package br.com.rhsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rhsystem.model.Supervisor;

@Repository
public interface SupervisorRepository extends CrudRepository<Supervisor, Long>{

}
