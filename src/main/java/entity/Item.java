package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private int id;
    private double quantidade;
    private double valor;

    /**
     * Calcula o valor total de cada item.
     *
     * @return
     */
    public double total() {
        return (quantidade * valor);
    }
}
