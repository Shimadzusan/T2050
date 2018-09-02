import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Field {
	ArrayList lot = new ArrayList();
	private int count = 1;
	String s = "";
	BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));
	
	int total_human = 0;
	int total_terminator = 0;
	int human_life = 50;
	int terminator_life = 100;
	int human_weapon = 10;
	int terminator_weapon = 20;
	
	Unit x = new Unit(0,0,"");
	Unit z = new Unit(0,0,"");
	
	//UNITS ONLY FIGHT METHOD!!!
	Unit terminator = new Unit(0,0,"");
	Unit human = new Unit(0,0,"");
	
	public Field() throws IOException{
		
		System.out.println("....world in 2050");
		System.out.println();
		
		Unit u1 = new Unit(0,0,"");
		Unit u2 = new Unit(0,0,"");
		Unit u3 = new Unit(0,0,"");
		Unit u4 = new Unit(0,0,"");
		Unit u5 = new Unit(0,0,"");
		Unit u6 = new Unit(0,0,"");
		
		lot.add(u1);
		lot.add(u2);
		lot.add(u3);
		lot.add(u4);
		lot.add(u5);
		lot.add(u6);
		
		boolean contact = false;
		 
//..MAIN STREAM	 
			 system_interface();
			 
		System.out.println();
		System.out.println("....total end");
		 }
	

//..BLOCK OF METHODS--------------------------------------------------------------	

//..SYSTEM INTERFACE
	public void system_interface() throws IOException{
		 while(!s.equals("exit")){
		 
				 System.out.println();
				 System.out.println("begin-------------" + count + "------------------");
//..RUN SYSTEM STATUS
				 system_status();
				 System.out.println("++..............++");
//..RUN SYSTEM MENU
				 system_menu();
				 
				 s = choice.readLine();
				 
				 if(s.equals("create human")) create_human();
				 if(s.equals("delete human")) delete_human();
				 if(s.equals("create terminator")) create_terminator();
				 if(s.equals("delete terminator")) delete_terminator();
				 
				 if(s.equals("begin fight")) fight();
				 //if(s.equals("finish fight")) create_human();
				 
				 System.out.println("....result");
				 System.out.println("---------------------------------end");
				 count++;
		 }
	}

private void create_human() {
boolean flag = true;
	
	for(int i = 0; i < lot.size(); i++){
		 x = (Unit) lot.get(i);
		 System.out.println(flag + "" + i);
//		 System.out.println("+++++++++++++++++");
//		 system_status();
//		 System.out.println("+++++++++++++++++");
		 //System.out.println("Unit: " + x.kind + " life: " + x.life + " weapon: " + x.weapon);
		 if(!x.kind.equals("human") && !x.kind.equals("terminator") && flag == true){
			 z = x;
			 z.kind = "human";
				z.life = human_life;
				z.weapon = human_weapon;
				lot.set(i, z);
				flag = false;
				total_human = total_human + 1;
				System.out.println(flag + "" + i);
		 }
	 }
		
	}

private void delete_human() {
boolean flag = true;
	
	for(int i = 0; i < lot.size(); i++){
		 x = (Unit) lot.get(i);
		 System.out.println(flag + "" + i);
//		 System.out.println("+++++++++++++++++");
//		 system_status();
//		 System.out.println("+++++++++++++++++");
		 if(x.kind.equals("human") && flag ==true){
			 z = x;
			 z.kind = "";
				z.life = 0;
				z.weapon = 0;
				lot.set(i, z);
				flag = false;
				total_human = total_human - 1;
				System.out.println(flag + "" + i);
			 
		 }
	}
	}


private void create_terminator() {
	boolean flag = true;
	
	for(int i = 0; i < lot.size(); i++){
		 x = (Unit) lot.get(i);
		 System.out.println(flag + "" + i);
//		 System.out.println("+++++++++++++++++");
//		 system_status();
//		 System.out.println("+++++++++++++++++");
		 //System.out.println("Unit: " + x.kind + " life: " + x.life + " weapon: " + x.weapon);
		 if(!x.kind.equals("human") && !x.kind.equals("terminator") && flag == true){
			 z = x;
			 z.kind = "terminator";
				z.life = terminator_life;
				z.weapon = terminator_weapon;
				lot.set(i, z);
				flag = false;
				total_terminator = total_terminator + 1;
				System.out.println(flag + "" + i);
		 }
	 }

}


private void delete_terminator() {
	boolean flag = true;
	
	for(int i = 0; i < lot.size(); i++){
		 x = (Unit) lot.get(i);
		 System.out.println(flag + "" + i);
//		 System.out.println("+++++++++++++++++");
//		 system_status();
//		 System.out.println("+++++++++++++++++");
		 if(x.kind.equals("terminator") && flag ==true){
			 z = x;
			 z.kind = "";
				z.life = 0;
				z.weapon = 0;
				lot.set(i, z);
				flag = false;
				total_terminator = total_terminator - 1;
				System.out.println(flag + "" + i);
			 
		 }
	}
	
}

//..SYSTEM STATUS
	public void system_status(){
		 System.out.println("..system status:");
		 for(int i = 0; i < lot.size(); i++){
			 //System.out.println(lot.get(i));
			 x = (Unit) lot.get(i);
			 System.out.println("Unit: " + x.kind + " life: " + x.life + " weapon: " + x.weapon);
		 }
		 System.out.println();
		 System.out.println("total human: " + total_human + " st.");
		 System.out.println("total terminator: " + total_terminator + " st.");
	}
	
//..SYSTEM MENU
	public void system_menu(){
		System.out.println("..main menu:");
		 System.out.println("command - create human");
		 System.out.println("command - delete human");
		 System.out.println("command - create terminator");
		 System.out.println("command - delete terminator");
		 
		 System.out.println("command - launch contact");
		 System.out.println("command - stop contact");
		 System.out.println("command - begin fight");
		 System.out.println("command - exit from program");
		 System.out.println("enter Your command:");
		 System.out.println();
	}
	
	
private void fight() throws IOException {
//	НАБОР УСЛОВИЙ FOR FIGHT!!!
	int h_firecraft = 0;
	int t_firecraft = 0;
 	if(s.equals("begin fight")){
 		System.out.println();
 		count++;
 		System.out.println("..fight begin");
 			
 			while(!s.equals("finish fight")){
 				if(total_human <= 0 || total_terminator <= 0) break;
 				System.out.println("fight-------------" + count + "------------------");
 				count++;
 				
//АЛГОРИТМ ВЗАИМОДЕЙСТВИЯ///////////////////////////////////////////////////////////////////////			 				
// 				human.dead(terminator.weapon);
// 				terminator.dead(human.weapon);
// 				
// 				System.out.println("human life: " + human.life);
// 				System.out.println("terminator life: " + terminator.life);
 				
 				System.out.println("This is fight!!!");
 				System.out.println();
 				system_status();
 				system_menu();
 				////////////////////////////////////////////
 				//СЧИТАЕМ ЮНИТОВ И ИХ ОГНЕВУЮ МОЩЬ
 				h_firecraft = total_human * human_weapon;
 				t_firecraft = total_terminator * terminator_weapon;
 				boolean tflag = true;
 				boolean hflag = true;
 				int index_h = 0;
 				int index_t = 0;
 				for(int i = 0; i < lot.size(); i++){
 					 x = (Unit) lot.get(i);
 					 
 					 if(x.kind.equals("terminator") && x.life > 0 && tflag == true){
 						 terminator = x;
 						 tflag = false;
 						 index_t = i;
 					 }
 					if(x.kind.equals("human") && x.life > 0 && hflag == true){
						 
						 human = x;
						 hflag = false;
 						 index_h = i;
					 }
 				}
 				
 				terminator.life = terminator.life - h_firecraft;
 				human.life = human.life - t_firecraft;
 				
 				 z = terminator;
 					lot.set(index_t, z);
 					
 					z = human;
 					lot.set(index_h, z);
 				
 				if(terminator.life <= 0) delete_terminator();
 				if(human.life <= 0) delete_human();
 				
 				///////////////////////////////////////////
 				System.out.println("---------------------------------end");
 				if(total_human <= 0 || total_terminator <= 0) break;
 				s = choice.readLine();
 				System.out.println(s);
 				if(s.equals("finish fight"))break;
 				
 			}
 	}
 	else{
 		if(s.equals("begin fight")) System.out.println("..contact status is false");
 	}
	
}
}
