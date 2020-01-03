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

	// ��¼
	public void login(String studentNo, String studentPassword) {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û�������");                      
			System.out.println("���������룺");
			LoginUI.show();
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("��¼�ɹ�");
			MainUI.show(student);
		} else {
			System.out.println("���벻��ȷ");
			LoginUI.show();// ���벻��ȷ�Ļ������ѧ��Ӧ��Ϊ�� student==null
		}

	}

	// ע�ᣬҵ���߼�ʵ��
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

			System.out.println("ע��ɹ���");
			MainUI.show(student);
		} else {
			System.out.println("ǰ�����벻һ�£������½���ѡ��");
			Student student1 = (Student) studentDao.getEntity(studentNo);
			MainUI.show(student1);
		}
	}

	public static void StudenDelet() throws Exception{

		System.out.println("��������Ҫɾ����ѧ��ѧ�ţ�");
		Scanner scanner = new Scanner(System.in);
		String ID = scanner.nextLine();
		Student student = (Student) StudentDao.getInstance().getEntity(ID);
		if (student != null) {
			StudentDao.getInstance().delete(student);
			System.out.println("*ɾ��ѧ���ɹ�*");
		}else 
			System.out.println("��ѧ�������ڣ�");
		
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
			System.out.println("ѧ��:"+student1.getStudentNo()+" "+"����:"+student1.getStudentName()+"  "+"Ժϵ��"+student1.getStudentDepartment());
			
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
