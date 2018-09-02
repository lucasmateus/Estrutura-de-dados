import java.util.*;

public class PilhaRubroNegra{
    int topPreto;
    int topVermelho;
    int capacity;
    Object[] array;

    public PilhaRubroNegra(int cap){
      capacity = cap;//capacidade do tamanho passado pelo parametro da função
      array = new Object[cap];//o array vai receber o tamanho passado
      topPreto = -1;// o topPreto vai iniciar de -1 pq ele ainda está vazio
      topVermelho = cap;//o topVermelho vai iniciar do final que é a capacidade da pilha
    }

    public void PushPreto(Object x) throws EPilhaCheia{
       if(topPreto+1==topVermelho){//nao precisa comparar com null  pode fazer assim if(topPreto + 1 == topVermelho)
            Object novo = new novo[this.capacity*2];
            for(int i=0;i<topPreto+1;i++){
                novo[i] = array[i]; 
            }

            int k = this.capacity-1;
            for(int j=0;j < SizeVermelho();j++){
                novo[k--] = array[(this.capacity/2)-SizeVermelho()];// eu acho que isso não tá certo
                /*  PODE ESTAR ASSIM
                    for(int i = capacity-1;i >= topVermelho;i--){
                           novo[i+capacity]  = array[i] mais ou menos isso daqui 
                     }
                     Reposiciona o topVermelho
                     topVermelho = capacity-SizeVermelho ();
                     agora dobra
                      capacity*=2;
                */
            }
	    topVermelho = this.capacity-SizeVermelho();
            novo[++topPreto] = x;
            this.array = novo;
       }
       array[++topPreto] = x; 
    }

    public void PushVermelho(Object x) throws EPilhaCheia{
       if(array[topVermelho-1] != null)//verifica se a pilha vermelha nao consegue mais guardar elementos
          throw new EPilhaCheia("Pilha Cheia");//retorna pilha cheia
       array[--topVermelho] = x; //adiciona o elemento x no array  pelo lado preto
    }

    public Object PopPreto() throws EPilhaVazia{
        if(topPreto == -1)//se o top preto tiver na posição -1 que é a posição inicial dele é pq a pilha preta esta vazia e nao podemos remover
          throw new EPilhaVazia("Pilha Preta Vazia");
        Object temp = array[topPreto];//criamos um object temporario para armazenar os valores do array da pilha preta
        array[topPreto--] = null;//retiramos o ultimo elemento adicionado na pilha preta
        return temp;//retornamos o object
    }

    public Object PopVermelho() throws EPilhaVazia{
        if(topVermelho == capacity)//se o top vermelho tiver na posição capacity, que é a posição inicial dele é pq a pilha vermelha esta vazia e nao podemos remover
           throw new EPilhaVazia("Pilha Vermelha Vazia");
        Object temp = array[topVermelho];
        array[topVermelho++] = null;//retiramos o ultimo elemento adicionado na pilha vermelha
        return temp;
    }

    public Object TopPreto() throws EPilhaVazia{
        if(topPreto == -1)//verifica
           throw new EPilhaVazia("Pilha Preta Vazia");
        return array[topPreto];//retorna o ultimo elemento da pilha preta
    }

    public Object TopVermelho() throws EPilhaVazia{
        if(topVermelho == capacity)//verifica
          throw new EPilhaVazia("Pilha Vermelha Vazia");
        return array[topVermelho];//retorna o ultimo elemento da pilha vermelha
    }

    public int SizePreto(){
        return topPreto+1;//retorna o tamanho da pilha preta... lembrando que o +1 é usado pq o primeiro elementod a pilha fica na posção 0
    }

    public int SizeVermelho(){
       return capacity-topVermelho;//retorna a o tamanho da pilha vermelha, subtraimos da capacidade que é o total da pilha apenas a quantidade de pilha vermelha
    }

    public boolean IsEmptyPreto(){
        return (topPreto == -1);//retorna V ou F caso a pilha esteja vazia
    }

    public boolean IsEmptyVermelho(){
         return (topVermelho == capacity);//retorna V ou F caso a pilha esteja vazia
    }

    public void DisplayPilha() throws EPilhaVazia{
       int i;
       if(IsEmptyVermelho()){
           System.out.println("Pilha Vermelha vazia");
       }
       else{
       System.out.println("Pilha Vermelha:");
       i = capacity-1;
         while(topVermelho-1 != i){
           System.out.print("| " + array[i--] + " |");
          }
       }
       if(IsEmptyPreto()){
           System.out.println("Pilha Preta Vazia");
       }
       else{
       System.out.println("\nPilha Preta:");
       i = 0;
         while(topPreto+1 != i){
           System.out.print("| " + array[i++] + " |");
         }
       }
       System.out.println("\nCapacity = " + capacity);
       System.out.println("Tamanho pilha vermelha = " + SizeVermelho());
       System.out.println("Tamanho pilha preta = " + SizePreto());
      
    }

    public static void main(String[] args) throws EPilhaCheia, EPilhaVazia {
        PilhaRubroNegra p = new PilhaRubroNegra(10);
        p.PushPreto(5);
        p.PushPreto(5);
        p.PushPreto(5);
        p.PushPreto(5);
        p.PushPreto(5);
        p.PushVermelho(10);
        p.PushVermelho(10);
        p.PushVermelho(10);
        p.PushVermelho(10);
        p.PushVermelho(10);
        p.PushVermelho(10);
        p.DisplayPilha();        
    }
}
=========================================================================

class EPilhaVazia extends Exception {
    public EPilhaVazia(String texto){
        super(texto);
    }
}

==========================================================================

class EPilhaCheia extends Exception {
    public EPilhaCheia(String pilha_cheia) {
        super(pilha_cheia); //To change body of generated methods, choose Tools | Templates.
    }
}

==========================================================================
