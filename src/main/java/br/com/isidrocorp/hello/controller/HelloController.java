package br.com.isidrocorp.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.hello.controller.model.Produto;

//incluindo a anotação, eu habilito a classe para atender solicitações web.
// cada método dessa classe pode atender uma solitiação via URL
//endereço da maquina: localhost (porta padrão 8080)

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World! --- primeiro projeto do Gustavo ---";
	}
	
	@GetMapping("/hellohtml")
	public String sayHtml() {
		return "<html>"
				+ "<body>"
				+ "<h1>Hello World</h1>"
				+ "</body>"
				+ "</html>";
	}
	
	@GetMapping("/produto")
	public Produto exibirProduto() {
		Produto prod = new Produto();
		prod.setId(10012);
		prod.setDescricao("Mesa Gamer");
		prod.setPreco(998.65);
		prod.setQtdeEstoque(1);
		return prod;
	}
	
	@PostMapping("/novoproduto")
	public String cadastrarProduto(@RequestBody Produto novo) {
		System.out.println("Recebi "+novo.getId()+"/"+novo.getDescricao()+
							"/"+novo.getPreco()+"/"+novo.getQtdeEstoque());
		return "Produto Cadastrado!";
	}
}
