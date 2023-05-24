import service.PrimitiveMethod;

public class PrimitiveMain {
	public static void main(String[] args) {
		PrimitiveMethod pm = new PrimitiveMethod();
		int maxIntValue = pm.voidParam();
		System.out.println(maxIntValue);
	}
}
