enum tipoTel{abitazione,cellulare,aziendale}
class Contatto{
    public String nome;
    public String cognome;
    public String numero;

    public tipoTel tipo;

    public String stampa()
    {
        return String.format("Nome: %s Cognome: %s Telefono: %s, tipo: %s", nome, cognome, numero, tipo.toString());
    }

}