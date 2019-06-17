package service.arquivo.processamento;

public interface IProcessaLinha {

    /**
     * Processa as informações das linhas do arquivo.
     *
     * @param linha
     * @return
     */
    Object processaLinha(String[] linha);
}
