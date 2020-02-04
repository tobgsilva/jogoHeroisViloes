
package Trabalho;
import javax.swing.JOptionPane;
public class Poder {
private String descricao;
private int valor;

    public Poder() {
    }

    public Poder(String descricao, int valor) {
        this.descricao = descricao;
        this.valor = valor;
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

    @Override
    public String toString() {
        return "Poder:" + "\nDescricao: " + descricao + "\nValor:" + valor ;
    }

    


}
