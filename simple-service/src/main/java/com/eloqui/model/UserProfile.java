package com.eloqui.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserProfile
{
    String firstName, lastName, email, password;
    String nickName;
    
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    boolean isMale;
    
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getNickName()
    {
        return nickName;
    }
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }
    public boolean isMale()
    {
        return isMale;
    }
    public void setMale(boolean isMale)
    {
        this.isMale = isMale;
    }                
}