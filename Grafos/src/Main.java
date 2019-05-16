import java.util.*;

public class Main {

	public static void main(String[] args) {
		Grafo g = new Grafo();
		
		Scanner sc = new Scanner(System.in);
		boolean marcador = true;
		
		Menu();
		while(marcador) {
			String op = sc.nextLine();
			switch(op){
				
				case "1":
					System.out.print("Digite o nome do Vertice: ");
					String elemento = sc.nextLine();
					g.inserirVertice(elemento);
					System.out.println();
					Menu();
					break;
				
				case "2":
					System.out.print("Digite o nome da Aresta: ");
					String elementoAresta = sc.nextLine();
					System.out.print("\nDigite a posição do Vertice 1: ");
					int p1 = sc.nextInt()-1;
					System.out.print("\nDigite a posição do Vertice 2: ");
					int p2 = sc.nextInt()-1;
					g.inserirAresta(elementoAresta, p1, p2, false);
					System.out.println();
					Menu();
					break;
				
				case "3":
					System.out.print("Digite o nome da Aresta: ");
					String elementoArestaDirecionada = sc.nextLine();
					System.out.print("\nDigite a posição do Vertice de saida: ");
					int pd1 = sc.nextInt()-1;
					System.out.print("\nDigite a posição do Vertice de entrada: ");
					int pd2 = sc.nextInt()-1;
					g.inserirArestaDirecionada(elementoArestaDirecionada, pd1, pd2, true);
					System.out.println();
					Menu();
					break;
						
				case "4":
					System.out.println("--------------Tabela----------------");
					g.displayTabela();
					Menu();
					break;
				
				case "0":
					System.out.println("Finalizando aplicação");
					marcador = false;
					break;
				
				default:
					System.out.println("Opcão invalida! Por favor escolha uma opcão valida.");
					Menu();
					break;
			}
		}
		
	}
	
	
	public static void Menu() {
		System.out.println(
				"\n------------Menu------------\n"+
				"1 - Adicionar Vertice\n"+
				"2 - Adicionar Aresta Simples\n"+
				"3 - Adicionar Aresta Direcionada\n"+
				"4 - Mostrar Tabela\n"+
				"0 - Sair\n"
		);
	}
}
