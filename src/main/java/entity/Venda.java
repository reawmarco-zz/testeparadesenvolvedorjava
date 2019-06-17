package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    private int id;
    private List<Item> itens;
    private double montante;
    private Vendedor vendedor;
    private String nomeVendedor;

    public Venda(int id, Vendedor vendedor, String nomeVendedor) {
        this.id = id;
        this.vendedor = vendedor;
        this.nomeVendedor = nomeVendedor;
        itens = new ArrayList<>();
    }

    public void adicionaItem(Item item) {
        itens.add(item);
        montante += item.total();
    }
}
