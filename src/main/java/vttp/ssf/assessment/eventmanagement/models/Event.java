package vttp.ssf.assessment.eventmanagement.models;



import java.text.SimpleDateFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    public Integer eventId;
    public String eventName;
    public Integer eventSize;
    public Long eventDate;
    public Integer participants;

    public String eventDateFormat() throws Exception{
        
        String dateAsString = String.valueOf(eventDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(dateAsString);
        return formattedDate;
    }    
 
    
}
