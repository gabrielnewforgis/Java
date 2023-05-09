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

    public static void deletar(ArrayList<User> dados, String id) {
        for (User usuario : dados) {
            if (usuario.getId().equals(id)) {
                int confirm = JOptionPane.showConfirmDialog(null, "Você realmente deseja deletar o usuário " + usuario.getNome() + "?", "Deletar", JOptionPane.YES_NO_OPTION);
                 if (confirm == JOptionPane.YES_OPTION) {
                dados.remove(usuario);
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!", "Deletar", JOptionPane.PLAIN_MESSAGE);
                return;
                 }else{ 
                     return;
                 }
            }
        }
    
        JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Deletar", JOptionPane.PLAIN_MESSAGE);
    }
}
