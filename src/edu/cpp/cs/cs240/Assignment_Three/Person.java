package edu.cpp.cs.cs240.Assignment_Three;
import java.util.ArrayList;

/**
 * Represents a person.  Each person has a name, birthdate, death date, gender, partners, and children.
 * 
 * @author Samuel Holt
 *
 */
public class Person {
	
	/**
	 * Represents the person's name.
	 */
	private String name;
	
	/**
	 * Represents the person's date of birth.
	 */
	private String birthDate;
	
	/**
	 * True if the person is alive, false if the person is dead.
	 */
	private boolean alive;
	
	/**
	 * Represents the person's date of death.
	 */
	private String deathDate;
	
	/**
	 * Represents the person's gender.  True if Male, False if Female.
	 */
	private boolean gender;
	
	/**
	 * Represents the partners of the person.  It is represented as an ArrayList of Person.
	 */
	private ArrayList<Person> partners;
	
	/**
	 * Represents the children of the person.  It is represented as an ArrayList of Person.
	 */
	private ArrayList<Person> children;
	
	/**
	 * This method determines if the Person is alive or not.
	 * 
	 * @return True if the Person is alive, False if they are not.
	 */
	public boolean isAlive(){
		return this.alive;
	}
	
	/**
	 * This method determines if the Person has children or not.
	 * 
	 * @return True if the Person has children, False if they do not.
	 */
	public boolean hasChildren(){
		return (!this.children.isEmpty());
	}
	
	/**
	 * 
	 * @return The children ArrayList of this person.
	 */
	public ArrayList<Person> getChildren(){
		return this.children;
	}
	
	/**
	 * 
	 * @return The partners ArrayList of this person.
	 */
	public ArrayList<Person> getPartners(){
		return this.partners;
	}

}
