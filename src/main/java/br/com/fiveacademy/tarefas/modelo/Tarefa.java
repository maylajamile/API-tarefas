package br.com.fiveacademy.tarefas.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tarefas")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Boolean estaCompleta;
	private LocalDate data;
	
	public Tarefa(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.titulo = tarefa.getTitulo();
		this.estaCompleta = tarefa.getEstaCompleta();
		this.data = tarefa.getData();
	}
	
	public Tarefa () {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

}
