package com.gpjecc.blogspot.chuvagame;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import com.badlogic.gdx.math.MathUtils;

public class ServidorRetornarGota extends UnicastRemoteObject 
implements InterfaceRetornarGota {

    ServidorRetornarGota() throws RemoteException {}

    public String retornarGota() throws RemoteException {
        int posX = MathUtils.random(0, 800-64);
        int posY = MathUtils.random(300, 480);
        return posX + "," + posY;
    }

    public static void main(String[] args) {
        InterfaceRetornarGota objeto;
        try {
            objeto = new ServidorRetornarGota();
            LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///ServidorRetornarGota", objeto);
        } catch (Exception e) {
            System.err.println("Exceção servidor: " + e.toString());
            e.printStackTrace();
        }
    }
    
}
