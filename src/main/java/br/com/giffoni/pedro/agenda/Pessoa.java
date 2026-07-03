/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.giffoni.pedro.agenda;

/**
 *
 * @author Pedro
 */


public class Pessoa {

    private String nome;
    private int idade;
    private String telefone;

    public Pessoa(String nome, int idade, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String toLinhaArquivo() {
        return nome + ";" + idade + ";" + telefone;
    }

    public static Pessoa fromLinhaArquivo(String linha) {
        String[] dados = linha.split(";");
            if (dados.length != 3) {
                return null;
            }
            
        String nome = dados[0];
        int idade = Integer.parseInt(dados[1]);
        String telefone = dados[2];

        return new Pessoa(nome, idade, telefone);
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome +
               "\nIdade: " + idade +
               "\nTelefone: " + telefone;
    }
}