package vicepresident;

import java.sql.ResultSet;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
//;,jnh
//hfz
@SuppressWarnings("serial")
public class Userapply extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl;
	//public Button quit = new Button("Quitter", this, "quit");
	Label applynum;
	
	public Userapply() throws Exception {
		User();
		setCompositionRoot(vl);
		vl.setSizeFull();
		vl.setSpacing(true);
		vl.setMargin(true);

	}
	
	public VerticalLayout User() throws Exception{
		Button accept;
		Button refuse;
		int id;
		String username;
		String sex;
		String first_name;
		String last_name;
		String nationality;
		String telephone;
		String email;
		String pwd;
		int i = 1;
		
		Table table = new Table("New conference(s)");

		table.addContainerProperty("Username", String.class,  null);
		table.addContainerProperty("Sex",  String.class,  null);
		table.addContainerProperty("First Name", String.class, null);
		table.addContainerProperty("Last Name", String.class,  null);
		table.addContainerProperty("Nationality",  String.class,  null);
		table.addContainerProperty("Telephone",   String.class, null);
		table.addContainerProperty("Email", String.class,  null);
		table.addContainerProperty("Accept",  Button.class,  null);
		table.addContainerProperty("Refuse",  Button.class, null);

		
		vl = new VerticalLayout();
		ResultSet rs = napply();
		rs.next();
		int numapply = rs.getInt("num");
		applynum = new Label(numapply+" apply");
		vl.addComponent(applynum);
		
		ResultSet apply = allApply();
		while(apply.next()){
			id = apply.getInt("id_pre_user");
			username = apply.getString("username");
			sex = apply.getString("sex");
			first_name = apply.getString("first_name");
			last_name = apply.getString("last_name");
			nationality = apply.getString("nationality");
			telephone = apply.getString("telephone");
			email = apply.getString("email");
			
			accept = new Button(String.valueOf(id));
			refuse = new Button(String.valueOf(id));
			
			accept.addListener(new ClickListener()
            {
               
				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					String str = event.getButton().getCaption();
                	System.out.println(str);
                    try {
						acceptUser(Integer.parseInt(str));
						remove(Integer.parseInt(str));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("out");
					}	
				}
            });
			
			refuse.addListener(new ClickListener()
            {
               
				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					String str = event.getButton().getCaption();
                	System.out.println(str);
                    try {
						remove(Integer.parseInt(str));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("out");
					}	
				}
            });
			
			table.addItem(new Object[]{username,sex,first_name,last_name,nationality,
					telephone,email,accept,refuse},new Integer(i));
			i++;
			
		}
		
		vl.addComponent(table);
		return vl;
		
	}
	
	public void acceptUser(int id_pre_user) throws Exception {
		con = new MysqlConnection();
		ResultSet rs = con.queryTable("select * from pre_user where id_pre_user=" +id_pre_user);
		rs.next();

		String username = rs.getString("username");
		String sex = rs.getString("sex");
		String first_name = rs.getString("first_name");
		String last_name = rs.getString("last_name");
		String nationality = rs.getString("nationality");
		String telephone = rs.getString("telephone");
		String email = rs.getString("email");
		String pwd = rs.getString("pwd");

		con.executeTable("insert into user(username,sex,first_name,last_name,nationality,telephone,email,password,role)"
				+ "values('" + username + "','" + sex + "','" + first_name +"','"+last_name+"','"+nationality+"','"+telephone+"','"+email
				+ "','" + pwd +"','GC')");
		
		
	}
	
	public void remove(int id_pre_user) throws Exception{
		con = new MysqlConnection();
		con.executeTable("delete from pre_user where id_pre_user="+ id_pre_user);
	}

	public ResultSet napply() throws Exception{

		con = new MysqlConnection();
		
		ResultSet rs = con.queryTable("SELECT count(*) as num FROM pre_user");
		
		return rs;
	}
	
	public ResultSet allApply() throws Exception{
		con = new MysqlConnection();
		
		ResultSet rs = con.queryTable("SELECT * FROM pre_user");
		
		return rs;
	}


}
