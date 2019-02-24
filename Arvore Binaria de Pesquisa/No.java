public class No{
  private int elemento;
  private No no_dir;
  private No no_esq;

  //Construtores
  public No(){

  }

  public No(int elemento){
    this.elemento = elemento;
    this.no_dir = null;
    this.no_esq = null;
  }

  //gets e sets
  public void setElemento(int elemento){
    this.elemento = elemento;
  }
  public void setNoDir(No no_dir){
    this.no_dir = no_dir;
  }
  public void setNoEsq(No no_esq){
    this.no_esq = no_esq;
  }
  public int getElemento(){
    return this.elemento;
  }
  public No getNoDir(){
    return this.no_dir;
  }
  public No getNoEsq(){
    return this.no_esq;
  }
}