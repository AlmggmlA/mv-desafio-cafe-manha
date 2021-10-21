package model;

import java.util.ArrayList;

import dao.ItemDAO;

public class Item_cafeManha {
	
	private int idItem;
	private String nomeItem;
	
	public Item_cafeManha() {}
	
	public Item_cafeManha(int idItem, String nomeItem) {
		this.idItem = idItem;
		this.nomeItem = nomeItem;
	}

	public Item_cafeManha(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
	
	public void salvar() {
		new ItemDAO().cadastrarItem(this);
	}
	
	public ArrayList<Item_cafeManha> consultarItem(String nomeItem){
		return new ItemDAO().consultarItem(nomeItem);
	}
}
