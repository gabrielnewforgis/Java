/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Poo {

    public static void main(String[] args) {
        ArrayList<User> dados = new ArrayList<>();
       User usuario = new User("", "", "","","", 0);
         
        int op = 99;

        while (op != 7) {
            String input = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1- Cadastro\n2- Deletar usuário\n3- Credito\n4- Debito\n5- Busca de usuário\n7- Sair", "Banco Senac", JOptionPane.PLAIN_MESSAGE);
            op = Integer.parseInt(input);
 
            switch (op) {
                case 1 -> {
                    String nome = JOptionPane.showInputDialog(null, "Insira seu nome", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    String cpf = JOptionPane.showInputDialog(null, "Insira seu CPF", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    String idade = JOptionPane.showInputDialog(null, "Insira sua idade", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    String celular = JOptionPane.showInputDialog(null, "Insira seu número de celular", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    String id = JOptionPane.showInputDialog(null, "Insira seu ID", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                   usuario = new User(nome,cpf,idade,celular,id, 0);
                    dados.add(usuario);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(null, usuario.toString(), "Cadastro", JOptionPane.PLAIN_MESSAGE);
                break;
                }
                case 2 -> {
                       String delete = JOptionPane.showInputDialog(null, "Insira o ID do usuário que deseja deletar", "Deletar", JOptionPane.PLAIN_MESSAGE);
                    usuario.deletar(dados,  delete);
                break;
                }
                case 3 -> {
                    String creditar = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Credito", JOptionPane.PLAIN_MESSAGE);
                    usuario.credito(dados, creditar);
                break;
                }
                case 4 -> {
                    String debitar = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Debito", JOptionPane.PLAIN_MESSAGE);
                    usuario.debito(dados, debitar);
                break;
                }
                case 5 -> {
                    String mostrar = JOptionPane.showInputDialog(null, "Insira o ID do usuário que você deseja procurar: ", "Debito", JOptionPane.PLAIN_MESSAGE);
                    if (usuario.getId().equals(mostrar)) {
                        JOptionPane.showMessageDialog(null, "Usuário encontrado!\n", "Procurar", JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(null,usuario.toString(), "Procurar", JOptionPane.PLAIN_MESSAGE);   
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Procurar", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 6 -> {
                    
                }
            }
        }
    }
}
