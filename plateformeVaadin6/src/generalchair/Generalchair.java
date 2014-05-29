package generalchair;

import com.example.plateformevaadin6.Footer;
//import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.VerticalLayout;
//hello
@SuppressWarnings("serial")
public class Generalchair extends CustomComponent implements TabSheet.SelectedTabChangeListener {	
	public Button quit = new Button("Quitter", this, "quit");
	public VerticalLayout vl = new VerticalLayout();
	//private MysqlConnection con;
	public Panel personInfo;
	public Panel tuto;
	public Panel toolbox;
	public Panel conferenceInfo;
	public Panel filrougeInfo;
	public Panel taskInfo;
	public int id_conf=1;

	public Generalchair(int id_user) {
		setCompositionRoot(vl);
		vl.setMargin(true);
		vl.setSpacing(true);
		vl.setSizeFull();
		Panel panel = new Panel();
		vl.addComponent(panel);
		panel.addComponent(createToolbar(id_user));		
	}
	
	public VerticalLayout createToolbar(int id_user) {
		VerticalLayout vl2 = new VerticalLayout();
		HorizontalLayout hl = new HorizontalLayout();
		TabSheet tabsheet = new TabSheet();
		
		ThemeResource resourceHeader = new ThemeResource("img/headerVert.jpg");
		Embedded imageHeader = new Embedded(null, resourceHeader) ;
		imageHeader.setWidth("1000px");
		imageHeader.setHeight("100px");
		vl2.addComponent(imageHeader);
		vl2.setComponentAlignment(imageHeader,Alignment.MIDDLE_CENTER);
		
		tabsheet.addListener(this);
		personInfo = personInfo(id_user);
		tuto = Tutorials.Tutorials();
		toolbox = ToolBox.ToolBox();
		conferenceInfo = conferenceInfo(id_user);
		tabsheet.addTab(conferenceInfo, "My Conferences", null); 
		tabsheet.addTab(personInfo, "My Profil", null);
		tabsheet.addTab(tuto, "Tutorials", null);
		tabsheet.addTab(toolbox, "ToolBox", null);
        
        hl.addComponent(tabsheet);
        quit.addStyleName("quitButton");
        hl.addComponent(quit);
        vl2.addComponent(hl);
        Footer foot = new Footer();
        vl2.addComponent(foot);
        vl2.setExpandRatio(hl, 4);
        vl2.setExpandRatio(foot, 1);
		return vl2;
	}
	
	private Panel personInfo(int id_user) {
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new PersonInfo(id_user));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}
	

	private Panel conferenceInfo(int id_user) {
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new ConferenceInfo(id_user));
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
