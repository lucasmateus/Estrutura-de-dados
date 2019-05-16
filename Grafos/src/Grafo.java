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
		
		int posi��oV1 = vertices.indexOf(vertice1);
		int posi��oV2 = vertices.indexOf(vertice2);
		
		if(tabela[posi��oV1][posi��oV2] == null) {
			tabela[posi��oV1][posi��oV2] = new Vector<Aresta>();
		}
		if(tabela[posi��oV2][posi��oV1] == null) {
			tabela[posi��oV2][posi��oV1] = new Vector<Aresta>();
		}
		
		if(posi��oV1 != posi��oV2) {
			tabela[posi��oV1][posi��oV2].add(a);
			tabela[posi��oV2][posi��oV1].add(a);
		}else {
			tabela[posi��oV1][posi��oV2].add(a);
		}
	}
	
}
