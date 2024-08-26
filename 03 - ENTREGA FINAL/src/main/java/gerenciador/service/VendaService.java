package gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gerenciador.entity.Cliente;
import gerenciador.entity.Venda;
import gerenciador.repository.VendaRepository;

@Service
public class VendaService {
	@Autowired
	private VendaRepository vendaRepository;

	public String save(Venda venda) {
		this.vendaRepository.save(venda);
		return "Venda realizada com sucesso!";
	}

	public String update(Venda venda, long id) {
		venda.setId(id);
		this.vendaRepository.save(venda);
		return "Venda atualizada com sucesso!";
	}

	public String delete(long id) {
		this.vendaRepository.deleteById(id);
		return "Venda deletada com sucesso!";
	}

	public List<Venda> findAll() {
		List<Venda> lista = this.vendaRepository.findAll();
		return lista;
	}

	public Venda findById(long id) {
		Venda venda = this.vendaRepository.findById(id).get();
		return venda;
	}
	
	public List<Venda> findByEnderecoEntrega(String enderecoEntrega){
		return this.vendaRepository.findByEnderecoEntrega(enderecoEntrega);
	}
	public List<Venda> findByCliente(long idCliente){
		Cliente cliente = new Cliente();
		cliente.setId(idCliente);
		return this.vendaRepository.findByCliente(cliente);
	}
}
