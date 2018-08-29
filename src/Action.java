
public class Action {
	
	public void fight(int tlife, int tweapon, int hlife, int hweapon){
		
		
		
		while(tlife > 0 && hlife > 0){
			tlife = tlife - hweapon;
			hlife = hlife - tweapon;
			
			System.out.println("fight");
			System.out.println("t = "+tlife);
			System.out.println("h = "+hlife);
		}
		
	}

}
