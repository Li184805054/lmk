package view;

import java.util.Scanner;

import biz.SCBiz;
import entity.Student;

public class MainUI {
	public static void show(Student stu) {
		
		System.out.println("1-修改密码；2-选课；3-切换账号； 4-查看已选课程； 0-退出  ");
		System.out.println("请输入您要进行的操作：");
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
			System.out.println("退出成功！");
			return;
			default:
				System.out.println("输入错误！");
				MainUI.show(stu);
		}
	}
}
