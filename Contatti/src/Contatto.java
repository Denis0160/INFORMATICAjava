enum tipoContratto{abitazione, cellulare, aziendale};

public class Contatto {
    protected String nome;
    protected String cognome;
    protected String telefono;
    public tipoContratto tipo;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getCognome(){
        return cognome;
    }
    public void  setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
   


    public String stampa()
    {
        return String.format("Nome: %s Cognome: %s Telefono: %s, tipo: %s", nome, cognome, telefono, tipo.toString());
    }
}