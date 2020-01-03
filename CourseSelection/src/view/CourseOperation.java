package view;

import entity.Student;
import java.util.*;

import biz.SCBiz;
import dao.*;

public class CourseOperation {
	
	public static void show(Student stud) {
		System.out.println("1-继续选课  2-查看所选课程  3-退选  4-返回上一级   5-退出");
		System.out.println("请输入您要选择的操作：");
		Scanner scanner=new Scanner(System.in);
		String option=scanner.nextLine();
		switch (option) {
		case "1" :
			//CourseDao.getInstance().show();
			CourseSelection.show(stud);
			break;
			
		case  "2" :
			SCBiz.CourseShow(stud);
			break;
			
		case "3" :
			SCBiz.courseDelet(stud);
			break;
			
		case "4" :
			MainUI.show(stud);
			break;
			
		case "5":
			return;
			default:
				System.out.println("输入错误！请从新输入");
				CourseOperation.show(stud);
				break;
			
		
		}
		
		
	}
   

}
