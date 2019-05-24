package com.example.connor.rest_database.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
public class People {
  @Id
  public ObjectId _id;
 
  public String firstName;
  public String lastName; 
  public int age;
 
  // Constructors
  public People() {}
 
  public People(ObjectId _id, String firstName, String lastName, int age) {
    this._id = _id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
 
  // ObjectId needs to be converted to string
  public String get_id() { return _id.toHexString(); }
  public void set_id(ObjectId _id) { this._id = _id; }
 
  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }
 
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }
 
  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
}
