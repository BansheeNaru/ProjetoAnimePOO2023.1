public class Main {
    public static void main(String[] args) {

        AnimeManager animeManager = new AnimeManager();
        AnimeGUI animeGUI = new AnimeGUI(animeManager);

        // Criando instâncias de animes
        Anime anime1 = new Anime("Naruto", "01/10/2002", 20, "Naruto Uzumaki é um jovem ninja...",CategoriaAnime.SHONEN);
        Anime anime2 = new Anime("One Piece", "20/10/1999", 25, "Monkey D. Luffy e sua tripulação...",CategoriaAnime.SHONEN);

        // Usando a interface AnimeInfo para acessar informações dos animes
        AnimeInfo[] animes = { anime1, anime2 };
        animeManager.cadastrarAnime(anime1);
        animeManager.cadastrarAnime(anime2);

        // Exibindo informações dos animes
        for (AnimeInfo anime : animes) {
            System.out.println("Nome: " + anime.getNome());
            System.out.println("Data de Lançamento: " + anime.getDataLancamento());
            System.out.println("Temporadas: " + anime.getTemporadas());
            System.out.println("Sinopse: " + anime.getSinopse());
            System.out.println();
        }
    }
}





