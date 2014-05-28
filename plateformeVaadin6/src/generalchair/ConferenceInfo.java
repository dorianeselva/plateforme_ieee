package generalchair;


import java.sql.ResultSet;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ConferenceInfo extends CustomComponent {
	private MysqlConnection con;
	//public Button quit = new Button("Quitter", this, "quit");
	public HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
	private VerticalLayout vl;
	private GridLayout gl;
	private int num = 21;
	private Embedded[] note = new Embedded[num];
	private Label[] line = new Label[num-1];
	private Embedded noteredcount;
	private int noterednumber=0;
	private Embedded noteorangecount;
	private int noteorangenumber=0;
	private Embedded notegreencount;
	private int notegreennumber=0;
	private Label red;
	private Label orange;
	private Label green;
	private Label lefttest1;
	private Label lefttest2;
	private Label lefttest3;
	private Window taskwindow;
	private Label task;
	private VerticalLayout vl2;
	public int id_conf=1;
	public int modelFR;
	public int node;
	
	public ConferenceInfo() {
		try {
			modelFR = getModelFR(id_conf);
			num = getNbNotes(modelFR);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		ShowConference(modelFR, id_conf);
		setCompositionRoot(hsplit);
		
	}
	
	private HorizontalSplitPanel ShowConference(int modelFR, int id_conf){

        hsplit = new HorizontalSplitPanel();
        
        gl = new GridLayout();
		
		gl.setSizeFull();
		
		gl.setColumns(15);
		gl.setRows(11);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		

		for(int i = 0; i<num; i++){
			note[i] = ConferenceInfo.getRedNode();
			
			//	note[i] = new Embedded("", new ThemeResource("images/search/details/personDetailsDresserIcons_history.png"));
				note[i].setSizeUndefined();
	            
				note[i].addListener(new ClickListener()
	            {
	                
	                public void click(com.vaadin.event.MouseEvents.ClickEvent event)
	                {
	                    try {
	                    	System.out.println("innnnn");
							showtask();
							System.out.println("innnnn2");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("out");
						}
	                    
	                }
	            });
				
				note[i].addStyleName("note"+(i+1));
				//note[i].setId("note"+(i+1));
				note[i].setWidth("100.0%");
				note[i].setHeight("100.0%");
			//note[i].setIcon(new ThemeResource("image/buttonred"));
			
			if(i<6){
				
				gl.addComponent(note[i], 2*(i+1), 2);
				
			}
			
			else if(i>=6 && i<12){
				
				gl.addComponent(note[i], 2*(12-i), 4);
				
			}
			
			else if(i>=12 && i<18){
				
				gl.addComponent(note[i], 2*((i-12)+1), 6);
				
			}
			
			else{
				
				gl.addComponent(note[i], 2*((24-i)), 8);
				
			}
			
			gl.setComponentAlignment(note[i], new Alignment(48));
		
			}
		
		
		for(int j = 0; j<num-1; j++){
			
			line[j] = new Label();
			line[j].addStyleName("line"+(j+1));
			
			if(j<5){
				
				gl.addComponent(line[j], 2*(j+1)+1, 2);
				line[j].setWidth("100.0%");
				line[j].setHeight("10.0%");
				
			}
			
			else if(j==5){
				
				gl.addComponent(line[j], 12, 3);
				line[j].setWidth("10.0%");
				line[j].setHeight("100.0%");
				
			}
			
			else if(j>=6 && j<11){
				gl.addComponent(line[j], 2*(12-(j+1))+1, 4);
				line[j].setWidth("100.0%");
				line[j].setHeight("10.0%");
				
			}
			
			else if(j==11){
				
				gl.addComponent(line[j], 2, 5);
				line[j].setWidth("10.0%");
				line[j].setHeight("100.0%");
				
			}
			
			else if(j>=12 && j<17){
				
				gl.addComponent(line[j],  2*((j+1)-12)+1, 6);
				line[j].setWidth("100.0%");
				line[j].setHeight("10.0%");
				
			}
			
			else if(j==17){
				
				gl.addComponent(line[j], 12, 7);
				line[j].setWidth("10.0%");
				line[j].setHeight("100.0%");
				
			}
			
			else{
				
				gl.addComponent(line[j], 2*(24-(j+1))+1, 8);
				line[j].setWidth("100.0%");
				line[j].setHeight("10.0%");
				
			}
			
			gl.setComponentAlignment(line[j], new Alignment(48));
			
		}
		
		try {
			getColorCount(modelFR, id_conf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		noteredcount = new Embedded("red");
		red = new Label(Integer.toString(noterednumber));
		noteorangecount = new Embedded("orange");
		orange = new Label(Integer.toString(noteorangenumber));
		notegreencount = new Embedded("green");
		green = new Label(Integer.toString(notegreennumber));
		
		gl.addComponent(noteredcount, 2, 10);
		gl.addComponent(red, 3, 10);
		gl.addComponent(noteorangecount, 4, 10);
		gl.addComponent(orange, 5, 10);
		gl.addComponent(notegreencount, 6, 10);
		gl.addComponent(green, 7, 10);
        
        hsplit.addComponent(showconference());
        hsplit.addComponent(gl);

        showconference().setSizeFull();
        gl.setSizeFull();
        
        showconference().setMargin(true);
        gl.setMargin(true);

		
		return hsplit;
	}

	@SuppressWarnings("unused")
	private static Embedded getBlackNode() {
		// A theme resource in the current theme ("book-examples")
		// Located in: VAADIN/themes/book-examples/img/themeimage.png
		ThemeResource resourceBlack = new ThemeResource("img/darkButton.png");
		// Use the resource
		Embedded imageNodeBlack = new Embedded(null, resourceBlack);
	//	imageNodeRed.setMargin(false);
		
		return imageNodeBlack;
	}

	public static Embedded getRedNode(){
		// A theme resource in the current theme ("book-examples")
				// Located in: VAADIN/themes/book-examples/img/themeimage.png
				ThemeResource resourceRed = new ThemeResource("img/redNodeTrans.png");
				// Use the resource
				Embedded imageNodeRed = new Embedded(null, resourceRed);
			//	imageNodeRed.setMargin(false);
				
				return imageNodeRed;
	}
	public static Embedded getGreenNode(){
		// A theme resource in the current theme ("book-examples")
				// Located in: VAADIN/themes/book-examples/img/themeimage.png
				ThemeResource resourceGreen = new ThemeResource("img/greenNodeTrans.png");
				// Use the resource
				Embedded imageNodeGreen = new Embedded(null, resourceGreen);
				return imageNodeGreen;
	}
	public static Embedded getOrangeNode(){
		// A theme resource in the current theme ("book-examples")
				// Located in: VAADIN/themes/book-examples/img/themeimage.png
				ThemeResource resourceOrange = new ThemeResource("img/orangeNodeTrans.png");
				// Use the resource
				Embedded imageNodeOrange = new Embedded(null, resourceOrange);
				return imageNodeOrange;
	}

	public void showtask() throws Exception{
		
		node = 1;
		taskwindow = new Window("showtask");
		//taskwindow.setSizeFull();
		vl2 = new VerticalLayout();
		task = new Label("There are the tasks you need to complete to turn this node green");
		vl2.addComponent(task);
		
        HorizontalLayout hl;
        Label lb;
        TextField tf;
        TextArea ta;
        DateField df;
        //upload;

        ResultSet rs = getTasks(modelFR,node);
        ResultSet rs1;
        int id_task;
        String label;
        int id_input;
        String value;
        int valid;

        while(rs.next()){
            id_task = rs.getInt("id_task");
            label = rs.getString("label");
            id_input = rs.getInt("id_input");
            rs1 = getTask_conf(id_task);

            System.out.println(id_task+label+id_input);
            if(rs1.next()){
                value = rs1.getString("value");
                valid = rs1.getInt("valid");
                System.out.println(value+valid);
                if(valid != 0 && value != null){
                    lb = new Label(label + ": " + value);
                    vl.addComponent(lb);
                }else if(valid != 0 ){
                    hl = new HorizontalLayout();
                    lb = new Label(label);
                    hl.addComponent(lb);
                    if(id_input == 1){
                        tf = new TextField();
                        hl.addComponent(tf);
                    }else if(id_input == 2){
                        ta = new TextArea();
                        hl.addComponent(ta);
                    }else if(id_input == 3){
                        df = new DateField();
                        hl.addComponent(df);
                    }else if(id_input == 4){
                        //upload
                    }
                    vl2.addComponent(hl);
                }
            }else{
                    hl = new HorizontalLayout();
                    lb = new Label(label);
                    hl.addComponent(lb);
                    if(id_input == 1){
                        tf = new TextField();
                        hl.addComponent(tf);
                    }else if(id_input == 2){
                        ta = new TextArea();
                        hl.addComponent(ta);
                    }else if(id_input == 3){
                        df = new DateField();
                        hl.addComponent(df);
                    }else if(id_input == 4){
                        //upload
                    }
                   // vl2.addComponent(hl);
            }
        }
		
		taskwindow.setContent(vl2);
		taskwindow.setWidth("600px");
		taskwindow.setHeight("350px");
		getApplication().getMainWindow().addWindow(taskwindow);
		}
	
	
	public VerticalLayout showconference(){
		
		vl = new VerticalLayout();
		Button addconf = new Button("New conference", this, "quit");
		lefttest1 = new Label("CONFERENCE ONE");
		lefttest2 = new Label("CONFERENCE TWO");
		lefttest3 = new Label("CONFERENCE THREE");
		vl.addComponent(lefttest1);
		vl.addComponent(lefttest2);
		vl.addComponent(lefttest3);
		vl.addComponent(addconf);
		vl.setComponentAlignment(lefttest1,Alignment.MIDDLE_CENTER);
		
		vl.addStyleName("styleConference");
		
		
		return vl;
	}
	public void quit() {
		getApplication().close();
	}
	public int getModelFR(int id_conf) throws Exception{
        con = new MysqlConnection();
        ResultSet rs = con.queryTable("select modelFR from conference where id_conference = " + id_conf);
        rs.next();
        return rs.getInt("modelFR");
    }

    //find number of notes for a model FR (FR)
    public int getNbNotes(int modelFR) throws Exception{
        con = new MysqlConnection();
        ResultSet rs = con.queryTable("select count(distinct(note)) as num1 from FR where modelFR = " + modelFR);
        rs.next();
        return rs.getInt("num1");
    }

    //find number of tasks for a note (FR)
    public int getNbTasks(int modelFR, int note) throws Exception{
        con = new MysqlConnection();
        ResultSet rs = con.queryTable("select count(id_task) as num2 from FR where modelFR = " + modelFR + " and note = " + note);
        System.out.println("select count(id_task) as num2 from FR where modelFR = " + modelFR + " and note = " + note);
        rs.next();
        return rs.getInt("num2");
      
    }

    //find number of tasks for a note (conf_FR)------if =0, red; <NbTasks, orange; =Nbtasks, green 
    public int getNbTasks_conf(int id_conf, int note) throws Exception{
        con = new MysqlConnection();
        ResultSet rs = con.queryTable("select count(conf_FR.id_task) as num3 from conf_FR " 
                             + " join FR on FR.id_task = conf_FR.id_task where id_conference = " + id_conf + " and valid = 1 and note = " + note);
        rs.next(); System.out.println("select count(conf_FR.id_task) as num3 from conf_FR " 
                                      + " join FR on FR.id_task = conf_FR.id_task where id_conference = " + id_conf + " and valid = 1 and note = " + note);
                             
        return rs.getInt("num3");
                            
    }

    //red-orange-green
    public void getColorCount(int modelFR, int id_conf) throws Exception{
        int Nbtasks=0; 
        int Nbtasks_conf=0;
        int nbNotes = getNbNotes(modelFR);
        for(int i = 1; i<= nbNotes; i++){
            Nbtasks = getNbTasks(modelFR, id_conf);System.out.println(Nbtasks+"Nbtasks");
            Nbtasks_conf = getNbTasks_conf(id_conf, i);System.out.println(Nbtasks_conf+"Nbtasks_conf");
            if(Nbtasks_conf == 0){
                noterednumber++;
            }else if(Nbtasks_conf < Nbtasks ){
                noteorangenumber++;
            }else{
                notegreennumber++;
            }
        }
    System.out.println(nbNotes+"nbNotes");
    
    
    }

    //list of tasks for a node
    public ResultSet getTasks(int modelFR, int note) throws Exception{
        con = new MysqlConnection();
        ResultSet rs = con.queryTable("select id_task, label, id_input from FR where modelFR = " 
                               + modelFR + " and note =" + note + " order by orderTask");
        System.out.println("select id_task, label, id_input from FR where modelFR = " 
                + modelFR + " and note =" + note + " order by orderTask");
       return rs;
    } 

    public ResultSet getTask_conf(int id_task) throws Exception{
        con = new MysqlConnection();
        ResultSet rs = con.queryTable("select value, valid from conf_FR where id_task = " + id_task);
        System.out.println("select value, valid from conf_FR where id_task = " + id_task);
        return rs;
    }
    
        

 

}