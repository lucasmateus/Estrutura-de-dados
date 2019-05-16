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
					System.out.print("\nDigite a posi��o do Vertice 1: ");
					int p1 = sc.nextInt()-1;
					System.out.print("\nDigite a posi��o do Vertice 2: ");
					int p2 = sc.nextInt()-1;
					g.inserirAresta(elementoAresta, p1, p2, false);
					System.out.println();
					Menu();
					break;
				
				case "3":
					System.out.println("--------------Tabela----------------");
					g.displayTabela();
					Menu();
					break;
					
				case "0":
					System.out.println("Finalizando aplica��o");
					marcador = false;
					break;
				
				default:
					System.out.println("Opc�o invalida! Por favor escolha uma opc�o valida.");
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
				"3 - Mostrar Tabela\n"+
				"0 - Sair\n"
		);
	}
}
