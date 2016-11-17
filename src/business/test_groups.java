package business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Group;
import model.Person;

public class test_groups {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:WebContent/WEB-INF/spring.xml");
		GroupDAOImp groupDAOImp = (GroupDAOImp) context.getBean("GroupDAOImp");

		System.out.println("----FindOne group -----");
		Group group;
		try {
			group = groupDAOImp.findOneGroup(1);
			System.out.println("Name : " + group.getName());
			System.out.println("------------------------------------------------");
			System.out.println("---- find All Groups -----");
			List<Group> listGroups = groupDAOImp.findAllGroups();
			System.out.println("------------------------------------------------");
			for (Group grp : listGroups) {
				System.out.println("Name : " + grp.getName());
				System.out.println("------------------------------------------------");
			}
			System.out.println("----- Add Group -----");
			// directoryDAOImp.addGroup(new Group("M2 GL"));

			System.out.println("----Update Group -----");
			Group groupObj = groupDAOImp.findOneGroup(3);
			groupObj.setName("SIR");
			groupDAOImp.updateGroup(groupObj, groupObj.getIdGroup());
			groupDAOImp.deleteGroup(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
