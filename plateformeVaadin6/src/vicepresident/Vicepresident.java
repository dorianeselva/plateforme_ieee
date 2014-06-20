package vicepresident;

import com.example.plateformevaadin6.Footer;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;

@SuppressWarnings("serial")
public class Vicepresident extends CustomComponent implements TabSheet.SelectedTabChangeListener {	
	public Button quit = new Button("Quitter", this, "quit");
	public VerticalLayout vl = new VerticalLayout();
	public Panel userapply;
	public Panel conferenceapply;
	public Panel managefilrouge;
	public Panel conferences;
	

	public Vicepresident(int id_user) {
		setCompositionRoot(vl);
		vl.setMargin(true);
		vl.setSpacing(true);
		vl.setSizeFull();
		Panel panel = new Panel();
		vl.addComponent(panel);
		panel.addComponent(createToolbar());		
	}
	
	public VerticalLayout createToolbar() {
		VerticalLayout vl2 = new VerticalLayout();
		HorizontalLayout hl = new HorizontalLayout();
		TabSheet tabsheet = new TabSheet();
		

		ThemeResource resourceHeader = new ThemeResource("img/headerVert.jpg");
		Embedded imageHeader = new Embedded(null, resourceHeader) ;
		imageHeader.setWidth("1000px");
		imageHeader.setHeight("80px");
		vl2.addComponent(imageHeader);
		vl2.setComponentAlignment(imageHeader,Alignment.MIDDLE_CENTER);
		
		tabsheet.addListener(this);
		userapply = userapply();
		conferenceapply = conferenceapply();
		conferences = taskapply();
		managefilrouge = managefilrouge();
		tabsheet.addTab(userapply, "User Application", null);
        tabsheet.addTab(conferenceapply, "Conference Application", null);          
        tabsheet.addTab(managefilrouge, "Mange of Filrouge", null); 
        hl.addComponent(tabsheet);
        

        quit.addStyleName("quitButton");
        hl.addComponent(quit);
        vl2.addComponent(hl);
        vl2.setComponentAlignment(hl,Alignment.MIDDLE_CENTER);
        
        Panel footer_panel =  new Panel();
        footer_panel.setWidth("1000px");
        footer_panel.setHeight("105px");
        footer_panel.setStyleName("footer");
        Footer foot = new Footer();
        footer_panel.addComponent(foot);
        vl2.addComponent(footer_panel);
        vl2.setComponentAlignment(footer_panel,Alignment.MIDDLE_CENTER);
        
        vl2.setExpandRatio(hl, 4);
        vl2.setExpandRatio(footer_panel, 1);
		return vl2;
	}
	
	private Panel userapply() {
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1000px");
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
		panel.setWidth("1000px");
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
		panel.setWidth("1000px");
		try {
			//panel.setContent(new Conferences());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}
	
	private Panel managefilrouge(){
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1000px");
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