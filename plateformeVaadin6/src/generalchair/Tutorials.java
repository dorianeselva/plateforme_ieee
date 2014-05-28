package generalchair;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class Tutorials extends CustomComponent {
	private static Link tuto1 = new Link("Tutorial for Task 1",
			new com.vaadin.terminal.ExternalResource("http://google.com/"));
	private static Link tuto2 = new Link("Tutorial for Task 2",
			new com.vaadin.terminal.ExternalResource("http://vaadin.com/"));

	public static Panel Tutorials() {
		VerticalLayout vl = new VerticalLayout();
		Panel p = new Panel();
		p.setHeight("550px");
		p.setWidth("1280px");

		vl.addComponent(tuto1);
		vl.addComponent(tuto1);
		vl.addComponent(tuto2);
		p.addComponent(vl);
		return p;
	}
}
