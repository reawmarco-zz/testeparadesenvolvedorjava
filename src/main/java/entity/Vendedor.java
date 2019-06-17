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
public class Vendedor {

    private int id;
    private String cpf;
    private String nome;
    private double salario;
    private List<Venda> vendas;

    public Vendedor(int id, String cpf, String nome, double salario) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
        vendas = new ArrayList<>();
    }
}
