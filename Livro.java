package br.com.poo.controlebiblioteca.item;

public class Livro extends Item{
    public static String TIPO_LIVRO;
    private String genero;

    public Livro(String titulo, String autor,
                 int anoPublicacao, int quantidadeCopias, String genero) {
        super(titulo, autor, anoPublicacao, quantidadeCopias);
        this.genero = genero;
        TIPO_LIVRO = "LIVRO";
    }

    @Override
    public String obterDados() {
        return "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n"+
                "Ano de Publicação: " + anoPublicacao + "\n"+
                "Quantidade de Cópias disponíveis: " + quantidadeCopias + "\n" +
                "Gênero do livro: " + genero;
    }

    @Override
    public String obterTipo() {
        return TIPO_LIVRO;
    }

    @Override
    public boolean emprestimo() {
        if (quantidadeCopias == 0){
            return false;
        }else{
            quantidadeCopias -= 1;
            return true;
        }
    }

    @Override
    public boolean devolucao() {
        quantidadeCopias += 1;
        return true;
    }
}
