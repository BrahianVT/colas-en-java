//Implementacion de una cola (FIFO)

class Cola{
	class Nodo{
		int dato;
		Nodo sig;
	}
	private Nodo raiz,fondo;
	public Cola(){
		raiz = null;
		fondo = null;
	}
	public boolean vacia(){
		if(raiz == null)
			return true;
		else
			return false;
	}
	public void insertar(int x){
		Nodo nuevo = new Nodo();
		nuevo.dato = x ;
		nuevo.sig = null;
		if(vacia()){
			raiz = nuevo;
			fondo = nuevo;
		}
		else{
			fondo.sig = nuevo;
			fondo = nuevo;
		}
	}
	public int eliminar(){
		if(!vacia()){
			int valor = raiz.dato;
			if(raiz == fondo){
				raiz = null;
				fondo = null;
			}
			else{
				raiz = raiz.sig;
			}
		return valor;	
		}
		else{
			return Integer.MAX_VALUE;
		}
	}
	public void imprimir(){
		Nodo aux = raiz;
		while(aux != null){
			System.out.println(aux.dato );
			aux = aux.sig;
		}
	}
	public int mostrar(){
		int val = raiz.dato;
		return val;
	}
	public static void main(String[] args){
		Cola cola = new Cola();
		cola.insertar(4);
		cola.insertar(9);
		cola.insertar(14);
		System.out.println(cola.vacia());
		System.out.println("Ultimo dato " + cola.mostrar());
		cola.eliminar();
		cola.imprimir();
	}

}
 
