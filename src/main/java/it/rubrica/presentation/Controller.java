package it.rubrica.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import it.rubrica.business.RubricaEjb;
import it.rubrica.entity.Contatto;
import it.rubrica.entity.NumTelefono;
import it.rubrica.exceptions.ContattoNonTrovatoException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       // Servlet che utilizza il pattern factory model per decidere quale istanza utilizzare.
	@EJB
	RubricaEjb servRubrica;
    public Controller() {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
		String operazione = request.getParameter("operazione");
		switch(operazione) {
		case "insert": 
			insertContatto(request, response);
			break;
		case "merge":
			try {
				modificaContatto(request, response);
				out.println("<h2> Contatto con id <font color='red'>" + request.getParameter("id") + "</font> è stato modificato correttamente!");
				out.println("<a href='index.html'>Torna alla Home</a>");
			} catch (ServletException | IOException | ContattoNonTrovatoException e1) {
				out.println("<h2>Contatto non trovato!</h2>");
				out.println("<a href='index.html'>Torna alla Home</a>");
				out.println("<a href='modificacontatto.jsp'>Inserisci un ID da sovrascrivere.</a>");
				e1.printStackTrace();
			}
			break;
		case "ricercapernumero":
			ricercaNumero(request, response);
			break;
		case "ricercapercognome":
			ricercaCognome(request, response);
			break;
		case "delete":
			try {
				removeContatto(request, response);
			} catch (ServletException | IOException | ContattoNonTrovatoException e) {
				out.println("<h2>Contatto non trovato!</h2>");
				out.println("<a href='index.html'>Torna alla Home</a>");
				out.println("<a href='deleteform.jsp'>Inserisci un ID corretto.</a>");
				e.printStackTrace();
			}
			break;
			
		}
		

	}
    


	private void insertContatto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Contatto c = new Contatto();

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");

		c.setNome(nome);
		c.setCognome(cognome);
		c.setEmail(email);

		NumTelefono numero1 = new NumTelefono();
		NumTelefono numero2 = new NumTelefono();

		ArrayList<NumTelefono> numeriTelefono = new ArrayList<NumTelefono>();

		if (!request.getParameter("numero1").isBlank()) {
			numero1.setNumTelefono(request.getParameter("numero1"));
			numero1.setContatto(c);
			numeriTelefono.add(numero1);

		}

		else if (!request.getParameter("numero2").isBlank()) {
			numero2.setNumTelefono(request.getParameter("numero2"));
			numero2.setContatto(c);
			numeriTelefono.add(numero2);
		}

		else if (request.getParameter("numero1").isBlank() || request.getParameter("numero2").isBlank()) {
			HttpSession session = request.getSession();
			session.setAttribute("messaggio", "Attenzione! Inserire almeno un numero di telefono!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/forminsertcontatto.jsp");
			dispatcher.forward(request, response);

		}
		c.setNumeriTel(numeriTelefono);
		servRubrica.insertContatto(c);
		out.println("<h2> Inserimento effettuato!</h2>");
		out.println("<a href='index.html'>Torna alla Home</a>");
	}

		private void modificaContatto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ContattoNonTrovatoException {
			PrintWriter out = response.getWriter();
			Integer idCont = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String email = request.getParameter("email");
			String numero1 = request.getParameter("numero1");
			String numero2 = request.getParameter("numero2");
			
			
			servRubrica.aggiornaContattoEsistente(idCont, numero1, numero2, nome, cognome, email);
			
		}
	
		
		private void ricercaNumero(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			List<?> listacontatti = null;
			listacontatti = servRubrica.ricercaPerNumero(request.getParameter("numerodacercare"));
		
			request.setAttribute("listacontatti", listacontatti);
	        RequestDispatcher rd = request.getRequestDispatcher("searchnumero.jsp");
	        rd.forward(request, response);
		}
	
		private void ricercaCognome(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			List listacontatti = null;
			listacontatti = servRubrica.ricercaPerCognome(request.getParameter("cognomedacercare"));
		
			request.setAttribute("listacontatti", listacontatti);
	        RequestDispatcher rd = request.getRequestDispatcher("searchcognome.jsp");
	        rd.forward(request, response);
		}
		
		private void removeContatto(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, ContattoNonTrovatoException {
			PrintWriter out = response.getWriter();
			
			Integer idCont = Integer.parseInt(request.getParameter("id"));
			
			
			servRubrica.removeContatto(idCont);
			
			out.println("<h2> Contatto con id <font color='red'>" + request.getParameter("id") + "</font> è stato eliminato correttamente!");
			out.println("<a href='index.html'>Torna alla Home</a>");
		}
}

