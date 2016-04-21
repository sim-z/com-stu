package com.personal.pool;

import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

public class SocketManager {
    
    //�ض��󹤳�
    private KeyedPooledObjectFactory<String, SocketObject> factory;
    //�����
    private GenericKeyedObjectPool<String, SocketObject> pools;

    private void init(){
        
        GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
        
        
        
        pools = new GenericKeyedObjectPool<>(factory, config);
        
    }
}
