//Michele Cristina Fernandes  1202210061 16-06-2023

package br.com.poo.controlebiblioteca.main;

import br.com.poo.controlebiblioteca.biblioteca.Biblioteca;
import br.com.poo.controlebiblioteca.interfaceusuario.InterfaceUsuario;
import br.com.poo.controlebiblioteca.item.Cd;
import br.com.poo.controlebiblioteca.item.Livro;
import br.com.poo.controlebiblioteca.item.Revista;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario ui = new InterfaceUsuario();
        Biblioteca biblioteca = new Biblioteca();

        String titulo = "";
        String autor = "";
        int ano = 0;
        int numeroCopias = 0;

        int opcao;
        do {
            ui.mostrarNaTela("\nSistema de Gerenciamento da Biblioteca");
            ui.mostrarNaTela("=========  Opções  ==========");
            ui.mostrarNaTela("1 - Cadastrar novo Livro");
            ui.mostrarNaTela("2 - Cadastrar novo CD");
            ui.mostrarNaTela("3 - Cadastrar nova Revista");
            ui.mostrarNaTela("4 - Listar os Itens cadastrados");
            ui.mostrarNaTela("5 - Emprestar Livro");
            ui.mostrarNaTela("6 - Emprestar CD");
            ui.mostrarNaTela("7 - Devolver Livro");
            ui.mostrarNaTela("8 - Devolver  CD");
            ui.mostrarNaTela("0 - Sair" + "\n");
            ui.mostrarNaTela("Digite o numero da opção desejada: ");
            opcao = ui.lerDados().nextInt();
            ui.lerDados().nextLine();

            if (opcao >= 1 && opcao < 4) {
                ui.mostrarNaTela("Digite o título: ");
                titulo = ui.lerDados().nextLine();

                ui.mostrarNaTela("Digite o Autor: ");
                autor = ui.lerDados().nextLine();

                ui.mostrarNaTela("Digite o ano de publicação: ");
                ano = ui.lerDados().nextInt();

                ui.mostrarNaTela("Digite a quantidade de cópias disponíveis: ");
                numeroCopias = ui.lerDados().nextInt();
            }

            switch (opcao) {
                case 1:
                    ui.mostrarNaTela("Digite o gênero do Livro: ");
                    String genero = ui.lerDados().next();

                    Livro livro = new Livro(titulo, autor, ano, numeroCopias, genero);

                    biblioteca.adicionarNovoItem(livro);
                    break;
                case 2:
                    ui.mostrarNaTela("Digite a duração em min do CD: ");
                    int duracao = ui.lerDados().nextInt();

                    Cd cd = new Cd(titulo, autor, ano, numeroCopias, duracao);
                    biblioteca.adicionarNovoItem(cd);
                    break;
                case 3:
                    ui.mostrarNaTela("Digite o número de edição da revista: ");
                    int edicao = ui.lerDados().nextInt();

                    Revista revista = new Revista(titulo, autor, ano, numeroCopias, edicao);
                    biblioteca.adicionarNovoItem(revista);
                    break;
                case 4:
                    biblioteca.listarItem();
                    break;
                case 5:
                    ui.mostrarNaTela("Digite o título do livro: ");
                    String tituloLivroEmprestimo = ui.lerDados().nextLine();

                    if (biblioteca.realizarEmprestimo(tituloLivroEmprestimo, Livro.TIPO_LIVRO)) {
                        ui.mostrarNaTela("Empréstimo realizado com sucesso");
                    }else{
                        ui.mostrarNaTela("Não é possível fazer o empréstimo do livro.");
                    }
                    break;
                case 6:
                    ui.mostrarNaTela("Digite o título do CD: ");
                    String tituloCdEmprestimo = ui.lerDados().nextLine();

                    if (biblioteca.realizarEmprestimo(tituloCdEmprestimo, Cd.TIPO_CD)) {
                        ui.mostrarNaTela("Empréstimo realizado com sucesso");
                    }else{
                        ui.mostrarNaTela("Não é possível fazer o empréstimo do CD.");
                    }
                    break;
                case 7:
                    ui.mostrarNaTela("Digite o título do livro a ser devolvido: ");
                    String tituloLivroDevolucao = ui.lerDados().nextLine();

                    if (biblioteca.realizarDevolucao(tituloLivroDevolucao, Livro.TIPO_LIVRO)) {
                        ui.mostrarNaTela("Devolução realizada com sucesso");
                    }
                    break;
                case 8:
                    ui.mostrarNaTela("Digite o título do CD a ser devolvido: ");
                    String tituloCdDevolucao = ui.lerDados().nextLine();

                    if (biblioteca.realizarDevolucao(tituloCdDevolucao, Cd.TIPO_CD)) {
                        ui.mostrarNaTela("Devolução realizada com sucesso");
                    }
                    break;
                default: ui.mostrarNaTela("Opção Inválida!!");
            }

        } while (opcao != 0);
        ui.mostrarNaTela("Finalizando......");
    }
}
