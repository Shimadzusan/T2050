import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Begin {

	public static void main(String[] args) throws IOException {
		System.out.println("....world in 2050");
		System.out.println();
		//MENU
		 BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));
		 String s = "";
		 
		 Unit human = new Unit(50,10,"human");
		 Unit terminator = new Unit(100,20,"terminator");
		 int count = 1;
		 boolean contact = false;
		 
// ..MAIN STREAM	 
		 while(!s.equals("exit")){
			 System.out.println();
			 System.out.println();
			 System.out.println("begin-------------" + count + "------------------");
			 //SYSTEM STATUS
			 System.out.println("..system status:");
			 system_status(human);
			 system_status(terminator);
			 System.out.println("contact status: " + contact);
			 System.out.println("****");
			 //MAIN MENU
			 System.out.println("..main menu:");
			 System.out.println("command - create human");
			 System.out.println("command - delete human");
			 System.out.println("command - create terminator");
			 System.out.println("command - delete terminator");
			 
			 System.out.println("command - launch contact");
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
	public static void system_status(Unit human){
		//System.out.println("..system status:");
		System.out.println(human.kind + " life: " + human.life);
	}

}
