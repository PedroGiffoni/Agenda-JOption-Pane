/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.giffoni.pedro.agenda;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Pedro
 */
public class PessoaRepository {

    private final String caminhoArquivo = "cadastros.txt";

    public ArrayList<Pessoa> carregar() {

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));

            String linha;

            while ((linha = leitor.readLine()) != null) {
                Pessoa pessoa = Pessoa.fromLinhaArquivo(linha);
                if (pessoa != null) {
                    pessoas.add(pessoa);
                }
            }

            leitor.close();

        } catch (FileNotFoundException e) {
           
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo.");
        }

        return pessoas;
    }

    public void salvar(ArrayList<Pessoa> pessoas) {

        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo));

            for (Pessoa pessoa : pessoas) {
                escritor.write(pessoa.toLinhaArquivo());
                escritor.newLine();
            }

            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo.");
        }
    }
    
        public Pessoa buscarPorTelefone(String telefone){

        for(Pessoa pessoa : carregar()){

            if(pessoa.getTelefone().equals(telefone)){
                return pessoa;
            }

        }

        return null;
    }
    
    
}