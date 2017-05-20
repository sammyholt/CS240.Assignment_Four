package edu.cpp.cs.cs240.Assignment_Three;
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
	 * This method will display each person in the descending family tree
	 * of the specified person.  This will not check for People above the
	 * specified level.
	 * 
	 * @param p
	 */
	public void display(Person p){
		if(p.getName() == null) return;
		
		System.out.println(p.getName() + ": " + p.getId());
		
		// if the person has children, recursively call this method with the children
		// using a Java Iterator to loop through each child in the ArrayList
		if(p.hasChildren()){
			Iterator<Person> childrenIterator = p.getChildren().iterator();
			while(childrenIterator.hasNext()){
				Person child = childrenIterator.next();
				display(child);
			}
		}
		
		// perform same action as the above children loop, but with the partners ArrayList
		if(p.hasPartners()){
			Iterator<Person> partnersIterator = p.getPartners().iterator();
			while(partnersIterator.hasNext()){
				Person partner = partnersIterator.next();
				display(partner);
			}
		}
	}

}
