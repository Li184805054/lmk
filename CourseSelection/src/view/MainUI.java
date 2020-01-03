package view;

import java.util.Scanner;

import biz.SCBiz;
import entity.Student;

public class MainUI {
	public static void show(Student stu) {
		
		System.out.println("1-�޸����룻2-ѡ�Σ�3-�л��˺ţ� 4-�鿴��ѡ�γ̣� 0-�˳�  ");
		System.out.println("��������Ҫ���еĲ�����");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		
		case "1":
			ModifyPasswordUI.show(stu);
			break;
		case "2":
			CourseSelection.show(stu);
			break;
		case "3":
			LoginUI.show();
		case "4":
			SCBiz.CourseShow(stu);
			break;
		case "0":
			System.out.println("�˳��ɹ���");
			return;
			default:
				System.out.println("�������");
				MainUI.show(stu);
		}
	}
}
