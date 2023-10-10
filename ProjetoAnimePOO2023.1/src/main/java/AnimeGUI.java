
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class AnimeGUI extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private JComboBox<String> searchTypeComboBox; // Adicionado JComboBox
    private JTextArea displayArea;

    private AnimeManager animeManager;

    public AnimeGUI(AnimeManager animeManager) {
        this.animeManager = animeManager;

        setTitle("Central offAnimes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Painel de pesquisa
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Pesquisar");
        searchTypeComboBox = new JComboBox<>(new String[]{"Nome", "Categoria"}); // Opções para pesquisa
        searchPanel.add(searchField);
        searchPanel.add(searchTypeComboBox);
        searchPanel.add(searchButton);

        // Área de exibição
        displayArea = new JTextArea();
        displayArea.setEditable(false);

        // Adicionando componentes ao painel principal
        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Adicionando ação ao botão de pesquisa
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                String searchType = (String) searchTypeComboBox.getSelectedItem();

                if ("Nome".equals(searchType)) {
                    pesquisarPorNome(searchTerm);
                } else if ("Categoria".equals(searchType)) {
                    pesquisarPorCategoria(searchTerm);
                }
            }
        });

        // Adicionando o painel principal à janela
        add(mainPanel);

        setVisible(true);
    }

    private void pesquisarPorNome(String nome) {
        AnimeInfo animeEncontrado = animeManager.encontrarAnimePorNome(nome);
        exibirResultado(animeEncontrado);
    }

    private void pesquisarPorCategoria(String categoriaStr) {
        try {
            CategoriaAnime categoria = CategoriaAnime.valueOf(categoriaStr.toUpperCase());
            List<AnimeInfo> animesPorCategoria = animeManager.encontrarAnimesPorCategoria(categoria);
            exibirResultado(animesPorCategoria);
        } catch (IllegalArgumentException e) {
            displayArea.setText("Categoria inválida.");
        }
    }

    private void exibirResultado(AnimeInfo animeInfo) {
        if (animeInfo != null) {
            displayAnimeInfo(animeInfo);
        } else {
            displayAnimeNotFound();
        }
    }

    private void exibirResultado(List<AnimeInfo> animes) {
        if (!animes.isEmpty()) {
            StringBuilder resultText = new StringBuilder();
            for (AnimeInfo anime : animes) {
                resultText.append(getFormattedAnimeInfo(anime)).append("\n\n");
            }
            displayArea.setText(resultText.toString());
        } else {
            displayAnimeNotFound();
        }
    }

    private String getFormattedAnimeInfo(AnimeInfo animeInfo) {
        return String.format(
                "Nome: %s\nData de Lançamento: %s\nTemporadas: %d\nSinopse: %s",
                animeInfo.getNome(), animeInfo.getDataLancamento(), animeInfo.getTemporadas(), animeInfo.getSinopse()
        );
    }

    private void displayAnimeInfo(AnimeInfo animeInfo) {
        displayArea.setText(getFormattedAnimeInfo(animeInfo));
    }

    private void displayAnimeNotFound() {
        displayArea.setText("Anime não encontrado.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnimeManager animeManager = new AnimeManager();
            new AnimeGUI(animeManager);
        });
    }
}









