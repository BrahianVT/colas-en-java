//Implementacion de una cola (FIFO) y resolucion de un problema
import javax.swing.*;
import java.awt.event.*;
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
	public int cantidad(){
		int cant = 0;
		Nodo aux = raiz;
		while(aux != null){
			cant++;
			aux = aux.sig;
		}
		return cant;
	}
}

public class Cajero extends JFrame implements ActionListener{
	private JLabel label1 , label2 , label3;
	private JButton boton1;
	public Cajero(){
		setLayout(null);
		boton1 = new JButton("Activar Simulacion");
		boton1.setBounds(10,10,200,30);
		add(boton1);
		boton1.addActionListener(this);
		
		label1 = new JLabel("Atendidos");
		label1.setBounds(10,50,300,30);
		add(label1);
		label2 = new JLabel("En cola");
		label2.setBounds(10,90,300,30);
		add(label2);
		label3 = new JLabel("Atendidos");
		label3.setBounds(10,130,400,30);
		add(label3);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == boton1){
		 simulacion();
		}
	}
	public void simulacion(){
		
		int salida = 2+(int)(Math.random()*3);
		int estado = 0;
		int llegada = 2 + (int) (Math.random() * 2);
		int atendidas = 0;
		Cola cola = new Cola();
		for(int minuto = 0; minuto < 600; minuto++){
			if(llegada == minuto){
				if(estado == 0){
					estado = 1;
					salida=minuto+2+(int)(Math.random()*3);
				}
				else{
					cola.insertar(minuto);
				}
				llegada = minuto + 2 + (int) (Math.random() * 2);
			}
			if(salida == minuto){
				estado = 0;
				atendidas++;
				if(!cola.vacia()){
					cola.eliminar();
					estado = 1;
					salida = minuto + 2 +(int) (Math.random() *2);
				}
			}
		}
		label1.setText("Atendidos: " + String.valueOf(atendidas));
		label2.setText("En cola: " + String.valueOf(cola.cantidad()));
		label3.setText("Minuto de llegada:" + String.valueOf(cola.eliminar()));
	}
	public static void main(String[] args){
		Cajero simular = new Cajero();
		simular.setBounds(0,0,340,250);
		simular.setTitle("Simulacion de cola en cajero");
		simular.setVisible(true);
		simular.setDefaultCloseOperation(simular.EXIT_ON_CLOSE);
		
	} 
}