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
		 
// ..MAIN STREAM	 
		 while(!s.equals("exit")){
			 System.out.println();
			 System.out.println();
			 System.out.println("begin-------------" + count + "------------------");
			 System.out.println("..main menu:");
			 System.out.println("command - begin fight");
			 System.out.println("command - exit from program");
			 System.out.println("Your command is: " + s);
			 System.out.println();
			 s = choice.readLine();
			 System.out.println("....result");
			 System.out.println("---------------------------------end");
			 count++;
			 
			 
//***	ВЗАИМОДЕЙСТВИЕ!!!
//		НАБОР УСЛОВИЙ
			 	if(s.equals("begin fight")){
			 		System.out.println("..fight begin");
			 			
			 			while(!s.equals("finish fight")){
			 				System.out.println("fight, first bum");
			 				
			 				
//АЛГОРИТМ ВЗАИМОДЕЙСТВИЯ			 				
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
			 				s = choice.readLine();
			 				System.out.println(s);
			 				if(s.equals("finish fight"))break;
			 				
			 			}
			 	}	
//..END MAIN STREAM
			 }
		 
		 // ...PART N
		 System.out.println();
		 System.out.println("....total end");

	}

}
