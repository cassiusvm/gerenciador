package br.eti.cvm.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoDados {

	private static List<Empresa> lista = new ArrayList<>();
	
	private static Integer chaveSequencial=1;
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return BancoDados.lista;
	}
	
	public void remove(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId().equals(id)) {
				it.remove();
				break;
			}
		}
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for(Empresa empresa : lista) {
			if(empresa.getId().equals(id))
				return empresa;
		}
		
		return null;
	}
	
}