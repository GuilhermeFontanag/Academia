import java.time.LocalDate;
import java.util.List;

public class Aluno extends Academia  implements Consulta {
    //atributos

    private String objetivo;


    public Aluno(String nome, String dat_nascimento, String telefone, String objetivo, String registro) {

        super(nome, dat_nascimento, telefone, registro);

        if (objetivo == null || objetivo.isBlank()) {
            throw new IllegalStateException("adicione corretamente seu objetivo");

        }
        this.objetivo = objetivo;

    }

    @Override
    public void exibir_dados() {
        System.out.println("Nome: " + getNome() +
                " %n Telefone: " + getTelefone() +
                " %n Registro do aluno:  " + getRegistro() +
                " %n Objetivo: " + objetivo);

    }

    @Override
    public void realizarCheckIn() {
        if (getStatus() == false) {
            setStatus(true);
            IO.println("bem vindo a academia");
        }
    }

    //getter
    public String getObjetivo() {
        return objetivo;
    }
}
  

    //adicionar algo pra validar matricula de aluno;

    


