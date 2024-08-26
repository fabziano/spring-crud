package gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gerenciador.entity.Cliente;
import gerenciador.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	public List<Venda> findByEnderecoEntrega(String enderecoEntrega);
	
	public List<Venda> findByCliente(Cliente cliente);
}
