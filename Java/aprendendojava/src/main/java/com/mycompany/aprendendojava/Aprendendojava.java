/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aprendendojava;

import java.util.Scanner;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null,"Limite de usuários atingido\n", "Limite excedido", JOptionPane.WARNING_MESSAGE );
            return;

        }
        nomes[i[0]] = JOptionPane.showInputDialog(null, "Informe seu nome", "Cadastro", JOptionPane.QUESTION_MESSAGE);
        while (op != 15) {
           cpf[i[0]] = JOptionPane.showInputDialog(null, "Informe seu CPF", "Cadastro", JOptionPane.QUESTION_MESSAGE);
            if ((cpf[i[0]]).length() != 11) {
                JOptionPane.showMessageDialog(null,"CPF incorreto, informe um CPF válido", "Erro CPF", JOptionPane.ERROR_MESSAGE);
            } else {
                op = 15;
            }
        }
        while (op2 != 99) {
           celular[i[0]] = JOptionPane.showInputDialog(null,"Informe seu número de celular", "Cadastro", JOptionPane.QUESTION_MESSAGE);
            if ((celular[i[0]]).length() != 9) {
                JOptionPane.showMessageDialog(null,"Numero de celular incorreto, informe um número válido", "Erro telefone", JOptionPane.ERROR_MESSAGE);
            } else {
                op2 = 99;
            }

        }
        JOptionPane.showMessageDialog(null,"Usuário criado com sucesso!", "Cadastro", JOptionPane.PLAIN_MESSAGE);
        saldo[i[0]] = 0.0f;
        JOptionPane.showMessageDialog(null,"Nome: " + nomes[i[0]] + "\nCPF: " + cpf[i[0]] + "\nCelular: " + celular[i[0]] + "\nSaldo: " + saldo[i[0]]+ "\n", "Cadastro",JOptionPane.PLAIN_MESSAGE);

    }

    public static float credito(float[] saldo, String[] nomes, String[] cpf, int[] i) {
       String user = JOptionPane.showInputDialog(null,"Insira o CPF ou nome do usuário cadastrado que você deseja buscar:", "Saldo", JOptionPane.QUESTION_MESSAGE);
        int posicao;
        for (int j = 0; j < i[0]; j++) {
            if (user.equals(nomes[j]) || user.equals(cpf[j])) {
                posicao = j;
                JOptionPane.showMessageDialog(null,"Saldo atual: " + saldo[posicao], "Credito",JOptionPane.PLAIN_MESSAGE );
               float valor = Float.parseFloat(JOptionPane.showInputDialog(null,"Insira o quanto você deseja depositar:", "Credito",JOptionPane.PLAIN_MESSAGE));
                saldo[posicao] += valor;
                JOptionPane.showMessageDialog(null,"Saldo atualizado: " + saldo[posicao] + "\n", "Credito", JOptionPane.PLAIN_MESSAGE);
                return saldo[posicao];
               
            }
        }
     JOptionPane.showMessageDialog(null, "Usuário não encontrado.\n", "Erro de usuário", JOptionPane.ERROR_MESSAGE);
                return 0;
    }

    public static float debito(float[] saldo, String[] nomes, String[] cpf, int[] i) {
        String user = JOptionPane.showInputDialog(null,"Insira o CPF ou nome do usuário cadastrado que você deseja buscar:", "Saldo", JOptionPane.QUESTION_MESSAGE);
        int posicao;
        for (int j = 0; j < i[0]; j++) {
            if (user.equals(nomes[j]) || user.equals(cpf[j])) {
                posicao = j;
                JOptionPane.showMessageDialog(null,"Saldo atual: " + saldo[posicao], "Debito", JOptionPane.PLAIN_MESSAGE);
                  float valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Insira o quanto você deseja sacar:", "Debito", JOptionPane.QUESTION_MESSAGE));
                saldo[posicao] -= valor;
                JOptionPane.showMessageDialog(null, "Saldo atualizado: " + saldo[posicao] + "\n", "Debito", JOptionPane.PLAIN_MESSAGE);
                return saldo[posicao];
               
            }
        }
      JOptionPane.showMessageDialog(null,"Usuário não encontrado.", "Erro de usuário",JOptionPane.ERROR_MESSAGE );
                return 0;
    }

    public static String atualizar_cel(String[] celular) {
        int i = 0;
        JOptionPane.showMessageDialog(null,"Numero atual: " + celular[i], "Atualizar telefone",JOptionPane.PLAIN_MESSAGE );
        while (true) {
           String novoNumero = JOptionPane.showInputDialog(null, "Insira o novo número:", "Atualizar telefone",JOptionPane.QUESTION_MESSAGE );

            if ((novoNumero).length() != 9) {
                JOptionPane.showMessageDialog(null,"Numero de celular incorreto, informe um número válido", "Atualizar telefone", JOptionPane.ERROR_MESSAGE);
            } else {
                celular[i] = novoNumero;
                JOptionPane.showMessageDialog(null, "Número atualizado com sucesso para: " + celular[i] + "\n", "Atualizar telefone", JOptionPane.PLAIN_MESSAGE);
                return novoNumero;
            }
        }
    }

    public static void buscar_user(String[] nomes, String[] cpf, String[] celular, float[] saldo) {
        String user = JOptionPane.showInputDialog(null,"Insira o CPF ou nome do usuário cadastrado que você deseja buscar:", "Saldo", JOptionPane.QUESTION_MESSAGE);
        for (int i = 0; i < nomes.length; i++) {
            if (user.equals(nomes[i]) || user.equals(String.valueOf(cpf[i]))) {
                JOptionPane.showMessageDialog(null,"Usuário encontrado!", "Busca de usuário",JOptionPane.INFORMATION_MESSAGE );
                JOptionPane.showMessageDialog(null, "Nome: " + nomes[i] + "\nCPF: " + cpf[i] + "\nCelular: " + celular[i] + "Saldo: " + saldo[i] + "\n", "Busca de usuário",JOptionPane.PLAIN_MESSAGE );
            }
        }
    }

    public static float buscar_saldo(float[] saldo, String[]nomes, String[] cpf) {
        String user = JOptionPane.showInputDialog(null,"Insira o CPF ou nome do usuário cadastrado que você deseja buscar:", "Saldo", JOptionPane.QUESTION_MESSAGE);
        for (int i = 0; i < nomes.length; i++) {
            if (user.equals(nomes[i]) || user.equals(String.valueOf(cpf[i]))) {
        float saldoUser = saldo[i];
        JOptionPane.showMessageDialog(null,"Seu saldo é: " + saldoUser + "\n", "Saldo", JOptionPane.PLAIN_MESSAGE);
        return saldoUser;
    }
        }
    JOptionPane.showMessageDialog(null,"Usuário não encontrado.\n", "Erro de usuário", JOptionPane.ERROR_MESSAGE);
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
            String input = JOptionPane.showInputDialog(null, "Escolha uma opção: \n1-Cadastrar\n2-Credito\n3-Debito\n4-Atualizar Celular\n5-Verificar usuario\n6-Verificar saldo\n7-Sair", "Banco Senac", JOptionPane.PLAIN_MESSAGE);
            op = Integer.parseInt(input);

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
