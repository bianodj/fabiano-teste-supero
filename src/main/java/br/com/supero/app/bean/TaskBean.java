package br.com.supero.app.bean;

import java.io.Serializable;
import java.util.Date;

public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String status;
	private String descricao;
	private Date dataCriacao;
	
	public TaskBean() {
		super();
	}

	public TaskBean(Integer id, String título, String status, String descricao) {
		super();
		this.id = id;
		this.titulo = título;
		this.status = status;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String título) {
		this.titulo = título;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
