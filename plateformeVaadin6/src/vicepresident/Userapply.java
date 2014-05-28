package vicepresident;

import java.sql.ResultSet;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Userapply extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl = new VerticalLayout();
	//public Button quit = new Button("Quitter", this, "quit");
	Label applynum;
	
	public Userapply() throws Exception {
		User();
		setCompositionRoot(vl);
		vl.setSizeFull();
		vl.setSpacing(true);
		vl.setMargin(true);

	}
	
	public VerticalLayout User() throws Exception{
		vl = new VerticalLayout();
		
		con = new MysqlConnection();
		
		ResultSet rs = con.queryTable("SELECT count(*) as num FROM pre_user");
		rs.next();
		int numapply = rs.getInt("num");
		applynum = new Label("Number of the application:   '"+numapply+"'");
		vl.addComponent(applynum);
		return vl;
		
	}


}
