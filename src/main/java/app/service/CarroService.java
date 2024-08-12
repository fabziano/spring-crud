package app.service;

import org.springframework.stereotype.Service;

import app.entity.Carro;

@Service
public class CarroService {

	public String salvarCarro(Carro carro) {
		//implementar 
		return "Carro adicionado com sucesso";
	}
	
	public String alterarCarro(Carro carro, long id) {
		//implementar
		return "Carro alterado com sucesso";
	}
	
	public String deletarCarro(long id) {
		//implementar
		return "Carro deletado com sucesso";
	}
	
	public List<Carro> ListarCarros(){
		//implementar
		return null;
	}
	public carro buscarPorId(long id) {
		//implementar
		return null;
	}

}
