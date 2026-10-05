import java.time.LocalDate;

public class Aluno extends Academia  implements Consulta {
    //atributos

    private String objetivo;
    private String matricula;


   
     
    public Aluno(String nome, LocalDate dat_nascimento, String telefone, String objetivo, String matricula) {
        
        super(nome, dat_nascimento, telefone);
        this.objetivo = objetivo;
        this.matricula = matricula;
        
    }
    //getter
    public String getMatricula(){
    return matricula;
}

	@Override
	public void exibir_dados() {
        IO.println(String.format("nome: " + getNome() + "%n telefone: " + getTelefone() + "%n identidade da matricula: " + matricula +"%n resultado esperado: " + objetivo ));
	
		
	}

	@Override
	public void realizarCheckIn() {
        if (getStatus() == false) {
            setStatus(true);
            IO.println("bem vindo a academia");
        }
	}
    //getter
    public String getObjetivo(){
    return objetivo;
}


    //adicionar algo pra validar matricula de aluno;

    
}