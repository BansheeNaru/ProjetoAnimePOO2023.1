public class Anime implements AnimeInfo {
    private String nome;
    private String dataLancamento;
    private int temporadas;
    private String sinopse;
    private CategoriaAnime categoria;

    public Anime(String nome, String dataLancamento, int temporadas, String sinopse, CategoriaAnime categoria) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.temporadas = temporadas;
        this.sinopse = sinopse;
        this.categoria = categoria;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDataLancamento() {
        return dataLancamento;
    }

    @Override
    public int getTemporadas() {
        return temporadas;
    }

    @Override
    public String getSinopse() {
        return sinopse;
    }

    public CategoriaAnime getCategoria() {
        return categoria;
    }
}
