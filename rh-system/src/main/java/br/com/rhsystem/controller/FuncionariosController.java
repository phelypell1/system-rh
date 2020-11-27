package br.com.rhsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rhsystem.interfaces.IController;
import br.com.rhsystem.model.Funcionarios;
import br.com.rhsystem.service.FuncionariosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(value="Operações para manipulação dos dos dados de ", tags="Funcionarios")
@RequestMapping(value="/funcionarios", path="/funcionarios")
public class FuncionariosController extends DefaultController implements IController<Funcionarios, Long> {
	
	@Autowired
	FuncionariosService funcionariosService;

	@Override	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Armazena um registro de um Funcionarios.", notes ="Cadastro de Funcionarios.")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message="Recurso criado.", response= Funcionarios.class),
			@ApiResponse(code = 404, message="Recurso não encontrado.", response= Funcionarios.class),
			@ApiResponse(code = 405, message="O servidor não suporta o método/verbo enviado nesta requisição", response= Funcionarios.class),
	})
	public ResponseEntity<?> create(@RequestBody Funcionarios entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionariosService.create(entity));
	}
	
	@GetMapping(path="", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Funcionarios> read(){
		return funcionariosService.read();
	}

	@Override
	@GetMapping(path="/{idFuncionarios}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> read(@PathVariable Long idFuncionarios) {
		
		Funcionarios p = funcionariosService.read(idFuncionarios);
		
		if(p!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(funcionariosService.read(idFuncionarios));	
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Funcionarios());	
		}
	}

	/*@Override
	@GetMapping(path="/page/{descricao}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> read(@RequestParam(required = false) String descricao, @RequestParam(defaultValue = "0") Integer page, 
			@RequestParam(defaultValue = "20")Integer size) {
		
		//Aqui Felipe você faz a consulta do serviço
		Page<Funcionarios> lista = funcionariosService.read(descricao, PageRequest.of(page, size));
		
		//Aqui você trata o retorn da consulta de acordo com o STATUS HTTP
		ResponseHeaderPaginable responsePaginable = new ResponseHeaderPaginable(page, lista);
		
		//Faz o cálculo de paginação
		responsePaginable.invoke();
		HttpStatus status = responsePaginable.getStatus();
		
		return ResponseEntity.status(status).header(CONTENT_RANGE_HEADER, responsePaginable.responsePageRange()).body(lista);
		
	}*/

	@Override
	@PutMapping(path="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Funcionarios entity) {
		
		Funcionarios p = entity;
		p.setId_funcionario(id);
		
		funcionariosService.update(p);
		
		return ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping(path="/delete/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		funcionariosService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

    @Override
    @RequestMapping(method={RequestMethod.OPTIONS}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.comment-options}", notes="Método responsável para apresentar as operações que o usuário pode fazer da API utilizada.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro excluído com sucesso.", response = Funcionarios.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Funcionarios.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Funcionarios.class)
    })
    public ResponseEntity<?> options() {
        return ResponseEntity.status(200).body(String.format("Métodos permitidos: %s", Arrays.asList("GET", "POST","PUT","DELETE", "OPTIONS").toString()));
    }

}