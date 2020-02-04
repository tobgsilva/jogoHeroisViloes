
package Trabalho;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Combate {
     private String resultado;
     Luta luta = new Luta();

    public Combate() {
    }

    public Combate(String resultadoFinal) {
        this.resultado = resultadoFinal;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
     
     public void criar() throws FileNotFoundException{
         luta.criarHerois();
         luta.criarViloes();
         luta.escolherPersonagem();
         
     }
     
     public void combater(){
         
         // Exibindo os herois e viloes escolidos
        List <Heroi> herois= new ArrayList<> ();
        List <Vilao> viloes= new ArrayList<> ();
        herois = luta.getHeroisEscolhidos();
        viloes = luta.getViloesEscolhidos();
        int i = 0;
        while (i < herois.size()){
            JOptionPane.showMessageDialog(null,"heroi: " + herois.get(i).getNome());
            i++;
        }
       
        i=0;
        while (i < luta.getViloesEscolhidos().size()){
            JOptionPane.showMessageDialog(null,"vilao: " + luta.getViloesEscolhidos().get(i).getNome());
            i++;
        }
        
        // Batalha entre herois e viloes e exibindo na tela
        float totalPontosHerois = 0, totalPontosViloes = 0,pontosHeroi=0, pontosVilao=0;
        i=0;
        while((i < herois.size()) && i <viloes.size()){
            
            //exibindo luta na tela
          JOptionPane.showMessageDialog(null, herois.get(i).getNome()
           + "\n   VS\n "+ viloes.get(i).getNome()+ "\n");
           //calculuando pontos
           pontosHeroi = luta.gerarResultadoHeroi(herois.get(i));
           pontosVilao = luta.gerarResultadoVilao(viloes.get(i));
           //exibindo luta i na tela
           if(pontosHeroi> pontosVilao){
               JOptionPane.showMessageDialog(null,"Vencedor\n Heroi : "+herois.get(i).getNome() +"\n Com "+pontosHeroi +" pontos." +
                       "\nPerdedor\n Vilão: "+viloes.get(i).getNome() +"\n Com "+pontosVilao +" pontos.");
           }else if (pontosHeroi < pontosVilao){
               JOptionPane.showMessageDialog(null,"Vencedor\n Vilão: "+viloes.get(i).getNome() +"\n Com "+pontosVilao +" pontos." +
                       "\nPerderdor\n Heroi : "+herois.get(i).getNome() +"\n Com "+pontosHeroi +" pontos.");
           }else
                JOptionPane.showMessageDialog(null,"EMPATE");
           totalPontosHerois+= pontosHeroi;
           totalPontosViloes += pontosVilao;
           
            i++;
        }
        JOptionPane.showMessageDialog(null,"Herois: " + totalPontosHerois);
        JOptionPane.showMessageDialog(null,"Viloes: "+ totalPontosViloes);
        if(totalPontosHerois>totalPontosViloes){
            JOptionPane.showMessageDialog(null,"Heroes won !");
        }
        else{
            JOptionPane.showMessageDialog(null,"villains won !");
        }
     }
}
