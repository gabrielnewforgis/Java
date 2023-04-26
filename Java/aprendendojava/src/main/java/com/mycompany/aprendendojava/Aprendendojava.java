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

    public static void cadastrar(String[] nomes, String[] cpf, String[] celular, float[] saldo, int[] i) {
        int op = 0;
        int op2 = 0;
        if (i[0] >= nomes.length) {
            System.out.println("Limite de usuários atingido");
            return;

        }
        System.out.println("Informe seu nome");
        nomes[i[0]] = s.nextLine();
        while (op != 15) {
            System.out.println("Informe seu CPF");
            cpf[i[0]] = s.nextLine();
            if ((cpf[i[0]]).length() != 11) {
                System.out.println("CPF incorreto, informe um válido");
            } else {
                op = 15;
            }
        }
        while (op2 != 99) {
            System.out.println("Informe seu celular");
            celular[i[0]] = s.nextLine();
            if ((celular[i[0]]).length() != 9) {
                System.out.println("Numero de celular incorreto, informe um válido");
            } else {
                op2 = 99;
            }

        }
        System.out.println("Usuario criado com sucesso!");
        saldo[i[0]] = 0.0f;
        System.out.println("Nome: " + nomes[i[0]] + "\nCPF: " + cpf[i[0]] + "\nCelular: " + celular[i[0]] + "\nSaldo: " + saldo[i[0]]+ "\n");

    }

    public static float credito(float[] saldo, String[] nomes, String[] cpf, int[] i) {
        System.out.println("Insira o cpf ou nome do usuario cadastrado que você deseja buscar: ");
        String user = s.nextLine();
        int posicao;
        for (int j = 0; j < i[0]; j++) {
            if (user.equals(nomes[j]) || user.equals(cpf[j])) {
                posicao = j;
                System.out.println("Saldo atual: " + saldo[posicao]);
                System.out.println("Insira o quanto você deseja depositar:");
                float deposito = n.nextFloat();
                saldo[posicao] += deposito;
                System.out.println("Saldo atualizado: " + saldo[posicao]+ "\n");
                return saldo[posicao];
               
            }
        }
     System.out.println("Usuário não encontrado.");
                return 0;
    }

    public static float debito(float[] saldo, String[] nomes, String[] cpf, int[] i) {
        System.out.println("Insira o cpf ou nome do usuario cadastrado que você deseja buscar: ");
        String user = s.nextLine();
        int posicao;
        for (int j = 0; j < i[0]; j++) {
            if (user.equals(nomes[j]) || user.equals(cpf[j])) {
                posicao = j;
                System.out.println("Saldo atual: " + saldo[posicao]);
                System.out.println("Insira o quanto você deseja depositar:");
                float deposito = n.nextFloat();
                saldo[posicao] -= deposito;
                System.out.println("Saldo atualizado: " + saldo[posicao] + "\n");
                return saldo[posicao];
               
            }
        }
     System.out.println("Usuário não encontrado.");
                return 0;
    }

    public static String atualizar_cel(String[] celular) {
        int i = 0;
        System.out.println("Numero atual: " + celular[i]);
        while (true) {
            System.out.println("Insira o novo número: ");
            String novoNumero = s.nextLine();

            if ((novoNumero).length() != 9) {
                System.out.println("Numero de celular incorreto, informe um válido");
            } else {
                celular[i] = novoNumero;
                System.out.println("Número atualizado com sucesso para: " + celular[i] + "\n");
                return novoNumero;
            }
        }
    }

    public static void buscar_user(String[] nomes, String[] cpf, String[] celular, float[] saldo) {
        System.out.println("Insira o cpf ou nome do usuario cadastrado que você deseja buscar: ");
        String user = s.nextLine();
        for (int i = 0; i < nomes.length; i++) {
            if (user.equals(nomes[i]) || user.equals(String.valueOf(cpf[i]))) {
                System.out.println("Usuário encontrado!");
                System.out.println("Nome: " + nomes[i] + "\nCPF: " + cpf[i] + "\nCelular: " + celular[i] + "Saldo: " + saldo + "\n");
            }
        }
    }

    public static float buscar_saldo(float[] saldo, String[]nomes, String[] cpf) {
        System.out.println("Insira o cpf ou nome do usuario cadastrado que você deseja buscar: ");
        String user = s.nextLine();
        for (int i = 0; i < nomes.length; i++) {
            if (user.equals(nomes[i]) || user.equals(String.valueOf(cpf[i]))) {
        float saldoUser = saldo[i];
        System.out.println("Seu saldo é: " + saldoUser + "\n");
        return saldoUser;
    }
        }
    System.out.println("Usuário não encontrado.\n");
                return 0;
    }
    public static void main(String[] args) {
        String nomes[] = new String[10];
        String celular[] = new String[10];
        String cpf[] = new String[10];
        float saldo[] = new float[10];
        int op = 0;
        int i[] = new int[10];

        while (op != 7) {
            System.out.println("--Banco Senac--");
            System.out.println("escolha uma opção: \n");
            System.out.println("1-Cadastrar\n2-Credito\n3-Debito\n4-Atualizar Celular\n5-Verificar usuario\n6-Verificar saldo\n7-Sair");
            op = n.nextInt();

            switch (op) {
                case 1 -> {
                    cadastrar(nomes, cpf, celular, saldo, i);
                    i[0]++;
                }
                case 2 ->
                    saldo[i[0]] = credito(saldo, nomes, cpf, i);
                case 3 ->
                    saldo[i[0]] = debito(saldo, nomes, cpf, i);
                case 4 ->
                    celular[i[0]] = atualizar_cel(celular);
                case 5 ->
                    buscar_user(nomes, cpf, celular, saldo);
                case 6 ->
                    buscar_saldo(saldo, nomes, cpf);
            }

        }
    }
}
