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
import br.com.rhsystem.model.Cargos;
import br.com.rhsystem.service.CargosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(value="Operações para manipulação dos dos dados de ", tags="Cargos")
@RequestMapping(value="/cargos", path="/cargos")
public class CargosController extends DefaultController implements IController<Cargos, Long> {
	
	@Autowired
	CargosService cargosService;

	@Override	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Armazena um registro de um Cargos.", notes ="Cadastro de Cargos.")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message="Recurso criado.", response= Cargos.class),
			@ApiResponse(code = 404, message="Recurso não encontrado.", response= Cargos.class),
			@ApiResponse(code = 405, message="O servidor não suporta o método/verbo enviado nesta requisição", response= Cargos.class),
	})
	public ResponseEntity<?> create(@RequestBody Cargos entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cargosService.create(entity));
	}
	
	@GetMapping(path="", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Cargos> read(){
		return cargosService.read();
	}

	@Override
	@GetMapping(path="/{idCargos}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> read(@PathVariable Long idCargos) {
		
		Cargos p = cargosService.read(idCargos);
		
		if(p!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(cargosService.read(idCargos));	
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Cargos());	
		}
	}

	/*@Override
	@GetMapping(path="/page/{descricao}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> read(@RequestParam(required = false) String descricao, @RequestParam(defaultValue = "0") Integer page, 
			@RequestParam(defaultValue = "20")Integer size) {
		
		//Aqui Felipe você faz a consulta do serviço
		Page<Cargos> lista = CargosService.read(descricao, PageRequest.of(page, size));
		
		//Aqui você trata o retorn da consulta de acordo com o STATUS HTTP
		ResponseHeaderPaginable responsePaginable = new ResponseHeaderPaginable(page, lista);
		
		//Faz o cálculo de paginação
		responsePaginable.invoke();
		HttpStatus status = responsePaginable.getStatus();
		
		return ResponseEntity.status(status).header(CONTENT_RANGE_HEADER, responsePaginable.responsePageRange()).body(lista);
		
	}*/

	@Override
	@PutMapping(path="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cargos entity) {
		
		Cargos p = entity;
		p.setId_cargos(id);
		
		cargosService.update(p);
		
		return ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping(path="/delete/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		cargosService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

    @Override
    @RequestMapping(method={RequestMethod.OPTIONS}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.comment-options}", notes="Método responsável para apresentar as operações que o usuário pode fazer da API utilizada.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro excluído com sucesso.", response = Cargos.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Cargos.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Cargos.class)
    })
    public ResponseEntity<?> options() {
        return ResponseEntity.status(200).body(String.format("Métodos permitidos: %s", Arrays.asList("GET", "POST","PUT","DELETE", "OPTIONS").toString()));
    }

}