class Main {
  public static void main(String[] args) {
    fila f = new fila(5);
    f.enfileirar("A");
    f.enfileirar("B");
    f.enfileirar("C");
    f.enfileirar("D");
    f.enfileirar("E");
    f.enfileirar("F");
    f.desenfileirar();
    f.desenfileirar();
    f.desenfileirar();
    f.desenfileirar();
    f.desenfileirar();
    f.desenfileirar();
    System.out.println("Capacidade da fila: "+f.tamanho+"\nTamanho da fila: " + f.size());
    f.display();
  }
}
class fila{
  Object [] Fila;
  int inicio;
  int fim;
  int tamanho;
  int total;

  public fila(int tamanho){
    Fila = new Object[tamanho];
    inicio = 0;
    fim = 0;
    total = 0;
    this.tamanho = tamanho;
  }
  public void enfileirar(Object elem){//fazer o execption de pilha cheia
    if(isFull()){
      Object [] novo = new Object[2*this.tamanho];
      for(int i = 0; i<this.fim;i++){
        novo[i] = Fila[i];
      }
      novo[fim] = elem;
      fim = ++fim;
      total++;
      Fila = novo;
      this.tamanho = 2 * this.tamanho;
    }else{
      Fila[fim] = elem;
    fim = ++fim;
    total++;
    }
  }
  public Object desenfileirar(){//fazer a execption de pilha vazia
    Object elem = Fila[inicio];
    inicio = (inicio+1)%tamanho;
    total--;
    return elem;
  }
  public boolean isEmpty(){
    return (total == 0);
  }
  public boolean isFull(){
    return (total==tamanho);
  }
  public int size(){
    return total;
  }
  public void display(){
    Object [] novo = Fila;
    int cont = total;
    while(--cont != -1){
      System.out.print(novo[inicio]+"->");
      inicio = inicio+1;
    }
    System.out.println("NULL");
  }
}
