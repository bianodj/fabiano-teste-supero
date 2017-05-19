package br.com.supero.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.supero.model.dao.TaskRepository;
import br.com.supero.model.entity.Task;
import br.com.supero.view.TaskView;

@RestController
public class TaskController {

	private final TaskRepository repository = new TaskRepository();
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = "application/json")
	public List<TaskView> GetTaskView() {
		return getTaskViewList();
	}

	@RequestMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<TaskView> InserTask(@RequestBody TaskView taskView) {
		Task task = new Task(taskView.getId(), taskView.getTitulo(), taskView.getStatus(), taskView.getDescricao());
		repository.Salvar(task);
		return getTaskViewList();
	}

	@RequestMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public List<TaskView> UpdateTask(@RequestBody TaskView taskView) {
		Task task = new Task(taskView.getId(), taskView.getTitulo(), taskView.getStatus(), taskView.getDescricao());
		repository.Salvar(task);
		return getTaskViewList();
	}

	@RequestMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public List<TaskView> DeleteTask(@RequestBody TaskView taskView) {
		Task task = new Task(taskView.getId(), taskView.getTitulo(), taskView.getStatus(), taskView.getDescricao());
		repository.Excluir(task.getId());
		return getTaskViewList();
	}
	
	private List<TaskView> getTaskViewList() {
		List<TaskView> taskViewList = new ArrayList<TaskView>();
		List<Task> listaEntityPessoas = repository.TodasPessoas();
		for (Task task : listaEntityPessoas) {
			taskViewList.add(new TaskView(task.getId(), task.getTitulo(), task.getStatus(), task.getDescricao()));
		}
		return taskViewList;
	}

}