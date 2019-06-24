package br.eti.cvm.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class BancoDados {

	private static List<Empresa> lista = new ArrayList<>();
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return BancoDados.lista;
	}
	
}
