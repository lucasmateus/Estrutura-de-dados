import java.util.*;

public class Main {

	public static void main(String[] args) {
		Grafo g = new Grafo();
		
		Scanner sc = new Scanner(System.in);
		boolean marcador = true;
		
		while(marcador) {
      Menu();
			String op = sc.nextLine();
			switch(op){
				
				case "1":
					System.out.print("Digite o nome do Vertice: ");
					String elemento = sc.nextLine();
					g.inserirVertice(elemento);
					System.out.println();
          g.displayTabela();
          System.out.println();
					break;
				
				case "2":
					System.out.print("Digite o nome da Aresta: ");
					String elementoAresta = sc.nextLine();
					System.out.print("\nDigite a posição do Vertice 1: ");
					int p1 = Integer.parseInt(sc.nextLine())-1;
					System.out.print("\nDigite a posição do Vertice 2: ");
					int p2 = Integer.parseInt(sc.nextLine())-1;
					g.inserirAresta(elementoAresta, g.buscarVertice(p1), g.buscarVertice(p2), false);
          System.out.println();
          g.displayTabela();
					System.out.println();
					break;
				
				case "3":
					System.out.print("Digite o nome da Aresta: ");
					String elementoArestaDirecionada = sc.nextLine();
					System.out.print("\nDigite a posição do Vertice de saida: ");
					int pd1 = Integer.parseInt(sc.nextLine())-1;
					System.out.print("\nDigite a posição do Vertice de entrada: ");
					int pd2 = Integer.parseInt(sc.nextLine())-1;
					g.inserirArestaDirecionada(elementoArestaDirecionada, g.buscarVertice(pd1), g.buscarVertice(pd2), true);
          System.out.println();
          g.displayTabela();
					System.out.println();
					break;
				
				case "4":
					System.out.print("Digite a posição do vertice a remover:");
					int removeVertice = Integer.parseInt(sc.nextLine())-1;
					g.removerVertice(g.buscarVertice(removeVertice));
          System.out.println();
          g.displayTabela();
					System.out.println();
					break;
				
        case "5":
          System.out.print("Digite o nome da aresta a remover: ");
          Object arestaRemove = sc.nextLine();
          g.removerAresta(g.buscarAresta(arestaRemove));
          System.out.println();
          g.displayTabela();
					System.out.println();
					break;

        case "6":
          System.out.print("Digite a posição do primeiro vertice: ");
          int ps1 = Integer.parseInt(sc.nextLine())-1;
          System.out.print("\nDigite a posição do segundo vertice: ");
          int ps2 = Integer.parseInt(sc.nextLine())-1;
          System.out.println(g.verticesAdjacentes(g.buscarVertice(ps1),g.buscarVertice(ps2))
           ? "\nSão adjacentes" : "\nNão são adjacentes");
          g.displayTabela();
					System.out.println();
					break;
        
				case "0":
					System.out.println("Finalizando aplicação");
					marcador = false;
					break;
				
				default:
					System.out.println("Opcão invalida! Por favor escolha uma opcão valida.");
					break;
			}
		}
		
	}
	
	
	public static void Menu() {
		System.out.print(
				"\n------------Menu------------\n"+
				"1 - Adicionar Vertice\n"+
				"2 - Adicionar Aresta Simples\n"+
				"3 - Adicionar Aresta Direcionada\n"+
				"4 - Remover Vertice\n"+
        "5 - Remover Aresta\n"+
        "6 - Vertices Adjacentes\n"+
				"0 - Sair\n"
		);
	}
}
