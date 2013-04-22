package it.uniroma3.model;

import it.uniroma3.persistence.postgres.*;

public class FacadeProdotto {
	public boolean inserisciProdotto(Prodotto prodotto) {
		ProdottoDAOPostgres p = new ProdottoDAOPostgres();
		return p.insert(prodotto);
	}
}