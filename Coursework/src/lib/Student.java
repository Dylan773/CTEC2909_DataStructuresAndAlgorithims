package lib;

import java.util.ArrayList;

public class Student {

	// Fields.
	
	private Student mentor; // This students mentor.
	private String pNumber; // This students unique p number.
	// ArrayList of type student. This ArrayList of this students mentees.
	private ArrayList<Student> mentees = new ArrayList<>();
	
	// Constructors.
	
	/**
	 * Creates a student object with no mentor or mentees.
	 * @param pNumber
	 */
	public Student(String pNumber) {
		this(pNumber, null, null);
	}
	
	/**
	 * Creates a student object and creates relationships with the provided mentor
	 * or mentees.
	 * @param pNumber This students unique p number.
	 */
	public Student(String pNumber, Student mentor, ArrayList<Student> mentee) {
		setMentor(mentor);
		setPNumber(pNumber);
		addAllMentees(mentee);
	}
	
	// Methods.
	
	/**
	 * Creates a new relationship with a new mentor.
	 * 
	 * Removes the student from the current mentors mentees (if there is one), then adds the new mentors.
	 * @param newMentor The students new mentor.
	 */
	public void setMentor(Student newMentor) {
		if(getMentor() != null) getMentor().getMentees().remove(this);
		this.mentor = newMentor;
		if(newMentor == null) {
			return; // Cannot create a relationship if the new mentor == null.
		}
		getMentor().getMentees().add(this); // Add this student to the list of the mentors mentees.
	}
	
	/**
	 * Calls addMentee for every student in the list.
	 * @param newMentees A collection of students who should be added as mentees of this student.
	 */
	public void addAllMentees(ArrayList<Student> newMentees) {
		if(newMentees == null)
			return;
		for(Student s : newMentees)
			addMentee(s);
	}
	
	/**
	 * Creates a relationship with a student, does not add a mentee but it tells the new
	 * mentee that this is now its mentor.
	 * @param newMentee Student who should be a mentee of this.
	 */
	public void addMentee(Student newMentee) {
		if(newMentee == null) {
			return; // Cant be null.
		}
		newMentee.setMentor(this);
	}
	
	/**
	 * @return True if student has a mentor.
	 */
	public boolean hasMentor() {
		return mentor != null;
	}
	
	/**
	 * @return True is student has a mentee.
	 */
	public boolean hasMentees() {
		return !this.mentees.isEmpty();
	}
	
	/**
	 * Sets students relationship to null, removing the relationship.
	 */
	public void removeMentor() {
		setMentor(null);
	}
	
	/**
	 * @return This students mentor.
	 */
	public Student getMentor() {
		return mentor;
	}
	
	/**
	 * 
	 * @return This students mentees.
	 */
	public ArrayList<Student> getMentees() {
		return mentees;
	}
	
	/**
    *
    * @return This students p number
    */
   public String getPNumber() {
       return pNumber;
   }
   
   /**
   *
   * @param pNumber Sets this student's p number.
   * Private - not expected to be modified externally.
   */
  private void setPNumber(String pNumber) {
      this.pNumber = pNumber;
  }
   
  /**
   * @return A string representation of this student.
   * Does not print mentors or mentees due to a recursion issue.
   */
  @Override
  public String toString() {
      return "student:{" +
              "P: " + getPNumber() +
              ", hasMentees: " + hasMentees() +
              ", hasMentor: "  + hasMentor() +
              "}"
              ;
  }
	
}
