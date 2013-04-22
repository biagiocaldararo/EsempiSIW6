package it.uniroma3.persistence;

import it.uniroma3.model.*;
import java.util.*; 

public interface ProdottoDAO {	
	boolean insert(Prodotto prodotto); 
	boolean delete(Prodotto prodotto); 
	boolean update(Prodotto prodotto);
	Prodotto findByNome(String nome);
 	List<Prodotto> findAll();
}
