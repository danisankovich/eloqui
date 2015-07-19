package com.eloqui.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserLogin
{
    String email, password;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
