package business;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import model.Group;

public interface IGroupDAO {
	
	public void setDataSource(DataSource ds);

	public void saveGroup(Group group) throws SQLException;

	public void removeGroup(Group group) throws SQLException;
	
	Group findOneGroup(long idPerson) throws SQLException;

	List<Group> findAllGroups() throws SQLException;

	void addGroup(Group group) throws SQLException;

	void updateGroup(Group group, long idGroup) throws SQLException;

	void deleteGroup(long idGroup) throws SQLException;

}
