package Employee_project;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<employees> hs = new HashSet<employees>();
		employees a = new employees(101,"RAM");
		employees b = new employees(102,"GOPI");
		employees c = new employees(103,"ALEX");
		employees d = new employees(104,"GOKUL");
		hs.add(a);
		hs.add(b);
		hs.add(c);
		hs.add(d);
		System.out.println("PLEASE SELECT THE FOLLOWING OPTIONS");
		int choice =10;
		int eid;
		String ename;
		while(choice!=5) {
			System.out.println("1.ADD EMPLOYEE\n2.DELETE AN EMPLOYEE\n3.UPDATE AN EMPLOYEE\n4.TO DISPLAY AN EMPLOYEE\n5.TO EXIT");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("ENTER ID OF THE EMPLOYEE");
			     eid = sc.nextInt();
				sc.nextLine();
				System.out.println("ENTER THE NAME OF THE EMPLOYEE");
				String ename1 = sc.nextLine();
				employees e = new employees(eid,ename1);
				e.display();
				hs.add(e);
				System.out.println("EMPLOYEEE ADDED SUCCESSFULY!!");
				break;
			case 2:
			    System.out.println("ENTER THE ID THAT NEED TO BE REMOVED");
			    eid = sc.nextInt();
			    sc.nextLine();
			    boolean found = false;
			    for (employees e5 : hs) {
			        if (e5.eid == eid) {
			            found = true;
			            break; // Exit loop once the employee is found
			        }
			    }
			    if (!found) {
			        System.out.println("DETAILS NOT FOUND");
			    } else {
			        System.out.println("DO YOU WANT TO DELETE " + eid + "?");
			        System.out.println("PRESS 1 TO DELETE\nPRESS 0 TO SKIP TO MAIN MENU");
			        int option = sc.nextInt();
			        if (option == 1) {
			            Iterator<employees> itr = hs.iterator();
			            while (itr.hasNext()) {
			                employees emp = itr.next();
			                if (emp.getEid() == eid) {
			                    itr.remove(); // Remove the employee using iterator
			                    System.out.println("Record deleted ");
			                    break; // Exit loop after removal
			                }
			            }
			        } else {
			            break;
			        }
			        // Print remaining employees after removal
			        for (employees emp : hs) {
			            System.out.println(emp.getEname() + emp.getEid());
			        }
			    }
			    break; // Make sure to break out of the switch-case after case 2

			case 3:
				System.out.println("PLEASE ENTER THE EMPLOYEE ID TO UPDATE THE EMPLOYEE");
				eid=sc.nextInt();
				sc.nextLine();
				found=false;
				Iterator<employees> itr = hs.iterator();
				 while (itr.hasNext()) {
					 employees emp = itr.next();
		                if (emp.getEid() == eid) {
		                	found=true;
		                	System.out.println("ENTER THE NAME TO BE UPDATED");
				        	ename=sc.nextLine();
				        	emp.setEname(ename);
				        	System.out.println("UPDATED EMPLOYEE DETAILS:");
				              for (employees emp1 : hs) {
				                  System.out.println(emp1.getEname() + " " + emp1.getEid());
				              }
		                                         }
		                
		          if(!found) {
		        	   System.out.println("DETAILS NOT FOUND!!PLEASE TRY AGAIN");
		          }
		          else {
		              System.out.println("UPDATED EMPLOYEE DETAILS:");
		              for (employees emp1 : hs) {
		                  System.out.println(emp1.getEname() + " " + emp1.getEid());
		              }
		          }
		          break;
				 }
				
				break;
			case 4:
				for (employees emp1 : hs) {
	                  System.out.println(emp1.getEname() + " " + emp1.getEid());
	              }
				break;

			
			default:
				System.out.println("ENTER VALID CHOICE: ");
				choice = sc.nextInt();
                break;


		}

	}
}}