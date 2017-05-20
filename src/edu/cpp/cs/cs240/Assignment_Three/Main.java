package edu.cpp.cs.cs240.Assignment_Three;

public class Main {
	
	public static void main(String[] args){
		
		FamilyTree tree = new FamilyTree();
		Person john = new Person("John Doe", "", "", true);
		Person mary = new Person("Mary Jane", "", "", false);
		Person jim = new Person("Jim Doe", "", "", true);
		Person jennifer = new Person("Jennifer Doe", "", "", false);
		Person tim = new Person("Tim Clark", "", "", true);
		Person jesse = new Person("Jesse Clark", "", "", false);
		Person nicole = new Person("Nicole Doe", "", "", false);
		Person nick = new Person("Nick Jonah", "", "", true);
		Person nancy = new Person("Nancy Jonah", "", "", false);
		
		// add John to the tree
		tree.add(john);
		
		// add partners
		tree.addPartner(john, mary);
		tree.addPartner(john, nicole);
		tree.addPartner(jennifer, tim);
		tree.addPartner(nicole, nick);
		
		// add the children
		tree.addChild(mary, jim);
		tree.addChild(mary, jennifer);
		tree.addChild(jennifer, jesse);
		tree.addChild(nicole, nancy);
		
		// display john's tree
		tree.display(john);
	}

}
