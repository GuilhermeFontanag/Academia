import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Academia{
    private String nome;
    private String idade ;
    private String telefone;
    private boolean status = false;
    private String registro;

    //metodo construtor
    public Academia(String nome, String idade, String telefone, String registro){
        
        if (nome.isBlank() || nome == null) {
            throw new IllegalStateException("adicione nome por favor");
            
        }
        this.nome = nome;

        if (idade.isBlank() || idade  == null  ) {
            throw new IllegalStateException("adicione uma idade valida");
        }
            this.idade = idade;

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

    public String getDat(){
        return idade;
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

    public void setDat(String idade){
        this.idade = idade;
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
