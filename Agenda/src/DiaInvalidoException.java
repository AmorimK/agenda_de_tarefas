public class DiaInvalidoException extends Exception {
	public DiaInvalidoException() {
        super("Dia inv?lido. Insira um valor entre 1 e 28.\n");
    }
}