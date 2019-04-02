import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArvoreAVL arv = new ArvoreAVL();
        /*int op = -1;
        Scanner sc = new Scanner(System.in);
        while(op != 0){
            System.out.println("1- inserir 2- remover");
            op = sc.nextInt();
            if(op == 1){
                System.out.println("digite o objeto a ser inserida:");
                String str = sc.next();
                System.out.println("digite o chave a ser inserida:");
                int x = sc.nextInt();
                arv.inserir(str,x);
            }
            if(op == 2){
                System.out.println("digite chave a ser removida:");
                if(arv.remover(sc.nextInt())==null)
                    System.out.println("chave inexistente");
            }
            arv.display();
        }*/
		arv.inserir("lucas",10);
		arv.inserir("Israel",20);
		arv.inserir("Pedro",30);
		arv.inserir("Lucas Santos",40);
		arv.inserir("Daniel Souza",50);
		arv.inserir("Coleguinha",60);
		arv.inserir("Andre",70);
		arv.inserir("Isaque",80);
		arv.display();
		arv.remover(30);
		arv.display();
		arv.remover(10);
		arv.display();
	}
}
