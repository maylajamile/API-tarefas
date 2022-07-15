package br.com.fiveacademy.tarefas.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiveacademy.tarefas.form.AtualizacaoTarefa;
import br.com.fiveacademy.tarefas.modelo.Tarefa;
import br.com.fiveacademy.tarefas.repository.TarefasRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {
	
	@Autowired
	private TarefasRepository tarefasRepository;
	
	Sort sort = Sort.by("data").descending();

	@GetMapping
	public List<Tarefa> listarTarefas() {
		return tarefasRepository.findAll(sort);
	}
	
	@PostMapping
	public Tarefa adicionarTarefas(@RequestBody Tarefa tarefa) {
		return tarefasRepository.save(tarefa);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @Valid @RequestBody AtualizacaoTarefa form) {
		Optional<Tarefa> optional = tarefasRepository.findById(id);
		if (optional.isPresent()) {
			Tarefa tarefa = form.atualizar(id, tarefasRepository);
			return ResponseEntity.ok(new Tarefa(tarefa));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarTarefa (@PathVariable Long id){
		tarefasRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
