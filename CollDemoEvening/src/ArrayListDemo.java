import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		// add single object
		a.add(1);
		// add object in specific position
		a.add(0, 2);

		List<Integer> aa = new ArrayList<Integer>();
		aa.add(11);
		aa.add(12);
		aa.add(11);

		// add a collection
		a.addAll(aa);
		// a.addAll(0, aa);
		// update
		// a.set(0,12);

		// System.out.println(a.contains(12));
		// System.out.println(a.containsAll(aa));

		// System.out.println(a.removeAll(aa));
		// System.out.println(a.remove((Integer)12));

		/*
		 * Iterator<Integer> it=a.iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 */
		/*
		 * ListIterator<Integer> lit = a.listIterator(a.size()); while
		 * (lit.hasPrevious()) {
		 * 
		 * System.out.println(lit.previous()); }
		 */

		// System.out.println(a.subList(0, 2));;

		/*
		 * for(Integer i:a) { System.out.println(i); }
		 */
		// lambda expression
		// a.forEach(x->System.out.println(x));
		// a.forEach(System.out::println);
		// System.out.println(a);
		// a.clear();
		// System.out.println(a);
		// System.out.println(a.isEmpty());
		// System.out.println(a.indexOf((Integer)11));;
		// System.out.println(a.lastIndexOf((Integer)11));;

		// Object o[] = a.toArray();
		a.remove(a.stream().filter(x -> x == 2).findAny().get());
		a.parallelStream().forEach(System.out::println);
	}
}
