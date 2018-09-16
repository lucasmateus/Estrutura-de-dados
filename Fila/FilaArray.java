class Main {
  public static void main(String[] args) {
    fila f = new fila(5);
    f.enfileirar("A");
    f.enfileirar("B");
    f.enfileirar("C");
    f.enfileirar("D");
    f.enfileirar("E");
    f.desenfileirar();
    f.enfileirar("G");

    System.out.println("Valor do fim: "+f.fim+"\nCapacidade da fila: "+f.tamanho+"\nTamanho da fila: " + f.size());
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
      Object [] aux = new Object[2*this.tamanho];
      for(int i=0;i<this.total;i++){
        aux[i] = Fila[inicio];
        inicio = (inicio+1) % tamanho;
      }
      aux[fim] = elem;
      Fila = aux;
      this.inicio = 0;
      this.fim = i;
      this.tamanho = 2*this.tamanho;
      this.total++;
    }else{
      Fila[this.fim] = elem;
      this.total++;
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
    return (total==tamanho-1);
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
