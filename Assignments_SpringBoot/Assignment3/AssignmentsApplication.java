package com.shroti.Assignments;
import com.shroti.Assignments.Assignment3.Marksheet;
import com.shroti.Assignments.Assignment3.marksheetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class AssignmentsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AssignmentsApplication.class, args);
		marksheetRepository marksheetRepo = context.getBean(marksheetRepository.class);
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter your Admno: ");
		int admno = sc.nextInt();
		System.out.println("Enter Student name: ");
		String name = sc.next();
		System.out.println("Enter marks1");
		int marks1 = sc.nextInt();
		System.out.println("Enter marks2: ");
		int marks2 = sc.nextInt();
		int total = marks1 + marks2;
		int avg = total / 2;
		String result ;
		if(avg >33){
			result = "pass";
		}
		else{
			result = " fail ";
		}
		System.out.println("Total : " + total);
		System.out.println("Avg is : " + avg);
		System.out.println("Result is : " + result);

		Marksheet mark = new Marksheet();
		mark.setAdmno(admno);
		mark.setName(name);
		mark.setMarks1(marks1);
		mark.setMarks2(marks2);
		mark.setTotal(total);
		mark.setAverage(avg);
		mark.setResult(result);
		marksheetRepo.save(mark);

		System.out.println("===========DATA SAVED===========");
	}
}
