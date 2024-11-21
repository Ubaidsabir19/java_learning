package EmployeeData;

public class Address  {
    private String phoneNo;
    private int street;
    private String city;
    private String state;

    // Setters
    public void setPhoneNo(String  phoneNo){
        this.phoneNo = phoneNo;
    }
    public void setStreet(int street){
        this.street = street;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }

    // Getters
    public String  getPhoneNo(){
        return phoneNo;
    }
    public int getStreet(){
        return street;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }

}
