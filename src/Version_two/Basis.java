package Version_two;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.JTextComponent;

/**
 * Создано на основе опытов с микросхемой файл Firs
 * для отработки многопоточности
 * 
 * Первый фундаментальный вопрос:
 * Выделять память сразу для всех объектов, или выделяем память в процессе работы программы при создании объектов
 */
public class Basis extends JFrame {
	/*
	 * Данный класс отвечает за формирование окна вывода основных параметров
	 * Так как вывод основных параметров в консоль по техническим причинам не возможен
	 * приходится пользоваться именно такой реализацией
	 * Класс так же содержит метод main  и запускает класс с основной логикой(Control)
	 */
	
	 static JPanel panel = new JPanel();
//переменные для вывода основных параметров на фрейм	 
		 static  JLabel lbl = new JLabel();
		 static  JLabel lbl2 = new JLabel();
		 static  JLabel lbl3 = new JLabel("system_status:");
		 static  JLabel lbl4 = new JLabel("system_time:");
		 static  JLabel lbl5 = new JLabel();
		 static  JLabel lbl6 = new JLabel();
		 static  JLabel unit1 = new JLabel();
		 static  JLabel unit2 = new JLabel();
		 static  JLabel unit3 = new JLabel();
		 static  JLabel unit4 = new JLabel();
		 static  JLabel label_fight = new JLabel();
		 static int i = 0;    

	public Basis(){
        setTitle("# main frame of control #");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(550,350);
        setLocation(400,650);
        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
    	Basis frame = new Basis();
        
	        panel.setBackground(Color.LIGHT_GRAY);
	        panel.setLayout(null);
	        frame.add(panel);
//расположение надписей с выводом основных параметров
	        	lbl.setBounds(10, 25, 350, 40);
	        	lbl2.setBounds(10, 45, 350, 40);
	        	lbl3.setBounds(10, 5, 150, 40);
	        	lbl4.setBounds(350, 5, 150, 40);
	        	
	        	lbl5.setBounds(350, 25, 350, 40);
	        	lbl6.setBounds(350, 45, 350, 40);
	        	
	        	unit1.setBounds(10, 65, 350, 40);
	        	unit2.setBounds(10, 85, 350, 40);
	        	unit3.setBounds(10, 105, 350, 40);
	        	unit4.setBounds(10, 125, 350, 40);
	        	
	        	label_fight.setBounds(10, 145, 250, 40);
	        	
	        	panel.add(lbl);
	        	panel.add(lbl2);
	        	panel.add(lbl3);
	        	panel.add(lbl4);
	        	
	        	panel.add(lbl5);
	        	panel.add(lbl6);
	        	
	        	panel.add(unit1);
	        	panel.add(unit2);
	        	panel.add(unit3);
	        	panel.add(unit4);
	        	
	        	panel.add(label_fight);
//===================================================
	        		new Control();
    }
 
}

class Control implements Runnable {
	
	static boolean flag_a = false;
	static int count_a = 1;
	static int object_class_a = 0;
	
	static boolean flag_b = false;
	static int count_b = 1;
	static int object_class_b = 0;
	
	static boolean flag_fight = false;
	//static boolean switch_fight = false;
//эта группа юнитов предназначена для ... операций	
		Unit unit_x = new Unit(0,0,"",0);
		Unit unit_z = new Unit(0,0,"",0);
		
	static ArrayList<Unit> lot_of_units = new ArrayList<Unit>();
//=====================================================
//BLOCK OF MY CONTROL
	Control() throws InterruptedException, IOException {
//...формируем список юнитов
		Unit u1 = new Unit(60,10,"human",0);
		Unit u2 = new Unit(80,20,"terminator",50);
		Unit u3 = new Unit(50,10,"human",10);
		Unit u4 = new Unit(90,15,"terminator",40);
		
		lot_of_units.add(u1);
		lot_of_units.add(u2);
		lot_of_units.add(u3);
		lot_of_units.add(u4);

		String command = "";
		
	while(true){

			System.out.println();//Интерфейс для командной строки
			System.out.println("==========BLOCK OF CONTROL==========");
			System.out.println("..availabel command: run; stop; exit");
			System.out.println("..system status: object_class_a = " + object_class_a + "; object_class_b = " + object_class_b);
					
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			command = bufferedReader.readLine(); //читаем строку с клавиатуры
			
		if(command.equals("exit"))break;
		
		if(command.equals("run -a")){
			Thread t = new Thread(this);
				t.start();
					flag_a = true;
		}	
		if(command.equals("stop -a"))flag_a = false;
//--------------------------B--------------------------
			
		if(command.equals("run -b")){
			Thread b = new Thread(new Process_b());
				b.start();
					flag_b = true;
		}
		if(command.equals("stop -b"))flag_b = false;
//----------------thread system_status----------------------

		if(command.equals("run -status")){
			Thread status = new Thread(new System_status());
				status.start();
				//flag_b = true;
		}
			
//		if(s.equals("stop -status"));//flag_b = false;		
//------------------OPERATION WITH UNITS--------------------
		if(command.equals("create -h")){
			create_human();
		}
		if(command.equals("delete -h"))delete_human();
		
		if(command.equals("create -t")){
			create_terminator();
		}
		if(command.equals("delete -t"))delete_terminator();
//----------------------fight-------------------------------
		
//		if(command.equals("fight")){
//			Thread fight = new Thread(new Fight());
//				fight.start();
//					flag_fight = true;
//		}
//		if(command.equals("stop fight"))flag_fight = false;
//----------------------move-t-------------------------------

		if(command.equals("move"))move();
		
//----------------------------------------------------------
			System.out.println("you command is: " + command);
			System.out.println("================END=================");
			
			Basis.lbl5.setText("|===================================");
		}
	}

	@Override
	public void run() {
		try {
//...простой процесс класса А	
			while(flag_a == true){
			Thread.sleep(5000);
			Basis.lbl.setText("Execution Process kind -a   ...stage " + Control.count_a + " run is: " + flag_a);
			//System.out.println("Execution Process kind -a   ...stage " + count);
			count_a++;
			if(count_a > 5)count_a = 1;
			
			object_class_a += - 2; 
			}
// Затем, создаем object type Humman
// И помещаем в lot_of_unit
			
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	private void create_human() {
		boolean flag = true;
			
			for(int i = 0; i < lot_of_units.size(); i++){
				 unit_x = lot_of_units.get(i);

				 if(!unit_x.ideology.equals("human") && !unit_x.ideology.equals("terminator") && flag == true){
					 unit_z = unit_x;
					 	unit_z.ideology = "human";
					 		unit_z.life = 50;
					 			unit_z.weapon = 10;
					 				unit_z.location = 10;
					 					lot_of_units.set(i, unit_z);
					 						flag = false;
				 }
			 }			
	}

	private void delete_human() {
		boolean flag = true;
			
			for(int i = 0; i < lot_of_units.size(); i++){
				unit_x = (Unit) lot_of_units.get(i);
				 
				 if(unit_x.ideology.equals("human") && flag ==true){
					 unit_z = unit_x;
					 	unit_z.ideology = "";
					 		unit_z.life = 0;
					 			unit_z.weapon = 0;
					 				unit_z.location = 0;
					 					lot_of_units.set(i, unit_z);
					 						flag = false;
				 }
			}
	}


	private void create_terminator() {
		boolean flag = true;
			
			for(int i = 0; i < lot_of_units.size(); i++){
				 unit_x = lot_of_units.get(i);

				 if(!unit_x.ideology.equals("human") && !unit_x.ideology.equals("terminator") && flag == true){
					 unit_z = unit_x;
					 	unit_z.ideology = "terminator";
					 		unit_z.life = 100;
					 			unit_z.weapon = 20;
					 				unit_z.location = 90;
					 					lot_of_units.set(i, unit_z);
					 						flag = false;
				 }
			 }			
	}

	private void delete_terminator() {
		boolean flag = true;
			
			for(int i = 0; i < lot_of_units.size(); i++){
				unit_x = (Unit) lot_of_units.get(i);
				 
				 if(unit_x.ideology.equals("terminator") && flag ==true){
					 unit_z = unit_x;
					 	unit_z.ideology = "";
					 		unit_z.life = 0;
					 			unit_z.weapon = 0;
					 				unit_z.location = 0;
					 					lot_of_units.set(i, unit_z);
					 						flag = false;
				 }
			}
	}
	
	private void move() throws IOException {

		String unit = "";		
		int number_unit = 0;
		int new_location = 0;
		
			System.out.println("=====MODE MOVE=====");	
			System.out.print("..chose the unit: ");
				BufferedReader buffer_one = new BufferedReader(new InputStreamReader(System.in));
					unit = buffer_one.readLine(); //читаем строку с клавиатуры
						number_unit = Integer.parseInt(unit);
						
			System.out.print("..set new location: ");
				BufferedReader buffer_two = new BufferedReader(new InputStreamReader(System.in));
					unit = buffer_two.readLine();
						new_location = Integer.parseInt(unit);
						
	System.out.println();
	System.out.println("unit: " + number_unit + " location: " + new_location);
	
	
//-----------------------------------------------------------------------------------------------
		unit_x = (Unit) lot_of_units.get(number_unit);
			unit_x.location = new_location;
				lot_of_units.set(number_unit, unit_x);
				
	System.out.println("set new location is done..");
	System.out.println("===================");
	}

	
}

class Process_b implements Runnable{

	@Override
	public void run() {
			
		try {
			while(Control.flag_b == true){
				Thread.sleep(8000);
				Basis.lbl2.setText("Execution Process kind -b   ...stage " + Control.count_b + " run is: " + Control.flag_b);
				//First.lbl.setText("complete: " + Control.count_b + "%");
				//System.out.println("Execution Process kind -b   ...stage " + Control.count_b);
				Control.count_b++;
				if(Control.count_b > 5)Control.count_b = 1;
				Control.object_class_b += - 5;	
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
}


class Fight implements Runnable{
	
	Unit unit_u = new Unit(0, 0, "",0);
	Unit unit_v = new Unit(0, 0, "",0);
	
	@Override
	public void run() {
		int omega = 1;
			System.out.println("fight");
		try {
			while(Control.flag_fight == true){
				Thread.sleep(3000);//MUST TO END REPLACE!
				Basis.label_fight.setText("fight   ...state " + Control.flag_fight);
				Basis.lbl.setText("..cycle of fight   ...stage " + omega);
				
				//System.out.println("cycle of fight " + omega);
				omega++;
			
				
//		for(int i = 0; i < Control.lot_of_units.size(); i++) {
//					
//					unit_u = Control.lot_of_units.get(i);
//						unit_u.life -= 1;
//						
//						Control.lot_of_units.set(i, unit_u);
//			}			
		
			
//===ЛОГИКА БОЯ===
	ArrayList<Unit> list_human = new ArrayList<Unit>();
	ArrayList<Unit> list_terminator = new ArrayList<Unit>();
	ArrayList<Unit> new_lot_units = new ArrayList<Unit>();
	ArrayList<Unit> empty = new ArrayList<Unit>();
	
	for(int i = 0; i < Control.lot_of_units.size(); i++) {
		
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
//При итерации добавляются лишние юниты, в обоих вариантах!!
//									
//									else {
//										new_lot_units.add(unit_u);
//									}
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
//									else {
//										new_lot_units.add(unit_u);
//									}
					}
					
					if(result > 3 || result < -3) {
						new_lot_units.add(unit_v);
					}
		}
Basis.lbl6.setText("searh contact: contact_h = " + contact_h.size() + " contact_t = " + contact_t.size() + " contact_zero = " + new_lot_units.size());
//=========================
		
		
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
				
				int m = 0;
					
					if(contact_h.size() > 0){
						
						for(int p = 0; p < contact_h.size(); p++) {
							Control.lot_of_units.set(p, contact_h.get(p));
							m++;
						}
						
					}
//----------------------------------------------------------2
					
					if(contact_t.size() > 0){
						
						for(int p = 0; p < contact_t.size(); p++) {
							Control.lot_of_units.set(m, contact_t.get(p));
							m++;
						}
					}

//----------------------------------------------------------3
					
					if(new_lot_units.size() > 0){
						
						for(int p = 0; p < new_lot_units.size(); p++) {
							Control.lot_of_units.set(m, new_lot_units.get(p));
							m++;
						}
					}
					

//----------------------------------------------------------4
					
					if(empty.size() > 0){
						
						for(int p = 0; p < empty.size(); p++) {
							Control.lot_of_units.set(m, empty.get(p));
							m++;
						}
					}
					


	
				
				
				
				/*		
				for(int m = 0; m < Control.lot_of_units.size(); m++) {
					Control.lot_of_units.remove(m);
				}
				
	for(int n = 0; n < contact_h.size(); n++) {
		Control.lot_of_units.add(contact_h.get(n));
	}
	
	for(int n = 0; n < contact_t.size(); n++) {
		Control.lot_of_units.add(contact_t.get(n));
	}
	for(int n = 0; n < new_lot_units.size(); n++) {
		Control.lot_of_units.add(new_lot_units.get(n));
	}
//END BATTLE MODUL
	*/
				
//	Control.lot_of_units = new_lot_units + contact_t;
				//First.lbl.setText("complete: " + Control.count_b + "%");
				//System.out.println("Execution Process kind -b   ...stage " + Control.count_b);
				
//					for(int i = 0; i < Control.lot_of_units.size(); i++) {
//						
//					}
//				for(int i = 0; i < Control.lot_of_units.size(); i++ ) {
//					u = Control.lot_of_units.get(i);
//						if(u.ideology.equals("human")) {
//						u.life -= 5;
//							Control.lot_of_units.set(i, u);
//							break;
//							//WE NEED BOOL VAR SWITCH
//						}
//				}
							
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
//	ArrayList<Unit> add_list (ArrayList<Unit> first, ArrayList<Unit> second) {
//		
//		for(int i = 0; i < first.size(); i++) {
//			first
//		}
//		
//		return first;
//	}
	
}

class System_status implements Runnable{

	/*
	 * Класс основного процесса, предназначен для вывода всех данных
	 * а так же здесь гнерируется системное время
	 */
	Unit unit_x = new Unit(0, 0, "",0);
	Unit unit_z = new Unit(0, 0, "",0);
	@Override
	public void run() {
			int time = 1;
			
		try {
			while(true){
				Thread.sleep(1000);
				Basis.lbl4.setText("system_time: " + time + " s.");
				//First.lbl.setText("complete: " + Control.count_b + "%");
				//System.out.println("Execution Process kind -b   ...stage " + Control.count_b);
				time++;
				//! проверка всех систем, то есть раз в секунду
				get_parametrs();
				set_parametrs();
//===FIGHT!!!			
				run_fight();
				
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	void get_parametrs() {
		
		unit_x = Control.lot_of_units.get(0);
//			System.out.println("Unit: " + x.kind + " life: " + x.life + " weapon: " + x.weapon);
			
			Basis.unit1.setText("Unit: " + unit_x.ideology + " life: " + unit_x.life + " weapon: " + unit_x.weapon + " location: " + unit_x.location);
		
			unit_x = Control.lot_of_units.get(1);	
			Basis.unit2.setText("Unit: " + unit_x.ideology + " life: " + unit_x.life + " weapon: " + unit_x.weapon + " location: " + unit_x.location);
			
			unit_x = Control.lot_of_units.get(2);	
			Basis.unit3.setText("Unit: " + unit_x.ideology + " life: " + unit_x.life + " weapon: " + unit_x.weapon + " location: " + unit_x.location);
			
			unit_x = Control.lot_of_units.get(3);	
			Basis.unit4.setText("Unit: " + unit_x.ideology + " life: " + unit_x.life + " weapon: " + unit_x.weapon + " location: " + unit_x.location);
		
		
	}
	
	void set_parametrs() {
		
		for(int i = 0; i < Control.lot_of_units.size(); i++) {
		unit_x = Control.lot_of_units.get(i);
	
//		System.out.println("Unit: " + x.kind + " life: " + x.life + " weapon: " + x.weapon);
		if(unit_x.life <= 0){

boolean flag = true;
			
						if(unit_x.ideology.equals("human") || unit_x.ideology.equals("terminator") && flag ==true){
					 unit_z = unit_x;
					 unit_z.ideology = "";
					 unit_z.life = 0;
					 unit_z.weapon = 0;
					 unit_z.location = 0;
						Control.lot_of_units.set(i, unit_z);
						flag = false;
						//total_human = total_human - 1;
					//	System.out.println(flag + "" + 0);
					 
				 }
		}
		
		}		
	}
	
	void run_fight() {
		/*
		 * Основа для запуска боя, это локация юнитов
		 * если достигается некоторое критическое значение, то запускается процесс боя
		 * battle_flag = true
		 */
		ArrayList<Integer> human_dist = new ArrayList<Integer>();
		ArrayList<Integer> terminator_dist = new ArrayList<Integer>();
		
		for(int i =0; i < Control.lot_of_units.size(); i++) {
			unit_x = Control.lot_of_units.get(i);
				if(unit_x.ideology.equals("human"))human_dist.add(unit_x.location);
				if(unit_x.ideology.equals("terminator"))terminator_dist.add(unit_x.location);
				
		}
		
	if(human_dist.size() > 0 && terminator_dist.size() > 0) {
		int h_dist = 0;
		int t_dist = 0;
		int[] result = new int[human_dist.size() * terminator_dist.size()];
		boolean contact = false;
		int r = 0;
		
			for(int i =0; i < human_dist.size(); i++) {
				h_dist = human_dist.get(i);
				
				for(int k = 0; k < terminator_dist.size(); k++) {
					t_dist = terminator_dist.get(k);
						result[r] = h_dist - t_dist;
						r++;
						
//						
//							if(result <= 3 && result >= -3 && Control.flag_fight == false) {
//								Control.flag_fight = true;
//									Thread fight = new Thread(new Fight());
//										fight.start();
//System.out.println("in first" + result);
////								Control.switch_fight = true;
//							}
//							if((result >= 4 || result <= -4) && Control.flag_fight == true) {
//System.out.println("in second" + result);
//								Control.flag_fight = false;
//							}
				}
			}

			for(int i = 0; i < result.length; i++) {
				//System.out.println(result[i] + " " + i);
				if(result[i] <= 3 && result[i] >= -3) {
					
					contact = true;}
			}
			
			if(contact ==true && Control.flag_fight == false) {
				Control.flag_fight = true;
					Thread fight = new Thread(new Fight());
						fight.start();
//System.out.println("in first" + result);
//				Control.switch_fight = true;
			}
			if(contact == false && Control.flag_fight == true) {
//System.out.println("in second" + result);
				Control.flag_fight = false;
			}
	}
		
	}
	
	}
