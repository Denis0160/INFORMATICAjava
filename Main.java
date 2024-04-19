import java.util.Random;
import java.util.Scanner;
public class Main{
    public static void main(String[] Args){
        String[] nomiPersonaggi =
                {"Marie Curie",
                        "Antoine Lavoisier",
                        "Louis Pasteur",
                        "Joseph Louis Proust",
                        "Albert Einstein",
                        "Nikola Tesla",
                        "Isaac Newton",
                        "Galileo Galilei",
                        "Leonardo Da Vinci",
                        "Michelangelo Buonarroti",
                        "Wolfgang Amadeus Mozart",
                        "Ludwig Van Beethoven",
                        "George Boole",//
                        "Blaise Pascal",//
                        "Pitagora",//
                        "Leonardo Fibonacci",//
                        "John von Neumann",//
                        "Archimede",//
                        "Charles Darwin",//
                        "Gustave Eiffel"};

        String[] domande = {"Ha vinto 2 premii nobel??",
                "Ha scoperto il ruolo dell'ossigeno nella combustione?",
                "Ha scoperto il vaccino per la Rabbia?",
                "È noto per le leggi delle proporzioni definite?",
                "Ha formulato la teoria della relatività?",
                "Ha contribuito allo sviluppo del sistema elettrico a corrente alternata?",
                "Ha scoperto la legge della gravitazione universale?",
                "È noto per il suo sostegno all'eliocentrismo?",
                "È conosciuto per i suoi capolavori artistici come \"La Gioconda\"?",
                "È stato un celebre scultore e pittore del Rinascimento?",
                "È stato un compositore prolifico del periodo classico?",
                "È considerato uno dei più grandi compositori della storia della musica occidentale?\n",//
                "È considerato il padre dell'algebra booleana?",//
                "È noto per la sua legge della pressione dei fluidi?\n",//
                "È famoso per il suo teorema nel campo della geometria?\n",//
                "È famoso per la sua sequenza numerica, chiamata \"Successione di Fibonacci\"?\n",//
                "È stato un eminente matematico, fisico, informatico ed economista?",//
                "È noto per il suo principio che descrive la spinta di un fluido su un corpo immerso?\n",
                "È famoso per le sue teorie sull'evoluzione biologica?",
                "È famoso per la progettazione e la costruzione della Torre Eiffel?"};


        Random random=new Random();
        Scanner scanner=new Scanner(System.in);
        boolean risposta=true;
        String risposta2;

        System.out.println("Scegli un personaggio tra quelli sotto elencati\n");

        for(int i=0;i<nomiPersonaggi.length;i++){
            System.out.println(nomiPersonaggi[i]);
        }

        while(risposta) {
            int indexDomandaCasuale = random.nextInt(domande.length); // Genera un numero casuale compreso tra 0 e la lunghezza del vettore delle domande
            String domandaCasuale = domande[indexDomandaCasuale]; // Ottiene la domanda corrispondente all'indice casuale generato
            System.out.println(domandaCasuale + "si/no"); // Stampa la domanda casuale
            risposta2 = scanner.nextLine();
            if (risposta2.equalsIgnoreCase("si")) {
                risposta = false;
                System.out.println("Il personaggio è: "+nomiPersonaggi[indexDomandaCasuale]);

            }

        }






    }
}