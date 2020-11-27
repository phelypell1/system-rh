package br.com.rhsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rhsystem.exceptions.BusinessEntityException;
import br.com.rhsystem.interfaces.IService;
import br.com.rhsystem.model.Estados;
import br.com.rhsystem.repository.EstadosRepository;

@Service
public class EstadosService implements IService<Estados, Long>{
	
	@Autowired
	EstadosRepository EstadosRepository;

	@Override
	public Estados create(Estados entity) {
		// TODO Auto-generated method stub
		return EstadosRepository.save(entity);
	}

	@Override
	public List<Estados> read() {
		// TODO Auto-generated method stub
		return (List<Estados>) EstadosRepository.findAll();
	}

	@Override
	public Estados read(Long id) {
		// TODO Auto-generated method stub
		return EstadosRepository.findById(id).orElseThrow(()-> new BusinessEntityException(String.format("Estados Não encontrado %s", id)));
	}

	@Override
	public Page<Estados> read(String descricao, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void update(Estados entity) {
		EstadosRepository.save(entity);
		
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void delete(Long id) {
		EstadosRepository.deleteById(id);
	}
}
