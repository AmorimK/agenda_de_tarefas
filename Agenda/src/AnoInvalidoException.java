public class AnoInvalidoException extends Exception {
	public AnoInvalidoException() {
        super("Ano inv?lido. Insira um valor maior que 0.\n");
    }
}