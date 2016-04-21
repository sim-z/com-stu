package com.personal.pool;

import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;

public class SocketFactory implements KeyedPooledObjectFactory<String, SocketObject> {

    @Override
    public void activateObject(String key, PooledObject<SocketObject> socket) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void destroyObject(String key, PooledObject<SocketObject> socket) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public PooledObject<SocketObject> makeObject(String key) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void passivateObject(String key, PooledObject<SocketObject> socket) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean validateObject(String arg0, PooledObject<SocketObject> arg1) {
        // TODO Auto-generated method stub
        return false;
    }

}
