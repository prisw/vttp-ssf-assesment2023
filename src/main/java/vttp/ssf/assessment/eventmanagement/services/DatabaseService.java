package vttp.ssf.assessment.eventmanagement.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import jakarta.json.JsonValue;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.Register;

@Service
public class DatabaseService {
    
    // TODO: Task 1

    public List<Event> readFile() throws Exception{
       
        List<Event> events = new ArrayList<>();

        String pathFile="target/events.json";
        File file = new File(pathFile);
        InputStream is = new FileInputStream(file);
        StringBuilder resuStringBuilder = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line ="";
            while((line=br.readLine()) != null) {
                resuStringBuilder.append(line);
            }
        }  String data = resuStringBuilder.toString();

            //reads json
            JsonReader jreader = Json.createReader(new StringReader(data));

            for(JsonValue jvalue: jreader.readArray()) {
                JsonObject obj = jvalue.asJsonObject();
                Integer eventId = obj.getInt("eventId");
                String eventName = obj.getString("eventName", "");
                Integer eventSize = obj.getInt("eventSize");
                Long eventDate = (long) obj.getInt("eventDate");
                Integer participants =obj.getInt("participants");
                events.add(new Event(eventId,eventName,eventSize,eventDate,participants));
            }

        return events;
    }

    public Integer participantCount(Event event, Register register){

        Integer totalParticipants = 0;
        Integer totalTickets =0;
        String eventsName = event.getEventName();
        if(eventsName.equalsIgnoreCase(("Christmas Eve Party"))){
            totalParticipants = 20;
        } else if(eventsName.equalsIgnoreCase("eventRound Singapore Cyclings")|| eventsName.equalsIgnoreCase("Intro to SCRATCH")|| eventsName.equalsIgnoreCase("JB Shopping !")) {
            totalParticipants = 5;
        }

        Integer ticketAcquired = register.getTickets();
        Integer maximumTicket = 0;
        if(eventsName.equalsIgnoreCase(("Christmas Eve Party"))){
            maximumTicket = 20;
        } else if(eventsName.equalsIgnoreCase("eventRound Singapore Cyclings")|| eventsName.equalsIgnoreCase("Intro to SCRATCH")|| eventsName.equalsIgnoreCase("JB Shopping !")) {
            maximumTicket = 5;
        }
        
        return ticketAcquired;
        
    }


  
}
