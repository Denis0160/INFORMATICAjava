public class Denis_3E_VettoreCaratteri {
    public static void main(String[] args) {




        boolean[] presenti = new boolean[26];
        String verifica="";
        String frase = "la mamma di pierino";


        /*for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) >= 'a' && frase.charAt(i) <= 'z') {
                presenti[frase.charAt(i) - 'a'] = true;
            }
        }*/
        Vett(presenti,frase);
        /*for (int i = 0; i < presenti.length; i++) {
            if (presenti[i]) {
                //char car= (char) (i + 'a');
                verifica+=(char) (i + 'a');
                System.out.println((char) (i + 'a'));


            }
        }
        System.out.println(verifica);*/
        stampa(presenti);


        char[] ricostruzione=new char[frase.length()];
        for(int i=0; i<frase.length(); i++){
            if (frase.charAt(i) >= 'a' && frase.charAt(i) <= 'z') {
                if( presenti[frase.charAt(i) - 'a'] ){

                    ricostruzione[i]=frase.charAt(i);
                }
            }

        }
        System.out.println(ricostruzione);

    }
    private static void Vett(boolean [] presenti, String frase){
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) >= 'a' && frase.charAt(i) <= 'z') {
                presenti[frase.charAt(i) - 'a'] = true;
            }
        }
    }

    private static void stampa(boolean[] presenti){
        for (int i = 0; i < presenti.length; i++) {
            if (presenti[i]) {
                //char car= (char) (i + 'a');

                System.out.println((char) (i + 'a'));


            }
        }


    }


}



