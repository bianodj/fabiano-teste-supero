package br.com.supero.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.supero.app.bean.TaskBean;

@Entity
@Table(name = "Task")
@NamedQueries({ @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t ORDER BY t.id") })
public class Task extends TaskBean {

	private static final long serialVersionUID = -7491678457517091119L;

	public Task() {
		super();
	}

	public Task(Integer id, String título, String status, String descricao) {
		super(id, título, status, descricao);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Override
	public Integer getId() {
		return super.getId();
	}

	@Column(name = "titulo")
	@Override
	public String getTitulo() {
		return super.getTitulo();
	}

	@Column(name = "status")
	@Override
	public String getStatus() {
		return super.getStatus();
	}

	@Column(name = "descricao")
	@Override
	public String getDescricao() {
		return super.getDescricao();
	}

}
