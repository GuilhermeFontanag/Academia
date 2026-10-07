
# Sistema de Gerenciamento de Academia
Um sistema em Java desenvolvido para gerenciar alunos, professores, banco de exercícios e montagem de fichas de treino de uma academia diretamente via linha de comando (terminal).

## Autores:
-Mirela Bertoloti
-Guilherme Gregorio

## Tecnologias Utilizadas:
* Linguagem: Java
* Paradigma: Programação Orientada a Objetos (POO)
### Conceitos de POO aplicados:

* Herança: As classes Aluno e Professor estendem a classe abstrata Academia.

* Polimorfismo e Interfaces: Implementação da interface Consulta para uniformizar a exibição dos dados.

* Abstração: Classe abstrata Academia que consolida atributos e comportamentos base.

* Encapsulamento: Uso de modificadores de acesso privados com métodos de acesso (getters e setters) e validação nos construtores.
 
 ## Pré-requisitos
1. Para compilar e executar o sistema na sua máquina local, você precisará de:
>Java Development Kit (JDK): Versão25 instalada.

2. Terminal / Linha de Comando: Prompt de Comando (CMD), PowerShell ou Terminal Bash.

3. Para verificar se o Java está configurado no seu sistema, execute:
>java -version
>javac -version


 ## Estrutura do Projeto

* **Academia.java:** Classe abstrata base contendo informações genéricas (nome, idade, telefone, registro e status de check-in).

* **Aluno.java:** Subclasse de Academia referente aos alunos e seus objetivos de treino.

* **Professor.java:** Subclasse de Academia contendo a especialidade do profissional.

* **Exercicio.java:** Classe contendo informações detalhadas do exercício (grupo muscular, séries, repetições e carga).

* **Treino.java:** Vincula um aluno a um professor responsável e gerencia uma lista com o limite de até 6 exercícios.

* **Consulta.java:** Interface que estabelece o contrato do método exibir_dados().

* **Main.java:** Classe principal responsável por inicializar a aplicação e gerenciar a navegação do menu interativo.

## Como Instalar e Executar no Terminal
1. Organização dos Arquivos
Certifique-se de que todos os arquivos .java (Academia.java, Aluno.java, Professor.java, Exercicio.java, Treino.java, Consulta.java, Main.java e a classe utilitária de I/O IO.java) estejam salvos no mesmo diretório.

2. Navegar até o Diretório
Abra o terminal e navegue até a pasta onde os arquivos foram salvos:

3. Compilar o Projeto
Execute o compilador Java para gerar os arquivos .class:
javac *.java


4. Executar a Aplicação
Inicie a execução a partir da classe principal (Main):
java Main


 ## Como Operar o Sistema
Ao iniciar a aplicação, o menu principal interativo será apresentado no terminal:
=== SISTEMA DE GERENCIAMENTO DE ACADEMIA === 
 1. Cadastrar Aluno 
 2. Cadastrar Professor 
 3. Cadastrar Exercício 
 4. Criar Novo Treino 
 5. Gerenciar Treino (Adicionar/Remover Exercícios) 
 6. Consultar Treino de um Aluno 
 7. Exibir Relatório Geral do Sistema 
 8. Enviar Notificação Geral 
 9. Sair


