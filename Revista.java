package br.com.poo.controlebiblioteca.item;

public class Revista extends Item{
    public static String TIPO_REVISTA;
    private int numeroEdicao;

    public Revista(String titulo, String autor, int anoPublicacao,
                   int quantidadeCopias, int numeroEdicao) {
        super(titulo, autor, anoPublicacao, quantidadeCopias);
        this.numeroEdicao = numeroEdicao;
        TIPO_REVISTA = "REVISTA";
    }

    @Override
    public String obterDados() {
        return "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n"+
                "Ano de Publicação: " + anoPublicacao + "\n"+
                "Quantidade de Cópias disponíveis: " + quantidadeCopias + "\n" +
                "Número de Edição: " + numeroEdicao;
    }

    @Override
    public String obterTipo() {
        return TIPO_REVISTA;
    }

    @Override
    public boolean emprestimo() {
        return false;
    }

    @Override
    public boolean devolucao() {
        return false;
    }
}
