package br.com.supero.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.supero.app.bean.TaskBean;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskView extends TaskBean {
	
	private static final long serialVersionUID = 4790685130792057020L;

	public TaskView() {
		super();
	}

	public TaskView(Integer id, String título, String status, String descricao) {
		super(id, título, status, descricao);
	}

	@XmlElement(name="id")
	@Override
	public Integer getId() {
		return super.getId();
	}

	@XmlElement(name="titulo")
	@Override
	public String getTitulo() {
		return super.getTitulo();
	}

	@XmlElement(name="status")
	@Override
	public String getStatus() {
		return super.getStatus();
	}

	@XmlElement(name="descricao")
	@Override
	public String getDescricao() {
		return super.getDescricao();
	}

	@Override
	public String toString() {
		return "taskView [id=" + getId() + ", titulo=" + getTitulo() + ", status=" + getStatus() + ", descricao=" + getDescricao() + "]";
	}
	
}