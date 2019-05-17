import java.util.Vector;

public class Grafo {

	Vector<Aresta> tabela[][] = new Vector[0][0];
	Vector<Aresta> arestas = new Vector<>();
	Vector<Vertice> vertices = new Vector<>();

	public void displayTabela() {
		for (int i = 0; i < tabela.length; i++) {
			System.out.print("\n" + vertices.get(i).getElemento() + "|");
			for (int j = 0; j < tabela.length; j++) {
				if (tabela[i][j] != null)
					System.out.print(tabela[i][j].size() + "|");
				else
					System.out.print("0|");
			}
		}
	}

	public void inserirVertice(Object elemento) {
		vertices.add(new Vertice(elemento));
		redimencionarTabela();
	}

	private void redimencionarTabela() {
		Vector<Aresta> novaTabela[][] = new Vector[vertices.size()][vertices.size()];

		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j < tabela.length; j++) {
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

		int posicaov1 = vertices.indexOf(vertice1);
		int posicaov2 = vertices.indexOf(vertice2);

		if (tabela[posicaov1][posicaov2] == null) {
			tabela[posicaov1][posicaov2] = new Vector<Aresta>();
		}
		if (tabela[posicaov2][posicaov1] == null) {
			tabela[posicaov2][posicaov1] = new Vector<Aresta>();
		}

		if (posicaov1 != posicaov2) {
			tabela[posicaov1][posicaov2].add(a);
			tabela[posicaov2][posicaov1].add(a);
		} else {
			tabela[posicaov1][posicaov2].add(a);
		}
	}

	public void inserirArestaDirecionada(Object elemento, int v1, int v2, boolean direcionado) {
		Vertice vertice1 = vertices.get(v1);
		Vertice vertice2 = vertices.get(v2);

		Aresta a = new Aresta(elemento, vertice1, vertice2, direcionado);
		arestas.add(a);

		int posicaov1 = vertices.indexOf(vertice1);
		int posicaov2 = vertices.indexOf(vertice2);

		if (tabela[posicaov1][posicaov2] == null) {
			tabela[posicaov1][posicaov2] = new Vector<Aresta>();
			tabela[posicaov1][posicaov2].add(a);
		} else {
			tabela[posicaov1][posicaov2].add(a);
		}
	}

	public Vertice buscarVertice(int index) {
		return vertices.get(index);
	}
	public Object removerVertice(Vertice v) {
		Object removido = v.getElemento();
		int posicaoV = vertices.indexOf(v);
		Vector<Aresta> novaTabela[][] = new Vector[vertices.size()-1][vertices.size()-1];
		int auxJ;
		int auxI;
		//Linha
		for (int i = 0; i < vertices.size() - 1; i++) {
			auxI = i;
			if (i == posicaoV) {
				auxI = i + 1;
			}
			//Coluna
			for (int j = 0; j < vertices.size() - 1; j++) {	
				auxJ = j;
				if (j == posicaoV) {
					auxJ = j + 1;
				}
				novaTabela[i][j] = tabela[auxI][auxJ];
			}
		}
		this.tabela = novaTabela;
		vertices.remove(posicaoV);
		return removido;
	}
}
