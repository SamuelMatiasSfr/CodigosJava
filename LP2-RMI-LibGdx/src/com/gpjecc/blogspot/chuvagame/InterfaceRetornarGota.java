package com.gpjecc.blogspot.chuvagame;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRetornarGota extends Remote {

    public String retornarGota() throws RemoteException;
    
}
