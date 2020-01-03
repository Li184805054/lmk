package dao;
import entity.*;
import java.util.*;
import java.io.*;

public class CourseDao implements IDao {
	private static CourseDao instance;
	//Student student;
	HashMap<String,Course> stuCour=null; 
	//ArrayList<Course> arralist; 
	String AdministratorId=null;
	String AdministratorPW=null;
	
	private CourseDao()throws Exception {
	//arralist=new ArrayList<Course>();
		stuCour=new HashMap<String,Course>();
		
		FileReader AdministratorInformation=new FileReader("AdInformation.txt");
		BufferedReader AdInfor=new BufferedReader(AdministratorInformation);
		
		FileReader courseInformation=new FileReader("courseInformation.txt");
		BufferedReader courInfor=new BufferedReader(courseInformation);
		
		String len;
		while((len=AdInfor.readLine())!=null) {
			String str=len;
			String[] str1=str.split(" ");
			AdministratorId=str1[0];
			AdministratorPW=str1[1];
					
		}
		
		while((len=courInfor.readLine())!=null) {
			String str=len;
			if(!(str.equals(" "))) {
			String[] str1=str.split(" ");
			String CourseName=str1[0];
			String CourseGrade=str1[1];
			String CourseNo=str1[2];
			
			
			Course course1=new Course();
			course1.setCourseName(CourseName);
			course1.setCourseGrade(Integer.valueOf(CourseGrade));
			course1.setCourseNo(CourseNo);
			stuCour.put(CourseNo, course1);
			}
		}
		
		AdInfor.close();
		courInfor.close();
		
		
	
	}
	
public void show(){
	    Set keySet=stuCour.keySet();
		Iterator it=keySet.iterator();
		while(it.hasNext()) {
			Object key=it.next();
			Object value=stuCour.get(key);
			Course value1=(Course)value;
			System.out.println(value1.getCourseNo()+":"+value1.getCourseName());
		}	
		
	}


	public static CourseDao getInstance() {
		if(instance == null) {
			synchronized(CourseDao.class) {
				if(instance == null) {
					try {
					instance = new CourseDao();
					}catch(Exception e) {
						e.printStackTrace();
					}
					return instance;
				}
			}
		}
		return instance;
		}
	
	
	public void insert(IEntity entity)throws Exception {
		Course CS=(Course)entity;
		FileWriter writer=new FileWriter("courseInformation.txt",true);
		BufferedWriter BW=new BufferedWriter(writer);
		BW.write("\n");
		BW.write(CS.getCourseName()+" "+Integer.valueOf(CS.getCourseGrade())+" "+CS.getCourseNo()+" ");
		BW.close();
		stuCour.put(CS.getCourseNo(), CS);
		
	}

	
	public void delete(IEntity entity)throws Exception {
		
	}

	public void update(IEntity entity) throws Exception{
		Course course=(Course)entity;
		for(Map.Entry<String, Course> item: stuCour.entrySet()) {
			if(item.getKey().equals(course.getCourseNo())) {
				stuCour.remove(item.getKey());
				break;
			}
		}
		
		//再把删除后的hashMap内容写入文件  更新
		FileWriter writer=new FileWriter("courseInformation.txt");
		BufferedWriter BW=new BufferedWriter(writer);
		
		for(Map.Entry<String, Course> item1: stuCour.entrySet()) {
			String St=item1.getKey();
			Course course2=item1.getValue();
			String alreadyAlter=(course2.getCourseName()+" "+(Integer.valueOf(course2.getCourseGrade()))
					+" "+course2.getCourseNo()+" ");
			BW.write(alreadyAlter);
			BW.write("\n");
			
		}
		
		BW.close();
		System.out.println("*删除课程成功*");
	}

	
	public HashMap<String, entity.IEntity> getAllEntities() {
		
		return null;
	}

	
	public IEntity getEntity(String Id) {
		IEntity ientity=(IEntity)stuCour.get(Id);
		return ientity;
	}
	
	
	public String getAdministratorId() {
		return AdministratorId;
	}
	public String getAdministratorPW() {
		return AdministratorPW;
	}

}
