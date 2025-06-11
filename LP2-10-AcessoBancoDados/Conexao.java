import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao{

	public Conexao() {
		
		// Conexão com o driver JDBC
		String nomeJDBC = "jdbc:mysql://localhost/discdb";
		String configTimeZone = "?useTimezone=true&serverTimezone=UTC";
		String nomeUser = "root";
		String password = "";

		try {
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver"); 

		Connection conexao = DriverManager.getConnection(nomeJDBC+configTimeZone, nomeUser, password);

		// Acessa um banco de dados específico.
		Statement st = conexao.createStatement();
		st.executeUpdate("USE " + "discdb");

		// Faz a consulta SQL
		String pedido = "Select * From musica;";
		
		ResultSet resultado = st.executeQuery(pedido);

		// Mostra os resultados da consulta
		int numeroLinhas = 1;

		while (resultado.next()) {
			System.out.println("REGISTRO: " + numeroLinhas );

			System.out.print("CodMus: ");
			System.out.println(resultado.getString("CodMus"));
			
			System.out.print("Titulo: ");
			System.out.println(resultado.getString("Titulo"));			

			numeroLinhas++;
		}
		
		st.close();
		conexao.close();
		} catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		} finally{
			
		}

	}

	public static void main(String[] args) {
		new Conexao();
	}

}
