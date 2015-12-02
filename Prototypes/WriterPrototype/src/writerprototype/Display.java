/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writerprototype;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mg3Blue
 */
public class Display {

    Scanner scanner = new Scanner(System.in);
    Personal e1;
    Experience e2;
    Education e3;
    Skills e4;
    
    public Personal AddPersonal() {
        e1 = new Personal();
        String s;
        System.out.println("Enter Name");
        e1.setName(scanner.nextLine());
        System.out.println("Enter Phone #");
        e1.setPhone(scanner.nextLine());
        System.out.println("Enter Email");
        e1.setEmail(scanner.nextLine());
        return e1;
    }
    public Experience AddExperience() {
       
        e2 = new Experience();
        System.out.println("Enter No. of Jobs");
        int n1 = scanner.nextInt();
        
        String[][] xx = new String[n1+1][6];
        xx[0][0] = "Employer";
        xx[0][1] = "Supervisor";
        xx[0][2] = "City";
        xx[0][3] = "State";
        xx[0][4] = "Description";
        xx[0][5] = "Years";
        scanner.nextLine();
        if(xx.length > 0){
            for(int i = 1; i < xx.length; i++){
                for(int j = 0; j < xx[0].length; j++){
                    System.out.println("Enter "+ xx[0][j]+ " for job "+ i);
                    xx[i][j] = scanner.nextLine();
                }
            }
        }
        
        e2.setExperienceElements(xx);
        e2.setData("hello???");
        return e2;
    }
    
    public Education AddEducation() {
        e3 = new Education();
        System.out.println("Enter No. of Schools Attended");
        int n1 = scanner.nextInt();
        
        String[][] xx = new String[n1+1][4];
        xx[0][0] = "School Name";
        xx[0][1] = "City";
        xx[0][2] = "State";
        xx[0][3] = "Years";
        scanner.nextLine();
        if(xx.length > 0){
            for(int i = 1; i < xx.length; i++){
                for(int j = 0; j < xx[0].length; j++){
                    System.out.println("Enter "+ xx[0][j]+ " for school "+ i);
                    xx[i][j] = scanner.nextLine();
                }
            }
        }
        
        e3.setEducationElements(xx);
        e3.setData("hello???");
        return e3;
    }

    public Skills AddSkills() {
        e4 = new Skills();
        System.out.println("Enter Number of Skillz:");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] x = new String[n];
        for (int i = 0; i < x.length; i++) {
            System.out.println("Enter Skill :"+ i);
            x[i] = scanner.nextLine();  
        }
        e4.setSkills(x);
        return e4;
    }

    public void Display(HTMLGenerator gen) throws IOException {

        System.out.println("Adding Personal Information...");
        e1 = AddPersonal();
        gen.appendResumeElement(e1);

        System.out.println("Adding Experience...");
        e2 = AddExperience();
        gen.appendResumeElement(e2);

        System.out.println("Adding Education...");
        e3 = AddEducation();
        gen.appendResumeElement(e3);

        System.out.println("Adding Skills...");
        e4 = AddSkills();
        gen.appendResumeElement(e4);

        System.out.println("Generating Web page");
        System.out.println("Enter The Web page Name");
        String fname = scanner.next();
        gen.generateHTMLPage(fname);
        System.out.println(" Web page: " + fname + "was generated");    
    }
}