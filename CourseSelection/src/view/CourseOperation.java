package view;

import entity.Student;
import java.util.*;

import biz.SCBiz;
import dao.*;

public class CourseOperation {
	
	public static void show(Student stud) {
		System.out.println("1-����ѡ��  2-�鿴��ѡ�γ�  3-��ѡ  4-������һ��   5-�˳�");
		System.out.println("��������Ҫѡ��Ĳ�����");
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
				System.out.println("����������������");
				CourseOperation.show(stud);
				break;
			
		
		}
		
		
	}
   

}
