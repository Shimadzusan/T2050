import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Begin {

	public static void main(String[] args) throws IOException {
		
		new Field();
		
		//System.out.println("Hello");
		/*
		System.out.println("....world in 2050");
		System.out.println();
		//MENU
		 BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));
		 String s = "";
		 String ss = "human2";
		 
		 Unit human = new Unit(0,10,"human");
		 Unit human2 = new Unit(50,10,"human");
		 Unit terminator = new Unit(0,20,"terminator");
		 Unit terminator2 = new Unit(90,20,"terminator");
		 
		 ArrayList list = new ArrayList();
			 list.add(human);
			 list.add(human2);
			 list.add(terminator);
			 list.add(terminator2);
			 
			 
		 
		 int count = 1;
		 boolean contact = false;
		 
// ..MAIN STREAM	 
		 while(!s.equals("exit")){
			 System.out.println();
			 System.out.println();
			 System.out.println("begin-------------" + count + "------------------");
			 //SYSTEM STATUS
			 System.out.println("..system status:");
			 system_status(human, human2, terminator, terminator2);
			 mass(list);
			 
			 System.out.println("contact status: " + contact);
			 System.out.println("****");
			 //MAIN MENU
			 System.out.println("..main menu:");
			 System.out.println("command - create human");
			 System.out.println("command - delete human");
			 System.out.println("command - create terminator");
			 System.out.println("command - delete terminator");
			 
			 System.out.println("command - launch contact");
			 System.out.println("command - stop contact");
			 System.out.println("command - begin fight");
			 System.out.println("command - exit from program");
			 System.out.println("Entere Your command is:");
			 System.out.println();
			 s = choice.readLine();
			 System.out.println("....result");
			 System.out.println("---------------------------------end");
			 count++;
			 
			 
//***	ВЗАИМОДЕЙСТВИЕ!!!
//		НАБОР УСЛОВИЙ FOR FIGHT!!!
			 	if(s.equals("begin fight") && contact == true){
			 		System.out.println("..fight begin");
			 			
			 			while(!s.equals("finish fight")){
			 				System.out.println("fight-------------" + count + "------------------");
			 				count++;
			 				
//АЛГОРИТМ ВЗАИМОДЕЙСТВИЯ///////////////////////////////////////////////////////////////////////			 				
			 				human.dead(terminator.weapon);
			 				terminator.dead(human.weapon);
			 				
			 				System.out.println("human life: " + human.life);
			 				System.out.println("terminator life: " + terminator.life);
			 				
			 				
			 				
			 				if(human.life <= 0) {
			 					System.out.println("human is dead");break;
			 				}
			 				if(terminator.life <= 0){
			 					System.out.println("terminator is dead");break;
			 				}
			 				System.out.println("---------------------------------end");
			 				s = choice.readLine();
			 				System.out.println(s);
			 				if(s.equals("finish fight"))break;
			 				
			 			}
			 	}
			 	else{
			 		if(s.equals("begin fight")) System.out.println("..contact status is false");
			 	}
//***	ВЗАИМОДЕЙСТВИЕ!!!
//				НАБОР УСЛОВИЙ FOR CREATE AND DELETE!!!
			 	if(s.equals("create human")){
			 		human.life = 50;
			 	}
			 	
			 	if(s.equals("create terminator")){
			 		terminator.life = 100;
			 	}
///////////////////////////////DELETE///////////////////////////////////////////
				if(s.equals("delete human")){
			 		human.life = 0;
			 	}
			 	
			 	if(s.equals("delete terminator")){
			 		terminator.life = 0;
			 	}
/////////////////////////////CONTACT/////////////////////////////////////////////
			 	if(s.equals("launch contact")){
			 		contact = true;
			 	}
			 	
			 	if(s.equals("stop contact")){
			 		contact = false;
			 	}
//..END MAIN STREAM
			 }
		
		 // ...PART N
		 System.out.println();
		 System.out.println("....total end");

	}
	public static void system_status(Unit unit1, Unit unit2, Unit unit3, Unit unit4){
		//System.out.println("..system status:");
		System.out.println(unit1.kind + " life: " + unit1.life);
		//System.out.println(list.);
		
		
	}
	
	
	public static void mass(ArrayList mass){
		Unit unitx = new Unit(0,0,"");
		int h = 0;
		int t = 0;
		String s = "";
		for(int i = 0; i < mass.size(); i++){
			
			unitx = (Unit) mass.get(i);
			System.out.println(unitx.kind + " life: " + unitx.life);
			s = unitx.kind;
			if(s.equals("human") && unitx.life > 0) h++;
			if(s.equals("terminator") && unitx.life > 0) t++;
			
			
		}
			System.out.println();
			System.out.println("total");
			System.out.println("human: " + h + " st.");
			System.out.println("terminator: " + t + " st.");
	
	*/
	}

}
