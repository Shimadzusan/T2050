import java.util.ArrayList;

public class Begin {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(".....world in 2050");
		System.out.println();
		
		Terminator t = new Terminator();
		Human h = new Human();
		//Human h2 = new Human();
		
		h.dead(t.weapon);
		t.dead(h.weapon);
		
		//РАЗРАБОТАТЬ СОБЫТИЕ КОНТАКТ!!!!
		
		//...here we add in this world action)
//		Action act = new Action();
//		act.fight(t.life, t.weapon, h.life, h.weapon);
		
		//FIGHT???
//		while(t.life > 0 && h.life > 0){
//			t.life = t.life - h.weapon;
//			h.life = h.life - t.weapon;
//			
//			System.out.println("fight");
//			System.out.println("t = "+t.life);
//			System.out.println("h = "+h.life);
//		}
		
		System.out.println(h.life);
		Human h2 = new Human();
		System.out.println(h2.life);
		System.out.println(h.life);
		System.out.println(t.life);
		System.out.println(t.kind);
	
		
		System.out.println("Array");
		ArrayList lot = new ArrayList();
		
		
			lot.add(h);
			lot.add(h2);
			//lot.add(t);
			Human h5 = new Human();
			for(int i = 0; i < lot.size(); i++){
				System.out.println(lot.get(i));
				System.out.println();
				h5 = (Human) lot.get(i);
				System.out.println("probe: " + h5.life);
				System.out.println("probe: " + h5.kind);
				
			}
			lot.get(0);
			
		
	}

}
