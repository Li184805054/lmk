package view;
import dao.StudentDao;
import java.util.Scanner;

import biz.StudentBiz;
import entity.Student;

public class ModifyPasswordUI {
	
	
	public static void show(Student Stu) {
		Scanner scanner;
		String new_password;
		String old_password;
	    String student_id;
	    Student student;
	    StudentDao studentDao = StudentDao.getInstance();
	    
		scanner = new Scanner(System.in);
		student_id= Stu.getStudentNo();
		System.out.println("���������������룺");
		new_password = scanner.nextLine();
		
		student=(Student)studentDao.getEntity(student_id);
		
		while(student!=null){
		System.out.println("����������ԭ���룺");
		old_password=scanner.nextLine();
		
		if(old_password.equals(student.getStudentPassword())){
		student.setStudentPassword(new_password);
		StudentBiz.modifyPW(student.getStudentNo());
		System.out.println("�޸ĳɹ���");
		MainUI.show(student);
		break;
		}
		else{
			System.out.println("ԭ��������޸�ʧ��!");
			MainUI.show(student);
		}
		
		}
		System.out.println("��ѧ�������ڣ�");
		MainUI.show(student);

	}
}
