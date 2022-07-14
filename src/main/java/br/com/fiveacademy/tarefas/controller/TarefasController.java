package br.com.fiveacademy.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiveacademy.tarefas.modelo.Tarefa;
import br.com.fiveacademy.tarefas.repository.TarefasRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {
	
	@Autowired
	private TarefasRepository tarefasRepository;

	@GetMapping
	public List<Tarefa> listarTarefas() {
		return tarefasRepository.findAll();
	}
	
	@PostMapping
	public Tarefa adicionarTarefas(@RequestBody Tarefa tarefa) {
		return tarefasRepository.save(tarefa);
	}
}
