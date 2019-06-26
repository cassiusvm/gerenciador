package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.eti.cvm.gerenciador.modelo.BancoDados;
import br.eti.cvm.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramSaida = request.getParameter("saida");
		
		List<Empresa> empresas = new BancoDados().getEmpresas();
		
		String saida = null;
		String contentType = null;
		
		if(paramSaida.equals("json")) {
			Gson gson = new Gson();
			saida = gson.toJson(empresas);
			contentType="application/json";
			
		} else if(paramSaida.equals("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			saida = xstream.toXML(empresas);
			contentType="application/xml";
		}

		if(paramSaida.equals("json") || paramSaida.equals("xml")) {
			response.setContentType(contentType);
			response.getWriter().print(saida);
		}
	}

}
