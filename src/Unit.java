
public class Unit {
	int life;
	int weapon;
	boolean dead;
	String kind; //special kind
	
	Unit(int life, int weapon, String kind){
		
		this.life = life;
		this.weapon = weapon;
		this.kind = kind;
	}
	
	public void dead(int weapon){
		//System.out.println("..this is dead-method of Modul!");
		System.out.println();
		this.life = this.life - weapon;
	}

}
