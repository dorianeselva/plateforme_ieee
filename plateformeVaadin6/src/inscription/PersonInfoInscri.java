package inscription;

import java.sql.ResultSet;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PersonInfoInscri extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl = new VerticalLayout();
	//public Button quit = new Button("Quitter", this, "quit");
	private TextField username;
	private TextField lastname;
	private TextField firstname;
	private ComboBox sex;
	private ComboBox nationality;
	private TextField tel;
	private TextField email;
	private PasswordField pwd;
	private PasswordField pwd1;
	private Button submit;
//	private Button submit2;
	
	
	public PersonInfoInscri() {
		Person();
		setCompositionRoot(vl);
		
	}
	private VerticalLayout Person(){
		vl = new VerticalLayout();
		vl.setSizeFull();
	
		username = new TextField("User name");
		lastname = new TextField("Last name");
		firstname = new TextField("First name");
		sex = new ComboBox("Gender");
		nationality = new ComboBox("Nationality");
		tel = new TextField("Telephone");
		email = new TextField("Email");
		pwd = new PasswordField("Password");
		pwd1 = new PasswordField("Confirm your password");
		//submit = new Button("Submit");
		submit = new Button("Submit", this, "setPrePerson");
	//	submit2 = new Button();

	    sex.addItem("male");
	    sex.addItem("female");
	    
	    try {
			ResultSet rs = getCountries();
	    	while(rs.next()){
				nationality.addItem(rs.getString("country_name"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("i");
		}
	   
	
		vl.addComponent(username);
		vl.addComponent(lastname);
		vl.addComponent(firstname);
		vl.addComponent(sex);
		vl.addComponent(nationality);
		vl.addComponent(tel);
		vl.addComponent(email);
		vl.addComponent(pwd);
		vl.addComponent(pwd1);
		vl.addComponent(submit);
		//vl.addComponent(submit2);
	
		vl.setComponentAlignment(username, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(lastname, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(firstname, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(sex, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(nationality, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(tel, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(email, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(pwd, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(pwd1, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(submit, Alignment.MIDDLE_CENTER);
		//vl.setComponentAlignment(submit2, Alignment.MIDDLE_CENTER);
		return vl;
	}
	
	public void setPrePerson(){
		
		
		try {
			con = new MysqlConnection();
			con.executeTable("INSERT INTO pre_user (username, last_name, first_name,"
				+ "sex, nationality, telephone, email, pwd) VALUES('"
				+ username.getValue() + "','" +lastname.getValue() +"','" 
				+ firstname.getValue() + "','"+ sex.getValue() +"','" 
				+ nationality.getValue() +"','" + tel.getValue()+"','" 
				+ email.getValue() +"','" + pwd.getValue() + "')");
			vl.removeAllComponents();
			vl.addComponent(new Label("Please wait for the response of the adminitrator"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getCountries() throws Exception{
			con = new MysqlConnection();
			ResultSet rs = con.queryTable("select country_name from countries");
 
			return rs;
	}
}
