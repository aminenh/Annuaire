package business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Group;
import model.Person;

public class test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:WebContent/WEB-INF/spring.xml");
		PersonDAOImp personDAOImp = (PersonDAOImp) context.getBean("PersonDAOImp");

		try {
			System.out.println("----Listing Record with IDperson = 2 -----");
			Person person = personDAOImp.findOnePerson(2);
			System.out.println("FirstName : " + person.getFirstName());
			System.out.println("Birthday : " + person.getBirthday());
			System.out.println("Mail : " + person.getMail());
			System.out.println("WebSite : " + person.getWebSite());
			System.out.println("Password : " + person.getPassword());
			System.out.println("------------------------------------------------");

			System.out.println("----Listing Record with IDgroup = 1 -----");
			List<Person> listPersons = personDAOImp.findPersonsByGroup(1);
			System.out.println("------------------------------------------------");
			for (Person per : listPersons) {
				System.out.println("FirstName : " + per.getFirstName());
				System.out.println("Birthday : " + per.getBirthday());
				System.out.println("Mail : " + per.getMail());
				System.out.println("WebSite : " + per.getWebSite());
				System.out.println("Password : " + per.getPassword());
				System.out.println("------------------------------------------------");
			}
			// System.out.println("----- Add person with Object person -----");
			// personDAOImp.addPerson(new Person("Test", "Test",
			// "Testgmail.com", "www.test.com", "aaa", "abc", 1));
			System.out.println("------------------------------------------------");
			System.out.println("----Update  Person -----");
			Person personID = personDAOImp.findOnePerson(15);
			personID.setFirstName("CHANGED2");
			// personDAOImp.updatePerson(personID, personID.getIdPerson());
			// personDAOImp.deletePerson(1);
			List<Person> listPersons2 = personDAOImp.findAllPersons();
			System.out.println("------------------------------------------------");
			for (Person per : listPersons2) {
				System.out.println("FirstName : " + per.getFirstName());
				System.out.println("Birthday : " + per.getBirthday());
				System.out.println("Mail : " + per.getMail());
				System.out.println("WebSite : " + per.getWebSite());
				System.out.println("Password : " + per.getPassword());
				System.out.println("------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
