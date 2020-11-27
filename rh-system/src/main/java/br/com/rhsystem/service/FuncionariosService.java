package br.com.rhsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rhsystem.exceptions.BusinessEntityException;
import br.com.rhsystem.interfaces.IService;
import br.com.rhsystem.model.Funcionarios;
import br.com.rhsystem.repository.FuncionarioRepository;

@Service
public class FuncionariosService implements IService<Funcionarios, Long>{
	
	@Autowired
	FuncionarioRepository FuncionarioRepository;

	@Override
	public Funcionarios create(Funcionarios entity) {
		// TODO Auto-generated method stub
		return FuncionarioRepository.save(entity);
	}

	@Override
	public List<Funcionarios> read() {
		// TODO Auto-generated method stub
		return (List<Funcionarios>) FuncionarioRepository.findAll();
	}

	@Override
	public Funcionarios read(Long id) {
		// TODO Auto-generated method stub
		return FuncionarioRepository.findById(id).orElseThrow(()-> new BusinessEntityException(String.format("Funcionario Não encontrado %s", id)));
	}

	@Override
	public Page<Funcionarios> read(String descricao, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void update(Funcionarios entity) {
		FuncionarioRepository.save(entity);
		
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void delete(Long id) {
		FuncionarioRepository.deleteById(id);
	}
}
