
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GravInfo {

    public static void gravarEmArquivo(List<String> linhas, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();  // Adiciona uma nova linha após cada linha de dados
            }
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar dados no arquivo: " + e.getMessage());
        }
    }

    // Método de exemplo para demonstrar o uso
    public static void main(String[] args) {
        // Lista de dados a serem gravados no arquivo
        List<String> dados = List.of(
                "Nome: Naruto",
                "Data de Lançamento: 01/10/2002",
                "Temporadas: 20",
                "Sinopse: Naruto Uzumaki é um jovem ninja..."
        );

        // Caminho do arquivo onde os dados serão gravados
        String caminhoDoArquivo = "C://Users//vitor//IdeaProjects//ProjetoAnimePOO2023.1//src//main//resources//Dados Gravados Central offAnimes.txt";

        // Chamada do método para gravar os dados no arquivo
        gravarEmArquivo(dados, caminhoDoArquivo);
    }
}



