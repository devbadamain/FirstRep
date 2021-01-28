package jwb.aha.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jwb.aha.address.model.Person;
import jwb.aha.address.util.DateUtil;

/**
 * �߰��� ����� ���� ������ �� ���� ���� �� �ֽ��ϴ�: 
 * ����ó ������ ���� ����� Ŀ���� ���̾�α� (�� ���� ���ο� ��������)�� �ʿ��մϴ�.
 * @author JWB
 *
 */

/**
 * ����ó ������ �����ϴ� ���̾�α�
 */
public class PersonEditDialogController {
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField postalCodeField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField birthdayField;
	
	
	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;
	
	 /**
     * ��Ʈ�ѷ� Ŭ������ �ʱ�ȭ�Ѵ�.
     * �� �޼���� fxml ������ �ε�� �� �ڵ����� ȣ��ȴ�.
     */
	@FXML
	private void initialize() { 
		
	}
	
	/**
     * �� ���̾�α��� ���������� �����Ѵ�.
     *
     * @param dialogStage
     */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	/**
     * ���̾�α׿��� ����� ����ó�� �����Ѵ�.
     *
     * @param person
     */
	public  void setPerson(Person person) {
		this.person = person;
		firstNameField.setText(person.getFirstName()); 
		lastNameField.setText(person.getLastName()); 
		streetField.setText(person.getStreet());
		postalCodeField.setText(Integer.toString(person.getPostalCode()));
		cityField.setText(person.getCity());
		birthdayField.setText(DateUtil.format(person.getBirthday()));
		birthdayField.setPromptText("yyyy.MM.dd.HH.mm.ss");
	}
	
	 /**
     * ����ڰ� OK�� Ŭ���ϸ� true��, �� �ܿ��� false�� ��ȯ�Ѵ�.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * ����ڰ� OK�� Ŭ���ϸ� ȣ��ȴ�.
     */
    @FXML
    private void handleOk() {
    	if(isInputValid()) {
    		person.setFirstName(firstNameField.getText()); 
    		person.setLastName(lastNameField.getText()); 
    		person.setStreet(streetField.getText()); 
    		person.setPostalCode(Integer.parseInt(postalCodeField.getText())); 
    		person.setCity(cityField.getText()); 
    		person.setBirthday(DateUtil.parse(birthdayField.getText())); 
    	
    		okClicked = true;
    		dialogStage.close();
    	}
    }
    
    /**
     * ����ڰ� cancel�� Ŭ���ϸ� ȣ��ȴ�.
     */
    @FXML
    private void handleCancel() {
    	dialogStage.close();
    }
    
    /**
     * �ؽ�Ʈ �ʵ�� ����� �Է��� �˻��Ѵ�.
     *
     * @return true if the input is valid
     */
     private boolean isInputValid() {
    	 String errorMessage ="";
    	 
    	 if(firstNameField.getText() == null || firstNameField.getText().length()==0){
    		 errorMessage += "No valid first name!\n";
    	 }
    	 if(lastNameField.getText() == null || lastNameField.getText().length()==0){
    		 errorMessage += "No valid last name!\n";
    	 }
    	 if(streetField.getText() == null || streetField.getText().length()==0){
    		 errorMessage += "No valid street!\n";
    	 }
    	 if(postalCodeField.getText() == null || postalCodeField.getText().length()==0){
    		 errorMessage += "No valid street!\n";
    	 }else {
    		 // ���� ��ȣ�� int Ÿ������ ��ȯ�Ѵ�.
    		 try {
    			 Integer.parseInt(postalCodeField.getText());
    		 }catch(NumberFormatException e) {
    			 errorMessage += "No valid postal code (must be an integer)!\n";
    		 }
    	 }
    	 if(cityField.getText() == null || cityField.getText().length()==0){
    		 errorMessage += "No valid city!\n";
    	 }
    	 if(birthdayField.getText() == null || birthdayField.getText().length()==0){
    		 errorMessage += "No valid birthday!\n";
    	 }else {
    		 if(!DateUtil.validDate(birthdayField.getText())) {
    			 errorMessage += "No valid birthday. Use the format yyyy.MM.dd.HH.mm.ss";
    		 }
    	 }
    	 
    	 if(errorMessage.length()==0) {
    		 return true;
    	 }else {
    		 // ���� �޽����� �����ش�.
             Alert alert = new Alert(AlertType.ERROR);
             alert.initOwner(dialogStage);
             alert.setTitle("Invalid Fields");
             alert.setHeaderText("Please correct invalid fields");
             alert.setContentText(errorMessage);

             alert.showAndWait();
             
             return false;
    	 }
     }
}