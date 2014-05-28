package com.example.plateformevaadin6;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class Footer extends CustomComponent {
	// we create all the components and objects
	private VerticalLayout layoutLines;
	private HorizontalLayout layoutFooter;
	// Show the image in the application 
	

	private Link linkTuto = new Link("Tutorials",
	        new com.vaadin.terminal.ExternalResource("http://vaadin.com/"));
		
	private Link linkTools = new Link("ToolBox ",
	        new com.vaadin.terminal.ExternalResource("http://vaadin.com/"));
		
	private Link linkHome = new Link("IEEE Home ",
	        new com.vaadin.terminal.ExternalResource("http://www.ieee.org/index.html"));
		
	private Link linkMap = new Link("Sitemap",
	        new com.vaadin.terminal.ExternalResource("http://ieee-cas.org/sitemap"));
		
	private Link linkContact = new Link("Contact",
	        new com.vaadin.terminal.ExternalResource("http://ieee-cas.org/about/contact"));
		
	private Link linkTerms = new Link("Terms & Conditions ",
	        new com.vaadin.terminal.ExternalResource("http://www.ieee.org/site_terms_conditions.html?WT.mc_id=hpf_terms%3Chttp://www.ieee.org/about/help/site_terms_conditions.html%3E"));
	
	private Link linkPrivacy = new Link("Privacy & Opting Out of Cookies ",
			        new com.vaadin.terminal.ExternalResource("http://www.ieee.org/security_privacy.html"));			
								
	private	Link linkPolicy = new Link("Nondiscrimination Policy ",
			        new com.vaadin.terminal.ExternalResource("http://www.ieee.org/about/corporate/governance/p9-26.html"));
	
	private HorizontalLayout whiteSpace = new HorizontalLayout();
	private HorizontalLayout whiteSpaceBis = new HorizontalLayout();
	private HorizontalLayout secondLines = new HorizontalLayout();
			
	public  Footer() {
		buildFooter();
		setCompositionRoot(layoutFooter);
		
		//layoutFooter.addStyleName("layoutFooter");
	//return buildFooter();
		//panelTuto.setContent();
		//buildPanelTuto();
	}
	
	private HorizontalLayout buildFooter(){
		
		layoutFooter = new HorizontalLayout(); 
		layoutFooter.setSpacing(true);
		layoutFooter.setMargin(false);
		//layoutFooter.setWidth("100%");
		layoutLines = new VerticalLayout();
		whiteSpace.setHeight("33px");
		layoutLines.addComponent(whiteSpace);
		whiteSpaceBis.setWidth("150px");
		ThemeResource resourceLogo = new ThemeResource("img/legroupevert.png");
		Embedded imageLogo = new Embedded(null, resourceLogo) ;
		layoutFooter.addComponent(imageLogo);
		secondLines.setSpacing(true);	
		secondLines.addComponent(whiteSpaceBis);
	//	secondLines.addComponent(linkTuto);
	//  secondLines.addComponent(linkTools);
		secondLines.addComponent(linkHome);
		secondLines.addComponent(linkMap);
		secondLines.addComponent(linkContact);
		secondLines.addComponent(linkTerms);
		secondLines.addComponent(linkPrivacy);
		secondLines.addComponent(linkPolicy);
		
	//	linkTuto.setTargetName("_blank");
	//	linkTools.setTargetName("_blank");
		linkHome.setTargetName("_blank");
		linkMap.setTargetName("_blank");
		linkContact.setTargetName("_blank");
		linkTerms.setTargetName("_blank");
		linkPolicy.setTargetName("_blank");
		linkPrivacy.setTargetName("_blank");
		layoutLines.addComponent(secondLines);
		layoutFooter.addComponent(layoutLines);
		return layoutFooter;
				
	}
	

}