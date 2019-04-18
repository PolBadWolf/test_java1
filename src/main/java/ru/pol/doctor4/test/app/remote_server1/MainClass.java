package ru.pol.doctor4.test.app.remote_server1;

import java.rmi.RemoteException;

public class MainClass {
    public static void main(String[] args) {
        new MainClass().go();
    }
    public void go() {
        RemoteServer serv = new RemoteServer();
        serv.go();
    }
}
