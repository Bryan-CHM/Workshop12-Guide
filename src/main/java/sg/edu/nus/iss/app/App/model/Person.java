package sg.edu.nus.iss.app.App.model;

public class Person {
 private Integer id;
 private String firstName;
 private String lastName;
 private Character gender;

 public void setId(Integer id){
this.id = id;
 }

 public Integer getId(){
  return this.id;
 }

 public void setFirstName(String firstName){
  this.firstName = firstName;
 }

 public String getFirstName(){
  return this.firstName;
 }

 public void setLastName(String lastName){
  this.lastName = lastName;
 }

 public String getLastName(){
  return this.lastName;
 }
 
 public void setGender(Character gender){
  this.gender = gender;
 }

 public Character getGender(){
  return this.gender;
 }
 
}
