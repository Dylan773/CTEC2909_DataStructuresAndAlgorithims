package lib;

public class StudentTree extends Student {

	// Constructor.

	public StudentTree() {
		super("head");
	}

	// Methods.

	/**
	 * Locates a student using their unique p number.
	 * 
	 * @param pNumber The p number used to search.
	 * @return Students p number.
	 */
	public Student findStudent(String pNumber) {
		return findStudent(this, pNumber);
	}

	/**
	 * Recursively scans the provided student and their mentors until either a match
	 * is found, or all are scanned and none matched.
	 * 
	 * @param s The student to be treated as the head.
	 * @param p p number of the student to search for
	 * @return student that matches, else null.
	 */
	public static Student findStudent(Student s, String p) {
		if (s.getPNumber().equals(p)) {
			return s;
		} else {
			for (Student mentee : s.getMentees()) {
				Student t = findStudent(mentee, p);
				if (t != null) {
					return t;
				}
			}
		}
		return null;
	}

	/**
	 * Overriding inherited setMentor method from Student class.
	 * 
	 * The head has been implemented to make searching for elements in the
	 * collection easier. The head is set as both level 6 mentors. Otherwise one
	 * level 6 student would be set to head. Thus, causing equality issues and
	 * issues within the program.
	 */
	@Override
	public void setMentor(Student newMentor) {

	}

	// Head cannot have a mentor, it is the top element.
	@Override
	public boolean hasMentor() {
		return false;
	}

	// Head cannot have a mentor, it is the top element.
	@Override
	public void removeMentor() {

	}

	@Override
	public Student getMentor() {
		return null;
	}
}
