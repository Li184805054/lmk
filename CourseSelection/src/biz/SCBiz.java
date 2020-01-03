package biz;
import java.util.*;

import entity.*;
import view.CourseOperation;
import dao.*;


public class SCBiz {
	SCDao scadao;
	
	
	public void courseAdd(String number,String course,int course_grade,Student student ) {
		
		Course course1=new Course();
		course1.setCourseNo(number);
		course1.setCourseName(course);
		course1.setCourseGrade(course_grade);
		
		
		SC sc=new SC();
		sc.setCourseNo(course1.getCourseNo());
		sc.setStudentNo(student.getStudentNo());
		
		SCDao scdao= SCDao.getInstance();
		try{
			scdao.insert(sc); 
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
		System.out.println("选课完成！");

	}
	public static void CourseShow(Student student) {
		SCDao scdao=SCDao.getInstance();
		
		String[] ALL=scdao.showStudenAllCourse(student.getStudentNo());
		if(ALL!=null) {
		System.out.println("已选课程：");
		for(int i=0;i<ALL.length;i++) {
			String coursE=ALL[i];
			if(CourseDao.getInstance().getEntity(coursE)!=null) {
				Course Course1=(Course)CourseDao.getInstance().getEntity(coursE);
				System.out.println(Course1.getCourseName()+"  "
				+Course1.getCourseGrade()+ "学分");
				
			}
			
		}
		}else 
			System.out.println("选课为空！");
		
		CourseOperation.show(student);
			
	}
	

	public static void courseDelet(Student student ){
		SCDao scdao=SCDao.getInstance();
		System.out.println("请输入您要退选的学号：");
		Scanner scanner=new Scanner(System.in);
		String No=scanner.nextLine();
		
		try {
		scdao.delete(student);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("*退选完成*");

		CourseOperation.show(student);
		
	}
	


}
