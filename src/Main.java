
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // Listas em memória para armazenar os dados
        List<Aluno> alunos = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Exercicio> bancoDeExercicios = new ArrayList<>();
        List<Treino> treinos = new ArrayList<>();

        int opcao = 0;

        // Loop principal do sistema
        while (opcao != 9) {
            IO.println(String.format(" %n === SISTEMA DE GERENCIAMENTO DE ACADEMIA === %n " + 
            "1. Cadastrar Aluno " + 
            "2. Cadastrar Professor" +
            "3. Cadastrar Exercício" + 
            " 4. Criar Novo Treino "+ 
            "5. Gerenciar Treino (Adicionar/Remover Exercícios) " + 
            "6. Consultar Treino de um Aluno " + 
            "7. Exibir Relatório Geral do Sistema " + 
            "8. Enviar Notificação Geral " + 
            " 9. Sair"));
            
            try {
                opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));
            } catch (NumberFormatException e) {
                IO.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    IO.println("\n--- CADASTRAR ALUNO ---");
                    String nomeAluno = IO.readln("Nome: ");
                    String matricula = IO.readln("Matrícula: ");
                    String objetivo = IO.readln("Objetivo (ex: Hipertrofia, Emagrecimento): ");
                    LocalDate nascAluno= LocalDate.parse(IO.readln("data de nascimento: "));

                    Aluno aluno = new Aluno(nomeAluno, nascAluno, nomeAluno, objetivo, matricula);
                    alunos.add(aluno);
                    IO.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    IO.println("\n--- CADASTRAR PROFESSOR ---");
                    //entrada
                    String nomeProf = IO.readln("Nome: ");
                    String registro= IO.readln("Registro CREF: ");
                    String teleProf = IO.readln("informe o telefone");
                    String especialidade = IO.readln("Especialidade: ");
                    LocalDate nascProf = LocalDate.parse(IO.readln("data de nascimento: "));
                    
                    //instancia
                    Professor professor = new Professor(nomeProf, nascProf, teleProf, especialidade, registro);
                    professores.add(professor);
                    IO.println("Professor cadastrado com sucesso!");
                    break;

                case 3:
                    IO.println("\n--- CADASTRAR EXERCÍCIO ---");
                    String nomeEx = IO.readln("Nome do Exercício: ");
                    String grupo = IO.readln("Grupo Muscular: ");
                    int series = Integer.parseInt(IO.readln("Séries: "));
                    int reps = Integer.parseInt(IO.readln("Repetições: "));
                    float carga = Float.parseFloat(IO.readln("Carga (Kg): "));
                    
                    bancoDeExercicios.add(new Exercicio(nomeEx, grupo, series, reps, carga));
                    IO.println("Exercício adicionado ao banco!");
                    break;

                case 4:
                    IO.println("\n--- CRIAR NOVO TREINO ---");
                    Aluno alunoEncontrado = null;
                    Professor profEncontrado = null;

                    String matBusca = IO.readln("Digite a matrícula do Aluno: ");

                    String crefBusca = IO.readln("Digite a identificacao do Professor responsável: ");

                    Treino treino = new Treino(alunoEncontrado, profEncontrado);
                    
                    IO.println("Treino criado com sucesso! Use a opção 5 para adicionar exercícios.");
                    
                    break;

                case 5:
                    IO.println("\n--- GERENCIAR TREINO ---");
                    String matTreino = IO.readln("Digite a matrícula do Aluno dono do treino: ");
                    Treino treinoAtual = null;
                    
                    for (Treino t : treinos) {
                      
                            break;
                        }
                    
                        

                case 6:
                    IO.println("\n--- CONSULTAR TREINO ---");
                    String matConsulta = IO.readln("Digite a matrícula do Aluno: ");
                    boolean achouTreino = false;
                    
                    for (Treino t : treinos) {
                            t.exibir_dados();
                        
                            break;
                        }
                    

                case 7:
                    IO.println("\n--- RELATÓRIO GERAL DO SISTEMA ---");
                    List<Consulta> relatorioGeral = new ArrayList<>();
                    relatorioGeral.addAll(alunos);
                    relatorioGeral.addAll(professores);
                    relatorioGeral.addAll(bancoDeExercicios);
                    relatorioGeral.addAll(treinos);

                    for (Consulta item : relatorioGeral) {
                        item.exibir_dados();
                        IO.println("----------------------------------");
                    }
                    break;
                    
                case 8:
                    IO.println("Saindo do sistema... Até logo!");
                    break;

                default:
                    IO.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}