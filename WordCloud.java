import java.io.*;
import java.util.*;
import java.util.HashMap; 
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
//What is a comparator class? it is implemented by stuff but we have to tweak it to what we want.
/**
 * Author: Mohsin Qureshi
 * Student Number: 100836228
 * This function reads in a text document, counts the occurence of words and determines the 10 most frequently used words.
 */
public class WordCloud
{



    //public final Comparator<String> comparer = new Comparator<String>() {

    //public int compare(String s1, String s2) {
    //    int result = s1.compareToIgnoreCase(s2);
    //    if( result == 0 )
    //       result = s1.compareTo(s2);
    //   return result;
   //    }
   //};
 


    protected BufferedReader fileReader;
    protected PrintWriter fileWriter;
    private int x;

    HashSet HSet = new HashSet();
    Map<String,Integer> mp=new HashMap<String,Integer>();
    //Map< String, Integer > tm = new TreeMap< String, Integer >(comparer);
    Map< String, Integer > tm = new TreeMap< String, Integer >();
    /**
     * Constructor for objects of class WordCloud
     */
    public WordCloud()
    {
        // initialise instance variables
        openFiles();
        docWords();
        TreeMap tm = new TreeMap(mp); 
        System.out.println(tm.size());
        
        
        
        
        //now that it is in the tree. i need to output the 10 with the highest frequency...
        

        //now use the comparor to get the top 10 and print them onto console.
        //tm.compare
        
        //what the hell is all this code.....
    List<Integer> list= new ArrayList<Integer>();
    for(Map.Entry<String, Integer> m:  mp.entrySet()){
        list.add(m.getValue());
    }
    Collections.sort(list);
    Map<ArrayList,Integer> sortedmp= new HashMap<ArrayList,Integer>();
    for(Map.Entry<String, Integer> m:mp.entrySet()){
        int tempage=m.getValue();
        List<String> tempname= new ArrayList<String>();
        for(Map.Entry<String, Integer> m1:mp.entrySet()){
         if(m1.getValue()==tempage)
             tempname.add(m1.getKey());
        }
        if(!sortedmp.containsKey(tempage)){
            Collections.sort(tempname);
            sortedmp.put((ArrayList) tempname,tempage);
        }

    }
    for(Map.Entry<ArrayList,Integer> m:sortedmp.entrySet()){
        System.out.println("key--->"+m.getKey()+" value--->"+m.getValue());
    }
        
        
      //List<Integer> c = new ArrayList<Integer>(mp.values());
      //Collections.sort(c);
      //for(int i=0 ; i< 10; ++i) {
      //  System.out.println(i + " rank is " + c.get(i)); 
      //}
        
    }
 
    public static void main(String args[]) {
        
        
        WordCloud wc = new WordCloud();
        
        //------------------------Example of HashSet----------------------------
        //a set does not allow for duplicate elements.
        //HashSet HSet = new HashSet();

        //HSet.add("C");
        //HSet.add("A");
               
        //System.out.println("The HashSet elements are: " + HSet);
        //-----------------------------------------------------------------------
   
        //------------------------Example of HashMap-----------------------------
        //Map<Object,String> mp=new HashMap<Object, String>();
        //mp.put(new Integer(2), "Two");
        //mp.put(new Integer(1), "One");
        
        //Map<Object,String> mp2=new HashMap<Object, String>();
        //mp2.put(new Integer(2), "Two2");
        //mp2.put(new Integer(1), "One2");
        
        //putting both maps into one map... no need..... but cool i guess....
        
        //Map<String, Object> mpMaps=new HashMap<String, Object>();

        //mpMaps.put("Map1",mp);
        //mpMaps.put("Map2",mp2);/
        
        //System.out.println("This is a map of Maps:   " + mpMaps); 
         //HashMap map = new HashMap();
         //map.add( new Integer( 2 ), "two" );
         //map.add( new Integer( 4 ), "four" );
         //System.out.println( map );
         //System.out.println();
          //----------------------------------------------------------------------
          
        //------------------Or should i use a TreeSet or a Tree Map?---------------
        //-------------------------------------------------------------------------
    }
    
    
    /**
     * Opens the Stopwords file and adds them to a HashSet
     */
    public PrintWriter openFiles()
    {
        //HashSet HSet = new HashSet();
        String x=" ";
     //final String IN_FILE_PROMPT =
     // "Please enter the path for the input file: ";
     //final String OUT_FILE_PROMPT =
     // "Please enter the path for the output file: ";
     //BufferedReader keyboardReader = new BufferedReader
     // (new InputStreamReader (System.in));
     String inFilePath,
     outFilePath;
     boolean pathsOK = false;

     while (!pathsOK)
     {
      try
      {
        //System.out.print (IN_FILE_PROMPT);
        inFilePath = "Stopwords.txt";
        fileReader = new BufferedReader(new FileReader (inFilePath));
        //System.out.print(OUT_FILE_PROMPT);
        //outFilePath = keyboardReader.readLine();
        //fileWriter = new PrintWriter(new FileWriter (outFilePath));
        pathsOK = true;
       } // try
       catch (IOException e)
       {
        System.out.println (e);
       } // catch I/O exception
     } // while
     
      try
      {
       //while(fileReader.readLine() != null){
       //    HSet.add(x);
       // }
       do{
           x = fileReader.readLine();
           if(x!=null){
           HSet.add(x);
        }
           
        }
       while(x!=null);
        }
       catch (IOException e)
       {
        System.out.println (e);
       }
       
       System.out.println(HSet.size());
       
     return null;
    } // method openFiles

     //Part 1
     //Have to add the Document words to a HashMap.
     //and while? im doing that i have to check for a few things.... USING a tokenizer.
     //the tokenizer will split the line and check for string that i dont want.. eg.. 1234!@#
     //Then i have to lower case them.
    
     //Part 2
     //Call next Token which is a fucntion in the hashmap?
     //compare the words to the set AND check that the length of words is more than 3 <--------- should this be in part 1?
     //IF the word is not in the SET then [[putword, 1]]
     //IF contains getvalue --> remove the key then [[putword, 2]]
    
     //Part 3
     //Send it to a Tree so that it is in order then output the top 10 words.
    /**
     * Adds the words in the Document to a hashmap.
     */
    public void docWords()
    {
        //Map<Object,String> mp=new HashMap<Object, String>();
        //-----------------------------the right one-----------Map<String,Integer> mp=new HashMap<String,Integer>();
        //mp.put(new Integer(2), "Two");
        //System.out.println(mp.size());
        
        String inFilePath,
        line,
        token,
        outFilePath;
        boolean pathsOK = false;
        int x;
        
         while (!pathsOK)
     {
      try
      {
        //System.out.print (IN_FILE_PROMPT);
       inFilePath = "CanadaCharter.txt";
       //inFilePath = "testing.txt";
        fileReader = new BufferedReader(new FileReader (inFilePath));
        //System.out.print(OUT_FILE_PROMPT);
        //outFilePath = keyboardReader.readLine();
        //fileWriter = new PrintWriter(new FileWriter (outFilePath));
        pathsOK = true;
       //} // try
       //catch (IOException e)
       //{
       // System.out.println (e);
       //} // catch I/O exception
     //} 
     
     //Lets tokenize the thing now.
     
     line = fileReader.readLine(); //when printed gives first line in file
     //try
     // {
     //while ((line = fileReader.readLine()) != null) {
         while (line != null) {
           //System.out.println(line);
           StringTokenizer stringTokenizer = new StringTokenizer (line,"\" 1234567890/\"@#$%^&*()_+.,\\");
     
           //where does it save to?????? does it save anywhere???
           
           while(stringTokenizer.hasMoreTokens()){
               
               token = stringTokenizer.nextToken();
               int i=1;
               
               String lowerCase = token.toLowerCase();
               
               //System.out.print("\n" + lowerCase); 
               
               
               //if( the lowerCase word is contained is NOT contained in the set. do-----
               
               if(HSet.contains(lowerCase) == false && lowerCase.length() >= 3 ){
               
               if(mp.containsKey(lowerCase) ==false)
               {
               mp.put(lowerCase, new Integer(i));
               //this only prints out the one of a kind words.
               //System.out.print("\n" + lowerCase); 
               
             }else if(mp.containsKey(lowerCase)){
               x = mp.get(lowerCase);
                 
                 mp.remove(lowerCase);
                 
                 mp.put(lowerCase, new Integer(x+1));
                 //remove 
                 //THEN put.
                 
                }
             
            }
             
               
               //Store it into the hash map here....
               
               //IF set does not contain the same word
                    //put it in a hash map with 1.
                       
                    //if it contains getvalue.. remove the key and add it to the hashmap with a 2.... and so on......
               
               
               
               
               //IF set does contain the word.... get rid of it// somehow.......
               
               
            }
           
           line = fileReader.readLine();
           
        } 
        //What is this code even doing?
        System.out.println(mp.size());
        
    } // try
       catch (IOException e)
       {
        System.out.println (e);
       }
   }
  
  //now to put it all into a hashtree
  
  }
 

 

}





