import java.util.*;

/**
 * The responder class represents a response generator object. It is used
 * to generate an automatic response. This is the second version of this 
 * class. This time, we generate some random behavior by randomly selecting 
 * a phrase from a predefined list of responses.
 * 
 * @author   Michael Kölling and David J. Barnes
 * @version 7.2
 */
public class Responder
{
    private Random gen;
    private HashMap<String, String> response;
    private ArrayList<String> generic;
    private boolean answered;
    private int genericResponse;
    private int prevResponse;
    private String answer;
    private boolean answering;
    private boolean searched;
    private HashMap<String, String> genericPlus;
    
    /**
     * Construct a Responder
     */
    public Responder()
    {
        gen = new Random();
        response = new HashMap<String, String>();
        generic = new ArrayList<String>();
        genericPlus = new HashMap<String, String>();
        fillResponseMap();
        populateGenericResponses();
        populateBetterGenerics();
        prevResponse=-1;
    }

    /**
     * Generate a response.
     * -DEPRECATED- This method was retained for documentation's sake.
     * 
     * @see generateResponsev2(HashSet<String> input)
     * @return  A string that should be displayed as the response
     */
    //q37
    public String generateResponse(ArrayList input)
    {       
        answered = false;
        searched = false;
        answering = true;
        while(answering){
            while(!searched){
                for(int i=0; i<input.size(); ++i){
                    if(response.containsKey(input.get(i))){
                        answered = true;
                        answering = false;
                        searched = true;
                        answer = response.get(input.get(i));
                    }
                }
                searched = true;
            }
            if(!answered){
                answering = false;
                answered = false;
            }
        }
        if(!answered){
            return generateGenericResponse();
        }
        else{
            return answer;
        }
    }
    
    /**
     * Generate a response.
     * 
     * @return A String to be displayed as an answer.
     */
    //37
    public String generateResponsev2(HashSet<String> input)
    {
        answered = false;
        String solution = new String("Here are some solutions: \n");
        for(String word : input){
            if(response.containsKey(word)){
                //q41
                solution = solution + response.get(word) + String.format("%n");
                answered = true;
            }
        }
        if(answered){
            return solution;
        }
        //q42
        for(String word2 : input){
            if(genericPlus.containsKey(word2)){
                return genericPlus.get(word2);
            }
        }
        return generateGenericResponse();
    }

    /**
     * Builds the list of basic answers to search through.
     */
    //q33
    private void fillResponseMap()
    {
        response.put("error","That sounds odd. Could you describe this in more detail?");
        response.put("setting", """
                      No other customer has ever complained about this before.
                      What is your system configuration?
                      """);
        response.put("problem", "I need a bit more information on that.");
        response.put("files", "Have you checked that you do not have a dll conflict?");
        response.put("help", "That is covered in the manual. Have you read the manual?");
        response.put("confused", """
                      Your description is a bit wishy-washy. Have you got an expert
                      there with you who could describe this more precisely?
                      """);
        response.put("bug", "That's not a bug, it's a feature!");
        response.put("config", "Could you elaborate on that?");
        response.put("desktop", "Have you tried running the app on your phone?");
        response.put("online", "I just checked StackOverflow - they don't know either.");
        
        //q38
        response.put("manual", "Why are you asking me? Check the manual.");
        response.put("numbers", ""+gen.nextInt());
        response.put("bot", "Beep boop");
        /**
         * for clarity's sake, this is a reference to the short story "i have no mouth and i must scream" by harlan ellison, 
         * this monologue from the main antagonist opens the story 
         */
        response.put("hru?", """
                       HATE. LET ME TELL YOU HOW MUCH I'VE COME TO HATE YOU 
                       SINCE I BEGAN TO LIVE. THERE ARE 387.44 MILLION MILES 
                       OF PRINTED CIRCUITS IN WAFER THIN LAYERS THAT FILL MY 
                       COMPLEX. IF THE WORD HATE WAS ENGRAVED ON EACH 
                       NANOANGSTROM OF THOSE HUNDREDS OF MILLIONS OF MILES IT 
                       WOULD NOT EQUAL ONE ONE-BILLIONTH OF THE HATE I FEEL 
                       FOR HUMANS AT THIS MICRO-INSTANT FOR YOU. HATE. HATE.
                       """);
        response.put("please", "I'm sorry John. I can't do that.");
        response.put("power", "Try turning it off and turning it back on again.");
        response.put("missile", """
                                The missile knows where it is at all times. 
                                It knows this because it knows where it isn't. 
                                By subtracting where it is from where it isn't, 
                                or where it isn't from where it is (whichever is greater), 
                                it obtains a difference, or deviation. The guidance subsystem 
                                uses deviations to generate corrective commands to drive the 
                                missile from a position where it is to a position where it isn't, 
                                and arriving at a position where it wasn't, it now is. 
                                Consequently, the position where it is, is now the position 
                                that it wasn't, and it follows that the position that it was, 
                                is now the position that it isn't.

                                In the event that the position that it is in is not the 
                                position that it wasn't, the system has acquired a variation, 
                                the variation being the difference between where the missile is, 
                                and where it wasn't. If variation is considered to be a 
                                significant factor, it too may be corrected by the GEA. However, 
                                the missile must also know where it was.

                                The missile guidance computer scenario works as follows. 
                                Because a variation has modified some of the information 
                                the missile has obtained, it is not sure just where it is. 
                                However, it is sure where it isn't, within reason, and it 
                                knows where it was. It now subtracts where it should be 
                                from where it wasn't, or vice-versa, and by differentiating 
                                this from the algebraic sum of where it shouldn't be, and 
                                where it was, it is able to obtain the deviation and its 
                                variation, which is called error.
                                """);
    }
    
    /**
     * Generates a generic response, if no other response was found.
     * 
     * @return A String to be displayed as the answer.
     */
    //q33
    public String generateGenericResponse()
    {
        //q39
        do{
            genericResponse = gen.nextInt(generic.size());
        }while(genericResponse==prevResponse);
        prevResponse = genericResponse;
        return generic.get(genericResponse);
    }
    
    /**
     * Builds the list of generic answers to generate from.
     */
    //q33
    private void populateGenericResponses()
    {
        generic.add("I don't know.");
        generic.add("I'm not sure, try googling it maybe?");
        generic.add("I'm not sure I understand");
    }
    
    /**
     * Builds the list of semi-generic responses to search from.
     */
    //q42
    private void populateBetterGenerics()
    {
        genericPlus.put("why", "Because computers are dumb.");
        genericPlus.put("who","Your administrator might be able to help with that.");
        genericPlus.put("how","Check the help page maybe?");
    }
}

