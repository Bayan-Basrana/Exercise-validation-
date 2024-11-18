package com.example.trackersystem.Conroller;

import com.example.trackersystem.Model.Project;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tracker")
public class trackerController {
ArrayList<Project> projects=new ArrayList();

@GetMapping("/get")
    public ResponseEntity getProject(){
return ResponseEntity.ok(projects);
    }
@PostMapping("/add")
    public ResponseEntity addProject (@RequestBody @Valid Project project , Errors errors){
    if(errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
projects.add(project);
        return ResponseEntity.status(200).body("project added successfully");
    }
@PutMapping("/update/{index}")
    public  ResponseEntity update (@PathVariable int index, @RequestBody @Valid Project project, Errors errors){
    if(errors.hasErrors()){
        String message= errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    projects.set(index,project);
    return ResponseEntity.status(200).body("project update successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity  deleteProject (@PathVariable int index){
    projects.remove(index);
    return ResponseEntity.status(200).body("project deleted successfully");
    }

@PutMapping("/changeStatus")
    public ResponseEntity changeStatus (){
for(Project project:projects){
    if (project.getStatus().equalsIgnoreCase("Not Started")){
        project.setStatus("in progress");
    } else if (project.getStatus().equalsIgnoreCase("in progress")) {
        project.setStatus("completed");
    }
}return ResponseEntity.status(200).body("change status successfully");
    }
    @GetMapping("/search/{title}")
    public ResponseEntity searchProjects(@PathVariable String title) {
        for(Project p : projects) {
            if(p.getTitle().equalsIgnoreCase(title)) {
                return ResponseEntity.status(200).body(p);
            }
        }  return null;
    }
    @GetMapping("/displayByCompanyName/{companyName}")
    public ResponseEntity displayByCompanyName(@PathVariable String companyName) {
        ArrayList<Project> projectByCompanyName = new ArrayList<>();
        for(Project p : projects) {
            if(p.getCompanyName().equalsIgnoreCase(companyName)) {
                projectByCompanyName.add(p);
            }
        }return ResponseEntity.status(200).body(projectByCompanyName);
    }


}
