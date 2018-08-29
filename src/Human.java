
public class Human extends Unit{
	int life = 60;
	int weapon = 10;
	boolean dead;
	String kind = "human"; //special kind
	
		public void dead(int weapon){
			System.out.println("..this is dead-method of Human!");
			this.life = this.life - weapon;
		}
		public void contact(){
			System.out.println();
		}
}