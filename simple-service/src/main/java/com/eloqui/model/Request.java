package com.eloqui.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Request
{
    String userId, word;
    
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    public String getWord()
    {
        return word;
    }
    public void setWord(String word)
    {
        this.word = word;
    }
    public Date getDate()
    {
        return date;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    Date date;

}
