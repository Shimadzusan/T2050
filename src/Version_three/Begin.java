package Version_three;

public class Begin  {
    public static void main(String[] args) throws Exception {
       
        boolean location = true;
        
        Terminator t = new Terminator();
        Human h = new Human();
        	
        	if (location == true){
//...реализация алгоритма боя, используемые параметры: оружие и жизнь
        		t.dead(h.shoot());
        		h.dead(t.shoot());
        	}
    	
    }
   
}

interface Fight {
//..способ взаимодействия между объектами
	int shoot();
	void dead(int weapon);
}

abstract class Unit {
	int location;
	//Наиболее общие признаки	
}

class Terminator extends Unit implements Fight {
	int life = 100;
	int weapon = 20;
	int other_parametrs = 200;
	
	@Override
	public int shoot() {
//...по сути это метод get_weapon
		return this.weapon;
	}
	@Override
	public void dead(int weapon) {
//...метод изменения параметра жизнь
		this.life -= weapon;
		
	}
	
}

class Human extends Unit implements Fight {
	int life = 50;
	int weapon = 10;
	
	@Override
	public int shoot() {
//...по сути это метод get_weapon
		return this.weapon;
		
	}
	@Override
	public void dead(int weapon) {
//...метод изменения параметра жизнь
		this.life -= weapon;
	}
	
}
