
//import delle librerie
import java.awt.*;
import javax.swing.*;
import Calcolatrice.*;

//dichiarazione classe extends jframe per eridatare tutti i metodi 
public class Calcolatrice extends JFrame{
	static JTextField testo = new JTextField(30); //dichiarazione campo di testo per il frame
	static float dato ; //dichiarazione variabile che contiene i risultati
    public Calcolatrice(){
    	Calcolatrice.dato = 0; //impostazione di dato
    	Calcolatrice.testo.setText("0"); //impostazione del campo di testo
    }
    public static void main(String[] args){
        try{ //controllo errori generici
        	JFrame calco = new JFrame("Calcolatrice"); //creazione del frame (finestra per la GUI)
            calco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //azione alla chiusura della finestra (close)
            JPanel tastierino = createUI(); //creazione pannello contenente il tastierino tramite funzione
            testo.setEditable(false); //campo di testo non editabile
            calco.add(testo,BorderLayout.NORTH); //posiziona campo testo in alto nel frame
            calco.add(tastierino, BorderLayout.CENTER);//posiziona tastierino centro nel frame
            calco.pack(); //impacchettamento del frame
            calco.setVisible(true); //frame visibile
        }
        catch(Exception e){ //catch try 
            System.err.println(e);
        }
    }
    public static JPanel createUI(){ //funzione per creare il tastierino
        JPanel pannello = new JPanel(); //nuovo pannello
        pannello.setLayout(new GridLayout(4,4)); //pannello layout 4x4 griglia

      //stringa con tutti i caratteri per i bottoni
        String[] buttons = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "C", "0", "=", "/" }; 
        for(int i =0; i<buttons.length; i++){ //riempimento tastierino 
            JButton b = new JButton(); //nuovo bottone
            b.setText(buttons[i]); //titolo bottone che prende nome dalla stringa
            b.addActionListener(new Listener(testo, dato)); //aggiungo azione di listener al bottone
            pannello.add(b); //aggiungo bottone al pannello
           
        }
       
        return pannello; // return pannello al main (JPanel tastierino)
    }
    
}