package generalchair;



import java.sql.ResultSet;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Alignment;
//import com.vaadin.ui.Button;
//import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
//import com.vaadin.ui.Panel;
//import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PersonInfo extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl = new VerticalLayout();
	//public Button quit = new Button("Quitter", this, "quit");
	private Label username;
	private Label lastname;
	private Label firstname;
	private Label tel;
	private Label email;
	private Label address;
	//private Button modif;

	
	
	public PersonInfo(int id_user) {
		try {
			Information(id_user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCompositionRoot(vl);
		
	}
	private VerticalLayout Information(int id_user) throws Exception{
		ResultSet rs = getPersonInfo(id_user);
		rs.next();		
		vl = new VerticalLayout();
		username = new Label("username: "+ rs.getString("username"));
		lastname = new Label("last name: "+ rs.getString("last_name"));
		firstname = new Label("first name: "+ rs.getString("first_name"));
		tel = new Label("phone number: "+ rs.getString("telephone"));
		email = new Label("email: "+ rs.getString("email"));
		address = new Label("address: "+ rs.getString("address"));
		//modif = new Button("modify");
		
		
		
		
		vl.addComponent(username);
		vl.addComponent(lastname);
		vl.addComponent(firstname);
		vl.addComponent(tel);
		vl.addComponent(email);
		vl.addComponent(address);
		//vl.addComponent(modif);
		
		vl.setComponentAlignment(username, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(lastname, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(firstname, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(tel, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(email, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(address, Alignment.MIDDLE_CENTER);
		
		vl.setMargin(true);
		
		vl.setSizeFull();

		
		return vl;
		
	}
	
	public ResultSet getPersonInfo(int id_user) throws Exception{
		con = new MysqlConnection();
		ResultSet rs = con.queryTable("select * from user where id_user = "+ id_user);
		return rs;
	}

}

