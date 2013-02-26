package net.zcmusicbox.test.util.reflect;

import java.lang.reflect.ParameterizedType;

public class TestGeneric {
	public class Test<T> {  
	    public T newInstance(){  
	        T instance=null;  
	        Class<T> entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	        try{
	        	instance = entityClass.newInstance();
	        }catch(Exception ex){
	        	
	        }
	        return instance;  
	    };  
	} 
}
