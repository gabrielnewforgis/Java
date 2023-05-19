/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Poo {

    public static void main(String[] args) {
        String nome;
        String cpf;
        String idade;
        String celular;
        String id;
        ArrayList<User> dados = new ArrayList<>();
        User usuario = new User("", "", "", "", "", 0);

        int opcao = 0;
        String op;
        boolean valido = false;

        // Menu principal
        menu: while (opcao != 7) {
            // Exibe o menu e obtém a opção do usuário
            op = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1- Cadastro\n2- Deletar usuário\n3- Credito\n4- Debito\n5- Busca de usuário\n6- Atualizar\n7- Sair", "Banco Senac", JOptionPane.PLAIN_MESSAGE);
            if (op == null) {
                            return;
                        }
// Valida se a opção é um número válido
            if (op.matches("\\d+")) {
                opcao = Integer.parseInt(op);
            }
            // Verifica se a opção é válida
            if (opcao > 0 && opcao <= 7) {
                valido = true;
            }
            // Se a opção não for válida exibe uma mensagem de erro
            if (!valido) {
                JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);

            }
            switch (opcao) {
                // Cadastro de usuário
                case 1 -> {
                    do {
                        // Solicita informações do usuário
                        nome = JOptionPane.showInputDialog(null, "Insira seu nome", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        // Verifica se o botão "Cancelar" foi pressionado
                        if (nome == null) {
                            continue menu;
                        }
                        if (nome.isBlank() || nome.matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(null, "O nome não pode ser deixado em branco e não pode conter números", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (nome.isBlank() || nome.matches(".*\\d.*"));
                    do {
                        cpf = JOptionPane.showInputDialog(null, "Insira seu CPF", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        // Verifica se o botão "Cancelar" foi pressionado
                        if (cpf == null) {
                             continue menu;
                        }
                        if (cpf.isBlank() || !cpf.matches("\\d{11}")) {
                            JOptionPane.showMessageDialog(null, "CPF inválido! O CPF deve ter 11 dígitos e apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (cpf.isBlank() || !cpf.matches("\\d{11}"));
                    do {
                        idade = JOptionPane.showInputDialog(null, "Insira sua idade", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        // Verifica se o botão "Cancelar" foi pressionado
                        if (idade == null) {
                             continue menu;
                        }
                        if (idade.isBlank() || idade.matches(".*\\D.*")) {
                            JOptionPane.showMessageDialog(null, "A idade não pode ser deixada em branco e precisa conter apenas números", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (idade.isBlank() || idade.matches(".*\\D.*"));
                    do {
                        celular = JOptionPane.showInputDialog(null, "Insira seu número de celular", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        // Verifica se o botão "Cancelar" foi pressionado
                        if (celular == null) {
                             continue menu;
                        }
                        if (celular.isBlank() || !celular.matches("\\d{9}")) {
                            JOptionPane.showMessageDialog(null, "Número de celular inválido! O número deve ter 9 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (celular.isBlank() || !celular.matches("\\d{9}"));
                    do {
                        
                        id = JOptionPane.showInputDialog(null, "Insira seu ID", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        // Verifica se o botão "Cancelar" foi pressionado
                        if (id == null) {
                             continue menu;
                        }
                        if (id.isBlank() || !id.matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(null, "ID inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (id.isBlank() || !id.matches(".*\\d.*"));

                    // Cria um objeto User com os dados informados
                    usuario = new User(nome, cpf, idade, celular, id, 0);
                    // Adiciona o usuário à lista de dados
                    dados.add(usuario);
                    // Exibe uma mensagem de sucesso e os dados do usuário cadastrado
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(null, usuario.toString(), "Cadastro", JOptionPane.PLAIN_MESSAGE);

                }
                //Usa o método para apagar um usuário cadastrado
                case 2 -> {

                    usuario.deletar(dados);

                }
                //Usa o método para adicionar saldo na conta
                case 3 -> {
                    usuario.credito(dados);

                }
                //Usa o método para retirar saldo da conta
                case 4 -> {
                    usuario.debito(dados);

                }

                case 5 -> {
                    //Utiliza o método para mostrar um usuário cadastrado
                    usuario.mostrar(dados);

                }
                case 6 -> {
                    //Utiliza o método para atualizar o telefone de um usuário cadastrado
                    usuario.atualizar(dados);

                }
            }
        }
    }
}
