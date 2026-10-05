import java.time.LocalDate;

public abstract class Academia{
    private String nome;
    private LocalDate dat_nascimento;
    private String telefone;
    private boolean status = false;

    //metodo construtor
    public Academia(String nome, LocalDate dat_nascimento, String telefone){
        this.nome = nome;
        this.dat_nascimento = dat_nascimento;
        this.telefone = telefone;
       
    }
    

    //getters
    public String getNome(){
    return nome;
}

    public LocalDate getDat(){
        return dat_nascimento;
    }

    public String getTelefone(){
        return telefone;
    }

    
    public boolean getStatus(){
        return status;
    }

    //setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDat(LocalDate dat_nascimento){
        this.dat_nascimento = dat_nascimento;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }



    public void setStatus(boolean Status){
        this.status = status;
    }
    //métodos


    public abstract void realizarCheckIn();



    


    






















}
