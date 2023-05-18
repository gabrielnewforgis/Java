/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class User {
    //atributos
    private String nome;
    private String cpf;
    private String idade;
    private String cel;
    private String id;
    private float valor;

    //construtor
    public User(String nome, String cpf, String idade, String cel, String id, float valor) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.cel = cel;
        this.id = id;
        this.valor = valor;
    }

    // Métodos Get/Set para acessar e modificar os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public String setValor(float valor) {
        this.valor = valor;
        return null;
    }
  
// Retorna uma representação dos atributos do usuário
    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nIdade: " + idade + "\nCelular: " + cel + "\nID: " + id + "\nValor: " + valor;
    }
//Métodos
// Método para deletar um usuário da lista de dados
    public void deletar(ArrayList<User> dados) {
         String delete;
          // Solicita o ID do usuário a ser deletado           
                    do{
                    delete = JOptionPane.showInputDialog(null, "Insira o ID do usuário que deseja deletar", "Deletar", JOptionPane.PLAIN_MESSAGE);
                    // Verifica se o ID do usuário atual corresponde ao ID informado
                    if(delete.isBlank()|| delete.matches(".*\\D.*")) {
                        JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    }while(delete.isBlank()|| delete.matches(".*\\D.*"));
        for (User usuario : dados) {
            if (usuario.getId().equals(id)) {
                 // Exibe uma confirmação para deletar o usuário
                int confirm = JOptionPane.showConfirmDialog(null, "Você realmente deseja deletar o usuário " + usuario.nome + "?", "Deletar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Remove o usuário da lista
                    dados.remove(usuario);
                    JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!", "Deletar", JOptionPane.PLAIN_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada!", "Deletar", JOptionPane.ERROR_MESSAGE);
                }
            }
         }
       {
           // Se o usuário não for encontrado na lista exibe uma mensagem de erro 
           JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Deletar", JOptionPane.ERROR_MESSAGE);        
        }
    }
//Método para adicionar crédito ao saldo do usuário
    public void credito(ArrayList<User> dados) {
         String creditar;
         // Solicita o ID do usuário para realizar o crédito           
         do{
                     creditar = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Credito", JOptionPane.PLAIN_MESSAGE);
                     // Verifica se o ID está em branco ou contém caracteres numéricos
                     if(creditar.isBlank()|| creditar.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    }while(creditar.isBlank()|| creditar.matches(".*\\d.*"));
        for (User usuario : dados) {
              // Verifica se o ID do usuário atual corresponde ao ID informado
            if (usuario.getId().equals(id)) {
                // Solicita o valor a ser creditado e converte para float
                float credito = Float.parseFloat(JOptionPane.showInputDialog(null, "Usuário: " + usuario.nome + "\nSaldo atual: " + usuario.getValor() + "\nInsira o valor a ser depositado", "Credito", JOptionPane.PLAIN_MESSAGE));
                usuario.setValor(usuario.getValor() + credito);
                // Atualiza o saldo do usuário
                int index = dados.indexOf(usuario);
                dados.set(index, usuario);
                JOptionPane.showMessageDialog(null, "Saldo atualizado com sucesso!\nSaldo atual: " + usuario.valor, "Credito", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
    }
// Método para realizar saque do saldo do usuário
    public void debito(ArrayList<User> dados) {
        String debitar;
         // Solicita o ID do usuário para realizar o débito            
        do{
                    debitar = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Debito", JOptionPane.PLAIN_MESSAGE);
                    // Verifica se o ID está em branco ou contém caracteres numéricos
                    if(debitar.isBlank()|| debitar.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    }while(debitar.isBlank()|| debitar.matches(".*\\d.*"));
        for (User usuario : dados) {
            // Verifica se o ID do usuário atual corresponde ao ID informado
            if (usuario.getId().equals(id)) {
                 // Solicita o valor a ser debitado e converte para float
                float debito = Float.parseFloat(JOptionPane.showInputDialog(null, "Usuário: " + usuario.nome + "\nSaldo atual: " + usuario.getValor() + "\nInsira o valor a ser sacado", "Debito", JOptionPane.PLAIN_MESSAGE));
                 // Verifica se o saldo é suficiente para realizar o débito
                usuario.setValor(usuario.getValor() - debito);
                // Atualiza o saldo do usuário
                int index = dados.indexOf(usuario);
                dados.set(index, usuario);
                JOptionPane.showMessageDialog(null, "Saldo atualizado com sucesso!\nSaldo atual: " + usuario.valor, "Debito", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
    }
    // Método para procurar um usuário pelo ID e exibir suas informações
    public void mostrar(ArrayList<User> dados) {
           String mostrar;
                    // Solicita o ID do usuário que deseja procurar
           do{
                    mostrar = JOptionPane.showInputDialog(null, "Insira o ID do usuário que você deseja procurar: ", "Debito", JOptionPane.PLAIN_MESSAGE);
                    // Verifica se o ID está em branco ou contém caracteres numéricos
                    if(mostrar.isBlank()|| mostrar.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(null, "O ID não pode ser deixada em branco", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    }while(mostrar.isBlank()|| mostrar.matches(".*\\d.*"));
                    boolean encontrado = false;
    for (User usuario : dados) {
         // Verifica se o ID do usuário atual corresponde ao ID informado
        if (usuario.getId().equals(mostrar)) {
            encontrado = true;
             // Exibe uma mensagem informando que o usuário foi encontrado
            JOptionPane.showMessageDialog(null, "Usuário encontrado!\n", "Procurar", JOptionPane.PLAIN_MESSAGE);
             // Exibe as informações do usuário
            JOptionPane.showMessageDialog(null, usuario.toString(), "Procurar", JOptionPane.PLAIN_MESSAGE);
            break;
        }
    }
// Se o usuário não foi encontrado, exibe uma mensagem de erro
    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Procurar", JOptionPane.ERROR_MESSAGE);
    }
}
    // Método para atualizar o número de celular de um usuário
    public void atualizar(ArrayList<User> dados) {
    String atualizar;
    // Solicita o ID do usuário que deseja atualizar
    do {
        atualizar = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Atualizar", JOptionPane.PLAIN_MESSAGE);
        // Verifica se o ID está em branco ou contém caracteres numéricos
        if (atualizar.isBlank() || atualizar.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "O ID não pode ser deixado em branco", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } while (atualizar.isBlank() || atualizar.matches(".*\\d.*"));

    for (User usuario : dados) {
        if (usuario.getId().equals(atualizar)) {
            String celular;
            do {
                // Solicita o novo número de celular e mostra o atual
                celular = JOptionPane.showInputDialog(null, "Número de celular atual: " + usuario.getCel() + "\nInsira o novo número de celular (9 dígitos): ", "Atualizar", JOptionPane.PLAIN_MESSAGE);
                if (celular.isBlank() || !celular.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(null, "Número de celular inválido! O número deve ter 9 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } while (celular.isBlank() || !celular.matches("\\d{9}"));
            
            // Atualiza o número de celular do usuário
            usuario.setCel(celular);
            // Exibe uma mensagem de sucesso com o número de celular atualizado
            JOptionPane.showMessageDialog(null, "Número de telefone atualizado com sucesso!\nNúmero atual: " + usuario.getCel());
        }
    }
}
}
