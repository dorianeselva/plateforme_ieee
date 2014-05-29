package inscription;


import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;

@SuppressWarnings("serial")
public class Inscription extends CustomComponent implements TabSheet.SelectedTabChangeListener {	
	public Button quit = new Button("Quitter", this, "quit");
	public VerticalLayout vl = new VerticalLayout();
	private MysqlConnection con;
	public Panel personInfoInscri;
//	public Panel workInfoInscri;
//	public Panel historyData;
	

	public Inscription() {
		setCompositionRoot(vl);
		vl.setMargin(true);
		vl.setSpacing(true);
		vl.setSizeFull();
		Panel panel = new Panel();
		vl.addComponent(panel);
		panel.addComponent(createToolbar());		
	}
	
	public HorizontalLayout createToolbar() {
		HorizontalLayout hl = new HorizontalLayout();
		TabSheet tabsheet = new TabSheet();
		tabsheet.addListener(this);
		personInfoInscri = personInfoInscri();
//		workInfoInscri = workInfoInscri();
	//	historyData = historyData();
		tabsheet.addTab(personInfoInscri, "Personal Information", null);
//        tabsheet.addTab(workInfoInscri, "Professional Information", null); 
  //      tabsheet.addTab(historyData, "History Data", null); 
        hl.addComponent(tabsheet);
        quit.addStyleName("quitButton");
        hl.addComponent(quit);
		return hl;
	}
	
	private Panel personInfoInscri() {
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new PersonInfoInscri());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}

	@SuppressWarnings("unused")
	private Panel workInfoInscri() {
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new WorkInfoInscri());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}
	
	@SuppressWarnings("unused")
	public static Panel historyData(){
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new HistoryData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}

	public void quit() {
		getApplication().close();
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}