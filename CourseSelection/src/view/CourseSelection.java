package view;

import java.util.Scanner;
import biz.CourseBiz;
import entity.*;
import dao.*;

public class CourseSelection {
//184804354 �α��� �� 123456 20 ���ѧԺ
	public static void main(String[] args) {
	
		System.out.println("��ѡ�������ݣ�1-ѧ��   2-����Ա  3-ע��");
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
				System.out.println("�����������������룡");
				CourseSelection.main(args);
				break;
		}
		
	}
	public static void show(Student stu){
		
		CourseBiz coursebiz=new CourseBiz();
		
		coursebiz.show(stu);
		

	}

}
