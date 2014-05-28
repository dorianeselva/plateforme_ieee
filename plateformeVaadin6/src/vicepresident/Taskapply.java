package vicepresident;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Taskapply extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl = new VerticalLayout();
	//public Button quit = new Button("Quitter", this, "quit");

	
	public Taskapply() {
		Task();
		setCompositionRoot(vl);
		//vl.setSizeFull();
		vl.setSpacing(true);
		vl.setMargin(true);

	}
	
	public VerticalLayout Task(){
		vl = new VerticalLayout();

		
		return vl;
		
	}


}