package Version_three;

abstract class Unit {
	int life;
	int weapon;
	int location;
	
	boolean dead;
	String ideology; //special kind of unit
//Наиболее общие признаки

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	

}

abstract class Terminator extends Unit {
	
	Terminator() {
		this.ideology = "terminator";
	}
}

