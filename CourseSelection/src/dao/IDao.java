package dao;
import java.util.HashMap;
import entity.IEntity;;

public interface IDao {
	void insert(IEntity entity)throws Exception;
	void delete(IEntity entity)throws Exception;
	void update(IEntity entity)throws Exception;
	public HashMap<String, IEntity> getAllEntities(); 
	public IEntity getEntity(String Id);
}
