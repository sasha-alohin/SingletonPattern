package singleton_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import singleton_inner_class.SingletonWithInnerStaticClass;

public class SerializedSingleton implements java.io.Serializable {
    private SerializedSingleton(){}
    
    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }
    
    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }
    
	protected Object readResolve() {
       return getInstance();
    }
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		SingletonWithInnerStaticClass singleton = SingletonWithInnerStaticClass.getInstance();
		SingletonWithInnerStaticClass singleton2 = SingletonWithInnerStaticClass.getInstance();
		if(singleton.equals(singleton2))
			System.out.println("good");
		else
			System.out.println("bad");
		
		SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
        
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
        
    }	
	
}