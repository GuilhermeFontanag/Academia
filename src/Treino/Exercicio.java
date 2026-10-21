package Treino;

import Consulta.Consulta;


public class Exercicio implements Consulta {

    private String grupoMuscular;
    private String nome_exercicio;
    private String series;
    private String repeticoes;
    private String carga;



    public Exercicio(String grupoMuscular, String nome_exercicio, String series, String repeticoes, String carga) {
        if (nome_exercicio.isBlank() || nome_exercicio == null) {
            throw new IllegalStateException("adicione nome por favor");
        }
        this.nome_exercicio = nome_exercicio;
        if (grupoMuscular.isBlank() || grupoMuscular == null) {
            throw new IllegalStateException("adicione nome por favor");
        }
        this.grupoMuscular = grupoMuscular;

        if (series.isBlank() || series == null) {
            throw new IllegalStateException("adicione nome por favor");

        }
        this.series = series;

        if (repeticoes.isBlank() || repeticoes == null) {
            throw new IllegalStateException("adicione nome por favor");

        }
        this.repeticoes = repeticoes;

        if (carga.isBlank() || carga == null) {
            throw new IllegalStateException("adicione nome por favor");

        }
        this.carga = carga;
    }



    @Override
    public String exibir_dados() {

    IO.println(String.format("Exercio: " + nome_exercicio + "(" + grupoMuscular + ") %n" +"series: " + series+ "%n repetição:" + repeticoes + "%n carga:" + carga ));

        return null;
    }

    public String getExercicio(){
    return nome_exercicio;
}

    public void setGrupoMuscular(String grupoMuscular) {
        if (grupoMuscular.isBlank()) {
            throw new IllegalStateException("informe o grupo corretamente");
        }
        this.grupoMuscular = grupoMuscular.trim();
    }

    public void setRepeticao(String repeticao) {
        this.repeticoes = repeticao;
    }

    public void setSerie(String series) {
        this.series = series;
    }


    public void setCarga(String carga) {
        this.carga = carga;
    }


    public String getNome_exercicio() {
        return nome_exercicio;
    }

    public String getSeries() {
        return series;
    }

    public String getRepeticoes() {
        return repeticoes;
    }

    public String getCarga() {
        return carga;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }
}