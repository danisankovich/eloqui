package com.eloqui.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.eloqui.model.Request;

public class SuggestionEngineTest
{
    SuggestionEngine engine;
    
    
    @Test
    public void testEngine()
    {
        engine = new SuggestionEngine();
        Request req = new Request();
        req.setUserId("user1");
        req.setWord("word1");
        engine.logRequest(req);
        
        
        req = new Request();
        req.setUserId("user2");
        req.setWord("word1");
        engine.logRequest(req);
        
        req = new Request();
        req.setUserId("user3");
        req.setWord("word1");
        engine.logRequest(req);
        
        req = new Request();
        req.setUserId("user4");
        req.setWord("word1");
        engine.logRequest(req);
        
        req = new Request();
        req.setUserId("user1");
        req.setWord("word2");
        engine.logRequest(req);
        
        req = new Request();
        req.setUserId("user2");
        req.setWord("word2");
        engine.logRequest(req);
        
        req = new Request();
        req.setUserId("user3");
        req.setWord("word2");
        engine.logRequest(req);
        
        req = new Request();
        req.setUserId("user4");
        req.setWord("word2");
        engine.logRequest(req);
        
        
        req = new Request();
        req.setUserId("user2");
        req.setWord("word3");
        engine.logRequest(req);
        
        req = new Request();
        req.setUserId("user1");
        req.setWord("word3");
        engine.logRequest(req);
        ;
        
       
        
        List<String> words = new ArrayList<>();
        words.add("word4");
        words.add("hello");
        words.add("milpitas");
        words.add("word1");
        words.add("word3");
        System.out.println(engine.getSuggestions("user3", words));
    }
}
