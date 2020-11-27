package br.com.rhsystem.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepository<T, N> extends JpaRepository<T, N>, JpaSpecificationExecutor<T> {
	
	Optional<T> findById(N id);
}