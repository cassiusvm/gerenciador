package br.eti.cvm.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class BancoDados {

	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa("Alura");
		Empresa empresa2 = new Empresa("Caelum");
		lista.add(empresa1);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return BancoDados.lista;
	}
	
}
