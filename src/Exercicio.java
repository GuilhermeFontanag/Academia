public class Exercicio implements Consulta{

    private String grupoMuscular;
    private String nome_exercicio;
    private int series;
    private int repeticoes;
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



    public void alterarSerie(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }



    public void alterarRepeticao(String nome_exercicio) {
        this.nome_exercicio = nome_exercicio;
    }



    public void alterarSerie(int series) {
        this.series = series;
    }



    public void alterarRepeticao(int repeticoes) {
        this.repeticoes = repeticoes;
    }



    public void alterarCarga(float carga) {
        this.carga = carga;
    }



  






}