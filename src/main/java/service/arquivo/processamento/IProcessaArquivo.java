package service.arquivo.processamento;

import java.io.File;
import java.io.FileNotFoundException;

public interface IProcessaArquivo {

    /**
     * Processa as informações do arquivo contido na pasta C:/temp/in no formato .DAT
     *
     * @param file
     */
    void processaArquivo(File file) throws FileNotFoundException;

    /**
     * Verifica se o arquivo está no formato padrão para realizar o processando das informações do mesmo
     *
     * @param file
     */
    void verificaArquivo(File file) throws FileNotFoundException;
}
