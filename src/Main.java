import java.util.Scanner;

import static tools.Utility.*;
public class Main {
    public static void main(String[] Args){


        String[] opzioni={"TELEFONICO",
                "[1] inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Ricerca Numero telefonico",
                "[5] Modifica contatto",
                "[6] Fine"};

        final int max=5;
        int contContratti=0;
        Scanner scanner=new Scanner(System.in);
        Contatto[] agenda=new Contatto[5];
        Boolean fine=true;


        do {
            switch (menu(opzioni, scanner)) {

                case 1:
                    String[] tipoC = {"Telefono", "1]abitazione", "2]cellulare", "3]aziendale"};
                    Contatto persona = new Contatto();
                    System.out.println("\nInserisci il nome: ");
                    persona.nome = scanner.nextLine();
                    System.out.println("\nInserisci il cognome: ");
                    persona.cognome = scanner.nextLine();

                    System.out.println("\nInserisci il numero di telefono: ");
                    persona.numero = scanner.nextLine();
                    switch (menu(tipoC, scanner)) {
                        case 1 -> persona.tipo = tipoTel.abitazione;
                        case 2 -> persona.tipo = tipoTel.cellulare;
                        default -> persona.tipo = tipoTel.aziendale;

                    }


                    if (contContratti < max) {
                        agenda[contContratti] = persona;
                        contContratti++;
                    }
                    else
                        System.out.println("Non ci sono piu contratti venduti");

                    break;

                case 2:
                    for (int i = 0; i < contContratti; i++)
                        System.out.println(agenda[i].stampa());

                    break;

                case 3:
                    String nome;
                    String cognome;
                    System.out.println("Inserisci il nome che vuoi trovare\n");
                    nome = scanner.nextLine();
                    System.out.println("Inserisci il cognome\n");
                    cognome = scanner.nextLine();
                    for (int i = 0; i < agenda.length; i++) {
                        if (agenda[i].nome.equalsIgnoreCase(nome) && agenda[i].cognome.equalsIgnoreCase(cognome))
                            System.out.println(String.format("Nome: %s   Cognome: %s" + agenda[i].nome + agenda[i].cognome));
                    }

                case 4:
                    System.out.println("Inserisci il numero di telefono\n");
                    String telefono=scanner.nextLine();
                    for(int i=0;i<agenda.length;i++)
                        if(agenda[i].numero.equalsIgnoreCase(telefono))
                            System.out.println("Nome: "+agenda[i].nome+"Cognome: "+agenda[i].cognome+"Telefono: "+agenda[i].numero);
                    break;

                case 5:
                    System.out.println("Inserisci il nome del contratto da modificare\n");
                    String nModifica=scanner.nextLine();
                    for(int i=0;i<agenda.length;i++){
                        if(agenda[i].nome.equalsIgnoreCase(nModifica)) {
                            System.out.println("Reinserisci i dati del contatto\n");
                            agenda[i].nome = scanner.nextLine();
                            System.out.println("Reinserisci il cognome\n");
                            agenda[i].cognome = scanner.nextLine();
                            System.out.println("Reinserisci il numero\n");
                            agenda[i].numero=scanner.nextLine();

                            String[] tipoCont = {"tipo","1]abitazione", "2]cellulare","3]aziendale"};
                            switch (menu(tipoCont,scanner)){
                                case 1 -> agenda[i].tipo=tipoTel.abitazione;
                                case 2 -> agenda[i].tipo=tipoTel.cellulare;
                                case 3 -> agenda[i].tipo=tipoTel.aziendale;
                            }

                        }
                        else
                            System.out.println("Non ci sono contratti per questa persona");
                        break;

                    }
                    break;


                default:
                    fine=false;
            }
        }while (fine);

    }

}
