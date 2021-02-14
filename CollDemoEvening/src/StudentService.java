import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentService {
	ArrayList<Student> students = new ArrayList<>();

	public StudentService() {
		students.add(new Student("Zu", 1));
		students.add(new Student("Ey", 2));
		students.add(new Student("Ft", 4));
		students.add(new Student("Ab", 3));
		students.add(new Student("Dg", 5));
		students.add(new Student("Bb", 7));
		students.add(new Student("Ab", 6));
	}

	public Optional<Student> getStudentByRoll(int roll) {
		return students.parallelStream().filter(std -> std.getRoll() == roll).findAny();
	}

	public Optional<Student> getStudentByName(String name) {
		return students.parallelStream().filter(std -> std.getName().toLowerCase().startsWith(name.toLowerCase()))
				.findAny();
	}

	public List<Student> getStudentsByName(String name) {
		return students.parallelStream().filter(std -> std.getName().toLowerCase().startsWith(name.toLowerCase()))
				.collect(Collectors.toList());
	}

	/*
	 * public void sortByName() { Collections.sort(students); students.forEach(std
	 * -> System.out.println(std.getName() + "\t" + std.getRoll())); }
	 */
	
	

	public void sortByNameComparator(Comparator<Student> cmp) {
		Collections.sort(students, cmp);
		students.forEach(std -> System.out.println(std.getName() + "\t" + std.getRoll()));
	}
	
	public void searchByNameComparator(Comparator<Student> cmp,Integer roll) {
		Collections.sort(students, cmp);
		int s=Collections.binarySearch(students,new Student("", roll),cmp);
		System.out.println(students.get(s).getName()+"\t"+students.get(s).getRoll());
	}

	public void findMaxRollStudent() {
		System.out.println(Collections.max(students).getName());;
	}
	
	public void findMinRollStudent() {
		System.out.println(Collections.min(students).getName());;
	}
	
	public void findSecondMaxRollStudent() {
		Student std=Collections.max(students);
		System.out.println(std.getRoll()+"\t"+std.getName());
		Collections.sort(students);
		System.out.println(students.indexOf(std));
		System.out.println(students.get(students.indexOf(std)-1).getName());
		
	}
	
	public static void main(String[] args) {

		StudentService ss = new StudentService();
		ss.findSecondMaxRollStudent();
		/*
		 * Optional<Student> stdopt = ss.getStudentByRoll(1); if (stdopt.isEmpty()) {
		 * System.out.println("This roll is not found"); } else {
		 * System.out.println(stdopt.get().getName()); }
		 */

		/*
		 * Optional<Student> stdopt = ss.getStudentByName("A"); if (stdopt.isEmpty()) {
		 * System.out.println("This name is not found"); } else {
		 * System.out.println(stdopt.get().getName()); }
		 */

		// List<Student> stdopt = ss.getStudentsByName("a");

		// ss.sortByName();

		/*
		 * Comparator<Student> cmp1 = new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { // TODO Auto-generated
		 * method stub return o1.getName().compareTo(o2.getName()); } };
		 */

		//Comparator<Student> cmp1 = (s1, s2) -> s1.getName().compareTo(s2.getName());

		/*
		 * Comparator<Student> cmp2 = new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) {
		 * if(o1.getRoll()>o2.getRoll()) { return 1; }else if(o1.getRoll()<o2.getRoll())
		 * { return -1; }else { return 0; } } };
		 */

		//Comparator<Student> cmp2 = (s1, s2) -> s1.getRoll() > s2.getRoll() ? 1 : s1.getRoll() < s2.getRoll() ? -1 : 0;

		//ss.sortByNameComparator(cmp2);
		
		
		//ss.searchByNameComparator(cmp2, 1);

	}

}
