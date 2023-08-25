package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Carros;

public class CarrosDAO extends DAO {
	
	public CarrosDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Carros carros) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO carros (codigo, placa, nome_carro, cor) "
				       + "VALUES ("+carros.getCodigo()+ ", '" + carros.getPlaca() + "', '"  
				       + carros.getNome() + "', '" + carros.getCor() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Carros get(int codigo) {
		Carros carros = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + codigo;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 Carros = new Carros(rs.getInt("codigo"), rs.getString("placa"), rs.getString("nome"), rs.getString("cor").charAt(0));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}
	
	
	public List<Carros> get() {
		return get("");
	}

	
	public List<Carros> getOrderByCodigo() {
		return get("codigo");		
	}
	
	
	public List<Carros> getOrderByLogin() {
		return get("placa");		
	}
	
	
	public List<Carros> getOrderBySexo() {
		return get("cor");		
	}
	
	
	private List<Carros> get(String orderBy) {	
	
		List<Carros> carros = new ArrayList<Carros>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carros" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Carros u = new Carros(rs.getInt("codigo"), rs.getString("placa"), rs.getString("nome_carro"), rs.getString("cor").charAt(0));
	            carros.add(c);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}


	public List<Carros> getSexoMasculino() {
		List<Carros> carross = new ArrayList<Carros>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carros o WHERE carros.cor LIKE 'M'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Carros u = new Carros(rs.getInt("codigo"), rs.getString("placa"), rs.getString("nome_carro"), rs.getString("cor").charAt(0));
	            carros.add(c);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}
	
	
	public boolean update(Carros carros) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE carros SET cadastro = '" + carros.getCadastro() + "', senha = '"  
				       + carros.getPlaca() + "', sexo = '" + carros.getCor() + "'"
					   + " WHERE codigo = " + carros.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM carros WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean autenticar(String login, String senha) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carros WHERE login LIKE '" + login + "' AND senha LIKE '" + senha  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}	
}