package br.com.poo.controlebiblioteca.item;

import br.com.poo.controlebiblioteca.emprestimo.InterfaceEmprestimo;

public abstract class Item implements InterfaceEmprestimo {
    protected String titulo;
    protected String autor;
    protected int anoPublicacao;
    protected int quantidadeCopias;

    public Item(String titulo, String autor, int anoPublicacao, int quantidadeCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeCopias = quantidadeCopias;
    }

    public abstract String obterDados();
    public abstract String obterTipo();

    public String getTitulo() {
        return titulo;
    }

    public abstract boolean emprestimo();

    public abstract boolean devolucao();
}
