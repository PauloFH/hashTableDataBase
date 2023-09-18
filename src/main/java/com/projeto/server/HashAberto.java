package com.projeto.server;

import com.projeto.model.Veiculo;

public class HashAberto {

	int m;
	No tabela[];

	public HashAberto(int tam) {
		this.m = tam;
		this.tabela = new No[this.m];
	}

	public int hash(int k) {

		return k % this.m;

	}

	public void inserir(int k, Veiculo v) {
        int h = this.hash(k);

        while (tabela[h] != null) {
            if (tabela[h].chave == k) {
                System.out.println("Chave duplicada");
                return;
            }
            h = (h + 1) % this.m;
        }

        tabela[h] = new No(k, v);
        System.out.println("Veiculo inserido com sucesso");
    }

	public No buscar(int k) {

		int h = this.hash(k);

		while (tabela[h] != null) {

			if (tabela[h].chave == k)
				return tabela[h];

			h = (h + 1) % this.m;
		}
		
		return null;

	}
	
	public void imprimir() {
		
		for (int i = 0; i < tabela.length; i++) {
			
			if(tabela[i] != null)
				System.out.println(i + " --> " + tabela[i].veiculo.toString());
			else
				System.out.println(i);
		}

	}

    public void Alterar(int k, Veiculo v){
		int h = this.hash(k);

   		 while (tabela[h] != null) {
        	if (tabela[h].chave == k) {
            tabela[h].veiculo = v;
       	     System.out.println("Veiculo alterado com sucesso");
        	}
        h = (h + 1) % this.m;
        if (h == this.hash(k)) {
           System.out.println("Veiculo não encontrado");
            break;
        }
    }
	 
	}


	public void Remover(int k) {
		
		int h = this.hash(k);
		if(tabela[h] == null){
		System.out.println("Veiculo não encontrado");
		return;
		}
		while (tabela[h] != null) {
			if (tabela[h].chave == k) {
				tabela[h] = null;
				System.out.println("Veiculo removido com sucesso");
			}
			h = (h + 1) % this.m;
			if (h == this.hash(k)) {
				break;
			}
			}
	}

	public int Quantidade() {
		int tm = 0;
			for (int i = 0; i < tabela.length; i++) {
				if(tabela[i] != null)
					tm++;
			}
		return tm;

	}

}