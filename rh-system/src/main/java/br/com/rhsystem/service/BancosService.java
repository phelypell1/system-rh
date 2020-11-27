package br.com.rhsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rhsystem.exceptions.BusinessEntityException;
import br.com.rhsystem.interfaces.IService;
import br.com.rhsystem.model.Bancos;
import br.com.rhsystem.repository.BancosRepository;

@Service
public class BancosService implements IService<Bancos, Long>{
	
	@Autowired
	BancosRepository bancosRepository;

	@Override
	public Bancos create(Bancos entity) {
		// TODO Auto-generated method stub
		return bancosRepository.save(entity);
	}

	@Override
	public List<Bancos> read() {
		// TODO Auto-generated method stub
		return (List<Bancos>) bancosRepository.findAll();
	}

	@Override
	public Bancos read(Long id) {
		// TODO Auto-generated method stub
		return bancosRepository.findById(id).orElseThrow(()-> new BusinessEntityException(String.format("Bancos Não encontrado %s", id)));
	}

	@Override
	public Page<Bancos> read(String descricao, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void update(Bancos entity) {
		bancosRepository.save(entity);
		
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void delete(Long id) {
		bancosRepository.deleteById(id);
	}
}

