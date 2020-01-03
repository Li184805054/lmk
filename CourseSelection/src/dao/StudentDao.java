package dao;

import entity.IEntity;
import entity.SC;
import entity.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.*;

public class StudentDao implements IDao {
	private HashMap<String, IEntity> allStudents = new HashMap<String, IEntity>();
	private static StudentDao instance = null;
	private Student student = null;
	private HashMap<String, Student> students = new HashMap<String, Student>();

	private StudentDao() throws Exception {

		FileReader read = new FileReader("Student.txt");
		BufferedReader br = new BufferedReader(read);
		String str=null;

		while ((str = br.readLine()) != null) {
			student = new Student();
			String informations = str;
			if (str.equals(" ")) {
				
			}else {
				String[] information = informations.split(" ");
				student.setStudentNo(information[0]);
				student.setStudentName(information[1]);
				student.setStudentGender(information[2]);
				student.setStudentPassword(information[3]);
				student.setStudentAge(Integer.valueOf(information[4]));
				student.setStudentDepartment(information[5]);
				students.put(student.getStudentNo(), student);
			}

		}
		br.close();

	}

	public static StudentDao getInstance() {
		if (instance == null) {
			synchronized (StudentDao.class) {
				if (instance == null) {
					try {
						instance = new StudentDao();
					} catch (Exception e) {
						e.printStackTrace();
					}

					return instance;
				}
			}
		}
		return instance;
	}

	public void insert(IEntity entity) throws Exception {
		// TODO Auto-generated method stub
		Student st = (Student) entity;
		FileWriter writer = new FileWriter("Student.txt", true);
		BufferedWriter bW = new BufferedWriter(writer);
		String STUD = st.getStudentNo() + " " + st.getStudentName() + " " + st.getStudentGender() + " "
				+ st.getStudentPassword() + " " + st.getStudentAge() + " " + st.getStudentDepartment() + " ";
		
		bW.write(STUD);
		bW.write("\n");
		bW.close();
		students.put(st.getStudentNo(), st);
	}

	public void delete(IEntity entity) throws Exception {
		Student student = (Student) entity;

		for (Map.Entry<String, Student> item : students.entrySet()) {
			if ((item.getValue().getStudentNo()).equals(student.getStudentNo())) {
				students.remove(item.getKey());
				break;
			}

		}

		FileWriter write = new FileWriter("Student.txt");
		BufferedWriter bw = new BufferedWriter(write);
		// 把修改后的信息再次存入文件
		for (Map.Entry<String, Student> item : students.entrySet()) {
			Student studenT = item.getValue();
			String infor = studenT.getStudentNo() + " " + studenT.getStudentName() + " " + studenT.getStudentGender()
					+ " " + studenT.getStudentPassword() + " " + studenT.getStudentAge() + " "
					+ studenT.getStudentDepartment() + " ";
			bw.write(infor);
			bw.write("\n");

		}
		bw.close();

	}

	public void update(IEntity entity) throws Exception {
		Student student = (Student) entity;
		// 遍历先这个删除学生
		for (Map.Entry<String, Student> item : students.entrySet()) {

			if ((item.getKey()).equals(student.getStudentNo())) {
				students.remove(item.getKey());
				break;
			}

		}

		students.put(student.getStudentNo(), student);

		FileWriter writer = new FileWriter("Student.txt");
		BufferedWriter BW = new BufferedWriter(writer);

		for (Map.Entry<String, Student> item : students.entrySet()) {
			Student student2 = item.getValue();

			String studInformation = student2.getStudentNo() + " " + student2.getStudentName() + " "
					+ student2.getStudentGender() + " " + student2.getStudentPassword() + " " + student2.getStudentAge()
					+ " " + student2.getStudentDepartment() + " ";

			BW.write(studInformation);
			BW.write("\n");

		}
		BW.close();

	}

//返回所有学生信息
	public HashMap<String, IEntity> getAllEntities() {

		Set<String> keySet1 = students.keySet();
		Iterator<String> it1 = keySet1.iterator();
		while (it1.hasNext()) {
			String key1 = it1.next();
			Student student = students.get(key1);
			IEntity ientity = (IEntity) student;
			allStudents.put(key1, ientity);

		}
		return allStudents;
	}

	public IEntity getEntity(String Id) {
		IEntity entity = (IEntity) students.get(Id);

		return entity;
	}

}
