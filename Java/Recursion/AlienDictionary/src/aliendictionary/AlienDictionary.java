/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aliendictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author lucky
 */
public class AlienDictionary {

    /**
     * @param args the command line arguments
     */
    public static void printGraph(HashMap<Character,HashSet<Character>> graph, int[] degree){
        for(Character c: graph.keySet()){
            System.out.print(c+"->");
            for(int i = 0; i<graph.get(c).size(); i++){
                System.out.print(graph.get(c).toArray()[i]);
            }
            System.out.println();
        }
        for(int i = 0; i < degree.length; i++){
            char c = (char)(i+'a');
            System.out.print(c+"  ");
        }
        System.out.println();
        for(int i = 0; i < degree.length; i++){
            System.out.print(degree[i]+"  ");
        }
    }
    
    public static String topologicalSort(HashMap<Character,HashSet<Character>> graph, int[] degree){
        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        //Search for 0 degree nodes on the graph
        for(Character c : graph.keySet()){
            if(degree[c-'a']==0){
                queue.add(c);
            }
        }
        while(!queue.isEmpty()){
            Character c = queue.poll();
            result.append(c);
            for(Character neighbor : graph.get(c)){
                degree[neighbor-'a']--;
                if(degree[neighbor-'a']==0){
                    queue.add(neighbor);
                }
            }
        } 
        return result.toString();
    }
    public static HashMap<Character,HashSet<Character>> buildGraph(String[]words, int[] degree){
        HashMap<Character,HashSet<Character>> graph = new HashMap<Character,HashSet<Character>>();
        //Create the map template: every letter on the dictionary with empty adjacents
        for(String word:words){
            for(int i = 0; i<word.length(); i++){
                graph.put(word.charAt(i),new HashSet<Character>());
            }
        }
        for(int i = 1; i<words.length; i++){
            String wordparent = words[i-1];
            String wordchildren = words[i];
            int len = Math.min(wordparent.length(),wordchildren.length());
            for(int j = 0; j<len; j++){
                if(wordparent.charAt(j)!=wordchildren.charAt(j)){
                    if(!graph.get(wordparent.charAt(j)).contains(wordchildren.charAt(j))){
                        graph.get(wordparent.charAt(j)).add(wordchildren.charAt(j));
                        degree[wordchildren.charAt(j)-'a']++;
                    }
                }
            }
        }
        return graph;       
    }
    public static String alienOrder(String[]words){
        if(words.length==0)
            return "";
        HashMap<Character,HashSet<Character>> graph = new HashMap<Character,HashSet<Character>>();
        int[] degree = new int[26];
        graph = buildGraph(words,degree);
        printGraph(graph,degree);
        String result = topologicalSort(graph,degree);
            
        return result.length()==graph.size()? result:"";
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        String[]words = {"wrt","wrf","er","ett","rftt"};
        String result = alienOrder(words);
        System.out.println();
        System.out.println("Alien Order  " +result); 
    }
    
}
