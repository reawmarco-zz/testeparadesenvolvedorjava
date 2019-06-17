package service.arquivo.processamento;

import entity.Vendedor;

public class AnalisarLinhaVendedor implements IProcessaLinha {

    /**
     * Processa as informações da linha referente ao Vendedor.
     *
     * @param linha
     * @return
     */
    @Override
    public Object processaLinha(String[] linha) {
        int id = Integer.parseInt(linha[0]);
        String cpf = linha[1];
        String nome = linha[2];
        double salario = Double.parseDouble(linha[3]);
        return new Vendedor(id, cpf, nome, salario);
    }
}
