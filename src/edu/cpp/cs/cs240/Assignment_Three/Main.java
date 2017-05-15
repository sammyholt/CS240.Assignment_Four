package edu.cpp.cs.cs240.Assignment_Three;

public class Main {
	
	public static void main(String[] args){
		
		FamilyTree tree = new FamilyTree();
		Person test = new Person();
		Person me = new Person("Sammy Holt", "6/19/1995", true, "", true);
		tree.add(me);
		tree.add(test);
		tree.addChild(test, me);
		
		tree.display(test);
	}

}
