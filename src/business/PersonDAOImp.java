package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import model.Group;
import model.Person;

@Service
public class PersonDAOImp implements IPersonDAO {

	/**
	 * 
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	private DataSource dataSource;

	/**
	 * This method allows to initiliaze the jdbcTemplate in order to connect the
	 * database
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * This method allows to create Person objects by using result's query
	 * 
	 * @return a person's map
	 */
	final private RowMapper<Person> personMapper = new RowMapper<Person>() {
		@Override
		public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
			Person person = new Person();
			person.setIdPerson((long) arg0.getInt("IDperson"));
			person.setName(arg0.getString("name"));
			person.setFirstName(arg0.getString("firstName"));
			person.setBirthday(arg0.getString("birthday"));
			person.setMail(arg0.getString("mail"));
			person.setWebSite(arg0.getString("webSite"));
			person.setPassword(arg0.getString("password"));
			person.setGroupId((long) arg0.getInt("groupID"));
			return person;
		}
	};

	@Override
	public void savePerson(Person person, Long id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePerson(Person person) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Person findOnePerson(long idPerson) throws SQLException {
		String sql = "SELECT * FROM persons WHERE IDperson = ?";
		Person person = jdbcTemplate.queryForObject(sql, new Object[] { idPerson }, personMapper);
		return person;
	}

	@Override
	public List<Person> findPersonsByGroup(long groupID) throws SQLException {
		String sql = "SELECT * FROM persons WHERE groupId = ?";
		List<Person> ListPerson = (List<Person>) jdbcTemplate.query(sql, new Object[] { groupID }, personMapper);
		return ListPerson;
	}

	@Override
	public List<Person> findAllPersons() throws SQLException {
		String sql = "SELECT * FROM persons";
		return this.jdbcTemplate.query(sql, personMapper);
	}

	@Override
	public void addPerson(Person person) throws SQLException {
		String sql = "INSERT INTO persons (name, firstName, birthday, mail, webSite, password, groupID) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] { person.getName(), person.getFirstName(), person.getBirthday(),
				person.getMail(), person.getWebSite(), person.getPassword(), person.getGroupId() });

	}

	@Override
	public void updatePerson(Person person, long idPerson) throws SQLException {
		this.jdbcTemplate.update("UPDATE persons SET name='" + person.getName() + "', firstName='"
				+ person.getFirstName() + "', birthday='" + person.getBirthday() + "', mail='" + person.getMail()
				+ "', webSite='" + person.getWebSite() + "', password='" + person.getPassword() + "', groupId='"
				+ person.getGroupId() + "' WHERE IDperson=" + idPerson + "");

	}

	@Override
	public void deletePerson(long idPerson) throws SQLException {
		String sql = "DELETE FROM persons WHERE IDperson = ?";
		jdbcTemplate.update(sql, idPerson);

	}
}