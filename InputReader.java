import java.util.*;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is then chopped into words, and a set of words 
 * is provided.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 7.0
 */
public class InputReader
{
    private Scanner reader;
    private ArrayList input;
    private boolean reading;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in).useDelimiter(" ");
        input = new ArrayList();
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public ArrayList getInput()
    {
        // debug System.out.println(reader.delimiter());
        System.out.print("> ");
        reading=true;
        while(reading){
            input.clear();
                if(reader.hasNext()){                                
                    String inputWord = reader.next();
                    input.add(inputWord);           
            }
            //debug System.out.println(input.size());
            //debug for(int i=0; i<input.size();++i){
            //debug    System.out.println(input.get(i));
            //debug }
            reading = false;
        }
        reading=true;
        return input;
    }
    
    //public HashSet<String> getInputv2()
    //{
       // System.out.print("> ");
       // String[] inputString = reader.nextLine().split("[s\\.]");
       // return inputString;
    //}
}
