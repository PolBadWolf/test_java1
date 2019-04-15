package ru.pol.doctor4.test.app.remote_server1;

import ru.pol.doctor4.test.interfaces.MyException;
import ru.pol.doctor4.test.interfaces.RemoteIntrface1;

class RemoteServer implements RemoteIntrface1 {

    public String retString(String s) throws MyException {
        throw new MyException();
    }

    public static void main(String[] args) {
        new RemoteServer().retString("");
    }
}