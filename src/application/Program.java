package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.service.LogService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			LogService log = new LogService();
			System.out.println("Enter file full path: ");
			String path = sc.nextLine();
			try(BufferedReader br = new BufferedReader(new FileReader(path))) {
				String line = br.readLine();
				while(line != null) {
					String[] data = line.split(" ");
					String name = data[0];
					String date = data[1];
					log.insertLog(name, date);
					line = br.readLine();
				}
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("Total users: " + log.getLog().size());
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}

	}

}
