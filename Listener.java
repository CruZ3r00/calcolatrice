//creazione package per le classi
package Calcolatrice;
//import delle librerie necessarie
import java.awt.event.*;
import javax.swing.*;

//implements di AcitionListener che permette azione su click dei pulsanti
public class Listener implements ActionListener {
	private String op;	//variabile che contiene l'operazione in corso
    private JTextField testo; //modificatore del campo di testo
    public  float dato; //variabile contenente i risultati
	public Listener(JTextField txt,float x) { //dichiarazione classe con variabili necessarie
		this.dato = x; //associo a dato dal main
		this.testo = txt;	//associo a campo di testo dal main
		this.op = "null"; //inizializzazione non c'è nessuna operazione in corso all'inizio
	}
    
	//descrizione delle azioni in base al bottone premuto
	public void actionPerformed(ActionEvent ev){
    	String operazione = ev.getActionCommand(); //acquizsizione del nome del bottone premuto
    	String d = testo.getText(); //acquisizione testo presente nel campo di testo
    	if(d.equals("err")) { //se il il campo di testo è err 
    		testo.setText("0"); //reset della stringa e del risultato
    		d = "0";
    		dato =0;
    		op="null";
    	}
    	if(operazione.equals("C")){ //se premo il tasto cancella
            dato = 0;//reset della stringa e del risultato
            testo.setText("0");
            op = "null";
        }
        else if(operazione.equals("=")){ //se si preme uguale
	        float num = Float.parseFloat(d); //acquisizione del testo presente sotto forma di numero
        	switch(op) {
	        	case "+":{ //operazione in corso +
	        		dato += num; //somma tra il dato precedentemante inserito e l'attuale
	        		testo.setText(Float.toString(dato)); //visualizzazione risultato
	        		break;
	        	}
	        	case "-":{ //operazione in corso -
	        		dato -= num;//sottrazione tra dato precedentemente inserito e attuale
	        		testo.setText(Float.toString(dato));//visualizzazione risultato
	        		break;
	        	}
	        	case "/":{//operazione in corso /
	        		if(num == 0) {//non si può dividere per 0 
	        			testo.setText("err");//visualizzazione errore
	        			break;
	        		}
	        		dato = dato / num;//divisione tra dato precedentemente inserito e l'attuale
	        		testo.setText(Float.toString(dato)); //visualizzazione risultato
	        		break;
	        	}
	        	case "*":{ //operazione in corso *
	        		dato *= num; //moltiplicazione dato precedentemente inserito e l'attuale
	        		testo.setText(Float.toString(dato)); //visualizzazione risultato
	        		break;
	        	}
	        	case "null":{ //nessuna operazione in corso, visualizzazione dato
	        		testo.setText(Float.toString(dato));
	        	}
        	}
        	
        }else {//non sono stati inseriti ne "=" ne "cancella"
            switch(op){
                case "null":{//nessuna operazione in corso
                	//se non vengono inseriti +,-,*,/ prendo ramo vero
                	if(!(operazione.equals("+") || operazione.equals("-") || operazione.equals("/") || operazione.equals("*"))) {
                		//se non ho inserito operazioni ho inserito numeri, acquisisco il numero
                		int num = Integer.parseInt(operazione);
                		if(d.equals("0") || d.equals("0.0"))//se c'è solo uno 0 nel campo di testo
                			testo.setText(operazione);//sostituzione campo di testo con numero inserito
                        else if(num>=0 && num < 10){//se c'è altro già scritto
                        	d = d + operazione;//inserimento in coda nella stringa del numero appena inserito
                        	testo.setText(d);//set del campo di testo
                        }
                	}
                	else { //se è stata inserita un'operazione
                		dato = Float.parseFloat(d); //inserisco il dato nel campo di testo nella variabile dato
                        op = operazione; //aggiornamento della variabile per l'operazione corrente
                        testo.setText("0");//reset campo di testo
                	}
                    break;
                }
                case "+":{//operazione in corso +
                	//se non vengono inseriti +,-,*,/ prendo ramo vero
                	if(!(operazione.equals("+") || operazione.equals("-") || operazione.equals("/") || operazione.equals("*"))) {
                		//se non ho inserito operazioni ho inserito numeri, acquisisco il numero
                		int num = Integer.parseInt(operazione);
                		if(d.equals("0") || d.equals("0.0"))//se c'è solo uno 0 nel campo di testo
                			testo.setText(operazione);//sostituzione campo di testo con numero inserito
                        else if(num>=0 && num < 10){//se c'è altro già scritto
                        	d = d + operazione;//inserimento in coda nella stringa del numero appena inserito
                        	testo.setText(d);//set del campo di testo
                        }
                	}
                    else{//se è stata inserita un'altra operazione
                        float x = Float.parseFloat(d); //acquisizione float del campo di testo
                        dato += x; //esegue la somma e salvo il risultato
                        op = operazione; //aggiorno variabile per l'operazione corrente
                        testo.setText("0");//reset campo di testo
                    }
                    break;
                }
                case "-":{ //operazione in corso -
                	//se non vengono inseriti +,-,*,/ prendo ramo vero
                	if(!(operazione.equals("+") || operazione.equals("-") || operazione.equals("/") || operazione.equals("*"))) {
                		//se non ho inserito operazioni ho inserito numeri, acquisisco il numero
                		int num = Integer.parseInt(operazione);
                		if(d.equals("0") || d.equals("0.0"))//se c'è solo uno 0 nel campo di testo
                			testo.setText(operazione);//sostituzione campo di testo con numero inserito
                        else if(num>=0 && num < 10){//se c'è altro già scritto
                        	d = d + operazione;//inserimento in coda nella stringa del numero appena inserito
                        	testo.setText(d);//set del campo di testo
                        }
                	}
                    else{//se è stata inserita un'altra operazione
                        float x = Float.parseFloat(d); //acquisizione float del campo di testo
                        dato -= x; //esegue la somma e salvo il risultato
                        op = operazione; //aggiorno variabile per l'operazione corrente
                        testo.setText("0");//reset campo di testo
                    }
                    break;
                }                    
                case "*":{//operazione in corso *
                	//se non vengono inseriti +,-,*,/ prendo ramo vero
                	if(!(operazione.equals("+") || operazione.equals("-") || operazione.equals("/") || operazione.equals("*"))) {
                		//se non ho inserito operazioni ho inserito numeri, acquisisco il numero
                		int num = Integer.parseInt(operazione);
                		if(d.equals("0") || d.equals("0.0"))//se c'è solo uno 0 nel campo di testo
                			testo.setText(operazione);//sostituzione campo di testo con numero inserito
                        else if(num>=0 && num < 10){//se c'è altro già scritto
                        	d = d + operazione;//inserimento in coda nella stringa del numero appena inserito
                        	testo.setText(d);//set del campo di testo
                        }
                	}
                    else{//se è stata inserita un'altra operazione
                        float x = Float.parseFloat(d); //acquisizione float del campo di testo
                        dato *= x; //esegue la somma e salvo il risultato
                        op = operazione; //aggiorno variabile per l'operazione corrente
                        testo.setText("0");//reset campo di testo
                    }
                    break;
                }
                case "/":{
                	//se non vengono inseriti +,-,*,/ prendo ramo vero
                	if(!(operazione.equals("+") || operazione.equals("-") || operazione.equals("/") || operazione.equals("*"))) {
                		//se non ho inserito operazioni ho inserito numeri, acquisisco il numero
                		int num = Integer.parseInt(operazione);
                		if(d.equals("0") || d.equals("0.0"))//se c'è solo uno 0 nel campo di testo
                			testo.setText(operazione);//sostituzione campo di testo con numero inserito
                        else if(num>=0 && num < 10){//se c'è altro già scritto
                        	d = d + operazione;//inserimento in coda nella stringa del numero appena inserito
                        	testo.setText(d);//set del campo di testo
                        }
                	}
                    else{//se è stata inserita un'altra operazione
                        float x = Float.parseFloat(d); //acquisizione float del campo di testo
                        if(x == 0) {//non si può dividere per 0
                        	testo.setText("err");//messaggio di errore
                        	break;
                        }
                        dato = dato / x; //esegue la somma e salvo il risultato
                        op = operazione; //aggiorno variabile per l'operazione corrente
                        testo.setText("0");//reset campo di testo
                    }
                    break;
                }
            }
        }
    }   
}