package pilhalistaencadeada;

public class PilhaListaEncadeada {
  private ListaEncadeada topo;
  private int tamanho;

  public PilhaListaEncadeada() {
    this.topo = null;
    this.tamanho = 0;
  }

  public void push(Object elem) {
    ListaEncadeada nova = new ListaEncadeada(); // declarando uma nova lista
    nova.setElemento(elem); // passando o elemento para a nova lista
    nova.setProximo(this.topo); // definindo o proximo como o topo... lembrando que o top inicial é null
    this.tamanho++;

    this.topo = nova; // o topo que era nulo agora recebe a nova lista que foi passado
  }

  public Object pop() {
    if(size()==0){
      //Exception de vazio
    }
    Object element = topo.getElemento();
    if(size == 1){
      this.topo = null;
    }
    topo = topo.getProximo();
    this.tamanho--;
    return element;
  }

  public boolean isEmpty() {
    return (this.topo == null);
  }

  public int size() {
    return tamanho;
  }

  public void display() {
    if (topo == null) {
      System.out.println("Pilha Vazia");
    } else {
      System.out.println("O tamanho da pilha é: " + size());
      ListaEncadeada nova = topo;
      while (nova != null) {
        System.out.println(nova.getElemento());
        nova = nova.getProximo();
      }
    }
  }
}
//===============================================================

package pilhalistaencadeada;

public class ListaEncadeada {
    private Object elemento;
    private ListaEncadeada proximo;
    
    public void setElemento(Object e){
        this.elemento = e;
    }
    public Object getElemento(){
        return this.elemento;
    }
    public void setProximo(ListaEncadeada prox){
        this.proximo = prox;
    }
    public ListaEncadeada getProximo(){
        return this.proximo;
    }
}
