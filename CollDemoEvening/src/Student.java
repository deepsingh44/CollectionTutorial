
public class Student implements Comparable<Student> {
	private String name;
	private int roll;

	public Student() {
		super();
	}

	public Student(String name, int roll) {
		super();
		this.name = name;
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	/*
	 * @Override public int compareTo(Student o) { return
	 * name.compareTo(o.getName()); }
	 */

	@Override
	public int compareTo(Student o) {
		return getRoll() > o.getRoll() ? 1 : getRoll() < o.getRoll() ? -1 : 0;
	}

}
