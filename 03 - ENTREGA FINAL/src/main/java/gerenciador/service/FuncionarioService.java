package gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gerenciador.entity.Funcionario;
import gerenciador.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public String save(Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
		return "Funcionario adicionado com sucesso!";
	}

	public String update(Funcionario funcionario, long id) {
		funcionario.setId(id);
		this.funcionarioRepository.save(funcionario);
		return "Funcionario atualizado com sucesso!";
	}

	public String delete(long id) {
		this.funcionarioRepository.deleteById(id);
		return "Funcionario deletado com sucesso!";
	}

	public List<Funcionario> findAll() {
		List<Funcionario> lista = this.funcionarioRepository.findAll();
		return lista;
	}

	public Funcionario findById(long id) {
		Funcionario funcionario = this.funcionarioRepository.findById(id).get();
		return funcionario;
	}
	
	public List<Funcionario> findByNome(String nome){
		return this.funcionarioRepository.findByNome(nome);
	}
	
	public List<Funcionario> findByMatricula(int matricula){
		return this.funcionarioRepository.findByMatricula(matricula);
	}
}
