
public class NoAVL {
	private NoAVL pai;
	private NoAVL esq,dir;
	private Object elemento;
	private int key;
	private int fb;
	
	//Construtor passando pai, elemento e chave
	public NoAVL(NoAVL pai, Object elemento, int key) {
		this.pai = pai;
		this.elemento = elemento;
		this.key = key;
		this.fb = 0;
		this.esq = null;
		this.dir = null;
	}
	
	//Atualiza o FB depois de uma inserção
	public NoAVL atualizarFbInserir(int side){
        fb += 1*side;
        if(fb == 2 || fb == -2) return this;
        if(pai == null || (fb == 0)) return this;
        return pai.atualizaFbIns(lado());
    }
	//Metodo recusivo para atualizar o FB depois de uma inserção
    public NoAVL atualizaFbIns(int side){
        fb += 1*side;
        if(esq != null && dir != null){
            if(side == 1){
                fb+=dir.fb*1;
            }else{
                fb+=Math.abs(esq.fb)*1;
            }
        }
        if(fb == 2 || fb == -2) return this;
        if(pai == null || (fb == 0)) return null;
        return pai.atualizaFbIns(lado());
    }
    //Atualiza o FB depois de uma remoção
    public NoAVL atualizarFbRemover(int side){
        fb += -1*side;
        if(fb == 2 || fb == -2) return this;
        if(pai == null || (fb != 0)) return this;
        return pai.atualizaFbRem(lado());
    }
    //Metodo recusivo para atualizar o FB depois de uma remoção
    public NoAVL atualizaFbRem(int side){
        fb += -1*side;
        if(esq != null && dir != null){
            if(side == 1){
                fb+=dir.fb*1;
            }else{
                fb+=Math.abs(esq.fb)*1;
            }
        }
        if(fb == 2 || fb == -2) return this;
        if(pai == null || (fb != 0)) return null;
        return pai.atualizaFbRem(lado());
    }
	//Diz o lado do nó
	public int lado() {
		if(this.key <= this.pai.getKey()) {
			return 1;
		}else return -1;
	}
	public Iterator children() {
        Vector<NoAVL> c = new Vector<NoAVL>();
        if (getEsq() != null)
            c.addElement(left);
        if (getDir() != null)
            c.addElement(right);
        return c.iterator();
	}
	//Get's e Set's Atributos do NoAVL
	public NoAVL getPai() {
		return pai;
	}
	public void setPai(NoAVL pai) {
		this.pai = pai;
	}
	public NoAVL getEsq() {
		return esq;
	}
	public void setEsq(NoAVL esq) {
		this.esq = esq;
	}
	public NoAVL getDir() {
		return dir;
	}
	public void setDir(NoAVL dir) {
		this.dir = dir;
	}
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getFb() {
		return fb;
	}
	public void setFb(int fb) {
		this.fb = fb;
	}
	
}
