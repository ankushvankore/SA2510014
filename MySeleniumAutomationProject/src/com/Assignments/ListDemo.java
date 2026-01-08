package com.Assignments;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List<String>fruits = new ArrayList<>();
		
		fruits.add("Banana");
		fruits.add("Grapes");
		fruits.add("Watermelon");
		
		//System.out.println(fruits.get(1));
		
		for(String f : fruits)
			System.out.println(f);
	}

}
