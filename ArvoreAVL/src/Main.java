
public class Main {

	public static void main(String[] args) {
		ArvoreAVL arv = new ArvoreAVL(new NoAVL(null,"Lucas", 6));
		arv.inserir("Mateus", 5);
		arv.inserir("Silva", 7);
		arv.inserir("Coleguinhha", 4);
		arv.remover(6);
		System.out.println(arv.root().getElemento());
		System.out.println(arv.root().getFb());
		System.out.println(arv.root().getEsq().getElemento());
		System.out.println(arv.root().getEsq().getFb());
		System.out.println(arv.root().getDir().getElemento());
		//System.out.println(arv.Busca(14).getElemento());
	}
}
