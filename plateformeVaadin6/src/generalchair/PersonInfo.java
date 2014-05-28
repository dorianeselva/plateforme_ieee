package generalchair;



import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

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
	private Button modif;
	
	
	public PersonInfo() {
		Information();
		setCompositionRoot(vl);
		
	}
	private VerticalLayout Information(){
		
		vl = new VerticalLayout();
		username = new Label("username: GCtest");
		lastname = new Label("last name: DOE");
		firstname = new Label("first name: Jon");
		tel = new Label("phone number: +33141556957");
		email = new Label("email: jdoe@isep.fr");
		address = new Label("address: 1 avenue des champs élysées 75008 Paris");
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

}

