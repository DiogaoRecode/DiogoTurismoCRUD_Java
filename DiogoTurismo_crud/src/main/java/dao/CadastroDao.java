package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cadastro;

public class CadastroDao implements CRUD{
	private static Connection connection= MySqlConnection.createConnection();
    private static String sql;
    
    
		public static void create (Cadastro cadastro) {
			sql="INSERT INTO cadastro VALUES(null,?,?,?,?)";
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setString(1,cadastro.getNome());
				preparedStatement.setString(2,cadastro.getCpf());
				preparedStatement.setString(3,cadastro.getEmail());
				preparedStatement.setString(4,cadastro.getTelefone());
				
				preparedStatement.executeUpdate();
				
				System.out.println("Dados inseridos no banco de dados!");
				
			}catch(SQLException e) {
				System.out.println("Dados não inseridos no banco de dados!"+ e.getMessage());
			}
			
			}
		
		
		
			
		public static void delete(int cadastroId) {
			
			sql= "DELETE FROM cadastro WHERE id = ?";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setInt(1,cadastroId);
				preparedStatement.executeUpdate();
				
				
				System.out.println("Cadastrado deletado do cliente!");
				
			} catch(SQLException e) {
				System.out.println("Cadastrado não foi deletado do cliente!" + e.getMessage());
			}
			
		}
		
		
		
		public static List<Cadastro> find(String pesquisa) {
			
			sql= String.format("SELECT * FROM cadastro WHERE nome like '%s%%' OR cpf LIKE '%s%%' ",pesquisa,pesquisa);
			List<Cadastro> cadastros = new ArrayList<Cadastro>();
			
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()) {
					Cadastro cadastro = new Cadastro();
					
					cadastro.setId_cliente(resultSet.getInt("id"));
					cadastro.setNome(resultSet.getString("nome"));
					cadastro.setCpf(resultSet.getString("cpf"));
					cadastro.setEmail(resultSet.getString("email"));
					cadastro.setTelefone(resultSet.getString("telefone"));
					
					cadastros.add(cadastro);
				}
				
				System.out.println("Busca correta no cadastro!");
				
				return cadastros;
				
			} catch (SQLException e) {
				
				System.out.println("Busca incorreta no cadastro" +e.getMessage());
				return null;
			}
			
			
			
			} 

		public static Cadastro findByPk(int cadastroId) {
			sql= String.format("SELECT * FROM cadastro WHERE id = %d",cadastroId);
			
			
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				Cadastro cadastro = new Cadastro();
				
				while(resultSet.next()) {
					
					cadastro.setId_cliente(resultSet.getInt("id"));
					cadastro.setNome(resultSet.getString("nome"));
					cadastro.setCpf(resultSet.getString("cpf"));
					cadastro.setEmail(resultSet.getString("email"));
					cadastro.setTelefone(resultSet.getString("telefone"));
					
					
				}
				
				System.out.println("Busca correta pelo pk no cadastro!");
				
				
				return cadastro;
				
			} catch (SQLException e) {
				
				System.out.println("Busca incorreta pelo pk no cadastro" +e.getMessage());
				return null;
			}
			}
		
		
		
		
		public static void update (Cadastro cadastro) {
              sql="UPDATE cadastro SET nome=?, cpf=?, email=?, telefone=? WHERE id=? ";
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setString(1,cadastro.getNome());
				preparedStatement.setString(2,cadastro.getCpf());
				preparedStatement.setString(3,cadastro.getEmail());
				preparedStatement.setString(4,cadastro.getTelefone());
				preparedStatement.setString(4,cadastro.getTelefone());
				preparedStatement.setInt(5, cadastro.getId_cliente());
				preparedStatement.executeUpdate();
				
				System.out.println("Dados atualizados no banco de dados!");
				
			}catch(SQLException e) {
				System.out.println("Dados não atualizados no banco de dados!"+ e.getMessage());
			}
			
			
		}
		
		}
