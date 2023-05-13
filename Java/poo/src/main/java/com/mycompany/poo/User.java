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

    // get/set
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
//fim get/set   

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nIdade: " + idade + "\nCelular: " + cel + "\nID: " + id + "\nValor: " + valor;
    }
//Métodos

    public void deletar(ArrayList<User> dados, String id) {
        boolean encontrado = false;
        for (User usuario : dados) {
            if (usuario.getId().equals(id)) {
                encontrado = true;
                int confirm = JOptionPane.showConfirmDialog(null, "Você realmente deseja deletar o usuário " + usuario.nome + "?", "Deletar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dados.remove(usuario);
                    JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!", "Deletar", JOptionPane.PLAIN_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada!", "Deletar", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Deletar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void credito(ArrayList<User> dados, String id) {
        for (User usuario : dados) {
            if (usuario.getId().equals(id)) {
                float credito = Float.parseFloat(JOptionPane.showInputDialog(null, "Usuário: " + usuario.nome + "\nSaldo atual: " + usuario.getValor() + "\nInsira o valor a ser depositado", "Credito", JOptionPane.PLAIN_MESSAGE));
                usuario.setValor(usuario.getValor() + credito);
                int index = dados.indexOf(usuario);
                dados.set(index, usuario);
                JOptionPane.showMessageDialog(null, "Saldo atualizado com sucesso!\nSaldo atual: " + usuario.valor, "Credito", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
    }

    public void debito(ArrayList<User> dados, String id) {
        for (User usuario : dados) {
            if (usuario.getId().equals(id)) {
                float debito = Float.parseFloat(JOptionPane.showInputDialog(null, "Usuário: " + usuario.nome + "\nSaldo atual: " + usuario.getValor() + "\nInsira o valor a ser sacado", "Debito", JOptionPane.PLAIN_MESSAGE));
                usuario.setValor(usuario.getValor() - debito);
                int index = dados.indexOf(usuario);
                dados.set(index, usuario);
                JOptionPane.showMessageDialog(null, "Saldo atualizado com sucesso!\nSaldo atual: " + usuario.valor, "Debito", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
    }
    public void atualizar(ArrayList<User> dados, String id){
        for (User usuario : dados) {
             if (usuario.getId().equals(id)) {
                 String celular = JOptionPane.showInputDialog(null, "Número de celular atual:"+ usuario.getCel() +"\nInsira o novo número de celular: ", "Atualizar", JOptionPane.PLAIN_MESSAGE);
                 usuario.setCel(celular);
                 JOptionPane.showMessageDialog(null, "Número de telefone atualizado com sucesso!\n Número atual: "+ usuario.cel);
             }
        }
    }
}
