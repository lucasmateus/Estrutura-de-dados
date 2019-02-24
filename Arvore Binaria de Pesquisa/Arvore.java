public class Arvore{
  private No raiz;

  public Arvore(){
    this.raiz = null;
  }

  //metodos de controle
  public boolean isEmpty(){
    return this.raiz == null;
  }
  public void inserir(int elemento){
    No novo = new No(elemento);//cria o novo nó

    if(isEmpty()){//se a arvore estiver vazia
      this.raiz = novo;
    }else{
      No atual = this.raiz;
      No anterior;//pulo do gato (esse nó serve para ser um auxiliar e possibilitar a inserção)
      while(true){
        anterior = atual;
        if(elemento <= atual.getElemento()){//vai para o lado esquerdo
          atual = atual.getNoEsq();//O no atual vai ser o filho esquerdo
          if(atual == null){//se o no esquerdo estiver vazio
            anterior.setNoEsq(novo);//inserimos o novo nó
          }
        }else{//vai para o lado direito
          atual = atual.getNoDir();//O no atual vai ser o filho direito
          if(atual == null){//se encontrarmos um vazio do lado direito
            anterior.setNoDir(novo);//inserimos o novo nó
          }
        }
      }
    }
  }

  public No Buscar(int valor){
    if(isEmpty()){
      return null;//se a arvore estiver vazia
    }
    No atual = this.raiz; //começamos a buscar pela raiz
    while(atual.getElemento() != valor){//enquanto o valor do nó for diferente do valor a ser buscado
      if(valor < atual.getElemento()){
        atual = atual.getNoEsq();
      }else{
        atual = atual.getNoDir();
      }
      if(atual == null){//o valor passado não encontra-se na arvore
        return null;
      }
    }
    return atual;
  }
}