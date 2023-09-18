package com.projeto.server;
import java.util.Scanner;


import com.projeto.model.Veiculo;

public class ServerAberto extends Server{

	
	public static HashAberto hash;
	
	public ServerAberto() {
		hash = new HashAberto(255);

	}
    public void inserir(int renavan, Veiculo v) {
		hash.inserir(renavan, v);
    }
	public void remover(int renavan) {
		hash.Remover(renavan);
	}
	public void alterar(int renavan, Veiculo v) {
		hash.Alterar(renavan, v);
	}
	
	public No buscar(int renavan) {
		return hash.buscar(renavan);
	}
	public int quantidade() {
		return hash.Quantidade();
	}
	
	public void imprimir() {
		hash.imprimir();
	}




	

}