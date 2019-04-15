package ru.pol.doctor4.test.app.remote_server1;

import ru.pol.doctor4.test.interfaces.RemoteInterface1;

import java.net.*;
import java.rmi.*;
import java.rmi.server.*;

class RemoteServer extends UnicastRemoteObject implements RemoteInterface1 {

    protected RemoteServer() throws RemoteException {
    }

    public String datString(String s) throws RemoteException {
        System.out.println("Клиент: \"" + s + "\"");
        return null;
    }
    private String revers(String s) {
        int lenght = s.length();
        if (lenght <= 0) return "";
        int indMax = lenght - 1;
        String ss = "";
        for (int i=0; i<lenght; i++) {
            ss += s.charAt(indMax - i);
        }
        return ss;
    }
    public static void main(String[] args) throws RemoteException {
        new RemoteServer().go();
    }
    private void go() {
        try {
            RemoteInterface1 service1 = new RemoteServer();
            Naming.rebind("Interface1", service1);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}