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
    private HashSet<String> input2;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in).useDelimiter(" ");
        input = new ArrayList();
        input2 = new HashSet<>();
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
            do{                                
                    String inputWord = reader.next();
                    input.add(inputWord);           
            }while(reader.hasNext());
            //debug System.out.println(input.size());
            //debug for(int i=0; i<input.size();++i){
            //debug    System.out.println(input.get(i));
            //debug }
            reading = false;
        }
        reading=true;
        return input;
    }
    
    public HashSet<String> getInputv2()
    {
        System.out.print("> ");
        input2.clear();
        String line = reader.nextLine().trim().toLowerCase();
        Scanner lineScanner = new Scanner(line);
        while(lineScanner.hasNext()){
            input2.add(lineScanner.next());
        }
        return input2;
    }
}
