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

import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@PostMapping("/salvar")
	public ResponseEntity<String> salvarCarro(@RequestBody Carro carro) {
		try {
			String mensagem = this.carroService.salvarCarro(carro);
			return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao salvar o carro: ", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/alterar/{id}")
	public ResponseEntity<String> alterarCarro(@RequestBody Carro carro, @PathVariable long id) {
		try {
			String mensagem = this.carroService.alterarCarro(carro, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao alterar o carro: ", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deletar{id}")
	public ResponseEntity<String> deletarCarro(@PathVariable long id) {
		try {
			String mensagem = this.carroService.deletarCarro(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao deletar o carro: ", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Carro>> ListarCarros(){
		try {
			List<Carro> lista = this.carroService.ListarCarros();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Carro> buscarPorId(@PathVariable long id) {
		try {
			Carro carro = this.carroService.buscarPorId(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
