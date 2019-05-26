/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aliendictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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
    
    public static boolean cycleRec(Character node, boolean[]visited, boolean[] recStack,HashMap<Character,HashSet<Character>> graph){
        if(!visited[node-'a']){
            visited[node-'a']=true;
            recStack[node-'a']=true;
            for(Character neighbor:graph.get(node)){
                if(!visited[neighbor-'a'] && cycleRec(neighbor,visited,recStack,graph)){
                    return true;
                }else if(recStack[neighbor-'a']){
                    return true;
                }
            }
        }
        recStack[node-'a']=false;
        return false;    
    }
    
    public static boolean cycle(HashMap<Character,HashSet<Character>> graph){
        boolean [] visited = new boolean[26];
        boolean [] recStack = new boolean[26];
        
        for (int i = 0 ; i < 26; i++){
            visited[i]=false;
            recStack[i]=false;
        }
        for(Character node : graph.keySet()){
           if(cycleRec(node,visited,recStack,graph)){
               return true;
           }
        }
        return false;
    }
    public static void dfs(Character c,HashMap<Character,HashSet<Character>> graph, boolean[]visited, Stack<Character> stack ){
        visited[c-'a']=true;
        for(Character neighbor : graph.get(c)){
            if(!visited[neighbor - 'a']){
                visited[neighbor - 'a']=true;
                dfs(neighbor,graph,visited,stack);
            }
        }
        stack.push(c);
    }
    
    public static String  topoSortDFS(HashMap<Character,HashSet<Character>> graph, boolean[] visited, Stack<Character> stack){
        for(Character c : graph.keySet()){
            if(visited[c-'a']==false){
                dfs(c,graph,visited,stack);
            }
        }
        String result = "";
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result;
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
                    break;
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
        //String result = topologicalSort(graph,degree);
        boolean [] visited = new boolean[26];
        for(int i = 0; i < visited.length; i++){
            visited[i]=false;
        }
        Stack<Character> stack = new Stack<>();
        String result = topoSortDFS(graph, visited, stack);
        System.out.println();
        if(cycle(graph))
            return "";
        return result.length()==graph.size()? result:"";
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //String [] words = {"jpoo","ztap","mhp","rzykfv","e","c","exubbjvmom","qi","tlrzz","krxme","svb"};
        //String [] words = {"wrt","wrf","er","ett","rftt"};
        String[]words = {"z","x","z"};
        String result = alienOrder(words);
        System.out.println();
        System.out.println("Alien Order  " +result); 
    }
    
}
