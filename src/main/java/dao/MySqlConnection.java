package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;

import JDBC.ConnectionJDBC_Factory;

public class MySqlConnection {
	
	public Connection getConnection() 
	{
		Connection conexao = null;
		
		/*try{	            
		           		            
					String driver = "mysql";
				    String dataBaseAddress = "localhost:3306";
				    String dataBaseName = "almg";
				    String user = "root";
				    String password = "123456";
		
		            
		            StringBuilder construcaoStringConexao = new StringBuilder("jdbc:")
		                    .append(driver).append("://")
		                    .append(dataBaseAddress).append("/")
		                    .append(dataBaseName);
		
		            String urlConexao = construcaoStringConexao.toString();
		            System.out.println(urlConexao);
		
		            
		            try{
		                conn = DriverManager.getConnection(urlConexao,user,password);
		                System.out.println("Conectado com SUCESSO!");
		            }catch (SQLException e){
		                System.out.println("FALHA ao tentar criar a conexão!");
		                throw new RuntimeException(e);
		            }
		            catch (Exception e){
		                System.out.println("Falha na conexão: "+e);
		            }
		           		
		        }finally {
	                //conn.close();
	            }
					/*catch (IOException e){
		            System.out.println("FALHA ao tentar carregar arquivos de propriedades!");
		            e.printStackTrace();
		        }*/
		        //return conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("org.postgresql.Driver");
			//Class.forName("org.hibernate.dialect.PostgreSQLDialect");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		try {
			//conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_manha","root","123456");
			conexao = DriverManager.getConnection("jdbc:mysql://ba105270c84a5b:e8de9300@us-cdbr-east-04.cleardb.com/heroku_38d17ec12bcaa77");
			
			/*conexao = DriverManager.getConnection(
					"jdbc:postgresql://"+
					"ec2-35-170-123-64.compute-1.amazonaws.com"+
					"dbnn24087s2ifh"+
					"woezwqydihbglr"+
					"a788c9362e0818115d57501186e78f231e11eab9345b68f3af760e945048efd7"				
					);*/	
			//conexao = DriverManager.getConnection("jdbc:postgresql://woezwqydihbglr:a788c9362e0818115d57501186e78f231e11eab9345b68f3af760e945048efd7@ec2-35-170-123-64.compute-1.amazonaws.com:5432/dbnn24087s2ifh");
			
		} catch(SQLException sqlExc) {
			System.out.println(conexao);
			System.out.println(sqlExc);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
				
		return conexao;
	}

}
