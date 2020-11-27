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
import br.com.rhsystem.model.Bancos;
import br.com.rhsystem.service.BancosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(value="Operações para manipulação dos dos dados de Bancos", tags="Bancos")
@RequestMapping(value="/bancos", path="/bancos")
public class BancosController extends DefaultController implements IController<Bancos, Long> {
	
	@Autowired
	BancosService bancosService;

	@Override	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Armazena um registro de um Bancos.", notes ="Cadastro de Bancos.")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message="Recurso criado.", response= Bancos.class),
			@ApiResponse(code = 404, message="Recurso não encontrado.", response= Bancos.class),
			@ApiResponse(code = 405, message="O servidor não suporta o método/verbo enviado nesta requisição", response= Bancos.class),
	})
	public ResponseEntity<?> create(@RequestBody Bancos entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bancosService.create(entity));
	}
	
	@GetMapping(path="", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Bancos> read(){
		return bancosService.read();
	}

	@Override
	@GetMapping(path="/{idBancos}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> read(@PathVariable Long idBancos) {
		
		Bancos p = bancosService.read(idBancos);
		
		if(p!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(bancosService.read(idBancos));	
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Bancos());	
		}
	}

	/*@Override
	@GetMapping(path="/page/{descricao}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> read(@RequestParam(required = false) String descricao, @RequestParam(defaultValue = "0") Integer page, 
			@RequestParam(defaultValue = "20")Integer size) {
		
		//Aqui Felipe você faz a consulta do serviço
		Page<Bancos> lista = bancosService.read(descricao, PageRequest.of(page, size));
		
		//Aqui você trata o retorn da consulta de acordo com o STATUS HTTP
		ResponseHeaderPaginable responsePaginable = new ResponseHeaderPaginable(page, lista);
		
		//Faz o cálculo de paginação
		responsePaginable.invoke();
		HttpStatus status = responsePaginable.getStatus();
		
		return ResponseEntity.status(status).header(CONTENT_RANGE_HEADER, responsePaginable.responsePageRange()).body(lista);
		
	}*/

	@Override
	@PutMapping(path="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Bancos entity) {
		
		Bancos p = entity;
		p.setId_banco(id);
		
		bancosService.update(p);
		
		return ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping(path="/delete/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		bancosService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

    @Override
    @RequestMapping(method={RequestMethod.OPTIONS}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.comment-options}", notes="Método responsável para apresentar as operações que o usuário pode fazer da API utilizada.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro excluído com sucesso.", response = Bancos.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Bancos.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Bancos.class)
    })
    public ResponseEntity<?> options() {
        return ResponseEntity.status(200).body(String.format("Métodos permitidos: %s", Arrays.asList("GET", "POST","PUT","DELETE", "OPTIONS").toString()));
    }

}