package config;

public class Test {

	public static void main(String[] args) {
		int oldCapacity = 10;
		for (int i = 0; i < 10; i++) {
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			System.out.println(oldCapacity + "--resize--" + newCapacity);
			oldCapacity = newCapacity;
		}
	}

}
