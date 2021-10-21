package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionJDBC_Factory {

    private ConnectionJDBC_Factory(){throw new UnsupportedOperationException();}

    public static Connection getConnection(){

        
        Connection conexao = null;

        
        try(InputStream entradaParametros = ConnectionJDBC_Factory.class.getClassLoader().getResourceAsStream("connection.properties")){

            
            Properties propriedades = new Properties();
            propriedades.load(entradaParametros);

            
            String driver = propriedades.getProperty("jdbc.driver");
            String dataBaseAddress = propriedades.getProperty("db.address");
            String dataBaseName = propriedades.getProperty("db.name");
            String user = propriedades.getProperty("db.user.login");
            String password = propriedades.getProperty("db.user.password");

            
            StringBuilder construcaoStringConexao = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String urlConexao = construcaoStringConexao.toString();

            
            try{
                conexao = DriverManager.getConnection(urlConexao,user,password);
                System.out.println("Conectado com SUCESSO!");
            }catch (SQLException e){
                System.out.println("FALHA ao tentar criar a conexão!");
                throw new RuntimeException(e);
            }
            catch (Exception e){
                System.out.println("Falha na conexão: "+e);
            }
//            finally {
//                conexao.close();
//            }

        }catch (IOException e){
            System.out.println("FALHA ao tentar carregar arquivos de propriedades!");
            e.printStackTrace();
        }
        return conexao;
    }
}
