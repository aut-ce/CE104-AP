import java.io.Serializable;

public class Student implements Serializable{
	private int age;
	private String name;
	private String familyName;
	private double grade;
	
	private transient boolean married;

	public Student(int age, String name, String familyName, double grade, boolean married) {
		this.age=age;
		this.name=name;
		this.familyName=familyName;
		this.grade=grade;
		this.married=married;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the grade
	 */
	public double getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(double grade) {
		this.grade = grade;
	}

	/**
	 * @return the married
	 */
	public boolean isMarried() {
		return married;
	}

	/**
	 * @param married the married to set
	 */
	public void setMarried(boolean married) {
		this.married = married;
	}
}
