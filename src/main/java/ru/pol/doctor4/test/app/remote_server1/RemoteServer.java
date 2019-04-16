package ru.pol.doctor4.test.app.remote_server1;

import ru.polbadwolf.test.interfaces.remoteRMI.RemoteInterface;

import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import java.time.LocalDateTime;
import java.util.Timer;

class RemoteServer extends UnicastRemoteObject implements RemoteInterface {
    BlockData datGet = new BlockData();
    BlockData datPut = new BlockData();
    public String retStatus() {

        return LocalDateTime.now().toString();
    }

    public void putMessage(String s) {
        System.out.println(s);
    }

    public void setBlockData(BlockData blockData) {
        datPut = blockData;
    }

    public BlockData getBlockData() {
        return datGet;
    }

    public RemoteServer() throws RemoteException {
    }

    /*
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

         */
    public static void main(String[] args) throws RemoteException {
        new RemoteServer().go();
    }

    private void go() {
        datGet.name = new String[] {"Василий" };
        datGet.content = new int[] {345};
        try {
            RemoteInterface service1 = new RemoteServer();
            Naming.rebind("Interface1", service1);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}