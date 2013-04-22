package it.uniroma3.controller;

import it.uniroma3.model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GestisciLogin
 */
@WebServlet("/login")
public class Autentica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autentica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		HttpSession sessione = request.getSession();
		RequestDispatcher rd;
		
		FacadeUtente fu = new FacadeUtente();
		UtenteHelper helper = new UtenteHelper(request, fu.trovaUtente(request.getParameter("username")));
		
		String destinazione = "/Login.jsp";
		
		if(helper.login()){
			destinazione = "/InserimentoProdotto.jsp";
			sessione.setAttribute("utente", helper.getUtente());
		}
		
		rd = application.getRequestDispatcher(destinazione);
		
		rd.forward(request, response);
	}
}
