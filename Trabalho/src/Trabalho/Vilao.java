package Trabalho;
import javax.swing.JOptionPane;
public class Vilao extends Personagem{
    private int genialidade;

    public Vilao() {
    }

    public Vilao(int genialidade) {
        this.genialidade = genialidade;
    }

    public Vilao(int gelialidade, String nome, int exp, Arma arma, Poder poder) {
        super(nome, exp, arma, poder);
        this.genialidade = gelialidade;
    }
    
    
    
    public int getGenialidade(){
        return genialidade;
    }

    public void setGenialidade(int genialidade) {
        this.genialidade = genialidade;
    }

    @Override
    public String toString() {
        return "Vilao:\n" + "gelialidade =" + genialidade + '\n' + super.toString();
    }
    
    
    @Override
    public int calcularPontos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
