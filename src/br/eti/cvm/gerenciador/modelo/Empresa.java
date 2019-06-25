package br.eti.cvm.gerenciador.modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Empresa {

	private Integer id;

	private String nome;

	private LocalDate dataAbertura = LocalDate.now();

	public Empresa() {

	}

	public Empresa(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getJavaUtilDate() {
		return java.util.Date.from(this.dataAbertura.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}
