package exception;

public class ExErroLinhaArquivo extends Exception {

    private static final long serialVersionUID = 1L;

    public ExErroLinhaArquivo() {
        super();
    }

    public ExErroLinhaArquivo(String erro) {
        super(erro);
    }
}
