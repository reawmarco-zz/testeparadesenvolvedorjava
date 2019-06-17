package service.arquivo.processamento;

public enum EDados {

    VENDEDOR("001"),
    CLIENTE("002"),
    VENDA("003");

    private String descricao;

    EDados(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
