package Version_three;

public class Begin  {
    public static void main(String[] args) throws Exception {
       Shooter_t t = new Shooter_t();
       System.out.println(t.ideology + " " + t.getLife());
//        boolean location = true;
//        
//        Terminator t = new Terminator(10);
//        Human h = new Human();
//        
//        //t.fight(t);
//       
//        Fight fi = new Fight();
//        fi.fight(t);
//        	 System.out.println(t.life);
//        	if (location == true){
////...реализация алгоритма боя, используемые параметры: оружие и жизнь
////        		t.dead(h.shoot());
////        		h.dead(t.shoot());
//        	}
    	
    }
   
}

interface Fightaible_two {
	//..способ взаимодействия между объектами
		
		void fight(Unit u);
		
	}


interface Fightaible {
//..способ взаимодействия между объектами
	
	void fight(Unit u);
	
}
//
//abstract class Unit {
//	int life;
//	int location;
//	//Наиболее общие признаки	
//}
//
//class Fight implements Fightaible, Fightaible_two {
//	Fightaible f;
//	
//	@Override
//	public void fight(Unit u) {
//		Terminator t = (Terminator) u;
//		System.out.println("fight");
////		if( u instanceof Terminator) {
////			t = (Terminator) u;
////		}
//		System.out.println(t.life);
//		
//	}	
//}
//
//class Terminator extends Unit implements Fightaible {
//	int life = 100;
//	int weapon = 20;
//	int other_parametrs = 200;
//	Terminator(int life) {
//		this.life = life;
//	}
////	@Override
////	public int shoot() {
//////...по сути это метод get_weapon
////		return this.weapon;
////	}
////	@Override
////	public void dead(int weapon) {
//////...метод изменения параметра жизнь
////		this.life -= weapon;
////		
////	}
//	@Override
//	public void fight(Unit u) {
//		Fight f = new Fight();
//		f.fight(u);
//		
//	}
//
//
//	
//}
//
//class Human extends Unit implements Fightaible {
//	int life = 50;
//	int weapon = 10;
//	
////	@Override
////	public int shoot() {
//////...по сути это метод get_weapon
////		return this.weapon;
////		
////	}
////	@Override
////	public void dead(int weapon) {
//////...метод изменения параметра жизнь
////		this.life -= weapon;
////	}
//	@Override
//	public void fight(Unit u) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
