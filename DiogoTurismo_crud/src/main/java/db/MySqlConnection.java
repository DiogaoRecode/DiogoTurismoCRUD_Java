package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
private static final String url="jdbc:mysql://localhost:3306/DiogoTurismo_crud";
private static final String user ="root";
private static final String password ="XXXXXXXX";

public static Connection createConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver encontrado!");
	} catch (ClassNotFoundException e) {
		System.out.println("Driver não encontrado!"+e.getMessage());
	}
	
	try {
		Connection connection = DriverManager.getConnection(url,user,password);
		System.out.println("Conectado no banco de dados!");
		return connection;
	} catch (SQLException e){
		System.out.println("Não conectado no banco de dados!e.getMessage())");
	    return null; //retornar vazio
}
}
}
