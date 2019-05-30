package Version_two;

import java.util.ArrayList;

public class Fight extends Thread implements Runnable{
	
	Unit unit_u = new Unit(0, 0, "",0);
	Unit unit_v = new Unit(0, 0, "",0);
	
	@Override
	public void run() {
		int omega = 1;
		
		
			System.out.println("fight");
			
		try {
			
			while(true) {
				Thread.sleep(3000);//MUST TO END REPLACE!
				Basis.lbl.setText("..cycle of fight   ...stage " + omega);
				omega++;
				
			while(Control.flag_fight == true){
				Thread.sleep(3000);//MUST TO END REPLACE!
				Basis.label_fight.setText("fight   ...state " + Control.flag_fight);
				
						
//===ЛОГИКА БОЯ===
				ArrayList<Unit> list_human = new ArrayList<Unit>();
				ArrayList<Unit> list_terminator = new ArrayList<Unit>();
				ArrayList<Unit> new_lot_units = new ArrayList<Unit>();
				ArrayList<Unit> empty = new ArrayList<Unit>();
	
	for(int i = 0; i < Control.lot_of_units.size(); i++) {
//..сортируем все юниты по классам
			unit_u = Control.lot_of_units.get(i);
				if(unit_u.ideology.equals("human"))list_human.add(unit_u);
				if(unit_u.ideology.equals("terminator"))list_terminator.add(unit_u);
				if(!unit_u.ideology.equals("terminator") && !unit_u.ideology.equals("human"))empty.add(unit_u);
	}
	Basis.lbl2.setText("human " + list_human.size() + " terminator " + list_terminator.size() + " other " + empty.size());
	
//===SEARCH CONTACT!! список законтаченных юнитов
				
	ArrayList<Unit> contact_h = new ArrayList<Unit>();
	ArrayList<Unit> contact_t = new ArrayList<Unit>();
	
		for(int k = 0; k < list_human.size(); k++) {
			unit_v = list_human.get(k);
				int dist_h = unit_v.location;
				int result = 0;
				
					for(int j = 0; j < list_terminator.size(); j++) {
						unit_u = list_terminator.get(j);
							int dist_t = unit_u.location;

								 result = dist_h - dist_t;
							
									if(result <= 3 && result >= -3) {
										contact_h.add(unit_v);
										break;
									}
					}
					
					if(result > 3 || result < -3) {
						new_lot_units.add(unit_v);
					}	
		}
		
		for(int j = 0; j < list_terminator.size(); j++) {
			unit_v = list_terminator.get(j);
				int dist_t = unit_v.location;
				int result = 0;
					for(int l = 0; l < list_human.size(); l++) {
						unit_u = list_human.get(l);
							int dist_h = unit_u.location;
							
								result = dist_h - dist_t;
							
									if(result <= 3 && result >= -3) {
										contact_t.add(unit_v);
										break;
									}
					}
					
					if(result > 3 || result < -3) {
						new_lot_units.add(unit_v);
					}
		}
Basis.lbl6.setText("searh contact: contact_h = " + contact_h.size() + " contact_t = " + contact_t.size() + " contact_zero = " + new_lot_units.size());
//=========================БОЙ===
		
		int total_weapon_power_t = 20 * contact_t.size();
		int total_weapon_power_h = 10 * contact_h.size();
		
		if(contact_h.size() > 0){
		unit_u = contact_h.get(0);
			unit_u.life -= total_weapon_power_t;
				contact_h.set(0, unit_u);
		}
		
		if(contact_t.size() > 0) {
		unit_u = contact_t.get(0);
			unit_u.life -= total_weapon_power_h;
				contact_t.set(0, unit_u);
		}
//ФОРМИРУЕМ КОНЕЧНЫЙ РЕЗУЛЬТАТ ИЗ ТРЕХ МАССИВОВ
		//???
	
		}
			
		}
	}
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
