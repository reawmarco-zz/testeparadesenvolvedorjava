package service.arquivo.processamento;

import entity.Cliente;

public class AnalisarLinhaCliente implements IProcessaLinha {

    /**
     * Processa as informações das linhas referentes ao Cliente.
     *
     * @param linha
     * @return
     */
    @Override
    public Object processaLinha(String[] linha) {
        int id = Integer.parseInt(linha[0]);
        String cnpj = linha[1];
        String nome = linha[2];
        String areaAtuacao = linha[3];
        return new Cliente(id, cnpj, nome, areaAtuacao);
    }
}
