package persistance;

import java.util.List;

public interface Dao<T> {
//Create
	void save(T item);
	boolean saveAll(List<T> items);
	//read
	List<T> getAll();
	//update
	void update(T item);
	//delete
	boolean deleteAll();
}

