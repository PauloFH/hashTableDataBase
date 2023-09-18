package com.projeto.protocol;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.projeto.exceptions.InvalidDataException;
import com.projeto.model.Veiculo;
import com.projeto.server.No;
import com.projeto.server.Server;
import com.projeto.server.ServerAberto;
import com.projeto.server.ServerExtendido;

public class Protocol {
    public static Server server;
    public static BufferedWriter gravarArq;
	FileWriter aql;
	
	public Protocol(ServerAberto server2) {
                try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd_MM_yyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("_HH_mm_ss").format(dataHoraAtual);
			String name = data+hora+ "_log";
			aql = new FileWriter(name+".txt");
			gravarArq = new BufferedWriter(aql);
            server = server2;
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }

    public Protocol(ServerExtendido server2) {
         try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd_MM_yyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("_HH_mm_ss").format(dataHoraAtual);
			String name = data+hora+ "_log";
			aql = new FileWriter(name+".txt");
			gravarArq = new BufferedWriter(aql);
            server = server2;
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }

    public void openAccess() {
        System.out.print("Tentando iniciar conexão");
        
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(5); // Aguarda 0.5 segundos
                System.out.print("."); // Imprime um ponto para simular a barra girando
            }
            
            System.out.println("\nConexão com o servidor feita com sucesso");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void cadVeiculos(){
          Scanner lex1;
        try{
         lex1 = new Scanner(System.in);
		 	String modelo;
			String cpf;
			String nome;
			int renavan;	
			String placa;
			int data = 0;
			System.out.println("Adicionar Veículos\n");
			System.out.print("marca do veículo: ");
			modelo = lex1.nextLine();
			System.out.print("placa do veículo: ");
			placa = lex1.nextLine();
			System.out.print("renavan do veículo: ");
			renavan = lex1.nextInt();
			System.out.print("data de fabricação do veículo: ");
			data = lex1.nextInt();
			lex1.nextLine();
			System.out.print("nome do condutor do veículo do veículo: ");
			nome = lex1.nextLine();
			System.out.print("CPF do condutor do veículo do veículo: ");
			cpf = lex1.nextLine();
			Veiculo v = new Veiculo(modelo,renavan , placa, data, nome, cpf);
        if (dadosInvalidos(modelo, placa, renavan, data, nome, cpf)) {
            throw new InvalidDataException("Dados de entrada inválidos. Verifique as informações e tente novamente.");
        }

                 writerAc("Adicionado Veiculo placa " + placa);
				server.inserir(renavan, v);
			} catch (InvalidDataException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
            };

	 }
      
	public void removeVeiculos() {
		  Scanner lex2 = new Scanner(System.in);
        int renavan;
        System.out.println("Remover Veículos\n");
        
        try{
        System.out.print("Digite renavan do veículo: ");
           renavan = lex2.nextInt();
           server.remover(renavan);
              writerAc("Remoção de veículo Realizada no veiculo: "+ renavan);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
    
    public void alterarVeiculos(){
        try{
         Scanner lex3 = new Scanner(System.in);
		 	String modelo;
			String cpf;
			String nome;
			int renavan = (int) 0;	
			String placa;
			int data = 0;
            System.out.print("Digite o renavam do veículo que você quer alterar: ");
			renavan = lex3.nextInt();
			lex3.nextLine();
			System.out.print("marca do veículo: ");
			modelo = lex3.nextLine();
			System.out.print("placa do veículo: ");
			placa = lex3.nextLine();
			System.out.print("data de fabricação do veículo: ");
			data = lex3.nextInt();
			lex3.nextLine();
			System.out.print("nome do condutor do veículo do veículo: ");
			nome = lex3.nextLine();
			System.out.print("CPF do condutor do veículo do veículo: ");
			cpf = lex3.nextLine();
			Veiculo v = new Veiculo(modelo,renavan , placa, data, nome, cpf);
            if (dadosInvalidos(modelo, placa, renavan, data, nome, cpf)) {
            throw new InvalidDataException("Dados de entrada inválidos. Verifique as informações e tente novamente.");
        }
			
				server.alterar(renavan, v);
                System.out.println("Veículo alterado com sucesso");
			} catch (InvalidDataException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
            };
    }
    public No buscarVeiculos(){
        
        Scanner lex4= new Scanner(System.in);
        int renavan;
        System.out.println("Buscar Veículos\n");
        
        
        System.out.print("Digite renavan do veículo: "); 
           renavan = lex4.nextInt();
           No v = server.buscar(renavan);
          if(v != null){
                System.out.println("Veículo encontrado");
                System.out.println(v.getVeiculo().toString());
          }else{
            System.out.println("Veículo Não encontrado");
          }              
          writerAc("Busca de veiculos Realizada");

          return v;


    }
    public void quantidade(){

        System.out.println("Quantidade de Veículos\n");
        int x = server.quantidade();
        System.out.println("Quantidade de veículos: "+x);
         writerAc("Contagem de veículos Realizada: " + x);
    }


    public void  closeAcess(){
        System.out.print("Tentando finalizar conexão");
        
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(5); // Aguarda 0.5 segundos
                System.out.print("."); // Imprime um ponto para simular a barra girando
            }
            
            System.out.println("\nConexão com o servidor finalizada com sucesso");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void listar(){
        System.out.println("Listar Veículos\n");
        server.imprimir();
        writerAc("Listagem de Veículos Realizada");

    }

   public void inserir(int k, Veiculo v){
        
        server.inserir(k, v);
          writerAc("Adicionar Veículos realizada de veiculo: " + v.getPlaca());
   }
public void  writerAc(String text) {
    try {
        gravarArq.write(text + "\n");
        gravarArq.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void buscar() {
    Scanner l = new Scanner(System.in);
    int renavan;
    System.out.println("Buscar Veículos\n");
    
    
    System.out.print("Digite renavan do veículo: ");
       renavan = l.nextInt();
       l.nextLine();
       No v = server.buscar(renavan);
      if(v != null){
            System.out.println("Veículo encontrado");
            System.out.println(v.getVeiculo().toString());
      }                   
      writerAc("Busca de veículos Realizada");

}
public  boolean dadosInvalidos(String modelo, String placa, int renavan, int data, String nome, String cpf) {

    if (modelo == null || placa == null || nome == null || cpf == null) {
        return true;
    }
    if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
        return true;
    }

    
    if (String.valueOf(renavan).length() > 9) {
        return true;
    }

    return false;
}
}