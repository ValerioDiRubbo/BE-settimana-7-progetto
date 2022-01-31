package it.rubrica.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import it.rubrica.business.RubricaEjb;

@WebServlet("/viewcontatti")
public class ViewContatti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @EJB
   RubricaEjb services;
    public ViewContatti() {
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List listacontatti = null;
		listacontatti = services.getRubrica();
	
		request.setAttribute("listacontatti", listacontatti);
        RequestDispatcher rd = request.getRequestDispatcher("contattonumero.jsp");
        rd.forward(request, response);
	}

}
