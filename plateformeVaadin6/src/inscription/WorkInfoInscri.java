package inscription;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class WorkInfoInscri extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl = new VerticalLayout();
	//public Button quit = new Button("Quitter", this, "quit");
	private ComboBox country;
	private ComboBox city;
	private TextField company;
	private ComboBox position;
	private ComboBox domain;
	private Button submit;
	
	public WorkInfoInscri() {
		Work();
		setCompositionRoot(vl);
		//vl.setSizeFull();
		vl.setSpacing(true);
		vl.setMargin(true);

	}
	
	public VerticalLayout Work(){
		vl = new VerticalLayout();
		
		country = new ComboBox("Country");
		city = new ComboBox("City");
		company = new TextField("Company");
		position = new ComboBox("Position");
		domain = new ComboBox("Domaine");
		submit = new Button("Submit");
		
		
		vl.addComponent(country);
		vl.addComponent(city);
		vl.addComponent(company);
		vl.addComponent(position);
		vl.addComponent(domain);
		vl.addComponent(submit);
		
		vl.setComponentAlignment(country, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(city, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(company, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(position, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(domain, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(submit, Alignment.MIDDLE_CENTER);
		
		return vl;
		
	}


}