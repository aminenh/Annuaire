package business;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import model.Group;
import model.Person;

public interface IPersonDAO {

	public void setDataSource(DataSource ds);
	
	public void savePerson(Person person, Long id) throws SQLException;

	public void removePerson(Person person) throws SQLException;

	Person findOnePerson(long idPerson) throws SQLException;

	List<Person> findPersonsByGroup(long groupID) throws SQLException;

	List<Person> findAllPersons() throws SQLException;

	void addPerson(Person person) throws SQLException;

	void updatePerson(Person person, long idPerson) throws SQLException;

	void deletePerson(long idPerson) throws SQLException;
}
