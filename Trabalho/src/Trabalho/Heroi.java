package Trabalho;
import javax.swing.JOptionPane;
public class Heroi extends Personagem{
    private int resistencia;
    private Arma arma;
    private Poder poder;
    public Heroi() {
    }

    public Heroi(int resistencia) {
        this.resistencia = resistencia;
    }

    public Heroi(int resistencia, String nome, int exp, Arma arma, Poder poder) {
        super(nome, exp, arma, poder);
        this.resistencia = resistencia;
    }
    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Heroi:\n" + "resistencia=" + resistencia + "\n" + super.toString();
    }
    
    
    
    @Override
    public int calcularPontos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }

    

