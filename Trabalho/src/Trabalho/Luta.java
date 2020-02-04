package Trabalho;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Luta {

    private String vencedor;
    private float resultado;
    private List<Heroi> herois = new ArrayList<>();
    private List<Vilao> viloes = new ArrayList<>();
    private List<Heroi> heroisSelecionados = new ArrayList<>();
    private List<Vilao> viloesSelecionados = new ArrayList<>();

    public Luta() {
    }

    public Luta(String vencedor, float resultado) {
        this.vencedor = vencedor;
        this.resultado = resultado;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public List<Heroi> getHeroisEscolhidos() {
        return heroisSelecionados;
    }

    public List<Vilao> getViloesEscolhidos() {
        return viloesSelecionados;
    }
    
    public void criarHerois() throws FileNotFoundException {
        Poder poder = new Poder();
        Arma arma = new Arma();
        Heroi heroi;
        //Pegando do arquivo os herois
        Scanner scanner ;
               scanner = new Scanner(new FileReader("CriarHerois.txt"))
                .useDelimiter(",");
        while (scanner.hasNext()) {
            heroi = new Heroi();
            heroi.setNome(scanner.next().trim());
            heroi.setResistencia(scanner.nextInt());
            heroi.setExperiencia(scanner.nextInt());

            while ((scanner.hasNext()) && (scanner.hasNext("ARMA"))) {
                scanner.next();
                arma.setDescricao(scanner.next());
                arma.setQuantidade(scanner.nextInt());
                arma.setValor(scanner.nextInt());

                heroi.setArma(arma);
            }
            while ((scanner.hasNext()) && (scanner.hasNext("PODER"))) {
                scanner.next();
                poder.setDescricao(scanner.next());
                poder.setValor(scanner.nextInt());
                heroi.setPoders(poder);
            }

            herois.add(heroi);

        }
    }

    public void criarViloes() throws FileNotFoundException {
       Poder poder = new Poder();
        Arma arma = new Arma();
        Vilao vilao;
        Scanner scanner;
        scanner = new Scanner(new FileReader("CriarViloes.txt"))
                .useDelimiter(",");
        while (scanner.hasNext()) {
            vilao = new Vilao();
            vilao.setNome(scanner.next().trim());
            vilao.setGenialidade(scanner.nextInt());
            vilao.setExperiencia(scanner.nextInt());

            while ((scanner.hasNext()) && (scanner.hasNext("ARMA"))) {
                scanner.next();
                arma.setDescricao(scanner.next());
                arma.setQuantidade(scanner.nextInt());
                arma.setValor(scanner.nextInt());

                vilao.setArma(arma);
            }
            while ((scanner.hasNext()) && (scanner.hasNext("PODER"))) {
                scanner.next();
                poder.setDescricao(scanner.next());
                poder.setValor(scanner.nextInt());
                vilao.setPoders(poder);
            }

            viloes.add(vilao);

        }

    }

    public void escolherPersonagem() {
       String[] array = new String[5];
       String heroi = "";
       String vilao = "";
        String aux = "";
        String auxc = "";
        int i = 0, escolha = 0, continuar = 0;
        Scanner input = new Scanner(System.in);
        //Listando herois
        //escolher herois
        while (continuar == 0) {

            if (escolha < herois.size()) {
                if (!herois.isEmpty() || !viloes.isEmpty()) {
            while (herois.size() > i) {
                heroi = heroi+ " " + (i + ") " + herois.get(i).getNome());
                i++;
            }
            
        }
                try {
                aux = JOptionPane.showInputDialog("Escolha o Heroi:" + heroi);
                escolha = Integer.parseInt(aux);
                } catch (NumberFormatException erro) {
                  JOptionPane.showMessageDialog(null,
                    "Houve erro na conversão, digite apenas caracteres numéricos.\n"
                    + "Erro: " + erro.toString());
                  System.exit(0);
                }
                if(!heroisSelecionados.contains(herois.get(escolha))){
                    heroisSelecionados.add(herois.get(escolha));
                }else{
                    JOptionPane.showMessageDialog(null,"Este heroi já está em combate!");
                }
                
            } else {
                JOptionPane.showMessageDialog(null,"Este heroi não existe neste universo!");
            }

            auxc = JOptionPane.showInputDialog("Digite 0 para continuar escolhendo");
            continuar = Integer.parseInt(auxc);
        }

        // Listando viloes
        i = 0;
        escolha = 0;
        continuar = 0;
        if (!herois.isEmpty() || !viloes.isEmpty()) {
            while (viloes.size() > i) {
                vilao = vilao+ " " + (i + ") " + viloes.get(i).getNome());
                i++;
            }
        }

        //esolher viloes
        while (continuar == 0) {

            if (heroisSelecionados.size() > viloesSelecionados.size()) {
                if (escolha < viloes.size()) {
                    try{
                    aux = JOptionPane.showInputDialog("Escolha o vilão:" + vilao);
                    escolha = Integer.parseInt(aux);
                    } catch (NumberFormatException erro) {
                  JOptionPane.showMessageDialog(null,
                    "Houve erro na conversão, digite apenas caracteres numéricos.\n"
                    + "Erro: " + erro.toString());
                  System.exit(0);
                }
                    if(!viloesSelecionados.contains(viloes.get(escolha))){
                        viloesSelecionados.add(viloes.get(escolha));
                    }else{
                        JOptionPane.showMessageDialog(null,"Este Vilao já está arquitetando planos para acabar com o mundo!");
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null,"Este vilão não existe neste universo!");
                }

                
                continuar = 0;
            } else if (heroisSelecionados.size() == viloesSelecionados.size()) {
                JOptionPane.showMessageDialog(null,"Você ja escolheu a mesma quantidadem de viloes que herois");
                continuar = 1;

            } else {
                JOptionPane.showMessageDialog(null,"Para todo bem, ha um mal! Escolha o mesmo numero de herois e viloes");
                continuar = 0;
            }

        }
    }

    public float gerarResultadoHeroi(Heroi hero) {
        float calculoHeroi;
        calculoHeroi = (hero.getExperiencia() * 2) + hero.valorpoder() + (hero.valorArma() + hero.getResistencia());
        return calculoHeroi;

    }

    public float gerarResultadoVilao(Vilao vilain) {
        float calculoVilao;
        calculoVilao = (vilain.getExperiencia() * 2) + vilain.valorArma() + vilain.valorpoder() + vilain.getGenialidade();
        return calculoVilao;

    }

    
}
