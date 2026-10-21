package Usuario;

import Academia.Academia;
import Consulta.Consulta;

public class Professor extends Academia implements Consulta {

    private String especialidade;

    public Professor(String nome, String idade, String telefone, String especialidade, String registro) {
        super(nome, idade, telefone, registro);

        if (especialidade == null || especialidade.isBlank()) {
            throw new IllegalArgumentException("Adicione uma especialidade válida.");
        }
        this.especialidade = especialidade.trim();
    }

    @Override
    public void realizarCheckIn() {
        if (!getStatus()) {
            setStatus(true);
            IO.println("Ponto realizado com sucesso!");
        }
    }

    @Override
    public String exibir_dados() {
        String dados = String.format(
                "Nome: %s%nTelefone: %s%nRegistro do Usuario.Professor: %s%nEspecialidade: %s",
                getNome(), getTelefone(), getRegistro(), especialidade
        );
        IO.println(dados);
        return dados;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}