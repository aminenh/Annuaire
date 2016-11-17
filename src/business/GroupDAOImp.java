package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Group;

public class GroupDAOImp implements IGroupDAO {
	

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
	 * This method allows to create Group objects by using result's query
	 * 
	 * @return a group's map
	 */
	final private RowMapper<Group> groupMapper = new RowMapper<Group>() {
		@Override
		public Group mapRow(ResultSet arg0, int arg1) throws SQLException {
			Group group = new Group();
			group.setIdGroup(arg0.getLong("IDgroup"));
			group.setName(arg0.getString("name"));
			return group;
		}
	};

	@Override
	public void saveGroup(Group group) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeGroup(Group group) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Group findOneGroup(long idGroup) throws SQLException {
		String sql = "SELECT * FROM groups WHERE IDgroup = ?";
		Group group = jdbcTemplate.queryForObject(sql, new Object[] { idGroup }, groupMapper);
		return group;
	}

	@Override
	public List<Group> findAllGroups() throws SQLException {
		String sql = "SELECT * FROM groups";
		return this.jdbcTemplate.query(sql, groupMapper);
	}

	@Override
	public void addGroup(Group group) throws SQLException {
		String sql = "INSERT INTO groups (name) values(?)";
		this.jdbcTemplate.update(sql, new Object[] { group.getName() });
	}

	@Override
	public void updateGroup(Group group, long idGroup) throws SQLException {
		this.jdbcTemplate.update("UPDATE groups SET name='" + group.getName() + "' WHERE IDgroup = " + idGroup + " ");
	}

	@Override
	public void deleteGroup(long idGroup) throws SQLException {
		String sql = "DELETE FROM groups WHERE IDgroup = ?";
		jdbcTemplate.update(sql, idGroup);

	}
	

}
