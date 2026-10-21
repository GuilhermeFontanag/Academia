package Treino;

import Usuario.Aluno;
import Usuario.Professor;
import Consulta.Consulta;

import java.util.ArrayList;
import java.util.List;

public class Treino implements Consulta {

    // Atributos
    private Aluno aluno;
    private Professor professor;
    private List<Exercicio> listaDeExercicios;

    // Construtor
    public Treino(Aluno aluno, Professor professor) {
        if (aluno == null || professor == null) {
            throw new IllegalArgumentException("Usuario.Aluno e Usuario.Professor devem ser válidos.");
        }
        this.aluno = aluno;
        this.professor = professor;
        this.listaDeExercicios = new ArrayList<>();
    }

    public void adicionarExercicio(Exercicio ex) {
        if (ex == null) {
            System.out.println("Exercício inválido.");
            return;
        }
        if (listaDeExercicios.size() < 6) {
            listaDeExercicios.add(ex);
            System.out.println("Exercício adicionado com sucesso!");
        } else {
            System.out.println("Atenção: O treino já atingiu o limite máximo de 6 exercícios.");
        }
    }

    public void removerExercicio(Exercicio ex) {
        if (ex == null) {
            throw new IllegalArgumentException("Informe um exercício válido.");
        }
        if (listaDeExercicios.remove(ex)) {
            System.out.println("Exercício removido do treino com sucesso!");
        } else {
            System.out.println("Exercício não encontrado neste treino.");
        }
    }

    // Getters
    public Aluno getAluno() {
        return aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Exercicio> getListaDeExercicios() {
        return listaDeExercicios;
    }

    @Override
    public String exibir_dados() {
        String cabecalho = String.format(
                "%n====== FICHA DE TREINO ======%n" +
                        "Usuario.Aluno: %s | Objetivo: %s%n" +
                        "Usuario.Professor Responsável: %s%n" +
                        "-----------------------------",
                aluno.getNome(), aluno.getObjetivo(), professor.getNome()
        );

        System.out.println(cabecalho);
        System.out.println("EXERCÍCIOS DA ROTINA:");

        if (listaDeExercicios.isEmpty()) {
            System.out.println("Nenhum exercício cadastrado neste treino ainda.");
        } else {
            for (Exercicio x : listaDeExercicios) {
                System.out.println(String.format("Exercício: %s (%s)%nSéries: %s | Repetições: %s | Carga: %s",
                        x.getExercicio(), x.getGrupoMuscular(), x.getSeries(), x.getRepeticoes(), x.getCarga()));
            }
        }

        System.out.println("=============================");
        return cabecalho;
    }
}