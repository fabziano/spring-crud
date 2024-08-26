package gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gerenciador.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findByNome(String nome);
	
	public List<Produto> findByMarca(String marca);

}
