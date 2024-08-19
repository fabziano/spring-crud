package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping("/salvar")
	public ResponseEntity<String> salvarLivro(@RequestBody Livro livro) {
		try {
			String mensagem = this.livroService.salvarLivro(livro);
			return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao salvar o livro: ", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/alterar/{id}")
	public ResponseEntity<String> alterarLivro(@RequestBody Livro livro, @PathVariable long id) {
		try {
			String mensagem = this.livroService.alterarLivro(livro, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao alterar o livro: ", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarLivro(@PathVariable long id) {
		try {
			String mensagem = this.livroService.deletarLivro(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao deletar o livro: ", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Livro>> listarLivros(){
		try {
			List<Livro> lista = this.livroService.listarLivros();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Livro> buscarPorId(@PathVariable long id) {
		try {
			Livro livro = this.livroService.buscarPorId(id);
			return new ResponseEntity<>(livro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
