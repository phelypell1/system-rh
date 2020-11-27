package br.com.rhsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rhsystem.exceptions.BusinessEntityException;
import br.com.rhsystem.interfaces.IService;
import br.com.rhsystem.model.LocacaoVeiculo;
import br.com.rhsystem.repository.LocacaoVeiculoRepository;

@Service
public class LocacaoVeiculoService implements IService<LocacaoVeiculo, Long>{
	
	@Autowired
	LocacaoVeiculoRepository LocacaoVeiculoRepository;

	@Override
	public LocacaoVeiculo create(LocacaoVeiculo entity) {
		// TODO Auto-generated method stub
		return LocacaoVeiculoRepository.save(entity);
	}

	@Override
	public List<LocacaoVeiculo> read() {
		// TODO Auto-generated method stub
		return (List<LocacaoVeiculo>) LocacaoVeiculoRepository.findAll();
	}

	@Override
	public LocacaoVeiculo read(Long id) {
		// TODO Auto-generated method stub
		return LocacaoVeiculoRepository.findById(id).orElseThrow(()-> new BusinessEntityException(String.format("LocacaoVeiculo Não encontrado %s", id)));
	}

	@Override
	public Page<LocacaoVeiculo> read(String descricao, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void update(LocacaoVeiculo entity) {
		LocacaoVeiculoRepository.save(entity);
		
	}

	@Override
	@Transactional(rollbackOn = Throwable.class)
	public void delete(Long id) {
		LocacaoVeiculoRepository.deleteById(id);
	}
}
