import java.time.LocalDate;

public abstract class Academia{
    private String nome;
    private LocalDate dat_nascimento;
    private String telefone;
    private boolean status = false;
    private String registro;

    //metodo construtor
    public Academia(String nome, LocalDate dat_nascimento, String telefone, String registro){
        
        if (nome == null || nome.isBlank()) {
            throw new IllegalStateException("adicione nome por favor");
            
        }
        

        if (dat_nascimento.isAfter(LocalDate.now()) || dat_nascimento == null) {
            throw new IllegalStateException("adicione uma data futura");
            }
            this.dat_nascimento = dat_nascimento;
        
        if (telefone == null || telefone.isBlank() || telefone.length() != 11) {
            throw new IllegalArgumentException("Telefone inválido");
        }
            this.telefone = telefone.trim();
         
            if (registro == null || registro.isBlank() || registro.length() != 6) {
            throw new IllegalArgumentException("Insira um registro valido");
        }

            this.registro = registro.trim();
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

    public String getRegistro(){
        return registro;
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

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setRegistro(String registro){
        this.registro = registro;
    }

    //métodos

    
    public abstract void realizarCheckIn();

    



    


    






















}
