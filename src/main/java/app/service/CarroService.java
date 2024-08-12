package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public String salvarCarro(Carro carro) {
		this.carroRepository.save(carro);
		return "Carro adicionado com sucesso";
	}
	
	public String alterarCarro(Carro carro, long id) {
		carro.setId(id);
		this.carroRepository.save(carro);
		return "Carro alterado com sucesso";
	}
	
	public String deletarCarro(long id) {
		this.carroRepository.deleteById(id);
		return "Carro deletado com sucesso";
	}
	
	public List<Carro> ListarCarros(){
		List<Carro> lista = this.carroRepository.findAll();
		return lista;
	}
	public Carro buscarPorId(long id) {
		Carro carro = this.carroRepository.findById(id).get();
		return carro;
	}

}
