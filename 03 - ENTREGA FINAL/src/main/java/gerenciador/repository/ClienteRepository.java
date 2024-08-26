package gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gerenciador.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	public List<Cliente> findByNome(String nome);
	
	public List<Cliente> findByCpf(String cpf);
}
