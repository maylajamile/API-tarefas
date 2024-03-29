package br.com.fiveacademy.tarefas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiveacademy.tarefas.dto.TokenDto;
import br.com.fiveacademy.tarefas.form.LoginForm;
import br.com.fiveacademy.tarefas.security.TokenService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	@ApiOperation(value = "Autentica o usuário",
		notes = "Este endpoint serve para autenticar o usuário e conceder permissões para criar, editar e excluir tarefas.")
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dados = form.receberDadosConvertidos();
		
		try {
			Authentication authentication = authManager.authenticate(dados);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
