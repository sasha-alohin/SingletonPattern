package singleton_inner_class;

public class SingletonWithInnerStaticClass {

	private String name;

	private SingletonWithInnerStaticClass() {
		name = "Singleton";
	}

	private static class SingletonHelper {
		private static final SingletonWithInnerStaticClass INSTANCE = new SingletonWithInnerStaticClass();
	}

	public static SingletonWithInnerStaticClass getInstance() {
		return SingletonHelper.INSTANCE;
	}

	@Override
	public String toString() {
		return "SingletonWithInnerStaticClass [name=" + name + "]";
	}

}
