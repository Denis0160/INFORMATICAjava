import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class ValidaData {
    public static void main(String[] args) {
        //declaration and initialization of variables/arrays

        int numero = 0;
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        int scelta=0;
        Boolean dataValida;
        boolean bisestile;
        boolean dataNonValida = false;

        do {
            dataValida = false;
            //output for enter the date
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
            //Check for non valid user input
            try {
                //insertion of the date
                numero = scanner.nextInt();
                int[] dataSeparata = separazioneData(numero);
                if (!dataOk(dataSeparata[0], dataSeparata[1], dataSeparata[2])) {
                    dataValida = true;
                    System.out.println("DATA ERRATA");
                } else {
                    System.out.println("DATA CORRETTA");
                }
            } catch (Exception x) {
                System.out.println("DATA ERRATA");
                dataValida = true;
                scanner.nextLine();
            }
        } while (dataValida);

        while (continua) {


            System.out.println("Scegli un'opzione:");
            System.out.println("1. Aggiungi giorni");
            System.out.println("2. Togli giorni");
            System.out.println("3. Esci");

            scelta=scanner.nextInt();


            switch (scelta) {

                case 1:
                    System.out.println("Inserisci il numero di giorni da aggiungere: ");
                    int giorni_da_aggiungere = scanner.nextInt();
                    numero = data_up(numero, giorni_da_aggiungere);
                    System.out.println("La nuova data è: " + numero);
                    continua=false;
                    break;
                case 2:
                    System.out.println("Inserisci il numero di giorni da togliere: ");
                    int giorni_da_togliere = scanner.nextInt();
                    numero = data_down(numero, giorni_da_togliere);
                    System.out.println("La nuova data è: " + numero);
                    continua=false;
                    break;
                case 3:
                    continua = false;

                    break;
                default:
                    System.out.println("Scelta non valida");
            }

            //Separare la data in giorno, mese, anno




        /*System.out.println("Conversione stringa 1 : " + dataToString1(dataSeparata));
        System.out.println("Conversione stringa 2 : " + dataToString2(dataSeparata));
        System.out.println("Conversione stringa 3 : " + dataToString3(dataSeparata));
        */
        }


    }
    public static int data_up(int data, int giorni) {
        int giorno=data / 1000000;
        int mese=(data % 1000000) / 10000;
        int anno=data % 10000;

        giorno += giorni;

        while (giorno>giorni_del_mese(mese, anno)) {
            giorno-=giorni_del_mese(mese, anno);
            mese++;
            if (mese>12) {
                mese=1;
                anno++;
            }
        }

        return giorno*1000000+mese*10000+anno;
    }

    // Metodo che sottrae giorni da una data
    public static int data_down(int data, int giorni) {
        int giorno=data / 1000000;
        int mese=(data % 1000000) / 10000;
        int anno=data % 10000;

        giorno -=giorni;

        while (giorno<=0) {
            mese--;
            if (mese<1) {
                mese=12;
                anno--;
            }
            giorno+=giorni_del_mese(mese,anno);
        }

        return giorno*1000000+mese*10000+anno;
    }

    // Metodo che restituisce il numero di giorni per un dato mese e anno
    public static int giorni_del_mese(int mese, int anno) {
        switch (mese) {
            case 1,3,5,7,8,10,12:
                return 31;
            case 4,6,9,11:
                return 30;
            case 2:
                return Bisestile(anno) ? 29 : 28;
            default:
                return-1; // Mese non valido
        }
    }




    // Metodo per verificare se un anno è bisestile
    //public static boolean Bisestile(int anno) {
        //return ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0);
    //}



    /* Separazione della data inserita in giorno, mese ed anno*/
    //12042024
    //12
    //04
    //2024:
    //Si ottiene dal resto della divisione della data per 10000
    //12042024 / 10000 = 1204 Resto 2024
    //12042024 / 10000 = 1204 Salviamo il risultato dentro data
    //1204 / 100 = 12 Resto 04
    //1204 / 100 = 12 Salviamo il risultato dentro data
    private static int[] separazioneData(int data) {
        //Contiene il valore d'uscita
        int[] output = new int[3];

        //Anno
        output[2] = data % 10000;
        //Rimuovere l'anno dalla data
        data /= 10000;
        //Mese
        output[1] = data % 100;
        //Rimuovere il mese dalla data
        data /= 100;
        //Giorno
        output[0] = data;

        //Ritornare i valori separati
        return output;
    }

    private static String dataToString1(int[] data) {
        String output;

        output = String.valueOf(data[0]) + "/" + String.valueOf(data[1]) + "/" + String.valueOf(data[2]);

        return output;
    }

    private static String dataToString2(int[] data) {
        String output;

        output = Integer.toString(data[0]) + "/" + Integer.toString(data[1]) + "/" + Integer.toString(data[2]);

        return output;
    }

    private static String dataToString3(int[] data) {
        Integer boxing = data[0];
        String output = boxing.toString() + "/";

        boxing = data[1];
        output += boxing.toString() + "/";

        boxing = data[2];
        output += boxing.toString();

        return output;
    }

    private static boolean Bisestile(int anno) {
        return ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0);
    }

    private static boolean dataOk(int giorno, int mese, int anno) {
        boolean valida = false;
        /*switch (mese) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                valida = (giorno > 0 && giorno < 32);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                valida = (giorno > 0 && giorno < 31);
                break;
            case 2:
                if (Bisestile(anno) && giorno > 0 && giorno < 30) {
                    valida = true;
                } else if (giorno > 0 && giorno < 29) {
                    valida = true;
                }
                break;
        }
         */
        /*if (mese==2) {
            if(Bisestile(anno) && giorno > 0 && giorno < 30) {
                valida = true;
            } else if (giorno > 0 && giorno < 29) {
                valida = true;
            }
        }else*/ {


            valida = switch (mese) {
                case 1, 3, 5, 7, 8, 10, 12 -> (giorno > 0 && giorno < 32);
                case 4, 6, 9, 11 -> (giorno > 0 && giorno < 31);
                case 2-> (Bisestile(anno) && giorno > 0 && giorno < 30) || (giorno > 0 && giorno < 29);
                default -> false;
            };
        }
        return valida;
    }



    //anno: 31129999
    //01010001
    private static boolean validadata(int numero){
        return (numero>31129999 || numero<01010001);
    }

    //private static int validata()
    //-1 : No error
    //1 : Out of range
    //2 : Domain incorrect

}