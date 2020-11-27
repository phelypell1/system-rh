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
import br.com.rhsystem.model.Regiao;
import br.com.rhsystem.model.Supervisor;
import br.com.rhsystem.service.RegiaoService;
import br.com.rhsystem.service.SupervisorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(value="Operações para manipulação dos dos dados de Regiao", tags="Regiao")
@RequestMapping(value="/regiao", path="/regiao")
public class RegiaoController extends DefaultController implements IController<Regiao, Long> {
	
	@Autowired
	RegiaoService regiaoService;

	@Override	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Armazena um registro de um Regiao.", notes ="Cadastro de regiao.")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message="Recurso criado.", response= Regiao.class),
			@ApiResponse(code = 404, message="Recurso não encontrado.", response= Regiao.class),
			@ApiResponse(code = 405, message="O servidor não suporta o método/verbo enviado nesta requisição", response= Regiao.class),
	})
	public ResponseEntity<?> create(@RequestBody Regiao entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(regiaoService.create(entity));
	}
	
	@GetMapping(path="", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Regiao> read(){
		return regiaoService.read();
	}

	@Override
	@GetMapping(path="/{idRegiao}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> read(@PathVariable Long idRegiao) {
		
		Regiao p = regiaoService.read(idRegiao);
		
		if(p!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(regiaoService.read(idRegiao));	
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Supervisor());	
		}
	}

	/*@Override
	@GetMapping(path="/page/{descricao}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> read(@RequestParam(required = false) String descricao, @RequestParam(defaultValue = "0") Integer page, 
			@RequestParam(defaultValue = "20")Integer size) {
		
		//Aqui Felipe você faz a consulta do serviço
		Page<Supervisor> lista = SupervisorService.read(descricao, PageRequest.of(page, size));
		
		//Aqui você trata o retorn da consulta de acordo com o STATUS HTTP
		ResponseHeaderPaginable responsePaginable = new ResponseHeaderPaginable(page, lista);
		
		//Faz o cálculo de paginação
		responsePaginable.invoke();
		HttpStatus status = responsePaginable.getStatus();
		
		return ResponseEntity.status(status).header(CONTENT_RANGE_HEADER, responsePaginable.responsePageRange()).body(lista);
		
	}*/

	@Override
	@PutMapping(path="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Regiao entity) {
		
		Regiao p = entity;
		p.setId_regiao(id);
		
		regiaoService.update(p);
		
		return ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping(path="/delete/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		regiaoService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

    @Override
    @RequestMapping(method={RequestMethod.OPTIONS}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.comment-options}", notes="Método responsável para apresentar as operações que o usuário pode fazer da API utilizada.")
    @ApiResponses(value={
            @ApiResponse(code = 204, message = "Registro excluído com sucesso.", response = Supervisor.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Supervisor.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Supervisor.class)
    })
    public ResponseEntity<?> options() {
        return ResponseEntity.status(200).body(String.format("Métodos permitidos: %s", Arrays.asList("GET", "POST","PUT","DELETE", "OPTIONS").toString()));
    }

}