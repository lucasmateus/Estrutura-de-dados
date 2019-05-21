public class Aresta {
	
	private Object elemento;
	private Vertice origem;
	private Vertice destino;
	private boolean direcionado;
	
	
	public Aresta(Object elemento, Vertice origem, Vertice destino, boolean direcionado) {
		this.elemento = elemento;
		this.origem = origem;
		this.destino = destino;
		this.direcionado = direcionado;
	}
	
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public Vertice getOrigem() {
		return origem;
	}
	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}
	public Vertice getDestino() {
		return destino;
	}
	public void setDestino(Vertice destino) {
		this.destino = destino;
	}

  public boolean getDirecionado(){
    return direcionado;
  }
	
}
