package jwb.aha.address.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ����ó ����Ʈ�� ���δ� ���� Ŭ�����̴�.
 * XML�� �����ϴ� �� ���ȴ�.
 *
 * @author Marco Jakob
 */

@XmlRootElement(name = "persons") 
public class PersonListWradpper {
	
	private List<Person> persons;
	
	@XmlElement(name = "person")
	public List<Person> getPerson(){
		return persons;
	}
	
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
