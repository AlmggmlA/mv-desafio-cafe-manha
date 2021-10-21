package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item_cafeManha;
import model.Usuario;

public class UsuarioDAO {
	
	public void cadastrarUsuario(Usuario usuario) {
		
		String sql = "INSERT INTO usuario VALUES (null,?,?,?)";
		
		PreparedStatement prepStat = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			prepStat = conn.prepareStatement(sql);
			prepStat.setString(1, usuario.getNome());
			prepStat.setString(2, usuario.getCpf());
			prepStat.setString(3, usuario.getSenha());
			
			prepStat.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepStat!=null) {
					prepStat.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
					}
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}

	}
	
	public ResultSet consultarUsuario(Usuario usuario) {
				
		String sql_consulta = "SELECT * FROM usuario WHERE cpf = ? AND senha = ?";
		
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement prepStat = null;		
			
		System.out.println(sql_consulta);
		try {
			conn = new MySqlConnection().getConnection();
			prepStat = conn.prepareStatement(sql_consulta);
			prepStat.setString(1, usuario.getCpf());
			prepStat.setString(2, usuario.getSenha());
			rs = prepStat.executeQuery();
			
			System.out.println(rs);
	
			
		} catch(SQLException sqlEx) {
			System.out.println(sqlEx);
			return null;
		}
			catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {
			try {
				if(prepStat!=null) {
					//prepStat.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) {
					//conn.close();
					}
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		return rs;				
	}
	
	public Usuario buscarIdUsuario(int id) {
		String sql = "SELECT * FROM usuario WHERE idusuario = ?";
		
		ResultSet rs = null;
		PreparedStatement prepStat = null;
		Connection conn = null;
		
		Usuario usuario = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			prepStat = conn.prepareStatement(sql);
			prepStat.setInt(1, usuario.getId());
			rs = prepStat.executeQuery();
			
			if(rs!=null && rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("idusuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepStat!=null) {
					prepStat.close();
				}
			}
			catch(SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
					}
			}catch(SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
			
			catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		
		return usuario;
	}
	
	public void alterarUsuario(Usuario usuario) {
		String sql = "UPDATE usuario SET nome =?, senha = ? WHERE idusuario = ?";
		
		PreparedStatement prepStat = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			prepStat = conn.prepareStatement(sql);
			prepStat.setString(1, usuario.getNome());
			prepStat.setString(2, usuario.getSenha());
			prepStat.setInt(3, usuario.getId());
			prepStat.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepStat!=null) {
					prepStat.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
					}
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
	}

}
