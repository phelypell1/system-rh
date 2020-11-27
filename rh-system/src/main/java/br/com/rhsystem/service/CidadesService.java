package br.com.rhsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rhsystem.exceptions.BusinessEntityException;
import br.com.rhsystem.interfaces.IService;
import br.com.rhsystem.model.Cidades;
import br.com.rhsystem.repository.CidadesRepository;

@Service
public class CidadesService implements IService<Cidades, Long>{
	
	@Autowired
	CidadesRepository CidadeRepository;

	@Override
	public Cidades create(Cidades entity) {
		// TODO Auto-generated method stub
		return CidadeRepository.save(entity);
	}

	@Override
	public List<Cidades> read() {
		// TODO Auto-generated method stub
		return (List<Cidades>) CidadeRepository.findAll();
	}

	@Override
	public Cidades read(Long id) {
		// TODO Auto-generated method stub
		return CidadeRepository.findById(id).orElseThrow(()-> new BusinessEntityException(String.format("Cidade Não encontrado %s", id)));
	}

	@Override
	public Page<Cidades> read(String descricao, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void update(Cidades entity) {
		CidadeRepository.save(entity);
		
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void delete(Long id) {
		CidadeRepository.deleteById(id);
	}
}
