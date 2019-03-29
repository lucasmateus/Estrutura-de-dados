public class Main {
    public static void main(String[] args) {
        ArvoreAVL arv = new ArvoreAVL(new NoAVL(null,"Lucas", 6));
	arv.inserir("Mateus", 5);
	arv.inserir("Silva", 7);
	arv.inserir("Coleguinhha", 3);
        arv.inserir("Isaque", 4);
	arv.remover(6);
        arv.remover(3);
        arv.inserir("Daniel", 8);
        arv.inserir("Pedro", 9);
        arv.inserir("Israel", 3);
        arv.display();
    }
}
