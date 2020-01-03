package dao;

import entity.*;
import view.CourseOperation;

import java.util.*;
import java.io.*;

public class SCDao implements IDao {
	private static SCDao instance = null;
	static Student student = null;
	static HashMap<String, SC> studentCourse = new HashMap<String, SC>();
	
	private SCDao() throws Exception {
		
		FileReader read = new FileReader("SCDaoInformation.txt");
		BufferedReader BR = new BufferedReader(read);
		String len = null;
		String SCDoInfor = null;
		while ((len = BR.readLine()) != null) {
			SC scc = new SC();
			SCDoInfor = len;
			String[] information = SCDoInfor.split(" ");
			String iD=information[0].substring(0, 9);
			scc.setStudentNo(iD);
			scc.setCourseNo(information[1]);
		
			studentCourse.put(iD+ information[1], scc);
		}
		BR.close();

	}

	public static SCDao getInstance() {
		if (instance == null) {
			synchronized (SCDao.class) {
				if (instance == null) {
					try {
						instance = new SCDao();
					} catch (Exception E) {
						E.printStackTrace();
					}
					return instance;
				}
			}
		}
		return instance;
	}

	public String[] showStudenAllCourse(String Id) {
		String[] AllCou = new String[20];
		String len = null;
		int i = 0;
		for(Map.Entry<String, SC> item:studentCourse.entrySet()) {
			SC studenCourse=item.getValue();
			if(item.getKey().contains(Id)) {
				AllCou[i]=studenCourse.getCourseNo();
				i++;
			}
			
		}
		
		return AllCou;
	}

	public void insert(IEntity entity) throws Exception {
		SC sc = (SC) entity;
		FileWriter writer = new FileWriter("SCDaoInformation.txt", true);
		BufferedWriter BW = new BufferedWriter(writer);
		String SS = sc.getStudentNo()+sc.getCourseNo() + " " + sc.getCourseNo() + " ";
		BW.write("\n");
		BW.write(SS);
		
		BW.close();
		studentCourse.put(sc.getStudentNo() + sc.getCourseNo(), sc);
	}
	//返回该学生所选的课程
	public IEntity getEntity(String Id) {
		Set keySet = studentCourse.keySet();
		Iterator it = keySet.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = studentCourse.get(key);
			SC value1 = (SC) value;
			if (value1.getStudentNo().equals(Id)) {
				return value1;
			}

		}

		return null;
	}

	
	
	
//退选

	public void delete(IEntity entity) throws Exception {
		System.out.println("请输入您要退选的课程号");
		CourseDao.getInstance().show();
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();	
			
		Student student2 = (Student) entity;
		String ID = (student2.getStudentNo() + number);	
		for(Map.Entry<String,SC> item: studentCourse.entrySet()) {
			String strC=item.getKey();
			if(strC.equals(ID)) {
				studentCourse.remove(item.getKey());
				break;
			}
			
		}
		
		// 把修改后的信息再次存入文件
		FileWriter write = new FileWriter("SCDaoInformation.txt");
		BufferedWriter bw = new BufferedWriter(write);
		for(Map.Entry<String, SC> item: studentCourse.entrySet()) {
			
			String infor = item.getKey() + " " + item.getValue().getCourseNo() + " ";
			bw.write(infor);
			bw.write("\n");
		
		}
		bw.close();
		

	}
	
	
	public void update(IEntity entity)throws Exception {
		SC sc=(SC)entity;
		

	}

	public HashMap<String, IEntity> getAllEntities() {

		return null;
	}

}
