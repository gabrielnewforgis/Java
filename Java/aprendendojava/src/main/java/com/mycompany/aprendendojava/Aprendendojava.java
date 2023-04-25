/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aprendendojava;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Aprendendojava {

    static Scanner s = new Scanner(System.in);
    static Scanner n = new Scanner(System.in);

    public static void cadastrar(String[] nomes, String[] cpf, String[] celular, float[] saldo, int i) {
        int op=0;
        int op2=0;
        if ( i >= nomes.length) {
            System.out.println("Limite de usuários atingido");
            return;
        
        }
        System.out.println("Informe seu nome");
        nomes[i] = s.nextLine();
        while (op != 15) {
        System.out.println("Informe seu CPF");
        cpf[i] = s.nextLine();
        if ((cpf[i]).length() != 11) {
        System.out.println("CPF incorreto, informe um válido");
        }else{
            op=15;
        }
        }
       while(op2 != 99){
        System.out.println("Informe seu celular");
        celular[i] = s.nextLine();
          if((celular[i]).length() != 9){
         System.out.println("Numero de celular incorreto, informe um válido");
          }else{
              op2=99;
          }
          System.out.println("Nome: " + nomes[i] + "\nCPF: " + cpf[i] + "\nCelular: " + celular[i] + "\nSaldo: " + saldo[i]);
       }         
    }   
    
        public static float credito(float[] saldo,String[] nomes, String[] cpf) {
        System.out.println("Insira o cpf ou nome do usuario cadastrado que você deseja buscar: ");
        String user = s.nextLine();
        for (int ind = 0; ind < nomes.length; ind++) {
            if (user.equals(nomes[ind]) || user.equals(String.valueOf(cpf[ind]))) {
        System.out.println("Saldo atual: " + saldo[ind]);
        System.out.println("Insira o quanto você deseja depositar:");
        float deposito = n.nextFloat();
        saldo[ind] += deposito;
        System.out.println("Saldo atualizado: " + saldo[ind]);
       return saldo[ind];
            }
        }
   System.out.println("Usuário não encontrado.");
    return -1;
        }
    public static float debito(float[] saldo) {
        System.out.println("Insira o número de segurança do usuário");
        int i = n.nextInt();

        System.out.println("Saldo atual: " + saldo[i]);
        System.out.println("Insira o quanto você deseja retirar:");
        float saque = n.nextFloat();
        saldo[i] -= saque;

        System.out.println("Saldo atualizado: " + saldo[i]);
        return saldo[i];
    }

    public static String atualizar_cel(String[] celular) {
        int i=0;
        System.out.println("Numero atual: " + celular[i]);
        while(true){
        System.out.println("Insira o novo número: ");
        String novoNumero = s.nextLine();
             
        if((novoNumero).length() != 9){
         System.out.println("Numero de celular incorreto, informe um válido");
          }else{
         celular[i] = novoNumero;
         System.out.println("Número atualizado com sucesso para: " + celular[i]);
             return novoNumero;
        }
    }
 }
    public static void buscar_user(String[] nomes, String[] cpf, String[] celular) {
        System.out.println("Insira o cpf ou nome do usuario cadastrado que você deseja buscar: ");
        String user = s.nextLine();
        for (int i = 0; i < nomes.length; i++) {
            if (user.equals(nomes[i]) || user.equals(String.valueOf(cpf[i]))) {
                System.out.println("Usuário encontrado!");
                System.out.println("Nome: " + nomes[i] + "\nCPF: " + cpf[i] + "\nCelular: " + celular[i]);
            }
        }
    }

    public static float buscar_saldo(float[] saldo) {
        System.out.println("Insira o número de segurança do usuário");
        int i = n.nextInt();
        float saldoUser = saldo[i];
        System.out.println("Seu saldo é: " + saldoUser);
        return saldoUser;
    }

    public static void main(String[] args) {
        String nomes[] = new String[10];
        String celular[] = new String[10];
        String cpf[] = new String[10];
        float saldo[] = new float[10];
        int op = 0;
        int i=0;
        
        while (op != 7) {
            System.out.println("--Banco Senac--");
            System.out.println("escolha uma opção: \n");
            System.out.println("1-Cadastrar\n2-Credito\n3-Debito\n4-Atualizar Celular\n5-Verificar usuario\n6-Verificar saldo\n7-Sair");
            op = n.nextInt();
            switch (op) {
                case 1 -> {
                    cadastrar(nomes, cpf, celular, saldo, i);
                i++;
}
                case 2 -> saldo[i] = credito(saldo,nomes, cpf);
                case 3 -> saldo[i] = debito(saldo);
                case 4 -> celular[i] = atualizar_cel(celular);
                case 5 -> buscar_user(nomes, cpf, celular);
                case 6 -> buscar_saldo(saldo);
            }

        }
    }
}
