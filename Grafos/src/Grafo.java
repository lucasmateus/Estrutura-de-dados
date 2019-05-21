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
    //Ordem de Grafo = numero de vertices
    System.out.println("\nNumero de vertices: "+vertices.size());
    System.out.println("Numero de arestas: "+arestas.size());
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

	public void inserirAresta(Object elemento, Vertice vertice1, Vertice vertice2, boolean direcionado) {
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

	public void inserirArestaDirecionada(Object elemento, Vertice vertice1, Vertice vertice2, boolean direcionado) {
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
		
		//Linha
    int auxI = 0;
		for (int i = 0; i < vertices.size() - 1;) {
      if(i == posicaoV && auxI == posicaoV){
        auxI++;
      }
			//Coluna
      int auxJ = 0;
			for (int j = 0; j < vertices.size() - 1;) {	
				if(j == posicaoV && auxJ == posicaoV){
          auxJ++;
        }
				novaTabela[i][j] = tabela[auxI][auxJ];
        j++;
        auxJ++;
			}
      i++;
      auxI++;
		}
		this.tabela = novaTabela;
		vertices.remove(posicaoV);
		return removido;
	}

  public Aresta buscarAresta(Object elemento){
    for(int i=0;i<arestas.size();i++){
      if(arestas.get(i).getElemento().equals(elemento)){
        return arestas.get(i);
      }
    }
    return null;
  }

  public Object removerAresta(Aresta a){
    Object removido = a.getElemento();
    int posiçãoA = arestas.indexOf(a);

    int vertice1 = vertices.indexOf(a.getOrigem());
    int vertice2 = vertices.indexOf(a.getDestino());

    if(a.getDirecionado()){
      tabela[vertice1][vertice2].remove(a);
    }else{
      tabela[vertice1][vertice2].remove(a);
      tabela[vertice2][vertice1].remove(a);
    }
    arestas.remove(a);
    return removido;
  }

  public boolean verticesAdjacentes(Vertice v1, Vertice v2){
    int posicaoV1 = vertices.indexOf(v1);
    int posicaoV2 = vertices.indexOf(v2);

    if(tabela[posicaoV1][posicaoV2] != null || 
      tabela[posicaoV2][posicaoV1] != null){
        return true;
    }else return false;
  }
  public boolean arestasParalelas(Aresta a1, Aresta a2){
    return true;
  }
}
