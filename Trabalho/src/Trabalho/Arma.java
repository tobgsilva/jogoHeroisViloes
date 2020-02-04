package Trabalho;
import javax.swing.JOptionPane;
public class Arma {
private String descricao;
private int valor;
private int quantidade;

    public Arma() {
    }

    public Arma(String descricao, int valor, int quantidade) {
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Arma:" + "\ndescricao=" + descricao + "\nvalor=" + valor + "\nquantidade=" + quantidade;
    }
    
    
    
}
  

