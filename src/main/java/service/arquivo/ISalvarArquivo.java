package service.arquivo;

public interface ISalvarArquivo {
    /**
     * Metodo para salvar o arquivo com as informações obtidas na leitura dos arquivos .DAT contidos na pasta in.
     *
     * @param tituloArquivoOrigem
     */
    void salvar(String tituloArquivoOrigem);
}
