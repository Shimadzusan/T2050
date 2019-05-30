package CPU_Simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Start {
static RAM_Modul ram = new RAM_Modul();

	public static void main(String[] args) throws IOException {
		//step one
		System.out.println("Включить!");
		System.out.println("...это когда напряжение на все устройства подано");
		//System.out.println();
		System.out.println("==========================================");
		System.out.println();
//-----------------------------------------------------------------------------------
		
		InputStream first_stream = System.in;
			Reader reader = new InputStreamReader(first_stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				System.out.println("Press <on> if You wish to start");
				
			boolean switch_0 = false;	
			String z = buffer.readLine();
			if(z.equals("on"))switch_0 = true;
		
			while(switch_0 == true) {
			System.out.println("Press <off> <read> <write>");
			String s = buffer.readLine();
				System.out.println(s);
				System.out.println();
				if(s.equals("off"))switch_0 = false;
		}
			System.out.println("programm end.");
		
	}
	public static int read() {
		System.out.println(ram.get_value_from_cell(1));
		return -1;
	}
	
	public static void write() {
		ram.set_value_to_cell(1, 1005);
	}

}

class RAM_Modul {
//..Адресное_пространство: 8 ячеек_памяти, размер_каждой 8 bit 
/*
 * 	| cell_0 | cell_1 | cell_2 | ...> 3-bit address
 * 	+--------+--------+--------+
 * 	|01010101|01010101|01010101| ...> 8-bit data
 * 	+--------+--------+--------+
 * 
 */
	int address_0000 = 0;
	int address_0001 = 1;
	int address_0010 = 2;
	int address_0011 = 3;
	int address_0100 = 4;
	int address_0101 = 5;
	int address_0110 = 6;
	int address_0111 = 7;
	
	int get_value_from_cell(int number_cell) {
		switch(number_cell) {
		case 0 : return address_0000;
		case 1 : return address_0001;
		case 2 : return address_0010;
		case 3 : return address_0011;
		case 4 : return address_0100;
		case 5 : return address_0101;
		case 6 : return address_0110;
		case 7 : return address_0111;
		}
		return -1;
	}
	
	void set_value_to_cell(int number_cell, int value) {
		switch(number_cell) {
		case 0 : address_0000 = value;
		case 1 : address_0001 = value;
		case 2 : address_0010 = value;
		case 3 : address_0011 = value;
		case 4 : address_0100 = value;
		case 5 : address_0101 = value;
		case 6 : address_0110 = value;
		case 7 : address_0111 = value;
		}
	}
	
	boolean set() {
		return true;
	}
	
}