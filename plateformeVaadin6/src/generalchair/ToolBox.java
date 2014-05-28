package generalchair;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class ToolBox extends CustomComponent{
	private static	Link tbox1 = new Link("Tool 1",
	        new com.vaadin.terminal.ExternalResource("http://www.google.fr"));
	private static	Link tbox2 = new Link("Tool 2",
	        new com.vaadin.terminal.ExternalResource("http://www.facebook.fr"));

	public static Panel ToolBox(){
		VerticalLayout vl = new VerticalLayout();
		vl.addComponent(tbox1);
		vl.addComponent(tbox2);
		Panel p = new Panel();
		p.addComponent(vl);
		p.setHeight("550px");
		p.setWidth("1280px");
		return p;
	}
}