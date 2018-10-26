import java.lang.reflect.Method;

public class TestClassLoad {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("A");
		Object o = c.newInstance();
		Method m = c.getMethod("foo", String.class);
		for(int i=0;i<3;i++){
			m.invoke(o, i);
		}
	}
}