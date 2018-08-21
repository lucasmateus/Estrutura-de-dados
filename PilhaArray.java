public class Pilha {
	public Object[] vetor;
	public int t;
	
	//CONSTRUTOR
	public Pilha(int capacidade) {
		this.t = -1;
		this.vetor = new Object[capacidade];
	}
	
	//VERIFICADOR DA PILHA VAZIA OU NAO
	public boolean isEmpty() {
		if(this.t == -1) {
			return true;
		}
		return false;
	}
	
	//TAMANHO DA PILHA
	public int size() {
		if(this.isEmpty()) {
			return 0;
		}
		return this.t+1;
	}
	
	//ELEMENTO DO TOPO DA PILHA
	public Object top() {
		if(this.isEmpty()) {
			return null;
		}
		return this.vetor[this.t];
	}
	
	//REMOVE O ULTIMO ELEMENTO DA PILHA
	public Object pop() {
		if(this.isEmpty()) {
			return null;
		}
		return this.vetor[this.t--];
	}
	
	//ADICIONA UM ELEMENTO NA PILHA
	public void push(Object value) {
		if(this.t<this.vetor.length-1) {
			this.vetor[++t] = value;
		}
	}
	
	public static void main(String [] args) {
		Pilha p = new Pilha(5);
		p.push("A");
		p.push(4);
		p.push(50);
		p.push("a");
		p.push("Z");
		System.out.println(p.size());
		System.out.println(p.isEmpty());
		System.out.println(p.pop());
		System.out.println(p.pop());
		System.out.println(p.pop());
		System.out.println(p.pop());
		System.out.println(p.pop());
		System.out.println(p.isEmpty());
		System.out.println(p.size());
		
	}
}
