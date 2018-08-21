class Main {
  public static void main(String[] args) {
    FilaDinamica f = new FilaDinamica();
    f.inserir(10);
    //f.remover();
    f.inserir(20);
    //f.remover();
    f.inserir(30);
    //f.remover();
    f.inserir(40);
    //f.remover();
    //f.remover();
    f.display();
  }
}

class FilaDinamica {
  private No incioFila;
  private No fimFila;
  private int tamanho;

  public FilaDinamica() {
    this.tamanho = 0;
    this.incioFila = null;
    this.fimFila = null;
  }

  public boolean filaVazia() {
    return this.tamanho == 0;
  }

  public void inserir(Object e) {
    No novo = new No();
    if (filaVazia()) { //Se a fila estiver vazia
      novo.setElemento(e); // o novo no recebera o valor do elemento
      novo.setProximo(null); // o proximo do no apontara para nulo
      this.incioFila = novo; //o inicio da fila ira apontar para o novo assim como o final sera o inicio pois é o primeiro elemento da fila
      this.fimFila = this.incioFila;
      this.tamanho++;//incrementamos o tamanho
    } else {//Se a fila não estiver vazia
      novo.setElemento(e);//o novo no recebera o valor do elemento
      novo.setProximo(null);//o proximo apontara para nulo
      this.fimFila.setProximo(novo); //adicionamos mais um no no final da fila, aqui temos o no atual e modificamos seu proximo que apontava para null e agora aponta para esse novo no.
      this.fimFila = novo;// agora mudamos a posição do final da fila, pois ele estava sendo o no anterior
      this.tamanho++;//incrementamos o tamanho da fila
    }
  }

  public void remover() {
    No novo = this.incioFila;
    if(filaVazia()){
      System.out.println("Fila vazia!!!");
    }else{
      novo = novo.getProximo();//o novo vai ser o proximo do iniciodafila
      this.incioFila = novo;// e o inicio da fila vai ser o novo nó
      this.tamanho--;//decrementa o tamanho
    }
  }

  public int tamanhoFila() {
    return this.tamanho;
  }

  public void display() {
    System.out.println(this.tamanhoFila());
    No novo = incioFila;
    for (int i = 0; i < this.tamanho; i++) {
      System.out.print(novo.getElemento() + " -> ");
      novo = novo.getProximo();
    }
    System.out.print("NULL\n");
  }
}

class No {
  private Object Elemento;
  private No proximo;

  public void setElemento(Object e) {
    this.Elemento = e;
  }

  public Object getElemento() {
    return this.Elemento;
  }

  public void setProximo(No p) {
    this.proximo = p;
  }

  public No getProximo() {
    return this.proximo;
  }
}
