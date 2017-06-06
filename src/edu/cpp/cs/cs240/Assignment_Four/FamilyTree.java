package edu.cpp.cs.cs240.Assignment_Four;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree {
	
	/**
	 * This stores all the people in the family tree.
	 */
	private ArrayList<Person> familyMembers;
	
	/**
	 * Default constructor.
	 */
	public FamilyTree(){
		this(new ArrayList<Person>());
	}
	
	/**
	 * Constructor with an argument for an existing ArrayList of people.
	 * 
	 * @param familyMembers
	 */
	public FamilyTree(ArrayList<Person> familyMembers){
		this.familyMembers = familyMembers;
	}
	
	/**
	 * Adds a person to the family tree.
	 * 
	 * @param p - Person to add to the Family Tree.
	 */
	public void add(Person p){
		this.familyMembers.add(p);
	}
	
	/**
	 * Adds a child to an existing person in Family Tree.
	 * 
	 * @param parent
	 * @param child
	 */
	public void addChild(Person parent, Person child){
		parent.getChildren().add(child);
		addParent(child, parent, !parent.getGenderFlag());
	}
	
	/**
	 * Adds a partner to an existing person in Family Tree.
	 * 
	 * @param p
	 * @param partner
	 */
	public void addPartner(Person p, Person partner){
		p.getPartners().add(partner);
	}
	
	/**
	 * Sets the specified parent as either the father or mother of the person.
	 * 
	 * @param p
	 * @param parent
	 * @param isMother
	 */
	public void addParent(Person p, Person parent, boolean isMother){
		if(isMother){
			p.setMother(parent);
		}else{
			p.setFather(parent);
		}
	}
	
	/**
	 * This method calls the necessary methods to find the relation between two people.
	 * 
	 * @param p1
	 * @param p2
	 */
	public void findRelation(Person p1, Person p2){
		
		relationSearch(p1, p2);
		
	}
	
	/**
	 * This method will print a specified number of dashes to the console.
	 * This method is used to visually show the depth of a certain member
	 * of the Family Tree.
	 * 
	 * @param number
	 */
	private void printDashes(int number){
		for(int i = 0; i < number; i++){
			System.out.print("-");
		}
	}
	
	private String addDashes(int number, String currentDisplay){
		for(int i = 0; i < number; i++){
			currentDisplay += "-";
		}
		return currentDisplay;
	}
	
	/**
	 * This method will display the downward facing family tree of the specified person.
	 * 
	 * @param p
	 */
	public void display(Person p){
		display(p, "", 0);
	}
	
	/**
	 * This method will display each person in the descending family tree
	 * of the specified person.  This will not check for People above the
	 * specified level.
	 * 
	 * @param p - The Person to display
	 * @param relation - The relation to the original person
	 * @param count - Count parameter to determine the depth of the recursive call.
	 */
	private void display(Person p, String relation, int count){
		if(p.getName() == null) return;
		
		
		printDashes(count);
		
		if(relation.isEmpty()){
			// this means it is the original person
			System.out.print("Starting Person: " + p.getName() + " (" + p.getGender() + ")" + "\n");
		}else{
			// is related to the original person
			System.out.print(p.getName() + ": " + "(" + relation + ", " + p.getGender() + ") " + "\n");
		}
		count++;
		
		
		
		// if the person has children, recursively call this method with the children
		// using a Java Iterator to loop through each child in the ArrayList
		if(p.hasChildren()){
			Iterator<Person> childrenIterator = p.getChildren().iterator();
			while(childrenIterator.hasNext()){
				Person child = childrenIterator.next();
				display(child, "Child", count);
			}
		}
		
		// perform same action as the above children loop, but with the partners ArrayList
		if(p.hasPartners()){
			Iterator<Person> partnersIterator = p.getPartners().iterator();
			while(partnersIterator.hasNext()){
				Person partner = partnersIterator.next();
				display(partner, "Partner", count);
			}
		}
	}
	
	/**
	 * This method will display the relationship between two people.
	 * 
	 * @param p1
	 * @param p2
	 */
	public void relationSearch(Person p, Person p2){
		String currentDisplay = "";
		relationSearch(p, p2, "", 0, currentDisplay);
	}
	
	/**
	 * This method will search the tree for the relationship between two provided people.  If they are not related, it will print no relation.
	 * 
	 * @param p - The Person to display
	 * @param relation - The relation to the original person
	 * @param count - Count parameter to determine the depth of the recursive call.
	 * @param currentDisplay - The current string holding the rest of the display for printing.
	 */
	private void relationSearch(Person p, Person p2, String relation, int count, String currentDisplay){
		if(p.getName() == null) return;
		
		
		
		
		currentDisplay = addDashes(count, currentDisplay);
		
		if(relation.isEmpty()){
			// this means it is the original person
			currentDisplay += "Starting Person: " + p.getName() + " (" + p.getGender() + ")" + "\n";
		}else{
			// is related to the original person
			currentDisplay += p.getName() + ": " + "(" + relation + ", " + p.getGender() + ") " + "\n";
		}
		count++;
		
		// found the relation and displayed it, print and stop looping
		if(p.getId() == p2.getId()){
			System.out.print(currentDisplay);
			return;
		}
		
		
		
		// if the person has children, recursively call this method with the children
		// using a Java Iterator to loop through each child in the ArrayList
		if(p.hasChildren()){
			Iterator<Person> childrenIterator = p.getChildren().iterator();
			while(childrenIterator.hasNext()){
				Person child = childrenIterator.next();
				relationSearch(child, p2, "Child", count, currentDisplay);
			}
		}
		
		// perform same action as the above children loop, but with the partners ArrayList
		if(p.hasPartners()){
			Iterator<Person> partnersIterator = p.getPartners().iterator();
			while(partnersIterator.hasNext()){
				Person partner = partnersIterator.next();
				relationSearch(partner, p2, "Partner", count, currentDisplay);
			}
		}
		
		// perform father check
		if(p.hasFather()){
			Person father = p.getFather();
			if(father.getId() == p2.getId()){
				// father is the person
				currentDisplay = addDashes(count, currentDisplay);
				currentDisplay += father.getName() + ": " + "(Father, " + father.getGender() + ") " + "\n";
				System.out.print(currentDisplay);
				return;
			}
		}
		
		// perform mother check
		if(p.hasMother()){
			Person mother = p.getMother();
			if(mother.getId() == p2.getId()){
				// mother is the person
				currentDisplay = addDashes(count, currentDisplay);
				currentDisplay += mother.getName() + ": " + "(Mother, " + mother.getGender() + ") " + "\n";
				System.out.print(currentDisplay);
				return;
			}
		}
	}

}
