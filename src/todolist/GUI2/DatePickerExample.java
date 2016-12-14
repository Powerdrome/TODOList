package todolist.GUI2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class DatePickerExample extends JPanel {
    JXDatePicker picker;   
    DatePickerExample(){
        picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        add(picker);
        setVisible(true);
    }
    
    public String getData(){
        Date oDate = picker.getDate();        
        DateFormat oDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return oDateFormat.format(oDate);
    }
}