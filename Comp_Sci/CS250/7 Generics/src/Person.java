
public class Person {
	private String name; //name of the person
	private int birthYear; //birth year of the person
	private int ssn; //the SSN of this person
	private String state; //the state
	
	public Person(String name, int by, int ssn, String state) {
		this.name = name;
		this.birthYear = by;
		this.ssn = ssn;
		this.state = state;
	}
	public String getName() { return name; }
	public int getBirthYear() {return birthYear; }
	public int getSsn() { return ssn; }
	public String getState() { return state; }
	
	public String toString() {
		return "name: " + name + ", birth year: " + birthYear + ", ssn: "
				+ ssn + ", state: " + state;
	}
	
	
	
}
