package service.arquivo;

import service.ClienteService;
import service.VendaService;
import service.VendedorService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class ResultadoAnalise implements ISalvarArquivo {

    private static final Logger LOGGER = Logger.getLogger(ResultadoAnalise.class.getName());

    /**
     * Metodo para salvar o arquivo com as informações obtidas na leitura dos arquivos .DAT contidos na pasta in.
     *
     * @param tituloArquivoOrigem
     */
    @Override
    public void salvar(String tituloArquivoOrigem) {

        tituloArquivoOrigem = tituloArquivoOrigem.replace(".dat", "");

        Path outputPath = Paths.get(
                System.getProperty("user.home")
                        .concat(File.separator)
                        .concat("data")
                        .concat(File.separator)
                        .concat("out"));

        Path outputFilePath = outputPath.resolve(tituloArquivoOrigem + ".done.dat");

        try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {
            writer.write("Quantidade de clientes no arquivo de entrada: " + ClienteService.buscaTotalDeClientes());
            writer.newLine();
            writer.write("Quantidade de vendedores no arquivo de entrada: " + VendedorService.buscaTotalDeVendedores());
            writer.newLine();
            writer.write("ID da venda mais cara: " + VendaService.buscarIDMaiorVenda());
            writer.newLine();
            writer.write("O nome do pior vendedor: " + VendaService.buscarNomeVendedorDaPiorVenda());
            writer.newLine();
            writer.close();
            LOGGER.info("Processo finalizado para o arquivo...");
        } catch (IOException e) {
            LOGGER.warning("Erro! " + e.toString());
            e.printStackTrace();
        }
    }
}
