package vicepresident;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;

public class Vicepresident extends CustomComponent implements TabSheet.SelectedTabChangeListener {	
	public Button quit = new Button("Quitter", this, "quit");
	public VerticalLayout vl = new VerticalLayout();
	private MysqlConnection con;
	public Panel userapply;
	public Panel conferenceapply;
	public Panel taskapply;
	public Panel managefilrouge;
	

	public Vicepresident() {
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
		userapply = userapply();
		conferenceapply = conferenceapply();
		taskapply = taskapply();
		managefilrouge = managefilrouge();
		tabsheet.addTab(userapply, "User Application", null);
        tabsheet.addTab(conferenceapply, "Conference Application", null); 
        tabsheet.addTab(taskapply, "Task Application", null); 
        tabsheet.addTab(managefilrouge, "Mange of Filrouge", null); 
        hl.addComponent(tabsheet);
        quit.addStyleName("quitButton");
        hl.addComponent(quit);
		return hl;
	}
	
	private Panel userapply() {
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new Userapply());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}

	private Panel conferenceapply() {
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new Conferenceapply());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}
	
	private Panel taskapply(){
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new Taskapply());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}
	
	private Panel managefilrouge(){
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new Managefilrouge());
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