import java.util.Vector;

public class Grafo {

	Vector<Aresta> tabela[][] = new Vector[0][0];
	Vector<Aresta> arestas = new Vector<>();
	Vector<Vertice> vertices = new Vector<>();
	
	public void displayTabela() {
		
		System.out.println("\t"+vertices.get(0).getElemento());
		for(int i = 0;i < tabela.length;i++){
			System.out.print("\n"+vertices.get(i).getElemento()+"|");
            for(int j = 0;j < tabela.length;j++){
            	if(tabela[i][j] != null)
            		System.out.print(vertices.get(i).getElemento()+"["+tabela[i][j].get(0).getElemento()+"]|");
            	else
            		System.out.print(vertices.get(i).getElemento()+"[0]|");
            }
        }
	}
	public void inserirVertice(Object elemento) {
		vertices.add(new Vertice(elemento));
		redimencionarTabela();
	}
	
	private void redimencionarTabela() {
		Vector<Aresta> novaTabela[][] = new Vector[vertices.size()][vertices.size()];
		
		for(int i = 0;i < tabela.length;i++){
            for(int j = 0;j < tabela.length;j++){
                novaTabela[i][j] = tabela[i][j];
            }
        }
		this.tabela = novaTabela;
	}

	public void inserirAresta(Object elemento, int v1, int v2, boolean direcionado) {
		Vertice vertice1 = vertices.get(v1);
		Vertice vertice2 = vertices.get(v2);
		
		Aresta a = new Aresta(elemento, vertice1, vertice2, direcionado);
		arestas.add(a);
		
		int posiçãoV1 = vertices.indexOf(vertice1);
		int posiçãoV2 = vertices.indexOf(vertice2);
		
		if(tabela[posiçãoV1][posiçãoV2] == null) {
			tabela[posiçãoV1][posiçãoV2] = new Vector<Aresta>();
		}
		if(tabela[posiçãoV2][posiçãoV1] == null) {
			tabela[posiçãoV2][posiçãoV1] = new Vector<Aresta>();
		}
		
		if(posiçãoV1 != posiçãoV2) {
			tabela[posiçãoV1][posiçãoV2].add(a);
			tabela[posiçãoV2][posiçãoV1].add(a);
		}else {
			tabela[posiçãoV1][posiçãoV2].add(a);
		}
	}
	
}
