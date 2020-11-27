package br.com.rhsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rhsystem.model.LocacaoVeiculo;

@Repository
public interface LocacaoVeiculoRepository extends CrudRepository<LocacaoVeiculo, Long>{

}
