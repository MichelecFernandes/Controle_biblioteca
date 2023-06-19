package br.com.poo.controlebiblioteca.biblioteca;

import br.com.poo.controlebiblioteca.interfaceusuario.InterfaceUsuario;
import br.com.poo.controlebiblioteca.item.Item;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Item> acervo;
    private InterfaceUsuario ui;
    private String nomeBiblioteca;

    public Biblioteca(){
        acervo = new ArrayList<>();
        ui = new InterfaceUsuario();
    }

    public void adicionarNovoItem(Item item){
        acervo.add(item);
    }

    public void listarItem(){
        for (Item item : acervo){
            ui.mostrarNaTela("=========================");
            ui.mostrarNaTela(item.obterDados() + "\n" + "Tipo do item: " + item.obterTipo() + "\n");
        }
    }

    public boolean realizarEmprestimo(String tituloItem, String tipoItem){
        boolean sucesso = false;
        for (Item item : acervo){
            if(item.getTitulo().equals(tituloItem) &&
                    item.obterTipo().equals(tipoItem)){
                sucesso = item.emprestimo();
                break;
            }
        }
        return sucesso;
    }

    public boolean realizarDevolucao(String tituloItem, String tipoItem){
        boolean sucesso = false;
        for (Item item : acervo){
            if(item.getTitulo().equals(tituloItem) &&
                    item.obterTipo().equals(tipoItem)){
                sucesso = item.devolucao();
                break;
            }
        }
        return sucesso;
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }
}
