import service.arquivo.processamento.AnalisarArquivo;
import service.arquivo.processamento.IProcessaArquivo;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        IProcessaArquivo iProcessaArquivo = new AnalisarArquivo();
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path inputPath = Paths.get(
                System.getProperty("user.home")
                        .concat(File.separator)
                        .concat("data")
                        .concat(File.separator)
                        .concat("in"));

        inputPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                String filename = event.context().toString();
                if (".dat".equalsIgnoreCase(filename.substring(filename.length() - 4))) {
                    Path inputFilePath = inputPath.resolve((Path) event.context());
                    LOGGER.info("processando arquivo de ".concat(inputFilePath.toString()));
                    iProcessaArquivo.verificaArquivo(inputFilePath.toFile());
                }
            }
            key.reset();
        }
    }
}