package com.example.plateformevaadin6;


import generalchair.Generalchair;
import inscription.Inscription;
import inscription.PersonInfoInscri;

import java.sql.ResultSet;

import com.vaadin.Application;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class Plateformevaadin6Application extends Application {

	public Window mainWindow;
	public HorizontalLayout layout = new HorizontalLayout();
	public VerticalLayout bigLayout = new VerticalLayout();
	public TextField login;
	public PasswordField pwd;
	public Panel panel = new Panel("Sign in");
	public Panel panel2 = new Panel("Register");

	public void init() {
		mainWindow = new Window("FilAr");
		setMainWindow(mainWindow);
		setTheme("mytheme");
		
		mainWindow.setContent(bigLayout);
		
		layout.addComponent(panel);
		layout.addComponent(panel2);
		layout.setSizeFull();
		layout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		layout.setComponentAlignment(panel2, Alignment.MIDDLE_CENTER);
		panel.setWidth("300px");
		panel.setHeight("300px");
		panel2.setWidth("300px");
		panel2.setHeight("300px");
		
		VerticalLayout vl = new VerticalLayout();

		panel.addComponent(vl);
		vl.setMargin(true);
		vl.setSpacing(true);
		vl.setSizeFull();
		Button validButton = new Button("Sign In", this, "validate");
		VerticalLayout vlLogin = formLogin();
		vl.addComponent(vlLogin);
		vl.setComponentAlignment(vlLogin, Alignment.MIDDLE_CENTER);
		vl.addComponent(validButton);
		vl.setComponentAlignment(validButton, Alignment.MIDDLE_CENTER);
		
		VerticalLayout vl2 = new VerticalLayout();
		panel2.addComponent(vl2);
		vl2.setMargin(true);
		vl2.setSpacing(true);
		vl2.setSizeFull();
		Label inscriptionLabel = new Label("Not a member yet?");
		Button inscriptionButton = new Button("Register",this,"inscription");
		vl2.addComponent(inscriptionLabel);
		vl2.addComponent(inscriptionButton);
		vl2.setComponentAlignment(inscriptionLabel,Alignment.MIDDLE_CENTER);
		vl2.addComponent(inscriptionButton);
		vl2.setComponentAlignment(inscriptionButton,Alignment.MIDDLE_CENTER);
		
		ThemeResource resourceHeader = new ThemeResource("img/headerVert.jpg");
		Embedded imageHeader = new Embedded(null, resourceHeader) ;
		imageHeader.setWidth("1000px");
		imageHeader.setHeight("150px");
		
		bigLayout.addComponent(imageHeader);
		bigLayout.setComponentAlignment(imageHeader,Alignment.MIDDLE_CENTER);
		bigLayout.addComponent(layout);
		Footer foot = new Footer();
		bigLayout.addComponent(foot);
		foot.setWidth("1000px");
		foot.setHeight("100px");		
		bigLayout.setComponentAlignment(foot,Alignment.MIDDLE_CENTER);
		bigLayout.setSpacing(true);
		bigLayout.setMargin(true);
		bigLayout.setExpandRatio(imageHeader, 1);
		bigLayout.setExpandRatio(layout, 10);
		bigLayout.setExpandRatio(foot, 1);
		
	}

	public VerticalLayout formLogin() {
		Label labelLogin = new Label("User Name");
		login = new TextField();
		Label labelPwd = new Label("Password");
		pwd = new PasswordField();
		VerticalLayout vl = new VerticalLayout();
		vl.setSpacing(true);
		vl.setMargin(true);
		vl.addComponent(labelLogin);
		vl.addComponent(login);
		vl.addComponent(labelPwd);
		vl.addComponent(pwd);
		return vl;
	}
	
	public void inscription(){
		panel2.removeAllComponents();
		panel2.addComponent(new PersonInfoInscri());
		
	}

		public void validate() {
			String name = (String) login.getValue();
			//String password = encode((String) pwd.getValue());
			String password = (String) pwd.getValue();
			MysqlConnection con;

			try {
				con = new MysqlConnection();

    			ResultSet rs = con
    					.queryTable("SELECT id_user FROM user WHERE username = '"
    							+ name + "' AND password = '" + password + "'");
    			rs.next();
    			int id_user = rs.getInt("id_user");
    			System.out.println(id_user);
    			getMainWindow().setContent(new Generalchair());
			} catch (Exception e) {
				//e.printStackTrace();
				getMainWindow().showNotification("Incorrect username or password!");
			}
		}

	/*public String encode(String password) {
		byte[] hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			hash = md.digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				sb.append(0);
				sb.append(hex.charAt(hex.length() - 1));
			} else {
				sb.append(hex.substring(hex.length() - 2));
			}
		}
		return sb.toString();
	}*/
}
