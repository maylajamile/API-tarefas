package br.com.fiveacademy.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiveacademy.tarefas.modelo.Tarefa;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefa, Long>{

}
