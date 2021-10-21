package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Item_cafeManha;

public class ItemDAO {
	
	public void cadastrarItem(Item_cafeManha item) {
		
		String sql = "INSERT INTO item VALUES (null,?,null)";
		
		PreparedStatement prepStat = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			prepStat = conn.prepareStatement(sql);
			prepStat.setString(1, item.getNomeItem());
			System.out.println(item.getNomeItem());
			System.out.println(sql);
			System.out.println(prepStat);
			
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
	
	public ArrayList<Item_cafeManha> consultarItem(String nomeItem){
		
		String sql_consulta = "SELECT * FROM item WHERE nome_item LIKE '%"+ nomeItem + "%'";
		
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement prepStat = null;		
		Item_cafeManha item = null;		
		ArrayList<Item_cafeManha> itens = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			prepStat = conn.prepareStatement(sql_consulta);
			rs = prepStat.executeQuery();
			
			if(rs!=null) {
				itens = new ArrayList<Item_cafeManha>();
				
				while(rs.next()) {
					item = new Item_cafeManha();
					item.setIdItem(rs.getInt("iditem") );
					item.setNomeItem(rs.getString("nome_item"));		
					itens.add(item);
				}
			}
			
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
		
		return itens;
		
	}

}
