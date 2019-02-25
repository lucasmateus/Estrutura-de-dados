class Main {
  public static void main(String[] args) {
    Arvore t = new Arvore();
    t.Inserir(5);
    t.Inserir(15);
    t.Inserir(4);
    System.out.println(t.isEmpty()?"Arvore vazia": "Arvore não vazia");
    System.out.println("Elemento raiz: " + t.root().getElemento());
    System.out.println("Filho Direito da raiz: " + t.root().getNoDir().getElemento());
    System.out.println("Filho Esquerdo da raiz: " + t.root().getNoEsq().getElemento());
    System.out.println(t.Busca(3) ? "O elemento foi encontrado!" : "O elemento não foi encontrado!");
  }
}