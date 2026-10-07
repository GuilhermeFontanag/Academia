import java.time.LocalDate;
public class Professor extends Academia implements Consulta {

    private String especialidade;
    

	public Professor(String nome, String idade, String telefone, String especialidade, String registro) {
        
        super(nome, idade, telefone,registro);
        this.especialidade = especialidade;
        
    }


    @Override
    public void realizarCheckIn() {
        if (getStatus() == false) {
            setStatus(true);
            IO.println("Ponto realizado");
        }
    }

    //adicionar metodo para validar registro de professor



    @Override
    public void exibir_dados() {
        System.out.println("Nome: " + getNome() +
                " %n Telefone: " + getTelefone() +
                " %n Registro do professor: " + getRegistro() +
                "%n Especialidade do professor: " + especialidade);
    }


    
    
}