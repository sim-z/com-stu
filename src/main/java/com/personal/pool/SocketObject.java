package com.personal.pool;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketObject extends Socket {

    @Override
    public void connect(SocketAddress endpoint, int timeout) throws IOException {
        // TODO Auto-generated method stub
        super.connect(endpoint, timeout);
    }

    @Override
    public synchronized void close() throws IOException {
        // TODO Auto-generated method stub
        super.close();
    }
    
}
