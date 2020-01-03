package view;

import java.util.Scanner;
import biz.CourseBiz;
import entity.*;
import dao.*;

public class CourseSelection {
//184804354 段宾宾 男 123456 20 软件学院
	public static void main(String[] args) {
	
		System.out.println("请选择你的身份：1-学生   2-管理员  3-注册");
		Scanner scanner=new Scanner(System.in);
		String option =scanner.nextLine();
		switch(option) {
		case "1":
		  LoginUI.show();
		  break;
		case "2":
			OfficialOperation OF=new OfficialOperation();
			OF.show();
			break;
		case "3":
			RegisterUI.show();
			break;
			default:
				System.out.println("输入有误，请重新输入！");
				CourseSelection.main(args);
				break;
		}
		
	}
	public static void show(Student stu){
		
		CourseBiz coursebiz=new CourseBiz();
		
		coursebiz.show(stu);
		

	}

}
