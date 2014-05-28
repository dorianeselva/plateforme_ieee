package inscription;

import java.sql.ResultSet;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class HistoryData extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl = new VerticalLayout();
	//public Button quit = new Button("Quitter", this, "quit");
	public TextField HD;
	
	public HistoryData() {
		HD();
		setCompositionRoot(vl);
		//vl.setSizeFull();
		vl.setSpacing(true);
		vl.setMargin(true);

	}
	
	public VerticalLayout HD(){
		vl = new VerticalLayout();
		vl.setSizeFull();
		
		
		
		MysqlConnection con;
		//ResultSet count = con.queryTable("SELECT count(id_input) FROM `HD`");
		//while(count.next()){
			
		//}
		
		try {
			con = new MysqlConnection();
			
			ResultSet rs = con.queryTable("SELECT label FROM HD");
			
			while (rs.next()){
				String nameHD = rs.getString(1);
			    System.out.println(nameHD);
			    HD = new TextField(nameHD);
        	vl.addComponent(HD);
        	vl.setComponentAlignment(HD, Alignment.MIDDLE_CENTER);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//Window.alert("Identifiant ou Mot de passe pas correct");
		}
		
		Button submit = new Button("Submit");
		vl.addComponent(submit);
		vl.setComponentAlignment(submit, Alignment.MIDDLE_CENTER);
		return vl;
	}
}

