package it.uniroma3.persistence.postgres;

import java.sql.*;

import java.util.*;

import it.uniroma3.model.*;
import it.uniroma3.persistence.*;

public class ProdottoDAOPostgres implements ProdottoDAO {
	private DataSource data;
	private PreparedStatement statement;
	private Connection connection;

	@Override
	public boolean insert(Prodotto prodotto) {
		this.data = new DataSource();
		String insert = "insert into prodotto(nome, descrizione, prezzo) values (?,?,?)";
		int inserito = 0;
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(insert);
			this.statement.setString(1, prodotto.getNome());
			this.statement.setString(2, prodotto.getDescrizione());
			this.statement.setDouble(3, prodotto.getPrezzo());
			inserito = this.statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();	
		} 
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (this.statement != null) 
					this.statement.close();
				if (this.connection!= null)
					this.connection.close();
			} 
			catch (SQLException e) {
				try {
					throw new PersistenceException(e.getMessage());
				} 
				catch (PersistenceException e1) {
					e1.printStackTrace();
				}
			}
		}

		return inserito!=0;
	}

	@Override
	public boolean delete(Prodotto prodotto) {
		this.data = new DataSource();
		String delete = "delete from prodotto where nome=?";
		int eliminato = 0;
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(delete);
			this.statement.setString(1, prodotto.getNome());
			eliminato = this.statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();	
		} 
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (statement != null) 
					statement.close();
				if (connection!= null)
					connection.close();
			} 
			catch (SQLException e) {
				try {
					throw new PersistenceException(e.getMessage());
				} 
				catch (PersistenceException e1) {
					e1.printStackTrace();
				}
			}
		}

		return eliminato!=0;
	}

	@Override
	public boolean update(Prodotto prodotto) {
		this.data = new DataSource();
		String update = "update prodotto set descrizione=?, prezzo=? where nome=?";
		int aggiornato= 0;
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(update);
			this.statement.setString(1, prodotto.getDescrizione());
			this.statement.setDouble(2, prodotto.getPrezzo());
			this.statement.setString(3, prodotto.getNome());
			aggiornato = this.statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();	
		} 
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (statement != null) 
					statement.close();
				if (connection!= null)
					connection.close();
			} 
			catch (SQLException e) {
				try {
					throw new PersistenceException(e.getMessage());
				} 
				catch (PersistenceException e1) {
					e1.printStackTrace();
				}
			}
		}

		return aggiornato!=0;
	}

	@Override
	public Prodotto findByNome(String nome) {
		this.data = new DataSource();
		String query= "select nome, descrizione, prezzo from prodotto where nome=?";
		Prodotto prodotto = null;	
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(query);
			this.statement.setString(1, nome);
			ResultSet r = statement.executeQuery();
			while (r.next()) 
				prodotto = new Prodotto(r.getString("nome"), r.getString("descrizione"), r.getDouble("prezzo"));
		} 
		catch (SQLException e) {
			e.printStackTrace();				
		} 
		catch (PersistenceException e) {
			e.printStackTrace();	
		}
		finally {
			try {
				if (statement != null) 
					statement.close();
				if (connection!= null)
					connection.close();
			} 
			catch (SQLException e) {
				try {
					throw new PersistenceException(e.getMessage());
				} 
				catch (PersistenceException e1) {
					e1.printStackTrace();
				}
			}
		}

		return prodotto;
	}
	
	@Override
	public List<Prodotto> findAll() {
		this.data = new DataSource();
		String query= "select nome, descrizione, prezzo from prodotto";
		List<Prodotto> prodotti = new LinkedList<Prodotto>();	
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(query);
			ResultSet r = statement.executeQuery();
			while (r.next()) {
				Prodotto prodotto = new Prodotto(r.getString("nome"), r.getString("descrizione"), r.getDouble("prezzo"));
				prodotti.add(prodotto);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();				
		} 
		catch (PersistenceException e) {
			e.printStackTrace();	
		}
		finally {
			try {
				if (statement != null) 
					statement.close();
				if (connection!= null)
					connection.close();
			} 
			catch (SQLException e) {
				try {
					throw new PersistenceException(e.getMessage());
				} 
				catch (PersistenceException e1) {
					e1.printStackTrace();
				}
			}
		}

		return prodotti;
	}
	
	public boolean deleteAll(){
		this.data = new DataSource();
		String delete = "delete from prodotto";
		int eliminati = 0;
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(delete);
			eliminati = this.statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();	
		} 
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (statement != null) 
					statement.close();
				if (connection!= null)
					connection.close();
			} 
			catch (SQLException e) {
				try {
					throw new PersistenceException(e.getMessage());
				} 
				catch (PersistenceException e1) {
					e1.printStackTrace();
				}
			}
		}

		return eliminati!=0;
	}
}
