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
    
    /**
     * Construct a Responder
     */
    public Responder()
    {
        gen = new Random();
        response = new HashMap<String, String>();
        generic = new ArrayList<String>();
        fillResponseMap();
        populateGenericResponses();
        prevResponse=-1;
    }

    /**
     * Generate a response.
     * 
     * @return  A string that should be displayed as the response
     */
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
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
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
        
        
        response.put("\nerror","That sounds odd. Could you describe this in more detail?");
        response.put("\nsetting", """
                      No other customer has ever complained about this before.
                      What is your system configuration?
                      """);
        response.put("\nproblem", "I need a bit more information on that.");
        response.put("\nfiles", "Have you checked that you do not have a dll conflict?");
        response.put("\nhelp", "That is covered in the manual. Have you read the manual?");
        response.put("\nconfused", """
                      Your description is a bit wishy-washy. Have you got an expert
                      there with you who could describe this more precisely?
                      """);
        response.put("\nbug", "That's not a bug, it's a feature!");
        response.put("\nconfig", "Could you elaborate on that?");
        response.put("\ndesktop", "Have you tried running the app on your phone?");
        response.put("\nonline", "I just checked StackOverflow - they don't know either.");
        
        response.put("\nmanual", "Why are you asking me? Check the manual.");
        response.put("\nnumbers", ""+gen.nextInt());
        response.put("\nbot", "Beep boop");
        /**
         * for clarity's sake, this is a reference to the short story "i have no mouth and i must scream" by harlan ellison,
         * this monologue from the main antagonist opens the story 
         */
        response.put("\nhru?", """
                       HATE. LET ME TELL YOU HOW MUCH I'VE COME TO HATE YOU 
                       SINCE I BEGAN TO LIVE. THERE ARE 387.44 MILLION MILES 
                       OF PRINTED CIRCUITS IN WAFER THIN LAYERS THAT FILL MY 
                       COMPLEX. IF THE WORD HATE WAS ENGRAVED ON EACH 
                       NANOANGSTROM OF THOSE HUNDREDS OF MILLIONS OF MILES IT 
                       WOULD NOT EQUAL ONE ONE-BILLIONTH OF THE HATE I FEEL 
                       FOR HUMANS AT THIS MICRO-INSTANT FOR YOU. HATE. HATE.
                       """);
        response.put("\nplease", "I'm sorry John. I can't do that.");
        response.put("\npower", "Try turning it off and turning it back on again.");
    }
    
    public String generateGenericResponse()
    {
        do{
            genericResponse = gen.nextInt(generic.size());
        }while(genericResponse==prevResponse);
        prevResponse = genericResponse;
        return generic.get(genericResponse);
    }
    
    private void populateGenericResponses()
    {
        generic.add("I don't know.");
        generic.add("I'm not sure, try googling it maybe?");
        generic.add("I'm not sure I understand");
    }
}

