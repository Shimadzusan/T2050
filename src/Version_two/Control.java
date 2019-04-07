package Version_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Control {
	
	static boolean flag_fight = false;
	//static boolean switch_fight = false;
//эта группа юнитов предназначена для ... операций	
		Unit unit_x = new Unit(0,0,"",0);
		Unit unit_z = new Unit(0,0,"",0);
		
	static ArrayList<Unit> lot_of_units = new ArrayList<Unit>();
//=====================================================
//BLOCK OF MY CONTROL
	Control() throws InterruptedException, IOException {
//...формируем список юнитов
		Unit u1 = new Unit(60,10,"human",0);
		Unit u2 = new Unit(80,20,"terminator",50);
		Unit u3 = new Unit(50,10,"human",10);
		Unit u4 = new Unit(90,15,"terminator",40);
		
		lot_of_units.add(u1);
		lot_of_units.add(u2);
		lot_of_units.add(u3);
		lot_of_units.add(u4);

		String command = "";
		
	while(true){

			System.out.println();//Интерфейс для командной строки
			System.out.println("==========BLOCK OF CONTROL==========");
			System.out.println("..availabel command: run; stop; exit");
			System.out.println();
					
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			command = bufferedReader.readLine(); //читаем строку с клавиатуры
			
		if(command.equals("exit"))break;
//----------------thread system_status----------------------
		if(command.equals("run")){
			Thread status = new Thread(new System_status());
				status.start();
		}	
//------------------OPERATION WITH UNITS--------------------
		if(command.equals("create -h")){
			create_human();
		}
		if(command.equals("delete -h"))delete_human();
		
		if(command.equals("create -t")){
			create_terminator();
		}
		if(command.equals("delete -t"))delete_terminator();
//----------------------move-t-------------------------------

		if(command.equals("move"))move();
		
//----------------------------------------------------------
			System.out.println("you command is: " + command);
			System.out.println("================END=================");
			
			Basis.lbl5.setText("..empty");
		}
	}

	private void create_human() {
		boolean flag = true;
			
			for(int i = 0; i < lot_of_units.size(); i++){
				 unit_x = lot_of_units.get(i);

				 if(!unit_x.ideology.equals("human") && !unit_x.ideology.equals("terminator") && flag == true){
					 unit_z = unit_x;
					 	unit_z.ideology = "human";
					 		unit_z.life = 50;
					 			unit_z.weapon = 10;
					 				unit_z.location = 10;
					 					lot_of_units.set(i, unit_z);
					 						flag = false;
				 }
			 }			
	}

	private void delete_human() {
		boolean flag = true;
			
			for(int i = 0; i < lot_of_units.size(); i++){
				unit_x = (Unit) lot_of_units.get(i);
				 
				 if(unit_x.ideology.equals("human") && flag ==true){
					 unit_z = unit_x;
					 	unit_z.ideology = "";
					 		unit_z.life = 0;
					 			unit_z.weapon = 0;
					 				unit_z.location = 0;
					 					lot_of_units.set(i, unit_z);
					 						flag = false;
				 }
			}
	}


	private void create_terminator() {
		boolean flag = true;
			
			for(int i = 0; i < lot_of_units.size(); i++){
				 unit_x = lot_of_units.get(i);

				 if(!unit_x.ideology.equals("human") && !unit_x.ideology.equals("terminator") && flag == true){
					 unit_z = unit_x;
					 	unit_z.ideology = "terminator";
					 		unit_z.life = 100;
					 			unit_z.weapon = 20;
					 				unit_z.location = 90;
					 					lot_of_units.set(i, unit_z);
					 						flag = false;
				 }
			 }			
	}

	private void delete_terminator() {
		boolean flag = true;
			
			for(int i = 0; i < lot_of_units.size(); i++){
				unit_x = (Unit) lot_of_units.get(i);
				 
				 if(unit_x.ideology.equals("terminator") && flag ==true){
					 unit_z = unit_x;
					 	unit_z.ideology = "";
					 		unit_z.life = 0;
					 			unit_z.weapon = 0;
					 				unit_z.location = 0;
					 					lot_of_units.set(i, unit_z);
					 						flag = false;
				 }
			}
	}
	
	private void move() throws IOException {
		String unit = "";		
		int number_unit = 0;
		int new_location = 0;
		
			System.out.println("=====MODE MOVE=====");	
			System.out.print("..chose the unit: ");
				BufferedReader buffer_one = new BufferedReader(new InputStreamReader(System.in));
					unit = buffer_one.readLine();
						number_unit = Integer.parseInt(unit);
			System.out.print("..set new location: ");
					unit = buffer_one.readLine();
						new_location = Integer.parseInt(unit);
						
	System.out.println();
	System.out.println("unit: " + number_unit + " location: " + new_location);	
//--------------setting new value------------------------------------------------------------
//..при таком подходе статичные объекты(здания, горы, дороги) тоже могут быть движимы
		unit_x = (Unit) lot_of_units.get(number_unit);
			unit_x.location = new_location;
				lot_of_units.set(number_unit, unit_x);
				
	System.out.println("set new location is done..");
	System.out.println("===================");
	}
}
