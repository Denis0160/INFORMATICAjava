import java.util.Scanner;

public class DividiStringa {
    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        System.out.println("Inserisci una frase:");
        String frase = tastiera.nextLine();


        if (frase.length() < 40) {
            System.out.println("La frase inserita ha meno di 40 caratteri.");
        } else if (frase.length() > 80) {
            System.out.println("La frase inserita è troppo lunga, deve avere meno di 80 caratteri.");
        } else {

            // Trova l'indice del 40° carattere che segna la fine della prima sottostringa
            int indiceFineSottostringa = 40;
            while(indiceFineSottostringa<frase.length() && frase.charAt(indiceFineSottostringa)!=' ') {
                indiceFineSottostringa++;
            }

            // Stampa la prima sottostringa
            System.out.println("La prima sottostringa è:");
            System.out.println(frase.substring(0, indiceFineSottostringa));

            // Verifica se ci sono altre sottostringhe
            if (indiceFineSottostringa<frase.length()) {
                // Trova gli indici di inizio e fine delle altre sottostringhe
                int indiceInizio=indiceFineSottostringa+1;

                while (indiceInizio < frase.length()) {
                    int indiceFine = min(indiceInizio,frase);
                    // Stampa le altre sottostringhe
                    System.out.println("Un'altra sottostringa è:");
                    System.out.println(frase.substring(indiceInizio, indiceFine));
                    indiceInizio = indiceFine + 1;
                }
            }
        }

    }
    public static int min(int indiceInizio, String frase) {
        if (indiceInizio+40 < frase.length()) {
            return indiceInizio;
        } else {
            return frase.length();
        }
    }
}