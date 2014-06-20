package vicepresident;

import java.sql.ResultSet;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Conferenceapply extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl = new VerticalLayout();
	//public Button quit = new Button("Quitter", this, "quit");

	
	public Conferenceapply() {
		Conference();
		setCompositionRoot(vl);
		//vl.setSizeFull();
		vl.setSpacing(true);
		vl.setMargin(true);

	}
	
	public VerticalLayout Conference(){
		vl = new VerticalLayout();
		try {
			MysqlConnection con;
			con = new MysqlConnection();

			ResultSet rs = con.queryTable("SELECT * FROM pre_hd_conf order by id_pre_conf");

		vl = new VerticalLayout();
	
					Table table = new Table("This is my Table");
					table.setWidth("300px");
					
					table.addContainerProperty("Conf",            Label.class,     null);
					table.addContainerProperty("validate()",        Button.class,    null);
					int i = 0;
					while (rs.next()) {
					/* Add a few items in the table. */
				//	for (int i=0; i<100; i++) {
					    // Create the fields for the current table row
						i++;
						String nameConf ; 
						
						nameConf = rs.getString("valeur");
					/*	final int id_pre_conf;
						id_pre_conf = rs.getInt(" id_pre_conf");
					*/	// The Table item identifier for the row.
					   Integer itemId = new Integer(i);
						Button detailsField = new Button("show details");
					//	detailsField.setData(itemId);
					    detailsField.addListener(new Button.ClickListener() {
					        public void buttonClick(ClickEvent event) {
					            // Get the item identifier from the user-defined data.
					            Integer itemId = (Integer)event.getButton().getData();
					            getWindow().showNotification("Link "+
					                                   itemId.intValue()+" clicked.");
					/*            try {
					        		MysqlConnection con;
					        		con = new MysqlConnection();

					        		// il faut id_fieldHD, id_conf, value4(
					        	//	con.executeTable("DELETE * FROM PRE_HD_CONF WHERE  id_pre_conf = "+  id_pre_conf );
					        	//	con.executeTable("INSERT * FROM PRE_HD_CONF order by id_pre_conf");
					        	} catch (Exception e) {
					        	
					        	//getWindow.showNotification("ERROR", e.getMessage(), Window.Notification.TYPE_ERROR_MESSAGE);
					        	e.printStackTrace();
					        	} 
					  */      } 
					    });
					    detailsField.addStyleName("link");
					 // Create the table row.
					    table.addItem(new Object[] {nameConf, detailsField}, itemId);
					 //   }
					   
					}
					table.setPageLength(i);
					vl.addComponent(table);
			} catch (Exception e) {
				e.printStackTrace();
				getWindow().showNotification("Database error");
			}


		
		return vl;
		
	}
	
	
	}
