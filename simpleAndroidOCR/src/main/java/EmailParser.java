import java.util.StringTokenizer;

/**
 * Parses a string to find all contained emails
 * Created by Craig on 02/04/2016.
 */
public class EmailParser {

    private String string;

    public static final String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    // Email Regular expression from : http://emailregex.com/


    /**
     * Constructs a parser for the given string
     * @param s The string to parse
     */
    public EmailParser(String s){
        this.string = s;
    }

    /**
     * Constructs a parser for the given string array
     * @param strings The string array to parse
     */
    public EmailParser(String[] strings){
        string = "";
        for(String s : strings){
            string += s;
        }
    }

    /**
     *  Parses the string to get all the email addresses that are in the string
     * @return The email addresses stored in string
     */
    public String[] parse(){
        StringTokenizer tokenizer = new StringTokenizer(string, emailRegex);
        String[] emails = new String[tokenizer.countTokens()];
        for(int i=0;i< emails.length;i++){
            emails[i] = tokenizer.nextToken();
        }
        return emails;
    }


}
