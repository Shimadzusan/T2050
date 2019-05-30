package version_fifth;

public class Unit {
	int life;
	int weapon;
	boolean dead;
	String ideology; //special kind of unit
	int location; //диапазон от 0 до 100 (условно)
	
	Unit(int life, int weapon, String ideology, int location){
		
		this.life = life;
		this.weapon = weapon;
		this.ideology = ideology;
		this.location = location;
	}
	
	public void dead(int weapon){
		//System.out.println("..this is dead-method of Modul!");
		System.out.println();
		this.life = this.life - weapon;
	}

}
