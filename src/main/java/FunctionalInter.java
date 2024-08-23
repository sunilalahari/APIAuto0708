import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
public interface FunctionalInter {
	
	public void m1();
	public static void m2() {
		System.out.println("The Static method of Interface: ");
	}

	
}
class Sorting{
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(10);
		l.add(32);
		l.add(1);
		l.add(2345);
		l.add(8);
		Collections.sort(l);
		System.out.println(l);
	}
}
