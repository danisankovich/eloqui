package com.eloqui.engine;

import java.util.HashMap;
import java.util.Map;

import com.eloqui.model.UserLogin;
import com.eloqui.model.UserProfile;

public class RegistrationEngine
{
    public boolean userExists(UserProfile user)
    {
        return profileDataSource.containsKey(user.getEmail().toLowerCase());
    }
    
    public void register(UserProfile newUser)
    {
        profileDataSource.put(newUser.getEmail().toLowerCase(), newUser);
        return;
    }
    
    public UserProfile getUserProfile(UserLogin loginInfo)
    {
        return profileDataSource.get(loginInfo.getEmail());
    }

    Map<String, UserProfile> profileDataSource = new HashMap<>();
}
