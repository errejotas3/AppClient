package br.edu.ifpb.pd;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientThread extends Thread{
	private DataInputStream in;
	
	
	public ClientThread (DataInputStream in) {
		this.in = in;
	}
	
	public void run() {
		String recebida ="";
		
		
		do {
			System.out.println("estou no do");
			try {
				System.out.println("estou no trycatch");
				recebida = in.readUTF();
				System.out.println(recebida);
				
			} catch (IOException e) {
				System.out.println("O seguinte erro ocorreu:" + e.getMessage());
				e.getStackTrace();
			}
		}while(!recebida.equals("fim"));
	}
	
}
