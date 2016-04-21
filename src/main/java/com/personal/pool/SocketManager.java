package com.personal.pool;

import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

public class SocketManager {
    
    //池对象工厂
    private KeyedPooledObjectFactory<String, SocketObject> factory;
    //对象池
    private GenericKeyedObjectPool<String, SocketObject> pools;

    private void init(){
        
        GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
        
        
        
        pools = new GenericKeyedObjectPool<>(factory, config);
        
    }
}
