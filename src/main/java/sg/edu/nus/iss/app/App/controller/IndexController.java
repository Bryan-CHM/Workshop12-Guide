package sg.edu.nus.iss.app.App.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.app.App.model.Person;

import org.springframework.http.MediaType;

@Controller
@RequestMapping(path="/demo", produces = MediaType.TEXT_HTML_VALUE)
public class IndexController {
 
 @GetMapping("/currtime")
 public String getCurrDateTime(Model model){
  model.addAttribute("currtime",new Date().toString()); 
  return "currtime";
 }

 @GetMapping("/person")
 public String getPerson(Model model){
  Person p = new Person();
  p.setId(1);
  p.setFirstName("Bryan");
  p.setLastName("Chan");
  p.setGender('M');
  model.addAttribute("person",p); 
  return "person";
 }

 @GetMapping("/allperson")
 public String getAllPerson(Model model){
  ArrayList<Person> allPerson = new ArrayList<Person>();

  Person p = new Person();
  p.setId(1);
  p.setFirstName("Bryan");
  p.setLastName("Chan");
  p.setGender('M');
  allPerson.add(p);

  Person p2 = new Person();
  p2.setId(2);
  p2.setFirstName("TestUser");
  p2.setLastName("TestUserLast");
  p2.setGender('F');
  allPerson.add(p2); 

  model.addAttribute("allperson",allPerson); 
  return "allperson";
 }

 @GetMapping("/searchperson")
 public String searchPerson(@RequestParam(required=true) String firstName, Model model){
  ArrayList<Person> allPerson = new ArrayList<Person>();
  Person pResult = null;

  Person p = new Person();
  p.setId(1);
  p.setFirstName("Bryan");
  p.setLastName("Chan");
  p.setGender('M');
  allPerson.add(p);

  Person p2 = new Person();
  p2.setId(2);
  p2.setFirstName("TestUser");
  p2.setLastName("TestUserLast");
  p2.setGender('F');
  allPerson.add(p2);

  if(firstName.equals("Bryan")){
   pResult = p;
  }
  if(firstName.equals("TestUser")){
   pResult = p2;
  }
 
  model.addAttribute("result",pResult); 
  return "searchperson"; 
 }

 @GetMapping("/getsomeone/{firstName}")
 public String getBryan(@PathVariable(name="firstName") String firstName, Model model){
  Person p = new Person();

  if(firstName.equals("Bryan")){
  p.setId(1);
  p.setFirstName("Bryan");
  p.setLastName("Chan");
  p.setGender('M');
  }

  if(firstName.equals("TestUser")){
  p.setId(1);
  p.setFirstName("TestUser");
  p.setLastName("TestUserLast");
  p.setGender('F');
  }

  model.addAttribute("result",p); 
  return "pathvar";
 }
}
