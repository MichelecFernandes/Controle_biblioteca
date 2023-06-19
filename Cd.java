package br.com.poo.controlebiblioteca.item;

public class Cd extends Item{
    public static String TIPO_CD;
    private int duracaoMinutos;

    public Cd(String titulo, String autor, int anoPublicacao,
              int quantidadeCopias, int duracaoMinutos) {
        super(titulo, autor, anoPublicacao, quantidadeCopias);
        this.duracaoMinutos = duracaoMinutos;
        TIPO_CD = "CD";
    }

    @Override
    public String obterDados() {
        return "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n"+
                "Ano de Publicação: " + anoPublicacao + "\n"+
                "Quantidade de Cópias disponíveis: " + quantidadeCopias + "\n" +
                "Duração em minutos: " + duracaoMinutos;
    }

    @Override
    public String obterTipo() {
        return TIPO_CD;
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
