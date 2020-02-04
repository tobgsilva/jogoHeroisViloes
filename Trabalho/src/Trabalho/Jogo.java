
package Trabalho;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Jogo {
    
    public static void main(String[] args) throws FileNotFoundException {
        Combate combate = new Combate();
        combate.criar();
        combate.combater();
       
         
        
       
    }
}