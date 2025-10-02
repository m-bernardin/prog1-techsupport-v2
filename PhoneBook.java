import java.util.HashMap;
/**
 * q24
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhoneBook
{
    private HashMap<String, String> phoneBook;
    public PhoneBook()
    {
        phoneBook = new HashMap<>();
    }
    
    public void enterNumber(String name, String number)
    {
        phoneBook.put(name, number);
    }
    
    public void lookupNumber(String name)
    {
        String number = phoneBook.get(name);
        System.out.println(name + ": " + number);
    }
}
