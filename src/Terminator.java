
public class Terminator extends Unit{
	int life = 100;
	int weapon = 20;
	boolean dead;
	String kind = "terminator"; //special kind
	
		public void dead(int weapon){
			System.out.println("..this is dead-method of t-800!");
			this.life = this.life - weapon;
		}
		public void contact(){
			System.out.println();
		}
}