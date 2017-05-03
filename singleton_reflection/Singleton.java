package singleton_reflection;

public class Singleton {

	protected Singleton() {

	}

	public static Singleton getInstance(String classname) {
		return (Singleton) SingletonRegistry.getInstance(classname);
	}
}
