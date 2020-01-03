package biz;

import java.util.*;
import java.io.*;
import entity.*;
import view.CourseOperation;
import view.OfficialOperation;
import dao.*;

public class CourseBiz {

	public void show(Student stud) {
		CourseDao dao = CourseDao.getInstance();
		dao.show();
		System.out.println("请输入您要选择课程：");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();

		SCBiz scb = new SCBiz();

		Course course2 = (Course) dao.getEntity(option);
		if (course2 != null) {
			scb.courseAdd(course2.getCourseNo(), course2.getCourseName(), course2.getCourseGrade(), stud);
		} else {
			System.out.println("所选课程不存在，请核对后再输入！");
			CourseOperation.show(stud);
		}

		CourseOperation.show(stud);

	}

	public static void CourseAdd() {
		Course course = new Course();

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入您要添加的课程号：");
		String courseNo = scanner.nextLine();
		System.out.println("请输入您要添加的课程名称：");
		String courseName = scanner.nextLine();
		System.out.println("请输入您要添加的课程名学分：");
		String courseGrade = scanner.nextLine();
		course.setCourseNo(courseNo);
		course.setCourseName(courseName);
		course.setCourseGrade(Integer.parseInt(courseGrade));
		try {
			CourseDao.getInstance().insert(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*添加课程成功*");

		OfficialOperation.show();

	}

	public static void showAllCourseInformation() throws Exception {
		FileReader read = new FileReader("courseInformation.txt");
		BufferedReader BR = new BufferedReader(read);
		String len;
		while ((len = BR.readLine()) != null) {
			if(!(len.equals(" "))) {
			String[] allInformation=len.split(" ");
			String courseNo=allInformation[2];
			String courseName=allInformation[0];
			String courseGrade=allInformation[1];
			System.out.println("课程号:"+courseNo+"  "+"课程名："+courseName+"  "+"课程学分："+courseGrade);
			}

		}
	}

	public static void courseDelete() {
		CourseDao CDao=CourseDao.getInstance();
				CDao.show();
		System.out.println("请输入您要删除的课程：");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		Course course=(Course)(CDao.getEntity(option));
		try {
		CDao.update(course);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
