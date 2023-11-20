public class Agenda {
	
	private int mes;
	private int ano;
	private Data[] datas = new Data[28];
	
	public Agenda(int mes, int ano) {
		this.mes = mes;
		this.ano = ano;
		}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void setData(int dia, Data data) {
		this.datas[dia-1] = data;
	}
	
	public Data getData(int dia) {
		return this.datas[dia-1];
	}
	
	public boolean checkData(int pos) {
		if(datas[pos-1] != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void exibirTodos() {
		for(int i = 1; i<datas.length+1; i++) {
			if(checkData(i)){
			System.out.println("Dia "+ (i));
			System.out.println();
			System.out.println("Tarefas Simples:");
			System.out.println();
			this.datas[i-1].exibeTarefaSimples();
			System.out.println();
			System.out.println("Tarefas Complexas:");
			this.datas[i-1].exibeTarefaComplexa();
			}
		}
	}
	
}

