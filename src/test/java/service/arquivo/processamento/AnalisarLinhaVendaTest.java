package service.arquivo.processamento;

import entity.Item;
import entity.Venda;
import entity.Vendedor;
import org.junit.Assert;
import org.junit.Test;
import service.VendaService;

import java.util.ArrayList;
import java.util.List;

public class AnalisarLinhaVendaTest {

    @Test
    public void adicionandoVendasVerificandoMaiorMenorTest(){
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, 2, 10.0));
        itens.add(new Item(2, 4, 100.0));
        itens.add(new Item(3, 2, 50.0));
        Venda venda = new Venda(1,itens, 520.0, new Vendedor(1,"2342342424243", "Teste", 500.0), "Teste");

        List<Item> itens2 = new ArrayList<>();
        itens2.add(new Item(1, 2, 10.0));
        itens2.add(new Item(2, 2, 100.0));
        itens2.add(new Item(3, 4, 100.0));
        itens2.add(new Item(4, 2, 50.0));
        Venda venda2 = new Venda(2,itens2, 620.0, new Vendedor(2,"234231234243", "Teste2", 600.0), "Teste2");

        VendaService.adicionaVenda(venda);

        VendaService.adicionaVenda(venda2);

        Assert.assertEquals(2, VendaService.buscarIDMaiorVenda());

        Assert.assertEquals("Teste", VendaService.buscarNomeVendedorDaPiorVenda());
    }
}
