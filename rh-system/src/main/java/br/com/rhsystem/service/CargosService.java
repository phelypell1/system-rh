package br.com.rhsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rhsystem.exceptions.BusinessEntityException;
import br.com.rhsystem.interfaces.IService;
import br.com.rhsystem.model.Cargos;
import br.com.rhsystem.repository.CargosRepository;

@Service
public class CargosService implements IService<Cargos, Long>{
	
	@Autowired
	CargosRepository cargosRepository;

	@Override
	public Cargos create(Cargos entity) {
		// TODO Auto-generated method stub
		return cargosRepository.save(entity);
	}

	@Override
	public List<Cargos> read() {
		// TODO Auto-generated method stub
		return (List<Cargos>) cargosRepository.findAll();
	}

	@Override
	public Cargos read(Long id) {
		// TODO Auto-generated method stub
		return cargosRepository.findById(id).orElseThrow(()-> new BusinessEntityException(String.format("Cidade Não encontrado %s", id)));
	}

	@Override
	public Page<Cargos> read(String descricao, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void update(Cargos entity) {
		cargosRepository.save(entity);
		
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void delete(Long id) {
		cargosRepository.deleteById(id);
	}
}
