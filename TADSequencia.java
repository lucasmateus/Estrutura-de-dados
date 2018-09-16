public class TADSequencia {
	private No inicio;
	private No fim;
	private int tamanho;


	public TADSequencia() {
		inicio = new No();
		fim = new No();
    inicio.setProximo(fim);
    fim.setAnterior(inicio);
		tamanho = 0;
	}
	public int size() { //Funçao que retorna o tamanho da sequencia
		return tamanho;
	}

	public boolean isEmpty() {//Função que retorna se a sequencia esta vazia ou não
		return tamanho == 0;
	}

	public Object elemAtRank(int r) {//funçao retorna o elemento da sequencia na posição "r"
		No no = new No();
		no = atRank(r);
		Object o = new Object();
		o = no.getElemento();
		return o;
	}

	public Object replaceAtRank(int r, Object o) {//substitui o elemento na posiçao "r" com o elemento "o" e retorna o objeto substituido
		No no = atRank(r);
		Object antigoElemento = no.getElemento();
		no.setElemento(o);
		return antigoElemento;
	}

	public void insertAtRank(int r, Object o) {//Insere um novo elemento "o" na posição "r"
		No antigo = atRank(r);//pegar o no na posiçao "r"
		No novo = new No(); // novo no
		novo.setElemento(o); //colocando o elemento do novo no
		novo.setProximo(antigo);//o proximo do novo no é o antigo
		novo.setAnterior(antigo.getAnterior());//o anterior do novo no é o anterior do antigo
    antigo.getAnterior().setProximo(novo);//o proximo do antigo anterior é o novo
    antigo.setAnterior(novo);//o anterior do antigo é o novo
		tamanho ++;
	}

	public Object removeAtRank(int r) {//Remove da sequencia o elemento que esta na posição "r"
		/*No no = atRank(r);
		Object NoRemovido = no.getElemento();
		remove(no);
		return NoRemovido;*/
		return remove(atRank(r));
	}

	public No first() {//retorna o primeiro no
		return inicio.getProximo();
	}

	public No last() {//retorna o ultimo no
		return fim.getAnterior();
	}

	public No before(No n) {//diz qual é o anterior de um no
		return n.getAnterior();
	}

	public No after(No n) {//diz qual é o proximo no
		return n.getProximo();
	}

	public void replaceElemt(No n, Object o) {//subistitui um elemento de um no
		n.setElemento(o);	
	}

	public void swapElem(No n, No q) {//troca um no
		Object novo = new Object();
		novo = n.getElemento();
		n.setElemento(q.getElemento());
		q.setElemento(novo);
	}

	public void insertBefore(No n, Object o) {//insere antes de um determinado no
		No v = new No();//novo no "v"
		v.setElemento(o);//inserindo o elemento no no "v"
		v.setProximo(n);//o proximo do no "v" é o no "n"
		v.setAnterior(n.getAnterior());//o anterior do no "v" e o anterior do no "n"
		(n.getAnterior()).setProximo(v);//o proximo do anterior de "n" é o no "v"
		n.setAnterior(v);//o anterior do no "n" é "v"
	}

	public void insertAfter(No n, Object o) {//insere depois de um determinado no
		No v = new No();//um novo no "v"
		v.setElemento(o);//passamos o elemento do paramento para este novo no "v"
		v.setAnterior(n);//o anterior desse no é o no "n"
		v.setProximo(n.getProximo());//o proximo desse no é o proximo do no "n"
		(n.getProximo()).setAnterior(v);//modificamos o valor do proximo do no "n" passando o novo no "v"
		n.setProximo(v);
	}

	public void insertFirst(Object o) {//insere no inicio
		No novo = new No();//novo no
		No antigo_inicio = new No();
		antigo_inicio = inicio.getProximo();//No para guardar o proximo do inicio
		novo.setElemento(o);//novo elemento inserido no novo no
		novo.setAnterior(inicio);//o anterior desse novo no é o inicio
		novo.setProximo(antigo_inicio);//o proximo dele é o antigo inicio
    antigo_inicio.setAnterior(novo);//o anterior do antigo inicio agora é o novo no
		inicio.setProximo(novo);//o proximo do inicio vai ser o novo no
		if(this.tamanho == 0){ // se o tamanho for igual a zero o anterior do fim e o novo elemento
			fim.setAnterior(novo);
		}
		this.tamanho++;//aumentar o tamanho da sequencia
	}

	public void insertLast(Object o) {//insere no final
		No novo = new No();//novo no
		No antigo_fim = fim.getAnterior();//no para guardar o anterior do fim
		novo.setElemento(o);//inserimos o elemento "o" no novo no
		novo.setProximo(fim);//o proximo desse novo no aponta para o fim da sequencia
		novo.setAnterior(antigo_fim);//o anterior do novo elemento era o antigo fim
    antigo_fim.setProximo(novo);//o proximo do antigo fim é o novo
		fim.setAnterior(novo);//o anterior do fim é o novo elemento
		if(this.tamanho == 0){//se o tamanho da sequencia for igual a 0 o proximo do inicio é tambem o novo no
			inicio.setProximo(novo);
		}
		this.tamanho++;//incrementa o tamanho da sequencia
	}

	public Object remove(No n) {//remove o no
		Object t = n.getElemento();//declaramos um objecto e passamos o valor do elemento do no passado por parametro
		(n.getAnterior()).setProximo(n.getProximo());//o proximo do anterior do no "n" vai ser igual ao proximo de "n"
		(n.getProximo()).setAnterior(n.getAnterior());//o anterior do proximo do no "n" vai ser igual ao anterior de "n"
		n.setAnterior(null);//o anterior de n agora é null
		n.setProximo(null);//o proximo de n agora é null
		tamanho --;//decrementa o tamanho da sequencia
		return t;
	}
	public No atRank(int r) {//retorna o no do indice "r"
		No node = new No();//novo no
		if(r <= size()/2) {//se o elemento for menor quer o tamanho/2
			node = inicio.getProximo();// o novo no é igual ao proximo do inicio
			for(int i = 0; i < r; i++) {//um for ate menor que o valor do elemento
				node = node.getProximo();//colocamos o proximo do no
			}
		}else {// se ele nao for menor ou igual a metade do tamanho da sequencia
			node = fim.getAnterior();//o novo no vai receber o anterior ao fim
			for(int i = 0; i < size()-r-1; i++) {//
				node = node.getAnterior();// colocamos no anterior do no
			}
		}
		return node;//retorna o novo no
	}
	public int rankOf(No n) {//retorna a posição do elemento
		No node = inicio.getProximo();
		int r = 0;
		while(node != n && n != fim) {
			n = n.getProximo();
			r++;
		}
		return r;
	}
  public void display(){
    No novo = inicio.getProximo();
    System.out.print("Inicio -> ");
    while(novo!=fim){
      System.out.print(novo.getElemento()+" -> ");
      novo = novo.getProximo();
    }
    System.out.println("FIM");
  }
}
