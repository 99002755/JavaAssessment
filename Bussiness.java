package com.example.demo;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

public class Bussiness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		long inputId = 0;
		String inputName = null;
		Character ge = null;
		String mail;
		String input = sc.nextLine();
		String inputs[] = input.split("\\,");
		try {
		
		 inputId=Long.parseLong(inputs[0]);
		
		 inputName = inputs[1];
		
		 ge = inputs[2].charAt(0);
		
		 mail = inputs[3];
		
		}
		catch(Exception e) {
			System.out.println("Invalid Input");
		}
	
		JSONParser parser = new JSONParser();
		
		try {
	         Object obj = parser.parse(new FileReader("C:\\Users\\40012858\\Desktop\\data.json"));
	         
	         JSONArray employeeList = (JSONArray) obj;
	         
	         System.out.println("Customer Details:");
	         
	         employeeWithId( inputId,employeeList);
	         
	         employeeWithName(inputName,employeeList);
	         
	         employeeOfGender(ge,employeeList);
	         

	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		
	}

	private static void employeeOfGender(Character ge, JSONArray employeeList) {
		// TODO Auto-generated method stub
		int count = 0;
		String genderout = "";
		genderout = (ge == 'M') ? "Male": "Female";
		
           for(int i = 0; i<employeeList.size();i++) {
			
			JSONObject employeeObject = (JSONObject)employeeList.get(i);
			String get = (String)employeeObject.get("gender");
			
			Character ch = get.charAt(0);
			
			if(ch==ge) {
				count++;
			}
			
		}
           System.out.println("Total "+genderout+" in the list is :"+count);
		
	}

	private static void employeeWithName(String inputName, JSONArray employeeList) {
		// TODO Auto-generated method stub
		
       int flag=0;
		
		for(int i = 0; i<employeeList.size();i++) {
			
			JSONObject employeeObject = (JSONObject)employeeList.get(i);
			String name = (String)employeeObject.get("name");
			
			if(name.equalsIgnoreCase(inputName)) {
				System.out.println(inputName+"-- "+employeeObject.toJSONString());
				flag=1;
				return;
			}
			
		}
		if(flag==0) {
			System.out.println(inputName+"-- Customer name NOT Found ");
		}
		
	}

	private static void employeeWithId(long inputId, JSONArray employeeList) {
		// TODO Auto-generated method stub
		int flag=0;
		
		for(int i = 0; i<employeeList.size();i++) {
			
			JSONObject employeeObject = (JSONObject)employeeList.get(i);
			long id = (long)employeeObject.get("id");
			
			if(id==inputId) {
				System.out.println(employeeObject.toString());
				flag=1;
				return;
			}
			
		}
		if(flag!=1) {
			System.out.println("No customer available");
		}

	}

}
