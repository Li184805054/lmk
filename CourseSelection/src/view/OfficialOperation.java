package view;

import java.util.*;

import biz.CourseBiz;
import biz.SCBiz;
import biz.StudentBiz;
import dao.CourseDao;

public class OfficialOperation {
	String AdministratorPW;
	String AdministratorId;

	public OfficialOperation() {
		System.out.println("欢迎进入管理员模式！");
		System.out.println("请输入管理员账号：");
		Scanner scanner = new Scanner(System.in);
		AdministratorId = scanner.nextLine();
		System.out.println("请输入管理员密码：");
		AdministratorPW = scanner.nextLine();
		if (AdministratorId.equals(CourseDao.getInstance().getAdministratorId())) {

			if (AdministratorPW.equals(CourseDao.getInstance().getAdministratorPW())) {

			} else {
				System.out.println("密码输入错误请重新输入！");
				new OfficialOperation();
			}

		} else {
			System.out.println("账号输入错误！");
			new OfficialOperation();
		}
	}

	public static void show() {
		System.out.println("请输入您要进行的操作：");
		System.out.println("1-删除学生  2-添加课程  3-删除课程  4-显示全部学生信息  5-显示所有课程信息  6-退出");
		Scanner scanner1 = new Scanner(System.in);
		String option1 = scanner1.nextLine();
		switch (option1) {
		case "1":
			try {
				StudentBiz.StudenDelet();
			} catch (Exception e) {
				e.printStackTrace();
			}
			OfficialOperation.show();
			break;

		case "2":
			CourseBiz.CourseAdd();
			OfficialOperation.show();
			break;

		case "3":
			CourseBiz.courseDelete();
			OfficialOperation.show();
			break;

		case "4":
			StudentBiz.showAllStudentInformation();
			OfficialOperation.show();
			break;
			
		case "5":
			try {
				CourseBiz.showAllCourseInformation();
			} catch (Exception e) {
				e.printStackTrace();
			}
			OfficialOperation.show();
			break;
			
		case "6":
			return;
				
		default:
			System.out.println("输入错误请重新登陆");
			OfficialOperation.show();
			break;

		}

	}
}
