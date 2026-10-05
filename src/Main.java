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
            "1. Cadastrar Aluno\n" + 
            "2. Cadastrar Professor\n" +
            "3. Cadastrar Exercício\n" + 
            "4. Criar Novo Treino\n"+ 
            "5. Gerenciar Treino (Adicionar/Remover Exercícios)\n" + 
            "6. Consultar Treino de um Aluno\n" + 
            "7. Exibir Relatório Geral do Sistema\n" + 
            "8. Enviar Notificação Geral\n" + 
            "9. Sair"));
            
            try {
                opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));
            } catch (NumberFormatException e) {
                IO.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1: {
                    IO.println("\n--- CADASTRAR ALUNO ---");
                    String nomeAluno = IO.readln("Nome: ");
                    String matricula = IO.readln("Matrícula: ");
                    String objetivo = IO.readln("Objetivo (ex: Hipertrofia, Emagrecimento): ");
                    String telefone = IO.readln("Telefone (11 digitos): ");
                    LocalDate nascAluno = LocalDate.parse(IO.readln("Data de nascimento (YYYY-MM-DD): "));

                    Aluno aluno = new Aluno(nomeAluno, nascAluno, telefone, objetivo, matricula);
                    alunos.add(aluno);
                    IO.println("Aluno cadastrado com sucesso!");
                    break;
                }

                case 2: {
                    IO.println("\n--- CADASTRAR PROFESSOR ---");
                    String nomeProf = IO.readln("Nome: ");
                    String registro = IO.readln("Registro CREF: ");
                    String teleProf = IO.readln("Telefone (11 digitos): ");
                    String especialidade = IO.readln("Especialidade: ");
                    LocalDate nascProf = LocalDate.parse(IO.readln("Data de nascimento (YYYY-MM-DD): "));
                    
                    Professor professor = new Professor(nomeProf, nascProf, teleProf, especialidade, registro);
                    professores.add(professor);
                    IO.println("Professor cadastrado com sucesso!");
                    break;
                }

                case 3: {
                    IO.println("\n--- CADASTRAR EXERCÍCIO ---");
                    String nomeEx = IO.readln("Nome do Exercício: ");
                    String grupo = IO.readln("Grupo Muscular: ");
                    int series = Integer.parseInt(IO.readln("Séries: "));
                    int reps = Integer.parseInt(IO.readln("Repetições: "));
                    float carga = Float.parseFloat(IO.readln("Carga (Kg): "));
                    
                    bancoDeExercicios.add(new Exercicio(grupo, nomeEx, series, reps, carga));
                    IO.println("Exercício adicionado ao banco!");
                    break;
                }

                case 4: {
                    IO.println("\n--- CRIAR NOVO TREINO ---");
                    String matBusca = IO.readln("Digite a matrícula do Aluno: ");
                    String crefBusca = IO.readln("Digite a identificação do Professor responsável: ");

                    Aluno alunoEncontrado = null;
                    for (Aluno a : alunos) {
                        if (a.getRegistro().equalsIgnoreCase(matBusca)) {
                            alunoEncontrado = a;
                            break;
                        }
                    }

                    Professor profEncontrado = null;
                    for (Professor p : professores) {
                        if (p.getRegistro().equalsIgnoreCase(crefBusca)) {
                            profEncontrado = p;
                            break;
                        }
                    }

                    if (alunoEncontrado != null && profEncontrado != null) {
                        Treino treino = new Treino(alunoEncontrado, profEncontrado);
                        treinos.add(treino);
                        IO.println("Treino criado com sucesso! Use a opção 5 para adicionar exercícios.");
                    } else {
                        IO.println("Erro: Aluno ou Professor não encontrados no sistema.");
                    }
                    break;
                }

                case 5: {
                    IO.println("\n--- GERENCIAR TREINO ---");
                    String acharRegistro = IO.readln("Digite a matrícula do Aluno: ");
                  
                    Treino treinoAtual = null;
                    for (Treino a : treinos) {
                        if (a.getAluno().getRegistro().equalsIgnoreCase(acharRegistro)) {
                            treinoAtual = a;
                            break;
                        }
                    }
                    
                    if (treinoAtual == null) {
                        IO.println("Treino não encontrado para esta matrícula.");
                        break; // Interrompe o case 5 se não achar o treino
                    } 
                    
                    String subMenu = String.format(
                        "%n--- OPÇÕES DE GERENCIAMENTO ---%n" +
                        "1. Adicionar Exercício ao Treino%n" +
                        "2. Remover Exercício do Treino%n" +
                        "3. Alterar Carga / Séries / Repetições de um Exercício"
                    );
                    IO.println(subMenu);
                    
                    int acao = Integer.parseInt(IO.readln("Escolha uma ação: "));

                    switch (acao) {
                        case 1: { // 1. ADICIONAR EXERCÍCIO AO TREINO
                            if (bancoDeExercicios.isEmpty()) {
                                IO.println("Erro: Nenhum exercício cadastrado no banco de dados da academia.");
                                break;
                            }
                            String nomeExercicio = IO.readln("Nome do Exercício do banco para adicionar: ");
                            Exercicio exEncontrado = null;
                            
                            for (Exercicio ex : bancoDeExercicios) {
                                if (ex.getExercicio().equalsIgnoreCase(nomeExercicio)) {
                                    exEncontrado = ex;
                                    break;
                                }
                            }

                            if (exEncontrado != null) {
                                treinoAtual.adicionarExercicio(exEncontrado);
                            } else {
                                IO.println("Exercício não existe no banco de dados.");
                            }
                            break;
                        }

                        case 2: { // 2. REMOVER EXERCÍCIO DO PRÓPRIO TREINO
                            String nomeExercicio = IO.readln("Nome do Exercício a remover do treino: ");
                            Exercicio exRemover = null; 
                            
                            for (Exercicio ex : bancoDeExercicios) {
                                if (ex.getExercicio().equalsIgnoreCase(nomeExercicio)) {
                                    exRemover = ex;
                                    break;
                                }
                            }

                            if (exRemover != null) {
                                try {
                                    treinoAtual.removerExercicio(exRemover);
                                    IO.println("Exercício removido do treino com sucesso!");
                                } catch (Exception e) {
                                    IO.println("Erro ao remover: " + e.getMessage());
                                }
                            } else {
                                IO.println("Exercício não encontrado.");
                            }
                            break;
                        }

                        case 3: { // 3. ALTERAR CARGA, SÉRIES OU REPETIÇÕES
                            String nomeEx = IO.readln("Nome do Exercício que deseja alterar: ");
                            Exercicio exAlterar = null;
                            
                            for (Exercicio ex : bancoDeExercicios) {
                                if (ex.getExercicio().equalsIgnoreCase(nomeEx)) {
                                    exAlterar = ex;
                                    break;
                                }
                            }

                            if (exAlterar != null) {
                                String menuAlteracao = String.format(
                                    "%nO que deseja alterar em '%s'?%n" +
                                    "1. Alterar Séries%n" +
                                    "2. Alterar Repetições%n" +
                                    "3. Alterar Carga (Kg)"
                                );
                                
                                IO.println(menuAlteracao);
                                int opcaoAlterar = Integer.parseInt(IO.readln("Escolha: "));

                                switch (opcaoAlterar) {
                                    case 1: {
                                        int novasSeries = Integer.parseInt(IO.readln("Nova quantidade de séries: "));
                                        exAlterar.setSerie(novasSeries);
                                        IO.println("Séries alteradas com sucesso!");
                                        break;
                                    }
                                    case 2: {
                                        // Nota: O método setRepeticao na classe Exercicio recebe uma String no seu código
                                        String novasReps = IO.readln("Nova quantidade de repetições: ");
                                        exAlterar.setRepeticao(novasReps);
                                        IO.println("Repetições alteradas com sucesso!");
                                        break;
                                    }
                                    case 3: {
                                        float novaCarga = Float.parseFloat(IO.readln("Nova carga em Kg: "));
                                        exAlterar.setCarga(novaCarga);
                                        IO.println("Carga alterada com sucesso!");
                                        break;
                                    }
                                    default: {
                                        IO.println("Opção de alteração inválida.");
                                        break;
                                    }
                                }
                            } else {
                                IO.println("Exercício não encontrado no banco de dados.");
                            }
                            break;
                        }
                        
                        default: {
                            IO.println("Ação inválida.");
                            break;
                        }
                    }
                    break;
                }

                case 6: {
                    IO.println("\n--- CONSULTAR TREINO ---");
                    String matConsulta = IO.readln("Digite a matrícula do Aluno: ");
                    boolean achouTreino = false;
                    
                    for (Treino t : treinos) {
                        if (t.getAluno().getRegistro().equalsIgnoreCase(matConsulta)) {
                            t.exibir_dados();
                            achouTreino = true;
                        }
                    }
                    
                    if (!achouTreino) {
                        IO.println("Nenhum treino encontrado para este aluno.");
                    }
                    break;
                }

                case 7: {
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
                }
                    
                case 8: {
                    IO.println("Funcionalidade em desenvolvimento.");
                    break;
                }
                    
                case 9: {
                    IO.println("Saindo do sistema... Até logo!");
                    break;
                }

                default: {
                    IO.println("Opção inválida. Tente novamente.");
                    break;
                }
            }
        }
    }
}