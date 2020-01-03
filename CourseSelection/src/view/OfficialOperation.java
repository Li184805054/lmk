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
		System.out.println("��ӭ�������Աģʽ��");
		System.out.println("���������Ա�˺ţ�");
		Scanner scanner = new Scanner(System.in);
		AdministratorId = scanner.nextLine();
		System.out.println("���������Ա���룺");
		AdministratorPW = scanner.nextLine();
		if (AdministratorId.equals(CourseDao.getInstance().getAdministratorId())) {

			if (AdministratorPW.equals(CourseDao.getInstance().getAdministratorPW())) {

			} else {
				System.out.println("��������������������룡");
				new OfficialOperation();
			}

		} else {
			System.out.println("�˺��������");
			new OfficialOperation();
		}
	}

	public static void show() {
		System.out.println("��������Ҫ���еĲ�����");
		System.out.println("1-ɾ��ѧ��  2-��ӿγ�  3-ɾ���γ�  4-��ʾȫ��ѧ����Ϣ  5-��ʾ���пγ���Ϣ  6-�˳�");
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
			System.out.println("������������µ�½");
			OfficialOperation.show();
			break;

		}

	}
}
