package com.eloqui.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.eloqui.model.Request;

public class SuggestionEngine
{
    private static class WordScore
    {
        String word; double score;
        public String getWord()
        {
            return word;
        }
        public double getScore()
        {
            return score;
        }
        WordScore(String word, double score)
        {
            this.word = word;
            this.score = score;
        }
               
    }
    
    public SuggestionEngine()
    {
        usersByWord = new HashMap<>();        
    }
    
    public SuggestionEngine(Map<String, HashSet<String>> usersByWord)
    {
        this.usersByWord = usersByWord;        
    }
    
    protected double getDotProduct(HashSet<String> vectorA, HashSet<String> vectorB)
    {
        if (vectorA == vectorB) return !vectorA.isEmpty() ? vectorA.size() : 0.0;
        if (vectorB == null) return 0.0;
        HashSet<String> copy = new HashSet<String>(vectorA);
        copy.removeAll(vectorB);
        return vectorA.size()  - copy.size() == 0 ? 0 : copy.size();
    }
    
    public void logRequest(Request request)
    {
        requests.add(request);
        HashSet<String> users = usersByWord.get(request.getWord());
        if(users == null)
        {
            users = new HashSet<>();
            users.add(request.getUserId());
            usersByWord.put(request.getWord(), users);
        }
        else
        {
            users.add(request.getUserId());
        }
        
        HashSet<String> wordSetForUser = wordsByUser.get(request.getUserId());
        if(wordSetForUser == null)
        {
            wordSetForUser = new HashSet<>();
        }
        wordSetForUser.add(request.getWord());
        wordsByUser.put(request.getUserId(),wordSetForUser);
        
    }
    
    protected double computeCosineSimilarity(String word1, String word2)
    {
        HashSet<String> vectorA = usersByWord.get(word1);
        HashSet<String> vectorB = usersByWord.get(word2);
        if (vectorA == null || vectorB == null) return 0.0;
        return getDotProduct(vectorA, vectorB)/(getDotProduct(vectorA, vectorA) * getDotProduct(vectorB, vectorB));        
    }
    
    public List<String> getSuggestions(String user, List<String> documentWords)
    {
        List<WordScore> words = new ArrayList<>();
        for (String word2 : documentWords)
        {
            double score = 0.0;
            for (String word : wordsByUser.get(user))
            {
                score += getDotProduct(usersByWord.get(word), usersByWord.get(word2));                
            }
            words.add(new WordScore(word2, score));
        }
        Collections.sort(words, new Comparator<WordScore>()
        {
            @Override
            public int compare(WordScore arg0, WordScore arg1)
            {
                return Double.compare(arg1.getScore(), arg0.getScore());
            }
        });
        
        List<String> possibilities = new ArrayList<>();
        for (WordScore phrase : words)
        {
            possibilities.add(phrase.getWord());
        }
        
        return possibilities;
        
    }

    List<Request> requests = new ArrayList<>();;
    Map<String, HashSet<String>> usersByWord;
    Map<String, HashSet<String>> wordsByUser = new HashMap<>();;
}
