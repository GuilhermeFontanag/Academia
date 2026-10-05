
import java.util.ArrayList;
import java.util.List;

public class Treino implements Consulta {
    
    //atributos instanciados
    private Aluno aluno;
    private Professor professor;
    private List<Exercicio> listaDeExercicios;

    // Construtor
    public Treino(Aluno aluno, Professor professor) {
        this.aluno = aluno;
        this.professor = professor;
        this.listaDeExercicios = new ArrayList<>(); 
    }

    public Exercicio getExercice(){
        Exercicio x = null;
        if (listaDeExercicios.isEmpty()) {
                IO.println("inexistente");
            }
        for(Exercicio i : listaDeExercicios ){
            
            x = i;
        }
        return x;
    }


    public void adicionarExercicio(Exercicio ex) {
        if (listaDeExercicios.size() < 6) {
            listaDeExercicios.add(ex);
            IO.println("exercicio adicionado com sucesso");
        } else {
            IO.println("Atenção: O treino já atingiu o limite máximo de 6 exercícios");
        }
    }

    // Método para remover exercício
    public void removerExercicio(Exercicio ex) {
        if (ex.getExercicio().isBlank()) {
            throw new IllegalStateException("informe o exercicio que exista");
        }
        
        listaDeExercicios.remove(ex);
    }

    //getters
    public Aluno getAluno() {
        return aluno;
    }

    public Professor getProfessor() {
        return professor;
    }


    @Override
    public void exibir_dados() {
     String cabecalho = String.format(
            "%n====== FICHA DE TREINO ======%n" +
            "Aluno: %s | Objetivo: %s%n" +
            "Professor Responsável: %s%n" +
            "-----------------------------",
            aluno.getNome(), aluno.getObjetivo(), professor.getNome()
        );
        
        IO.println(cabecalho);
        IO.println("EXERCÍCIOS DA ROTINA:");
        for(Exercicio x : listaDeExercicios){
        if (listaDeExercicios.isEmpty()) {
            IO.println("Nenhum exercício cadastrado neste treino ainda.");
        }
        } 
         IO.println("=============================");
    }

}