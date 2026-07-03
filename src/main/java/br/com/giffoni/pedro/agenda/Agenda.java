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

                case "1":{

                    String nome;

                    while (true) {
                        nome = JOptionPane.showInputDialog(null, "Digite o nome:");

                        if (nome == null) {
                            break;
                        }

                        if (nome.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "[Erro] O nome não pode ficar vazio.");
                            continue;
                        }

                        if (!nome.matches("[a-zA-ZÀ-ÿ ]+")) {
                            JOptionPane.showMessageDialog(null, "[Erro] O nome deve conter apenas letras.");
                            continue;
                        }

                        break;
                    }

                    if (nome == null) {
                        break;
                    }

                    String idadeTexto;
                    int idade = 0;

                    while (true) {
                        idadeTexto = JOptionPane.showInputDialog(null, "Digite a idade:");

                        if (idadeTexto == null) {
                            break;
                        }

                        if (idadeTexto.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "[Erro] A idade não pode ficar vazia.");
                            continue;
                        }

                        try {
                            idade = Integer.parseInt(idadeTexto);

                            if (idade < 18) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "[Rejeitado] Apenas maiores de idade podem ser cadastrados."
                                );
                                continue;
                            }

                            break;

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "[Erro] Idade inválida. Digite apenas números."
                            );
                        }
                    }

                    if (idadeTexto == null) {
                        break;
                    }

                    String telefone;

                    while (true) {
                        telefone = JOptionPane.showInputDialog(null, "Digite o telefone:");

                        if (telefone == null) {
                            break;
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

                        break;
                    }

                    if (telefone == null) {
                        break;
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

                    break;
                }
                case "2":{

                    if (pessoas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.");
                    } else {
                        String lista = "..:: PESSOAS CADASTRADAS ::..\n\n";

                        for (Pessoa pessoa : pessoas) {
                            lista += pessoa + "\n\n";
                        }

                        JOptionPane.showMessageDialog(null, lista);
                    }

                    break;
                }        
                case "3": {
                    rodando = false;
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;
                }        
                default: {
                    JOptionPane.showMessageDialog(null, "[Erro] Opção inválida.");
                    break;
                }
            }
        }
    }
}
