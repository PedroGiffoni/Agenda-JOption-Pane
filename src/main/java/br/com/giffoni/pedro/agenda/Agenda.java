/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.giffoni.pedro.agenda;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class Agenda {

    public static void main(String[] args) {

        PessoaRepository repository = new PessoaRepository();
        ArrayList<Pessoa> pessoas = repository.carregar();

        boolean rodando = true;

        while (rodando) {

            String opcao = JOptionPane.showInputDialog(
                    null,
                    "..:: MENU ::..\n" +
                    "1 - Cadastrar\n" +
                    "2 - Listar cadastros\n" +
                    "3 - Sair\n\n" +
                    "Escolha uma opção:"
            );

            if (opcao == null) {
                break;
            }

            switch (opcao) {
                case "1":
                    cadastrarPessoa(pessoas, repository);
                    break;

                case "2":
                    listarPessoas(pessoas);
                    break;

                case "3":
                    rodando = false;
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "[Erro] Opção inválida.");
                    break;
            }
        }
    }

    public static void cadastrarPessoa(ArrayList<Pessoa> pessoas, PessoaRepository repository) {

        String nome = pedirNome();

        if (nome == null) {
            return;
        }

        Integer idade = pedirIdade();

        if (idade == null) {
            return;
        }

        String telefone = pedirTelefone();

        if (telefone == null) {
            return;
        }

        Pessoa pessoaExistente = buscarPessoaPorTelefone(pessoas, telefone);

        if (pessoaExistente != null) {
            JOptionPane.showMessageDialog(
                    null,
                    "[Erro] Telefone já cadastrado!\n\n" +
                    "Este telefone pertence ao contato:\n" +
                    "Nome: " + pessoaExistente.getNome() + "\n" +
                    "Idade: " + pessoaExistente.getIdade() + "\n" +
                    "Telefone: " + pessoaExistente.getTelefone()
            );
            return;
        }

        Pessoa pessoa = new Pessoa(nome, idade, telefone);

        pessoas.add(pessoa);
        repository.salvar(pessoas);

        JOptionPane.showMessageDialog(
                null,
                "[Sucesso] Cadastro realizado com sucesso!\n\n" +
                "Nome: " + pessoa.getNome() + "\n" +
                "Idade: " + pessoa.getIdade() + "\n" +
                "Telefone: " + pessoa.getTelefone()
        );
    }

    public static String pedirNome() {

        while (true) {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome:");

            if (nome == null) {
                return null;
            }

            if (nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "[Erro] O nome não pode ficar vazio.");
                continue;
            }

            if (!nome.matches("[a-zA-ZÀ-ÿ ]+")) {
                JOptionPane.showMessageDialog(null, "[Erro] O nome deve conter apenas letras.");
                continue;
            }

            return nome;
        }
    }

    public static Integer pedirIdade() {

        while (true) {
            String idadeTexto = JOptionPane.showInputDialog(null, "Digite a idade:");

            if (idadeTexto == null) {
                return null;
            }

            if (idadeTexto.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "[Erro] A idade não pode ficar vazia.");
                continue;
            }

            try {
                int idade = Integer.parseInt(idadeTexto);

                if (idade < 18) {
                    JOptionPane.showMessageDialog(
                            null,
                            "[Rejeitado] Apenas maiores de idade podem ser cadastrados."
                    );
                    continue;
                }

                return idade;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "[Erro] Idade inválida. Digite apenas números."
                );
            }
        }
    }

    public static String pedirTelefone() {

        while (true) {
            String telefone = JOptionPane.showInputDialog(null, "Digite o telefone:");

            if (telefone == null) {
                return null;
            }

            if (telefone.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "[Erro] O telefone não pode ficar vazio.");
                continue;
            }

            if (!telefone.matches("\\d{11}")) {
                JOptionPane.showMessageDialog(
                        null,
                        "[Erro] O telefone deve conter exatamente 11 números.\nExemplo: 85999998888"
                );
                continue;
            }

            return telefone;
        }
    }

    public static Pessoa buscarPessoaPorTelefone(ArrayList<Pessoa> pessoas, String telefone) {

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getTelefone().equals(telefone)) {
                return pessoa;
            }
        }

        return null;
    }

    public static void listarPessoas(ArrayList<Pessoa> pessoas) {

        if (pessoas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.");
            return;
        }

        String lista = "..:: PESSOAS CADASTRADAS ::..\n\n";

        for (Pessoa pessoa : pessoas) {
            lista += pessoa + "\n\n";
        }

        JOptionPane.showMessageDialog(null, lista);
    }
}