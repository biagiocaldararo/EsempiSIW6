package it.uniroma3.persistence.postgres;

import java.sql.*;

import java.util.*;

import it.uniroma3.model.*;
import it.uniroma3.persistence.*;

public class UtenteDAOPostgres implements UtenteDAO {
	private DataSource data;
	private PreparedStatement statement;
	private Connection connection;

	@Override
	public boolean insert(Utente utente) {
		this.data = new DataSource();
		String insert = "insert into utente(username, password, ruolo) values (?,?,?)";
		int inserito = 0;
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(insert);
			this.statement.setString(1, utente.getUsername());
			this.statement.setString(2, utente.getPassword());
			this.statement.setString(3, utente.getRuolo());
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
	public boolean delete(Utente utente) {
		this.data = new DataSource();
		String delete = "delete from utente where nome=?";
		int eliminato = 0;
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(delete);
			this.statement.setString(1, utente.getUsername());
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
	public boolean update(Utente utente) {
		this.data = new DataSource();
		String update = "update utente set password=?, ruolo=? where username=?";
		int aggiornato= 0;
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(update);
			this.statement.setString(1, utente.getPassword());
			this.statement.setString(2, utente.getRuolo());
			this.statement.setString(3, utente.getUsername());
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
	public Utente findByNome(String nome) {
		this.data = new DataSource();
		String query= "select username, password, ruolo from utente where username=?";
		Utente utente = null;	
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(query);
			this.statement.setString(1, nome);
			ResultSet r = statement.executeQuery();
			while (r.next()) 
				utente = new Utente(r.getString("username"), r.getString("password"), r.getString("ruolo"));
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

		return utente;
	}
	
	@Override
	public List<Utente> findAll() {
		this.data = new DataSource();
		String query= "select username, password, ruolo from utente";
		List<Utente> utenti = new LinkedList<Utente>();	
		
		try {
			this.connection = data.getConnection();
			this.statement = this.connection.prepareStatement(query);
			ResultSet r = statement.executeQuery();
			while (r.next()) {
				Utente utente = new Utente(r.getString("username"), r.getString("password"), r.getString("ruolo"));
				utenti.add(utente);
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

		return utenti;
	}
	
	public boolean deleteAll(){
		this.data = new DataSource();
		String delete = "delete from utente";
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

