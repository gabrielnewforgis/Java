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

        int op = 99;

        while (op != 7) {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma opção:\n1- Cadastro\n2- Deletar usuário\n3- Credito\n4- Debito\n5- Busca de usuário\n6- Atualizar\n7- Sair", "Banco Senac", JOptionPane.PLAIN_MESSAGE));
            switch (op) {
                case 1 -> {
                   do{
                    nome = JOptionPane.showInputDialog(null, "Insira seu nome", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                   if(nome.isBlank()){
                       JOptionPane.showMessageDialog(null, "O nome não pode ser deixado em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                   }
                   }while(nome.isBlank());
                    do{
                            cpf = JOptionPane.showInputDialog(null, "Insira seu CPF", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        if (!cpf.matches("\\d{11}")) {
        JOptionPane.showMessageDialog(null, "CPF inválido! O CPF deve ter 11 dígitos e apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } while(!cpf.matches("\\d{11}"));
                        do{
                         idade = JOptionPane.showInputDialog(null, "Insira sua idade", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        if(idade.isBlank()){
                            JOptionPane.showMessageDialog(null, "A idade não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        }while(idade.isBlank());
                         celular = JOptionPane.showInputDialog(null, "Insira seu número de celular", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                         do{
                         if (celular.length() != 9) {
                            JOptionPane.showMessageDialog(null, "Número de celular inválido! O número deve ter 9 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                         }
                         }while(idade.isBlank());
                        do{
                         id = JOptionPane.showInputDialog(null, "Insira seu ID", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        if(id.isBlank()){
                            JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        }while(id.isBlank());
                        
                        usuario = new User(nome, cpf, idade, celular, id, 0);
                        dados.add(usuario);
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(null, usuario.toString(), "Cadastro", JOptionPane.PLAIN_MESSAGE);
                        break;
                }

                case 2 -> {
                    String delete;
                    do{
                    delete = JOptionPane.showInputDialog(null, "Insira o ID do usuário que deseja deletar", "Deletar", JOptionPane.PLAIN_MESSAGE);
                    if(delete.isBlank()){
                        JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    }while(delete.isBlank());
                    usuario.deletar(dados, delete);
                    break;
                }
                case 3 -> {
                     String creditar;
                    do{
                     creditar = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Credito", JOptionPane.PLAIN_MESSAGE);
                    if(creditar.isBlank()){
                        JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    }while(creditar.isBlank());
                     usuario.credito(dados, creditar);
                    break;
                }
                case 4 -> {
                    String debitar;
                    do{
                    debitar = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Debito", JOptionPane.PLAIN_MESSAGE);
                    if(debitar.isBlank()){
                        JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    }while(debitar.isBlank());
                    usuario.debito(dados, debitar);
                    break;
                }
                case 5 -> {
                    String mostrar;
                    do{
                    mostrar = JOptionPane.showInputDialog(null, "Insira o ID do usuário que você deseja procurar: ", "Debito", JOptionPane.PLAIN_MESSAGE);
                    if(mostrar.isBlank()){
                        JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    }while(mostrar.isBlank());
                    if (usuario.getId().equals(mostrar)) {
                        JOptionPane.showMessageDialog(null, "Usuário encontrado!\n", "Procurar", JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(null, usuario.toString(), "Procurar", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Procurar", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 6 -> {
                    String atualizar;
                   do{
                    atualizar = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Debito", JOptionPane.PLAIN_MESSAGE);
                    if(atualizar.isBlank()){
                        JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                   }while(atualizar.isBlank());
                    usuario.atualizar(dados, atualizar);
                }
            }
        }
    }
}
