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

	public Basis() {
        setTitle("# main frame of control #");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(550,350);
        setLocation(400,650);
        setVisible(true);
 //==============================================================
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        this.add(panel);
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
    }
}

class Fight extends Thread implements Runnable{
	
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
				time++;
				//! проверка всех систем, то есть раз в секунду
				get_parametrs();
				set_parametrs();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void get_parametrs() {
//..вывод параметров в наш фрейм
		unit_x = Control.lot_of_units.get(0);
		Basis.unit1.setText("Unit: " + unit_x.ideology + " life: " + unit_x.life + " weapon: " + unit_x.weapon + " location: " + unit_x.location);
		
		unit_x = Control.lot_of_units.get(1);	
		Basis.unit2.setText("Unit: " + unit_x.ideology + " life: " + unit_x.life + " weapon: " + unit_x.weapon + " location: " + unit_x.location);
			
		unit_x = Control.lot_of_units.get(2);	
		Basis.unit3.setText("Unit: " + unit_x.ideology + " life: " + unit_x.life + " weapon: " + unit_x.weapon + " location: " + unit_x.location);
			
		unit_x = Control.lot_of_units.get(3);	
		Basis.unit4.setText("Unit: " + unit_x.ideology + " life: " + unit_x.life + " weapon: " + unit_x.weapon + " location: " + unit_x.location);
	}
	
	void set_parametrs() {
//..метод для обнуления юнитов с отрицательным life		
		for(int i = 0; i < Control.lot_of_units.size(); i++) {
		unit_x = Control.lot_of_units.get(i);
			if(unit_x.life <= 0) {
				boolean flag = true;
			
				if((unit_x.ideology.equals("human") || unit_x.ideology.equals("terminator")) && flag ==true){
					System.out.println("blam"); 
					unit_z = unit_x;
					 unit_z.ideology = "";
					 unit_z.life = 0;
					 unit_z.weapon = 0;
					 unit_z.location = 0;
						Control.lot_of_units.set(i, unit_z);
						flag = false;
				}
			}
		}		
	}
}
