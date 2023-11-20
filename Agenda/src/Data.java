public class Data {
	
	private TarefaSimples[] tarefaS = new TarefaSimples[3];
	private TarefaComplexa[] tarefaC = new TarefaComplexa[3];
	private int qtdS = 0;
	private int qtdC = 0;
	
	public Data() {}
	
	public int getQtdS() {
		return this.qtdS;
	}
	
	public int getQtdC() {
		return this.qtdC;
	}
	
	public TarefaSimples[] getListaS() {
		return this.tarefaS;
	}
	
	public TarefaComplexa[] getListaC() {
		return this.tarefaC;
	}
	
	public void exibeTarefaSimples(){
		
		for(int i = 0; i < qtdS; i++) {
			System.out.println("Tarefa " + i+1 + " - " + tarefaS[i].getDesc());
		}
		
	}
	
	public void exibeTarefaComplexa(){
		
		for(int i = 0; i < qtdC; i++) {
			System.out.println("Tarefa " + i+1 + " - " + tarefaC[i].getDesc());
			tarefaC[i].exibeEtapas();
		}
		
	}
	
	public void exibirBusca(int tipoT, int posLista) {
		
		if(tipoT==1) {
			System.out.println(tarefaS[posLista].getDesc());
		}
		else if(tipoT==2) {
			System.out.println(tarefaC[posLista].getDesc());
			tarefaC[posLista].exibeEtapas();
		}
		else {System.out.println("Erro de índice.\n");}
	}
	
	public void incluirTarefaSimples(TarefaSimples tarefa) {
		
		tarefaS[qtdS] = tarefa;
		qtdS++;
	}
	
	public void incluirTarefaComplexa(TarefaComplexa tarefa) {
			
			tarefaC[qtdC] = tarefa;
			qtdC++;
			
	}
	
	public void delTarefaSimples(int i) {
			
			if(i==qtdS) {
				qtdS--;
			}
			else {
				for(int j = i; j<qtdS; j++) {
					tarefaS[j] = tarefaS[j+1];
					qtdS--;
				}
			}
			
		}
	
	public void delTarefaComplexa(int i) {
		
		if(i==qtdC) {
			qtdC--;
		}
		else {
			for(int j = i; j<qtdC; j++) {
				tarefaC[j] = tarefaC[j+1];
				qtdC--;
			}
		}
		
	}
	
	public void altTarefaComplexa(int posT, TarefaComplexa tarefa) {
		tarefaC[posT] = tarefa;
	}
	
	public void altTarefaSimples(int posT, TarefaSimples tarefa) {
		tarefaS[posT] = tarefa;
	}
	
}
