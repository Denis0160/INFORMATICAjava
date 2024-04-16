import tools.Oggetto;
import java.util.Scanner;

public class Main {
    public static void main(String[] Args){
        Scanner scanner = new Scanner(System.in);

        Oggetto[] vettore = new Oggetto[2];
        boolean fine = true;

        String[] operazioni = {"MENU",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca Stringa",
                "[4] Ricerca Numero",
                "[5] Fine"};


        do {
            switch (Menu.menu(operazioni, scanner)) {
                case 1: {
                    /* Creazione degli oggetti nel vettore */
                    for (int i = 0; i < vettore.length; i++) {
                        vettore[i] = new Oggetto();
                        System.out.println("Inserisci una stringa:");
                        vettore[i].setStringa(scanner.nextLine());
                        System.out.println("Inserisci un numero:");
                        vettore[i].setNumero(scanner.nextInt());
                        scanner.nextLine();  // Consuma il newline
                    }
                    break;
                }
                case 2: {
                    System.out.println("Oggetti presenti:");
                    for (int i = 0; i < vettore.length; i++) {
                        System.out.println(vettore[i].getStringa());
                        System.out.println(vettore[i].getNumero());
                    }
                    break;
                }
                case 3: {
                    Oggetto oggettoTrovato = ricercaTramiteStringa(vettore, scanner);
                    if (oggettoTrovato != null) {
                        System.out.println("Oggetto trovato:");
                        System.out.println("Stringa: " + oggettoTrovato.getStringa());
                        System.out.println("Numero: " + oggettoTrovato.getNumero());
                    } else {
                        System.out.println("Nessun oggetto trovato.");
                    }
                    break;
                }
                case 4:{
                    Oggetto trovato= ricercaTramiteTelefono(vettore,scanner);
                    if(trovato!=null){
                        System.out.println("Oggetto trovato:\n");
                        System.out.println("Stringa:"+trovato.getStringa());
                        System.out.println("Numero:"+trovato.getNumero());
                    }else
                        System.out.println("Nessun oggetto trovato");
                    break;
                }
                default:{
                    fine=false;
                    break;
                }

            }
        } while(fine);
    }

    public static Oggetto ricercaTramiteStringa(Oggetto[] vettore, Scanner scanner) {
        System.out.println("Inserisci la stringa che stai cercando:");
        String ricercaStringa = scanner.nextLine();
        for (int i = 0; i < vettore.length; i++) {
            Oggetto oggettoCorrente = vettore[i];
            if (oggettoCorrente.getStringa().equals(ricercaStringa)) {
                return oggettoCorrente;
            }
        }
        return null;
    }
    public static Oggetto ricercaTramiteTelefono(Oggetto[] vettore, Scanner scanner) {
        System.out.println("Inserisci il numero che stai cercando:");
        int ricercaNumero= scanner.nextInt();
        for (int i = 0; i < vettore.length; i++) {
            Oggetto oggettoCorrente = vettore[i];
            if (oggettoCorrente.getNumero()==ricercaNumero) {
                return oggettoCorrente;
            }
        }
        return null;
    }
}
