package br.com.isidrocorp.hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.hello.controller.model.Usuario;

@RestController
public class UserController {
	
	//quero fazer um login nock
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dadosLogin) {
		//testando se o usuario existe
		if (dadosLogin.getRacf().equals("gsgimgh")) {
			//usuario existe, testando a senha dele
			if (dadosLogin.getSenha().equals("1234")) {
				
				//usuario existe, retorno 200-OK + o objeto preenchido
				Usuario resposta = new Usuario();
				resposta.setId(36854);
				resposta.setNome("Gustavo Godoy");
				resposta.setEmail("gustavo@godoy.com");
				resposta.setRacf("gsgimgh");
				resposta.setFuncional("007673015");
				resposta.setDepartamento("Tecnologia");
				return ResponseEntity.ok(resposta);
			}
			//senha não confere, retorno 401
			return ResponseEntity.status(401).build();
		}
		//usuario não existe, retorno 404
		return ResponseEntity.status(404).build();
	}
}
