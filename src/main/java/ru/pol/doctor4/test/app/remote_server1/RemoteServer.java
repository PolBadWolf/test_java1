package ru.pol.doctor4.test.app.remote_server1;

import ru.polbadwolf.test.interfaces.remoteRMI.RemoteInterface;

import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

class RemoteServer {
    //BlockData datGet = new BlockData();
    //BlockData datPut = new BlockData();
    public class Service extends UnicastRemoteObject implements RemoteInterface {
        public Service() throws RemoteException {
        }

        @Override
        public String retStatus() throws RemoteException {
            return "Hello";
        }

        @Override
        public void putMessage(String s) throws RemoteException {
            System.out.println(s);
        }

        @Override
        public void putData(BlockData blockData) throws RemoteException {
            System.out.println(blockData);
        }

        @Override
        public void putData(BlockData[] blockData) throws RemoteException {
            ArrayList<BlockData> arrayList = new ArrayList<>();
            boolean b = Collections.addAll(arrayList, blockData);
            System.out.println(blockData);
            System.out.println(arrayList);
            System.out.println(blockData[0]);
        }
    }
    public void go() {
        try {
            Service service = new Service();
            Naming.rebind("Interface1", service);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}