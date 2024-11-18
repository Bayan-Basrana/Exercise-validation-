package com.example.eventsystem.Controller;

import com.example.eventsystem.Model.Event;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events=new ArrayList<Event>();


    @GetMapping("/get")
    public ResponseEntity getEvents() {
        return ResponseEntity.ok(events);
    }

    @PostMapping("/add")
    public ResponseEntity addEvent(@RequestBody @Valid Event event, Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        events.add(event);
        return ResponseEntity.status(200).body("event added successfully");
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEvent(@PathVariable int index,  @RequestBody @Valid Event event, Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        events.set(index, event);
        return ResponseEntity.status(200).body("event updated successfully");
    }
@DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEvent(@PathVariable int index) {
        events.remove(index);
        return ResponseEntity.status(200).body("event deleted successfully");
    }

    @PutMapping("/changeCapacity/{id}")
    public ResponseEntity changeCapacity(@PathVariable String id ,@RequestBody @Valid Integer capacity ,Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        for (Event e : events) {
            if (e.getId().equalsIgnoreCase(id)) {
                e.setCapacity(capacity);
            }
        }return ResponseEntity.status(200).body("capacity updated successfully");
    }



    @GetMapping("/eventBy-id/{id}")
    public Event getEventById(@PathVariable String id) {
        for (Event event : events) {
            if (event.getId().equalsIgnoreCase(id)) {
                return event;
            }
        }return  null;
    }


}
