package it.uniroma3.persistence;

import it.uniroma3.model.Utente;

import java.util.List;

public interface UtenteDAO {	
	boolean insert(Utente utente); 
	boolean delete(Utente utente); 
	boolean update(Utente utente);
	Utente findByNome(String username);
 	List<Utente> findAll();
}
