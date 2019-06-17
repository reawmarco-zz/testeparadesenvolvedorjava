package service.arquivo.processamento;

import entity.Item;
import entity.Venda;
import entity.Vendedor;
import service.VendedorService;

public class AnalisarLinhaVenda implements IProcessaLinha {

    /**
     * Processa as informações das linhas referente as vendas.
     *
     * @param linha
     * @return
     */
    @Override
    public Object processaLinha(String[] linha) {

        int id = Integer.parseInt(linha[1]);
        String item = linha[2];
        item = item.substring(1, item.length() - 2);
        String nomeVendedor = linha[3];

        Vendedor vendedor = VendedorService.buscarVendedorPeloNome(nomeVendedor);
        Venda venda = new Venda(id, vendedor, nomeVendedor);

        String[] itens = item.split(",");

        for (String strItem : itens) {
            String[] texto = strItem.split("-");
            int itemID = Integer.valueOf(texto[0]);
            double total = Double.valueOf(texto[1]);
            double valor = Double.valueOf(texto[2]);
            venda.adicionaItem(new Item(itemID, total, valor));
        }
        return venda;
    }
}
