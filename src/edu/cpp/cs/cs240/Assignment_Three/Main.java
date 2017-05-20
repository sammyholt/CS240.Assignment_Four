package edu.cpp.cs.cs240.Assignment_Three;

public class Main {
	
	public static void main(String[] args){
		
		FamilyTree tree = new FamilyTree();
		Person test = new Person("Sam Holt", "9/2/1968", "", true);
		Person me = new Person("Sammy Holt", "6/19/1995", "", true);
		Person testPartner = new Person("Lisa Holt", "3/5/1969", "", false);
		tree.add(me);
		tree.add(test);
		tree.addChild(test, me);
		tree.addPartner(test, testPartner);
		
		tree.display(test);
	}

}
