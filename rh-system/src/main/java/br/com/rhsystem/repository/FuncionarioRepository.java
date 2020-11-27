package br.com.rhsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rhsystem.model.Funcionarios;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionarios, Long>{

}
