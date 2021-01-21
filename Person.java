//Assign 4, Peron:
//  Represent an applicant, or an employee

//package assign4_template;
/* CIS2168 003 Data Structures
o Dat Nguyen tuk78874@temple.edu
o Lab4 Queue
o Person.java
o Program description: class for creating person to be hired
*/
import java.util.ArrayList;

public class Person {

	// Item 3. in Assign 4 Document.

	// define data fields: name, degree, skill list ("Java, C#, C++", etc.)
	private String name;
	private String degree;
	private String skillList[];

	// define the constructor with given name, degree, and skill list

	public Person(String name, String degree, String skillList[]) {
		this.name = name;
		this.degree = degree;
		this.skillList = skillList;
	}

	// define getters
	public String getName() {
		return name;
	}

	public String getDegree() {
		return degree;
	}

	public String[] skillList() {
		return skillList;
	}

	// define setters
	public void setName(String newName) {
		name = newName;
	}

	public void setDegree(String newDegree) {
		degree = newDegree;
	}

	public void setSkillList(String newSkillList[]) {
		skillList = newSkillList;
	}

	// define toString()
	@Override
	public String toString() {
		String skills = "";
		for (String skill : skillList) {
			skills += skill + " ";
		}
		return "Name: " + name + "| Degree: " + degree + "| " + "\n" + skills;
	}

}
