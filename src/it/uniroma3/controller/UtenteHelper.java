package it.uniroma3.controller;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;

public class UtenteHelper {
	private HttpServletRequest request;
	private Utente utente;
	
	public UtenteHelper(HttpServletRequest request, Utente utente){
		this.request = request;
		this.utente = utente;
	}
	
	public Utente getUtente() {
		return utente;
	}
	
	public boolean login(){		
		boolean loggato = true;
		String erroreInserimento = "Errore inserimento username o password";
		
		if(this.utente == null){
			loggato = false;
			this.request.setAttribute("errore", erroreInserimento);
		}
		else if(!this.utente.getPassword().equals(request.getParameter("password"))){
			loggato = false;
			this.request.setAttribute("errore", erroreInserimento);
		}
		else if (!this.utente.getRuolo().equals("admin")){
			loggato = false;
			this.request.setAttribute("errore", "Per accedere bisogna essere loggati come Admin");	
		}

		return loggato;
	}

}
