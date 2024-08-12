package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<String> salvar(@RequestBody Carro carro){
		try {
			 String mensagem = this.carroService.salvar(carro);
			 return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao salvar: ", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<Carro> buscarPorId(@PathVariable Long id){
		try {
			Carro carro = this.carroService.buscarPorId(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);			
		}
	}
}
