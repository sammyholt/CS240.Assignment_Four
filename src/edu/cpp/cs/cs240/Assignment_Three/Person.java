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
	 * The default constructor
	 */
	public Person(){
		
		this("John Doe", "1/1/1900", false, "1/1/2000", true);
		
	}
	
	/**
	 * This constructor takes all information about a person except their children or partners.
	 * 
	 * @param name
	 * @param birthDate
	 * @param alive
	 * @param deathDate
	 * @param gender
	 */
	public Person(String name, String birthDate, boolean alive, String deathDate, boolean gender){
		this(name, birthDate, alive, deathDate, gender, new ArrayList<Person>(), new ArrayList<Person>());
	}
	
	/**
	 * This constructor takes all information about a person.
	 * @param name
	 * @param birthDate
	 * @param alive
	 * @param deathDate
	 * @param gender
	 * @param partners
	 * @param children
	 */
	public Person(String name, String birthDate, boolean alive, String deathDate, boolean gender, ArrayList<Person> partners, ArrayList<Person> children){
		this.name = name;
		this.birthDate = birthDate;
		this.alive = alive;
		this.deathDate = deathDate;
		this.gender = gender;
		this.partners = partners;
		this.children = children;
	}
	
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
