package cn.com.action;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import cn.com.entity.Person;

public class IOTest {

	public static void main(String[] args){
		int count = 0;
		int num = 12;
		byte[] b = new byte[70];
		char[] cbuf = new char[1024];
		File file = new File("d:/ioTest/");
		if(!file.exists()){
			file.mkdir();
		}
		File txtFile = new File("d:/ioTest/text.txt");
		if(!txtFile.exists()){
			try {
				txtFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File outFile = new File("d:/ioTest/out.txt");
		if(!outFile.exists()){
			try {
				outFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
/*	System.out.println(new Person("gongf", "nan", 12, "52213").toString());
		
		try {
			ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(outFile));
			objOutStream.writeObject(new Person("gongf", "nan", 12, "52213"));
			ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(outFile));
			try {
				System.out.println(((Person)(objInputStream.readObject())).getName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
*/
		
/*
		try {
			InputStream inputStream = new FileInputStream(outFile);
			OutputStream outputStream = new FileOutputStream(txtFile);
			
			try {
				int temp = 0;
				while((temp =inputStream.read()) != -1){
				outputStream.write(temp);
				    }
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			
//			try {
//				
//				while((num = inputStream.read(b)) != -1){
//					outputStream.write(b, 0, num);
//
//				}
//			
//			} catch (IOException e) {
//			
//				e.printStackTrace();
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
*/
/*		try {                                                      
			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(txtFile));
			DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outFile));
			try {
				char a = dataInputStream.readChar();
				dataOutputStream.writeChar(a);
				System.out.println(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	*/	
/********************** ×Ö·û²Ù×÷ ******************************************************************************************/
		
/*		try {
			FileReader fileReader = new FileReader("d:/ioTest/out.txt");
			try {
			       fileReader.read(cbuf);
			       FileWriter fileWriter = new FileWriter(new File("d:/ioTest/text.txt"));
			       PrintWriter out = new PrintWriter(System.out);
			       out.print(cbuf);
			       out.flush();
			       out.close();
			       fileWriter.write(cbuf);
			       fileWriter.flush();

				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	*/
		
/*		try {
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
			BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile));
			bufferedReader.read(cbuf);
			bufferedWriter.write(cbuf);
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
			
			BufferedReader outwrite = new BufferedReader(new FileReader(outFile));
	        System.out.println(outwrite.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
*/		
		
/*		try {
			FileWriter writeFile = new FileWriter(txtFile);
		    PrintWriter out = new PrintWriter(writeFile); 
		    out.println(new BufferedReader(new InputStreamReader(System.in)).readLine());
		    writeFile.close();
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
/*		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(txtFile)));
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
			PrintWriter out = new PrintWriter(bufferedWriter);
			try {
			    bufferedReader.read(cbuf);
				bufferedWriter.write(cbuf);

				bufferedWriter.flush();;

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/

		
	}
}
