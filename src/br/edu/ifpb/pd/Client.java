package br.edu.ifpb.pd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) {
		try {
			String enviada = "";
			Socket socket = new Socket("localhost", 27015);
			String nome = "";
			System.out.println("Conectado!");
			
			nome = JOptionPane.showInputDialog("Informe seu nome: ");
			
			
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			DataInputStream in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF(nome);
			
			new ClientThread(in).start();
			do {
			
				enviada = JOptionPane.showInputDialog("Digite a mensagem aqui:");
				out.writeUTF(enviada);

			}while(!enviada.equals("fim"));
			
			socket.close();
			System.out.println("Conexão finalizada");
		}catch (IOException e) {
			System.out.println("O seguinte erro ocorreu no cliente: ");
			e.printStackTrace();
		}
	}
}
