package com.projeto.server;

import com.projeto.model.Veiculo;

public class HashExtendido {

    Integer m;
    No tabela[];

    public HashExtendido(int tam) {
        this.m = tam;
        this.tabela = new No[this.m];
    }

    public int hash(int k) {
        return k % m;
    }

    public void inserir(int k, Veiculo v) {
        
		Integer c = this.hash(k);
		No no = this.tabela[c];
		
		while(no != null) {
			if(no.chave == k) {
				break;
			}
			no = no.prox;
		}
		if(no == null) {
			no = new No(k,v);
			no.prox = this.tabela[c];
			this.tabela[c] = no;
		}
    }
    public No buscar(int k) {
        Integer c = this.hash(k);
        No no = this.tabela[c];
        while (no != null) {
            if (no.chave == k)
                return no;
            no = no.prox;
        }
        System.out.println("Veiculo não encontrado");
        return null;
    }

    public void imprimir() {
        No no;

        for (int i = 0; i < this.m; i++) {
            no = this.tabela[i];
            System.out.print(i);

            while (no != null) {
                System.out.print(" --> " + no.veiculo.toString());
                no = no.prox;
            }
			System.out.println();
        }
	}
	public void Alterar(int renavan, Veiculo v) {
		Integer c = this.hash(renavan);
		No no = this.tabela[c];
	
		while (no != null) {
			if (no.chave == renavan) {
				no.veiculo = v;
				System.out.println("Veiculo alterado com sucesso");
				return;
			}
			no = no.prox;
		}
	
		System.out.println("Veiculo não encontrado");
	}
	
	public void Remover(int renavan) {
		Integer c = this.hash(renavan);
		No no = this.tabela[c];
		No anterior = null;

		if(tabela[c] == null){
			System.out.println("Veiculo não encontrado");
			return;
			}
		while (no != null) {
			if (no.chave == renavan) {
				if (anterior == null) {
					// O veículo a ser removido é o primeiro da lista
					this.tabela[c] = no.prox;
				} else {
					anterior.prox = no.prox;
				}
				System.out.println("Veiculo removido com sucesso ");
				return;
			}
			anterior = no;
			no = no.prox;
		}
	
		System.out.println("Veiculo não encontrado");
	}

	public int Quantidade() {
		int total = 0;
	
		for (int i = 0; i < this.m; i++) {
			No no = this.tabela[i];
	
			while (no != null) {
				total++;
				no = no.prox;
			}
		}
	
		return total;
	}
	
	
}
