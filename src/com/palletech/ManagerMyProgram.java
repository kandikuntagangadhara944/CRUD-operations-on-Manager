package com.palletech;

import java.util.ArrayList;

public class ManagerMyProgram {

	public static void main(String[] args) {
		//ManagerJdbcOperations.create();
		/*ManagerJdbcOperations.insert("kuwaila", "trainer", 2);
		ManagerJdbcOperations.insert("Bharath", "trainer", 3);
		ManagerJdbcOperations.insert("satish", "IT", 10);*/
		//ManagerJdbcOperations.delete(1);
		//ManagerJdbcOperations.update("manohar", "hr", 4, 2);
		ArrayList<Manager> a=  ManagerJdbcOperations.display();
		System.out.println("ID   NAME   DEPARTMENT   EXP  ");
		for(Manager item:a)
		{
			System.out.println(item.getId()+"||"+item.getName()+"||"+item.getDept()+"||"+item.getExp());
		}

	}

}
