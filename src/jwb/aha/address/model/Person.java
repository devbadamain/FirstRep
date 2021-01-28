package jwb.aha.address.model;

import java.time.LocalDateTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private StringProperty firstName;
	private StringProperty  lastName;
	private StringProperty  street;
	private IntegerProperty postalCode;
	private StringProperty city;
	private ObjectProperty<LocalDateTime> birthday;
	
	/**
	 * 디폴트 생성자
	 */
	public Person() {
		this(null,null);
	}
	
	/**
	 * 데이터를 초기화하는 생성자
	 *
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.street = new SimpleStringProperty("some street");
		this.postalCode = new SimpleIntegerProperty(1234);
		this.city = new SimpleStringProperty("some city");
		this.birthday = new SimpleObjectProperty<LocalDateTime>(LocalDateTime.now());
	}

	public String getFirstName() {
		return firstName.get();
	}

	public String getLastName() {
		return lastName.get();
	}

	public String getStreet() {
		return street.get();
	}

	public int getPostalCode() {
		return postalCode.get();
	}

	public String getCity() {
		return city.get();
	}

	public LocalDateTime getBirthday() {
		return birthday.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	
	public StringProperty lastNameProperty() {
		return lastName;
	}

	public void setStreet(String street) {
		this.street.set(street);
	}

	public StringProperty streetProperty() {
		return street;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode.set(postalCode);
	}
	
	public IntegerProperty postalCodePropety() {
		return postalCode;
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public StringProperty cityProperty() {
		return city;
	}
	
	public void setBirthday(LocalDateTime birthday) {
		this.birthday.set(birthday);
	}
	
	public ObjectProperty<LocalDateTime> birthdayProperty(){
		return birthday;
	}
}
