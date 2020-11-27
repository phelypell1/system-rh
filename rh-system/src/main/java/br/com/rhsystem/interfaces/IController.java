package br.com.rhsystem.interfaces;

import org.springframework.http.ResponseEntity;

public interface IController<T, N> {
	
	ResponseEntity<?> create(T entity);
	
	ResponseEntity<?> read(N id);
	
	/*ResponseEntity<?> read(String descricao, Integer page, Integer size);*/
	
	ResponseEntity<?> update(N id, T entity);
	
	ResponseEntity<?> delete(N id);
	
	ResponseEntity<?> options();
	
}
