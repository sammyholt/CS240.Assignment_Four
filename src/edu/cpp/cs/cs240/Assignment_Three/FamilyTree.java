package edu.cpp.cs.cs240.Assignment_Three;
import java.util.ArrayList;

public class FamilyTree {
	
	/**
	 * This stores all the people in the family tree.
	 */
	private ArrayList<Person> familyMembers;
	
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

}
