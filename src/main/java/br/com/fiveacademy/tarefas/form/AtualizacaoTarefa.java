package br.com.fiveacademy.tarefas.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.fiveacademy.tarefas.modelo.Tarefa;
import br.com.fiveacademy.tarefas.repository.TarefasRepository;

public class AtualizacaoTarefa {
	
	@NotNull
	@NotEmpty
	private String titulo;
	
	@NotNull
	private Boolean estaCompleta;
	
	@NotNull
	private LocalDate data;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Boolean getEstaCompleta() {
		return estaCompleta;
	}

	public void setEstaCompleta(Boolean estaCompleta) {
		this.estaCompleta = estaCompleta;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Tarefa atualizar (Long id, TarefasRepository tarefasRepository) {
		Tarefa tarefa = tarefasRepository.getReferenceById(id);
		tarefa.setTitulo(this.titulo);
		tarefa.setEstaCompleta(this.estaCompleta);
		tarefa.setData(this.data);
		
		return tarefa;
	}
	
}
