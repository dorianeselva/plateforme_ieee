package inscription;

import java.sql.ResultSet;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class HistoryData extends CustomComponent {
	//private MysqlConnection con;
	private TextField myTxtField;
	private TextArea myTxtArea;
	private DateField myDateField;
	private Upload myUpload;

	public VerticalLayout vl = new VerticalLayout();

	public HistoryData() {
		HD();
		setCompositionRoot(vl);
		vl.setSpacing(true);
		vl.setMargin(true);

	}

	public VerticalLayout HD() {
		vl = new VerticalLayout();

		try {
			MysqlConnection con;
			con = new MysqlConnection();

			ResultSet rs = con.queryTable("SELECT * FROM pre_hd order by orderpreHD");

			while (rs.next()) {
				String nameHD = null;
				int fieldtype = 0;
				nameHD = rs.getString("label");
				fieldtype = rs.getInt("id_input");

				switch (fieldtype) {
				case 1:
					myTxtField = new TextField(nameHD);
					vl.addComponent(myTxtField);
					vl.setComponentAlignment(myTxtField, Alignment.BOTTOM_LEFT);
					break;
				case 2:
					myTxtArea = new TextArea(nameHD);
					vl.addComponent(myTxtArea);
					vl.setComponentAlignment(myTxtArea, Alignment.BOTTOM_LEFT);
					break;
				case 3:
					myDateField = new DateField(nameHD);
					myDateField.setDateFormat("yyyy-MM-dd");
					vl.addComponent(myDateField);
					vl.setComponentAlignment(myDateField, Alignment.BOTTOM_LEFT);
					break;
				case 4:
					myUpload = new Upload(nameHD, null);
					vl.addComponent(myUpload);
					vl.setComponentAlignment(myUpload, Alignment.BOTTOM_LEFT);
					break;
				}
			}
			Button submit = new Button("Submit");
			vl.addComponent(submit);
			vl.setComponentAlignment(submit, Alignment.BOTTOM_LEFT);
		} catch (Exception e) {
			e.printStackTrace();
			getWindow().showNotification("Database error");
		}

		return vl;
	}
}