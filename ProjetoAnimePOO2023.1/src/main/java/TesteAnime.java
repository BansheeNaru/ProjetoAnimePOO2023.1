public class TesteAnime {
    public static void main(String[] args) {
        AnimeManager animeManager = new AnimeManager();


        // Animes criados e adicionados ao animeManager
        Anime anime1 = new Anime("Naruto", "01/10/2002", 20, "Naruto Uzumaki é um jovem ninja...",CategoriaAnime.SHONEN);
        Anime anime2 = new Anime("One Piece", "20/10/1999", 25, "Monkey D. Luffy e sua tripulação...",CategoriaAnime.SHONEN );
        Anime anime3 = new Anime("Bleach", "05/10/2004", 16, "Ichigo Kurosaki é um adolescente que...",CategoriaAnime.SHONEN );

        animeManager.cadastrarAnime(anime1);
        animeManager.cadastrarAnime(anime2);
        animeManager.cadastrarAnime(anime3);

        AnimeGUI animeGUI = new AnimeGUI(animeManager);


        try {
            AnimeInfo animeEncontrado = animeManager.encontrarAnimePorNome("Naruto");
            if (animeEncontrado != null) {
                System.out.println("Anime encontrado: " + animeEncontrado.getNome());
            } else {
                throw new AnimeNaoEncontradoException("Anime não econtrado");
            }
        } catch (AnimeNaoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }
}

class AnimeNaoEncontradoException extends Exception{
    public AnimeNaoEncontradoException(String message){
        super(message);
    }
}

