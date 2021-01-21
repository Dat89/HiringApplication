//Assign 4, HiringApp

//package assign4_template;
/* CIS2168 003 Data Structures
o Dat Nguyen tuk78874@temple.edu
o Lab4 Queue
o HiringApp.java
o Program description: User are prompted for input for given menu hiring or firing with appropriated data structure
*/
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Stack;

public class HiringApp {
	// Hiring = Stack //kick newest employee first
	// Firing = stack (skills irrelevant) recently fired = rehired
	// Applicant = Queue
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		// define the data structures for the different groups of people:
		// applicants, people hired, people fired
		Queue<Person> applicants = new ArrayDeque<>(); // queue
		Deque<Person> hires = new ArrayDeque<>(); // stack
		Deque<Person> fires = new ArrayDeque<>(); // stack

		// testLoad(applicants, hired, fired);
		// applicant will push to hiredList, should IT be fired, a Queue to be rehired
		boolean run = true;
		// looping until the user decides to quit.
		while (run) {
			System.out.println("Action (1 to accept, 2 to hire, 3 to fire, 4 to quit): ");
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();
			switch (input) {
			case 1: // accept applicants method
				applicants.offer(applicantMaker());
				break;
			case 2: // hire method
				if (fires.isEmpty() && applicants.isEmpty()) {
					System.out.println("Memo to Supervisor: There is nobody to hire");
					break;
				} else if (!fires.isEmpty()) { // re-hiring the fired
					System.out.println(fires.peek().getName() + " is RE-HIRED");
					hires.push(fires.pop());
					break;
				}
				System.out.println(applicants.peek().getName() + " is hired");
				hires.push(applicants.poll());
				break;
			case 3: // fire method
				if (hires.isEmpty()) {
					System.out.println("Memo to supervisor: There is nobody to fire");
					break;
				}
				System.out.println(hires.peek().getName() + " is FIRED");
				fires.push(hires.pop());
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("Invalid choice -- try again");
			}
		}
		// ArrayDeque<Person>

		// display the menu

		// get the menu choice

		// process user selected service request.

	}

	// other methods for code modularization

	// method to take in information about a person
	public static Person applicantMaker() {
		Scanner detail = new Scanner(System.in);
		System.out.println("enter name: ");
		String name = detail.nextLine();
		System.out.println("enter degree: ");
		String degree = detail.nextLine();
		System.out.println("enter number of skills: ");
		int num_skill = detail.nextInt();
		String[] skillList = new String[num_skill];
		for (int i = 0; i < num_skill; i++) {
			System.out.println("enter programming skill: ");
			skillList[i] = detail.next();
		}
		Person candidate = new Person(name, degree, skillList);
		return candidate;
	}

	// TESTING PURPOSES ONLY
	public static void testLoad(Queue<Person> loadTo, Deque<Person> hireTo, Queue<Person> firedOut) {
		String[] aSkill = { "C", "Python" };
		Person aa = new Person("Fred", "doctor", aSkill);

		String[] bSkill = { "Java" };
		Person bb = new Person("Barney", "phd", bSkill);

		String[] cSkill = { "HTML", "C++", "Django" };
		Person cc = new Person("Bambam", "self-taught", cSkill);

		loadTo.offer(aa); // first
		loadTo.offer(bb);
		loadTo.offer(cc);
//		hireTo.push(aa);
//		hireTo.push(bb);
//		hireTo.push(cc); // top
//		firedOut.push(aa);// first
//		firedOut.push(bb);
//		firedOut.push(cc);

	}

}