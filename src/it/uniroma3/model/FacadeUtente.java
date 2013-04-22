package it.uniroma3.model;

import it.uniroma3.persistence.postgres.UtenteDAOPostgres;

public class FacadeUtente {
	public Utente trovaUtente(String username){
		UtenteDAOPostgres u = new UtenteDAOPostgres();
		return u.findByNome(username);
	}

}
