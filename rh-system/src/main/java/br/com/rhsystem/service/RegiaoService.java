package br.com.rhsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rhsystem.exceptions.BusinessEntityException;
import br.com.rhsystem.interfaces.IService;
import br.com.rhsystem.model.Regiao;
import br.com.rhsystem.repository.RegiaoRepository;

@Service
public class RegiaoService implements IService<Regiao, Long>{
	
	@Autowired
	RegiaoRepository regiaoRepository;

	@Override
	public Regiao create(Regiao entity) {
		// TODO Auto-generated method stub
		return regiaoRepository.save(entity);
	}

	@Override
	public List<Regiao> read() {
		// TODO Auto-generated method stub
		return (List<Regiao>) regiaoRepository.findAll();
	}

	@Override
	public Regiao read(Long id) {
		// TODO Auto-generated method stub
		return regiaoRepository.findById(id).orElseThrow(()-> new BusinessEntityException(String.format("Regiao Não encontrado %s", id)));
	}

	@Override
	public Page<Regiao> read(String descricao, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void update(Regiao entity) {
		regiaoRepository.save(entity);
		
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void delete(Long id) {
		regiaoRepository.deleteById(id);
	}
}

