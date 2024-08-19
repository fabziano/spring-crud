package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Livro;
import app.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public String salvarLivro(Livro livro) {
		this.livroRepository.save(livro);
		return "Livro adicionado com sucesso";
	}
	
	public String alterarLivro(Livro livro, long id) {
		livro.setId(id);
		this.livroRepository.save(livro);
		return "Livro alterado com sucesso";
	}
	
	public String deletarLivro(long id) {
		this.livroRepository.deleteById(id);
		return "Livro deletado com sucesso";
	}
	
	public List<Livro> listarLivros(){
		List<Livro> lista = this.livroRepository.findAll();
		return lista;
	}
	
	public Livro buscarPorId(long id) {
		return this.livroRepository.findById(id).orElse(null);
	}
}
