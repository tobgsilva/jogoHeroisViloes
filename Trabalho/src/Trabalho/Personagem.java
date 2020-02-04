package Trabalho;

import java.util.AbstractList;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

abstract class Personagem {

    private String nome;
    private int experiencia;
    private Arma arma;
    private Poder poder = new Poder();
    private List<Arma> armas = new ArrayList<>();
    private List<Poder> poderes = new ArrayList<>();

    public Personagem() {
    }

    public Personagem(String nome, int experiencia, Arma arma, Poder poder) {
        this.nome = nome;
        this.experiencia = experiencia;
        this.arma = arma;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public List <Arma> getArmas() {

        return armas;
    }

    public void setArma(Arma arma) {
        
        armas.add(arma);
    }

    public List<Poder> getPoderes() {
        if (poderes.isEmpty()){
            return null;
        }
        return poderes;
    }

    public void setPoders(Poder poder) {
        poderes.add(poder);
    }

    public float valorArma() {
        int i = 0;
        float total = 0;
        if (!armas.isEmpty()) {
            while (armas.size() > i) {
                total += (armas.get(i).getValor() * 5) / armas.get(i).getQuantidade();
                i++;
            }
        }
        return total;
    }

    public float valorpoder() {
        int i = 0;
        float total = 0;
        if (!poderes.isEmpty()) {
            while (poderes.size() > i) {
                total += poderes.get(i).getValor() * 3;
                i++;
            }
        }
        return total;
    }
    

    @Override
    public String toString() {
        int i = 0; String armasSTR ="", poderersSTR = "";
        while(i < armas.size()){
            armasSTR += armas.get(i).toString() + "\n";
            i++;
        }
        i=0;
        while(i < poderes.size()){
            poderersSTR += poderes.get(i).toString() + "\n";
            i++;
        }
        return  "Nome = " + nome + "\nExperiencia = " + experiencia + "\n" + armasSTR  + poderersSTR;
        
    }

    

    public abstract int calcularPontos();

}
