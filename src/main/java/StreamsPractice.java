import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StreamsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> lis = Arrays.asList("Sunil Alahari", "Alahari Teja", "Sirisha Nune", "Yuvan Teja", "Bala Thota");
		List<Integer> list = Arrays.asList(1, 2, 5, 1, 45, 4, 98, 31);
		Collections.reverse(list);
		System.out.println(list);
		Collections.sort(lis);
		System.out.println(lis);
		Collections.sort(lis, Comparator.reverseOrder());
		System.out.println(lis);
		Map<Integer, String> maps = new HashMap<Integer, String>();
		maps.put(3, "Sunil Alahari");
		maps.put(12, "Sirisha Alahari");
		maps.put(32, "Ajay");
		maps.put(11, "Vijay Moddula");
		List<Map.Entry<Integer, String>> entries = new ArrayList<Map.Entry<Integer, String>>(maps.entrySet());
		Collections.sort(entries, (o1, o2) -> o1.getKey() - o2.getKey());
		for (Map.Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + "    :  " + entry.getValue());
		}

		Map<Employee, String> m = new TreeMap<Employee, String>(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getEmpNo()-o2.getEmpNo();
			}
			
		});
		m.put(new Employee("Sunil", "IT", 2341), "Regular");
		m.put(new Employee("Anil", "ITS", 4343), "General");
		m.put(new Employee("Jeeva", "ITS", 4943), "KT");
		m.put(new Employee("Kumar", "CTC", 23441), "Regular");
		m.put(new Employee("Sirisha", "IT", 434), "General");

		List<Map.Entry<Employee, String>> en = new ArrayList<Map.Entry<Employee, String>>(m.entrySet());

		Collections.sort(en,new Comparator<Map.Entry<Employee, String>>() {

			@Override
			public int compare(Entry<Employee, String> o1, Entry<Employee, String> o2) {
				// TODO Auto-generated method stub
				return o2.getKey().getName().compareTo(o1.getKey().getName());
			}
		});
		//System.out.println(en);
		for(Map.Entry<Employee, String> ent: en) {
			System.out.println(ent.getKey().getName()+" : "+ent.getKey().getDept());
		}
		System.out.println("*************************");
		m.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpNo).reversed())).forEach(System.out::println);

	}
}
