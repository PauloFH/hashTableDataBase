package com.projeto.server;

import com.projeto.model.Veiculo;

public class ServerExtendido  extends Server{
    	public static HashExtendido hash;
	
	public ServerExtendido() {
		hash = new HashExtendido(255);

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
