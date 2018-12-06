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
		 static  JLabel label_fight = new JLabel();
		 static int i = 0;    

	public Basis(){
        setTitle("# main frame of control #");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(450,345);
        setLocation(400,400);
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
	        	
	        	lbl5.setBounds(10, 65, 350, 40);
	        	lbl6.setBounds(10, 85, 350, 40);
	        	
	        	label_fight.setBounds(10, 105, 250, 40);
	        	
	        	panel.add(lbl);
	        	panel.add(lbl2);
	        	panel.add(lbl3);
	        	panel.add(lbl4);
	        	
	        	panel.add(lbl5);
	        	panel.add(lbl6);
	        	
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
//эта группа юнитов предназначена для ... операций	
		Unit x = new Unit(0,0,"");
		Unit z = new Unit(0,0,"");
		
	static ArrayList<Unit> lot_of_units = new ArrayList<Unit>();
//=====================================================
//BLOCK OF MY CONTROL
	Control() throws InterruptedException, IOException {
//...формируем список юнитов
		Unit u1 = new Unit(0,0,"");
		Unit u2 = new Unit(0,0,"");
		
		lot_of_units.add(u1);
		lot_of_units.add(u2);

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
//----------------------fight-------------------------------
		
		if(command.equals("fight")){
			Thread fight = new Thread(new Fight());
				fight.start();
					flag_fight = true;
		}
		if(command.equals("stop fight"))flag_fight = false;
//----------------------------------------------------------
			System.out.println("you command is: " + command);
			System.out.println("================END=================");
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
				 x = lot_of_units.get(i);

				 if(!x.kind.equals("human") && !x.kind.equals("terminator") && flag == true){
					 z = x;
					 	z.kind = "human";
					 		z.life = 50;
					 			z.weapon = 10;
					 				lot_of_units.set(i, z);
					 					flag = false;
				 }
			 }			
	}

	private void delete_human() {
		boolean flag = true;
			
			for(int i = 0; i < lot_of_units.size(); i++){
				 x = (Unit) lot_of_units.get(i);
				 
				 if(x.kind.equals("human") && flag ==true){
					 z = x;
					 	z.kind = "";
					 		z.life = 0;
					 			z.weapon = 0;
					 				lot_of_units.set(i, z);
					 					flag = false;
				 }
			}
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
	
	Unit u = new Unit(0, 0, "");
	
	@Override
	public void run() {
			System.out.println("fight");
		try {
			while(Control.flag_fight == true){
				Thread.sleep(3000);
				Basis.label_fight.setText("fight   ...state " + Control.flag_fight);
				//First.lbl.setText("complete: " + Control.count_b + "%");
				//System.out.println("Execution Process kind -b   ...stage " + Control.count_b);
				
//					for(int i = 0; i < Control.lot_of_units.size(); i++) {
//						
//					}
				for(int i = 0; i < Control.lot_of_units.size(); i++ ) {
					u = Control.lot_of_units.get(i);
						if(u.kind.equals("human")) {
						u.life -= 5;
							Control.lot_of_units.set(i, u);
							break;
							//WE NEED BOOL VAR SWITCH
						}
				}
							
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
}

class System_status implements Runnable{

	/*
	 * Класс основного процесса, предназначен для вывода всех данных
	 * а так же здесь гнерируется системное время
	 */
	Unit x = new Unit(0, 0, "");
	Unit z = new Unit(0, 0, "");
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
				
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	void get_parametrs() {
		
			x = Control.lot_of_units.get(0);
//			System.out.println("Unit: " + x.kind + " life: " + x.life + " weapon: " + x.weapon);
			
			Basis.lbl5.setText("Unit: " + x.kind + " life: " + x.life + " weapon: " + x.weapon);
		
			x = Control.lot_of_units.get(1);	
			Basis.lbl6.setText("Unit: " + x.kind + " life: " + x.life + " weapon: " + x.weapon);
		
		
	}
	
	void set_parametrs() {
		x = Control.lot_of_units.get(0);
//		System.out.println("Unit: " + x.kind + " life: " + x.life + " weapon: " + x.weapon);
		if(x.life < 0){

boolean flag = true;
			
							 if(x.kind.equals("human") && flag ==true){
					 z = x;
					 z.kind = "";
						z.life = 0;
						z.weapon = 0;
						Control.lot_of_units.set(0, z);
						flag = false;
						//total_human = total_human - 1;
						System.out.println(flag + "" + 0);
					 
				 }
		}
			
	}
	
	
	
	}

