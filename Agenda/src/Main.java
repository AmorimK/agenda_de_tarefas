import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);
        int mes;
        int ano;

        try {
            System.out.println("Insira o mês referente a Agenda:\n");
            mes = ent.nextInt();
            validarMes(mes);

            System.out.println("Insira o ano referente a Agenda:\n");
            ano = ent.nextInt();
            validarAno(ano);

            Agenda agenda = new Agenda(mes, ano);
            System.out.println("Agenda criada com sucesso.\n");

            int opt = menu(ent);

            if (opt == 0) {
                System.out.println("Encerrado.\n");
            } else {
                while (opt != 0) {
                    // chamar menu no final dnv

                    // op 1 e 2 serao uma opcao so

                    if (opt == 1) { // Cadastrar Tarefas

                        int dia;

                        System.out.println("Insira o tipo de tarefa:\n1 - Simples\n2 - Complexa");
                        int tipo = ent.nextInt();
                        validarTipoTarefa(tipo);

                        System.out.println("Insira o dia em que a tarefa será realizada:\n");
                        dia = ent.nextInt();
                        validarDia(dia);

                        if (!agenda.checkData(dia)) {
                            Data data = new Data();
                            agenda.setData(dia, data);
                        }

                        if (tipo == 1) {
                            TarefaSimples tarefaS = new TarefaSimples();
                            ent.nextLine();
                            System.out.println("Insira a descrição da tarefa:\n");
                            tarefaS.setDesc(ent.nextLine());

                            agenda.getData(dia).incluirTarefaSimples(tarefaS);
                            System.out.println("Tarefa simples cadastrada com sucesso.\n");

                        } else {
                            TarefaComplexa tarefaC = new TarefaComplexa();
                            ent.nextLine();
                            System.out.println("Insira a descrição da tarefa:\n");
                            tarefaC.setDesc(ent.nextLine());

                            int opcao;
                            int aux = 0;

                            do {

                                System.out.println("Deseja cadastrar nova Etapa?\n1 - Sim\n2 - Não");
                                opcao = ent.nextInt();

                                if (opcao == 1) {
                                    ent.nextLine();
                                    System.out.println("Insira a descrição da etapa:\n");
                                    String etapadesc = ent.nextLine();
                                    Etapa etapa = new Etapa();
                                    etapa.setDesc(etapadesc);
                                    tarefaC.incluirEtapa(etapa);
                                    aux++;
                                }
                            } while (aux < 3 && opcao != 2);

                            agenda.getData(dia).incluirTarefaComplexa(tarefaC);
                            System.out.println("Tarefa complexa cadastrada com sucesso.\n");

                        }

                    } else if (opt == 2) { // Alterar Tarefa

                        System.out.println("Selecione o tipo de tarefa a mudar:\n1 - Tarefa Simples\n2 - Tarefa Complexa");
                        int tipo = ent.nextInt();
                        validarTipoTarefa(tipo);

                        System.out.println("Insira o dia em que a tarefa se encontra:\n");
                        int diaT = ent.nextInt();
                        validarDia(diaT);
                        
                        Data tarefaDia = agenda.getData(diaT);

                        if(tarefaDia==null) {
                        	System.out.println("Não há tarefas a serem alteradas.\n");
                        }
                        
                        
                        else if (tipo == 1) {

                            System.out.println("Tarefas Simples Listadas:\n");
                            tarefaDia.exibeTarefaSimples();

                            System.out.println("Selecione a tarefa simples a ser alterada:\n");

                            int posT = ent.nextInt() - 1;

                            TarefaSimples tarefaS = new TarefaSimples();

                            ent.nextLine();
                            System.out.println("Insira a descrição da nova tarefa simples:\n");
                            tarefaS.setDesc(ent.nextLine());

                            tarefaDia.altTarefaSimples(posT, tarefaS);
                            System.out.println("Alterada com sucesso.\n");

                        } else if(tipo==2){

                            System.out.println("Tarefas Complexas Listadas:\n");
                            tarefaDia.exibeTarefaComplexa();

                            System.out.println("Selecione a tarefa complexa a ser alterada:\n");

                            int posT = ent.nextInt() - 1;

                            TarefaComplexa tarefaC = new TarefaComplexa();

                            ent.nextLine();
                            System.out.println("Insira a descrição da nova tarefa complexa:\n");
                            tarefaC.setDesc(ent.nextLine());

                            int opcao;
                            int aux = 0;

                            do {

                                System.out.println("Deseja cadastrar nova Etapa?\n1 - Sim\n2 - Não");
                                opcao = ent.nextInt();

                                if (opcao == 1) {
                                    ent.nextLine();
                                    System.out.println("Insira a descrição da etapa:\n");
                                    String etapadesc = ent.nextLine();
                                    Etapa etapa = new Etapa();
                                    etapa.setDesc(etapadesc);
                                    tarefaC.incluirEtapa(etapa);
                                    aux++;
                                }
                            } while (aux < 3 && opcao != 2);

                            tarefaDia.altTarefaComplexa(posT, tarefaC);
                            System.out.println("Alterada com sucesso.\n");

                        }

                    } else if (opt == 3) { // Excluir Tarefa

                        System.out.println("Selecione o tipo de tarefa a ser deletada:\n1 - Tarefa Simples\n2 - Tarefa Complexa");
                        int tipo = ent.nextInt();
                        validarTipoTarefa(tipo);

                        System.out.println("Insira o dia em que a tarefa se encontra:\n");
                        int diaT = ent.nextInt();
                        validarDia(diaT);

                        Data tarefaDia = agenda.getData(diaT);

                        if(tarefaDia==null) {
                        	System.out.println("Não há tarefas a serem excluídas.\n");
                        }

                        else if (tipo == 1) {

                            System.out.println("Selecione a tarefa simples a ser deletada:\n");
                            tarefaDia.exibeTarefaSimples();
                            int posT = (ent.nextInt()) - 1;

                            tarefaDia.delTarefaSimples(posT);

                        } else if (tipo==2){
                            System.out.println("Selecione a tarefa complexa a ser deletada:\n");
                            tarefaDia.exibeTarefaComplexa();
                            int posT = (ent.nextInt()) - 1;

                            tarefaDia.delTarefaComplexa(posT);

                        }

                    } else if (opt == 4) { // Busca

                        agenda.exibirTodos();

                    } else if (opt == 5) {

                        System.out.println("Selecione o tipo de busca:\n1 - Dia\n2 - Palavra-chave\n");
                        opt = ent.nextInt();

                        if (opt == 1) {
                            System.out.println("Escolha o dia desejado:\n");
                            int dia = ent.nextInt();
                            
                            Data diaEscolhido = agenda.getData(dia);
                            
                            if(diaEscolhido == null) {
                            	System.out.println("Não há tarefas a serem exibidas.\n");
                            	
                            }
                      
                            else {
                            
                            System.out.println("Tarefas Simples:\n");
                            diaEscolhido.exibeTarefaSimples();
                            System.out.println();
                            System.out.println("Tarefas Complexas:\n");
                            diaEscolhido.exibeTarefaComplexa();
                            System.out.println();
                            ;}
                        } else if (opt == 2) {
                            ent.nextLine();
                            System.out.println("Insira a palavra-chave:\n");
                            String palavraChave = (ent.nextLine()).toLowerCase();

                            for (int dia = 1; dia <= 28; dia++) {
                                if (agenda.checkData(dia)) {
                                    Data diaAtual = agenda.getData(dia);
                                    int qtdS = diaAtual.getQtdS();
                                    int qtdC = diaAtual.getQtdC();

                                    System.out.println("Tarefas encontradas no dia " + dia + ":\n");

                                    for (int i = 0; i < qtdS; i++) {
                                        TarefaSimples[] tarefaS = diaAtual.getListaS();
                                        if (tarefaS[i].getDesc().toLowerCase().contains(palavraChave)) {
                                            System.out.println("Tipo: Tarefa Simples\nDescrição: " + tarefaS[i].getDesc() + "\n");
                                        }
                                    }

                                    for (int i = 0; i < qtdC; i++) {
                                        TarefaComplexa[] tarefaC = diaAtual.getListaC();
                                        if (tarefaC[i].getDesc().toLowerCase().contains(palavraChave)) {
                                            System.out.println("Tipo: Tarefa Complexa\nDescrição: " + tarefaC[i].getDesc() + "\n");
                                        }

                                    }
                                }

                            }

                        }

                    }
                    opt = menu(ent);
                }
            }

        } catch(InputMismatchException e) {
        	System.out.println("Erro: Tipo de entrada inválida\n");
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    private static void validarMes(int mes) throws MesInvalidoException {
        if (mes < 1 || mes > 12) {
            throw new MesInvalidoException();
        }
    }

    private static void validarAno(int ano) throws AnoInvalidoException {
        if (ano <= 0) {
            throw new AnoInvalidoException();
        }
    }

    private static void validarTipoTarefa(int tipo) throws TipoTarefaInvalidoException {
        if (tipo < 1 || tipo > 2) {
            throw new TipoTarefaInvalidoException();
        }
    }

    private static void validarDia(int dia) throws DiaInvalidoException {
        if (dia < 1 || dia > 28) {
            throw new DiaInvalidoException();
        }
    }

    private static void validarOpcao(int opt) throws OpcaoInvalidaException {
        if (opt < 0 || opt > 5) {
            throw new OpcaoInvalidaException();
        }
    }

    public static int menu(Scanner ent) throws OpcaoInvalidaException {

        System.out.println("1 - Cadastrar Tarefa");
        System.out.println("2 - Alterar Tarefa");
        System.out.println("3 - Excluir Tarefa");
        System.out.println("4 - Listar todas as tarefas");
        System.out.println("5 - Buscar"); // por data e por palavra
        System.out.println("0 - Encerrar sistema");
        System.out.println();

        int opt = ent.nextInt();
        validarOpcao(opt);

        return opt;

    }

}
