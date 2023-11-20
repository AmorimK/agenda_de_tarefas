public class TarefaComplexa extends TarefaSimples{
	
	private Etapa[] etapas = new Etapa[3];
	private int qtd = 0;
	
	public TarefaComplexa() {}
	
	public void exibeEtapas() {
		for(int i = 0; i<etapas.length; i++) {
			if(etapas[i]!=null){
			System.out.println(etapas[i].getDesc());
			}
		}
	}
	
	public void incluirEtapa(Etapa etapa) {
		
		if(qtd<etapas.length) {
		this.etapas[qtd] = etapa;
		qtd++;
		}
		else {
			System.out.println("Quantidade máxima de etapas atingida.\n");
		}
		
	}
	
	public void excluirEtapa(int i) {
		
		if(i==etapas.length) {
			qtd--;
		}
		else {
			for(int j = i; j<etapas.length; j++) {
				etapas[j] = etapas[j++];
				qtd--;
			}
		}
		
	}
}

