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
        // print prompt
        System.out.println(reader.delimiter());
        System.out.print("> ");
        reading=true;
        while(reading){
            input.clear();
                if(reader.hasNext()){
                                
                    String inputWord = reader.next();
                    input.add(inputWord);
            
            }
            System.out.println(input.size());
            for(int i=0; i<input.size();++i){
                System.out.println(input.get(i));
            }
            reading = false;
        }
        reading=true;
        return input;
    }
}
