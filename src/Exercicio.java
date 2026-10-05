public class Exercicio implements Consulta{

    private String grupoMuscular;
    private String nome_exercicio;
    private String series;
    private String repeticoes;
    private float carga;



    public Exercicio(String grupoMuscular, String nome_exercicio, int series, int repeticoes, float carga) {
        this.grupoMuscular = grupoMuscular;
        this.nome_exercicio = nome_exercicio;
        this.series = series;
        this.repeticoes = repeticoes;
        this.carga = carga;
    }



    @Override
    public void exibir_dados() {

    IO.println(String.format("Exercio: " + nome_exercicio + "(" + grupoMuscular + ")%n" +"series: " + series+ "%n repetição" + repeticoes + "%n carga" + carga ));

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

    public void setSerie(int series) {
        this.series = series;
    }


    public void setCarga(float carga) {
        this.carga = carga;
    }



  






}