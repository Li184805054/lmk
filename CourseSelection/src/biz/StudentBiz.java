package biz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import dao.SCDao;
import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import view.LoginUI;
import view.MainUI;
import view.OfficialOperation;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;

	// 登录
	public void login(String studentNo, String studentPassword) {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("用户不存在");                      
			System.out.println("请重新输入：");
			LoginUI.show();
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("登录成功");
			MainUI.show(student);
		} else {
			System.out.println("密码不正确");
			LoginUI.show();// 密码不正确的话这里的学生应该为空 student==null
		}

	}

	// 注册，业务逻辑实现
	public void register(String studentNo, String studentName, String studentGender, int studentAge,
			String studentDepartment, String firstPassword, String secondPassword) {
		if (firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentGender(studentGender);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			studentDao = StudentDao.getInstance();
			try {
				studentDao.insert(student);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("注册成功！");
			MainUI.show(student);
		} else {
			System.out.println("前后密码不一致，请重新进行选择！");
			Student student1 = (Student) studentDao.getEntity(studentNo);
			MainUI.show(student1);
		}
	}

	public static void StudenDelet() throws Exception{

		System.out.println("请输入您要删除的学生学号：");
		Scanner scanner = new Scanner(System.in);
		String ID = scanner.nextLine();
		Student student = (Student) StudentDao.getInstance().getEntity(ID);
		if (student != null) {
			StudentDao.getInstance().delete(student);
			System.out.println("*删除学生成功*");
		}else 
			System.out.println("该学生不存在！");
		
		OfficialOperation.show();

	}
	
	public static void showAllStudentInformation() {
		
		HashMap<String,IEntity> allStudents = StudentDao.getInstance().getAllEntities();
		Set<String> keySet = allStudents.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			IEntity value=allStudents.get(key);
			Student student1=(Student)value;
			System.out.println("学号:"+student1.getStudentNo()+" "+"姓名:"+student1.getStudentName()+"  "+"院系："+student1.getStudentDepartment());
			
		}
		
		
	}
	
	public static void modifyPW(String stuNo) {
		StudentDao stuDao=StudentDao.getInstance();
		Student stud=(Student)stuDao.getEntity(stuNo);
		try {
		stuDao.update(stud);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
