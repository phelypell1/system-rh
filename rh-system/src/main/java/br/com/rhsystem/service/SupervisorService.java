package br.com.rhsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rhsystem.exceptions.BusinessEntityException;
import br.com.rhsystem.interfaces.IService;
import br.com.rhsystem.model.Supervisor;
import br.com.rhsystem.repository.SupervisorRepository;

@Service
public class SupervisorService implements IService<Supervisor, Long>{
	
	@Autowired
	SupervisorRepository supervisorRepository;

	@Override
	public Supervisor create(Supervisor entity) {
		// TODO Auto-generated method stub
		return supervisorRepository.save(entity);
	}

	@Override
	public List<Supervisor> read() {
		// TODO Auto-generated method stub
		return (List<Supervisor>) supervisorRepository.findAll();
	}

	@Override
	public Supervisor read(Long id) {
		// TODO Auto-generated method stub
		return supervisorRepository.findById(id).orElseThrow(()-> new BusinessEntityException(String.format("Supervisor Não encontrado %s", id)));
	}

	@Override
	public Page<Supervisor> read(String descricao, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void update(Supervisor entity) {
		supervisorRepository.save(entity);
		
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void delete(Long id) {
		supervisorRepository.deleteById(id);
	}
}
