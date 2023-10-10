
import java.util.ArrayList;
import java.util.List;

public class AnimeManager {
    private final List<Anime> listsDeAnimes = new ArrayList<>();

    public void cadastrarAnime(Anime anime) {
        listsDeAnimes.add(anime);
    }

    public Anime encontrarAnimePorNome(String nome) {
        for (Anime anime : listsDeAnimes) {
            if (anime.getNome().equalsIgnoreCase(nome)) {
                return anime;
            }
        }
        return null;
    }

    public List<AnimeInfo> encontrarAnimesPorCategoria(CategoriaAnime categoria) {
        List<AnimeInfo> animesPorCategoria = new ArrayList<>();
        for (Anime anime : listsDeAnimes) {
            if (anime.getCategoria() == categoria) {
                animesPorCategoria.add(anime);
            }
        }
        return animesPorCategoria;
    }

    public AnimeInfo encontrarAnimePorNomeECategoria(String nome, CategoriaAnime categoria) {
        for (Anime anime : listsDeAnimes) {
            if (anime.getNome().equalsIgnoreCase(nome) && anime.getCategoria() == categoria) {
                return anime;
            }
        }
        return null;
    }
}







