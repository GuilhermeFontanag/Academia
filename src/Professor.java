import java.time.LocalDate;
public class Professor extends Academia implements Consulta {

    private String especialidade;
    private String registro;

	public Professor(String nome, LocalDate dat_nascimento, String telefone, String especialidade, String registro) {
        
        super(nome, dat_nascimento, telefone);
        this.especialidade = especialidade;
        this.registro = registro;
    }

        public String getRegistro(){
            return registro;
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
              IO.println(String.format("nome: " + getNome() + "%n telefone: " + getTelefone() + "%n  registro do professor: " + registro + "especialidade do professor: " + especialidade ));

    }


    
    
}