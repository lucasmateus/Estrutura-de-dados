public class Arvore{
  private No raiz;

  public Arvore(){
    this.raiz = null;
  }

  //metodos de controle
  public No root(){
    return this.raiz;
  }

  public boolean isEmpty(){
    return (this.raiz == null);
  }

  public void Inserir(int value) {
    this.raiz = InserirRecusivo(raiz, value);
  }

  public No InserirRecusivo(No root, int valor) {
	    if (root == null) { //Se a arvore estiver vazia
	        return new No(valor);
	    }
	    if (valor < root.getElemento()) {//insere no lado esquerdo
	        root.setNoEsq(InserirRecusivo(root.getNoEsq(), valor));
	    } else if (valor >= root.getElemento()) {//insere no lado direito
	        root.setNoDir(InserirRecusivo(root.getNoDir(), valor));
	    } else {
	        return root;
	    }
	 
	    return root;
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
  
  public boolean BuscaRecursiva(No root, int valor){
    if(root == null){
      return false;
    }
    if(valor == root.getElemento()){
      return true;
    }
    return valor < root.getElemento() ? BuscaRecursiva(root.getNoEsq(), valor) : BuscaRecursiva(root.getNoDir(), valor);
  }

  public boolean Busca(int valor){
    return BuscaRecursiva(this.raiz, valor);
  }
}