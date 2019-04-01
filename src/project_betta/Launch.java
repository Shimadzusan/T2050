package project_betta;

import java.util.ArrayList;

public class Launch {
/*
 * We have big lot of the units, for example: shooter, plane, vehicle, plant and etc.
 * All objects can only to live. Everybody samples is extends from abstract class,
 * which called Unit.
 * 
 * The structure of the our project have next view:
 * 				+-------------------+								.
 * 				|	abstract UNIT	|								.
 * 				+-------------------+								.
 * 				//		  ||		\\								.
 * 		+---------+	  +---------+  +---------+						.
 * 		| shooter |   | vehicle |  |  plant  |						.
 * 		+---------+	  +---------+  +---------+						.
 * 
 * This was step one.
 * 	
 */
	public static void main(String[] args) {
//first version of realization 
		Shooter shooter = new Shooter();
			shooter.to_life();
			
		Vehicle vehicle = new Vehicle();
			vehicle.to_life();
			
		Plane plane = new Plane();
			plane.to_life();
		
		Plant plant = new Plant();
			plant.to_life();
			
//=====================================================================
//second version of realization
	System.out.println();
		ArrayList<Unit> list = new ArrayList<Unit>();
		list.add(shooter);
		list.add(vehicle);
		list.add(plane);
		list.add(plant);
		
		for(int i = 0; i < list.size(); i++) {
			Unit unit = list.get(i);
				System.out.print(unit.getClass() + " ");
					unit.to_life();
		}

	}

}

abstract class Unit {
	int life;
	
	private int get_life() {
		return life;
	}
	
	private void set_life(int life) {
		this.life = life;
	}
	
	public void to_life(){
		System.out.println("..this unit lives");
	}
} 

class Shooter extends Unit {
	
}

class Vehicle extends Unit {
	
}

class Plane extends Unit{
	
}

class Plant extends Unit {
//static object of type factory	
}