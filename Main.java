class Main {
  public static void main(String[] args) {
    TADSequencia t = new TADSequencia();
    t.insertFirst("A");
    t.insertFirst(2);
    t.insertFirst("Lucas");
    t.insertLast("Mateus");
    System.out.println(t.atRank(2).getElemento());
    t.display();
    t.remove(t.atRank(2));
    t.display();
    t.removeAtRank(0);
    t.display();
    t.insertAfter(t.atRank(0), "Andre");
    t.display();
    t.insertBefore(t.atRank(0), "Pedro");
    t.display();
  }
}
