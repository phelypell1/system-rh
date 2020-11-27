package br.com.rhsystem.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService <T, N> {
	
	T create(T entity);
	
	List<T> read();
	
	T read(N id);
	
	Page<T> read(String descricao, Pageable pageable);
	
	void update(T entity);
	
	void delete(N id);

}
