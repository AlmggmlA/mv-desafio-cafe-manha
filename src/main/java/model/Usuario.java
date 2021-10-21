package model;

import dao.ItemDAO;
import dao.UsuarioDAO;

public class Usuario {
	
	private int id;
	private String cpf;
	private String nome;
	private String senha;
	private String item_cafeManha;
	
	public Usuario(int id, String cpf, String nome,String senha,String item_cafeManha){
		this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.item_cafeManha = item_cafeManha;
    }
	
	public Usuario(String cpf, String nome,String senha,String item_cafeManha){		
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.item_cafeManha = item_cafeManha;
    }
	
	public Usuario() {}
	
	public String getCpf() {return cpf;}
	public void setCpf(String cpf) {this.cpf = cpf;}
	
	public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    
    public String getItem() {return nome;}
    public void setItem(String item_cafeManha) {this.item_cafeManha = item_cafeManha;}
    
    
	public void salvar() {
		new UsuarioDAO().cadastrarUsuario(this);
	} 
	
	public void consultar() {
		new UsuarioDAO().consultarUsuario(this);
	}
 
}
