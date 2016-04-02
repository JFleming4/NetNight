import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;

/**
 * Sends an email to an email client selected by the user
 * Created by Craig on 02/04/2016.
 */
public class SendEmail {
    public static final String DEFAULT_SUBJECT = "Subject Line";
    public static final String DEFAULT_TEXT = "Body of email";

    private String subject;
    private String text;
    private File file;
    private Activity activity;

    /**
     * Creates an object with the needed info to send an email
     * @param subject The subject line of the email
     * @param text The body of the email
     * @param filename The filename of the attachment
     * @param activity The activity that is calling this function
     */
    public SendEmail(String subject, String text, String filename, Activity activity){
        this.subject = subject;
        this.text = text;
        this.activity = activity;
        //TODO Validate file
        file = new File(filename);
    }

    /**
     * Creates an object with needed info to send an email. Uses default subject and body.
     * @param filename The filename of attachment
     * @param activity The activity that is calling this function
     */
    public SendEmail(String filename, Activity activity){
        this(DEFAULT_SUBJECT, DEFAULT_TEXT, filename, activity);
    }

    /**
     * Sets the text of the email body
     * @param text The text of the email body
     */
    public void setText(String text){
        this.text = text;
    }

    /**
     * Sets the subject line of the email
     * @param subject The subject of the email
     */
    public void setSubject(String subject){
        this.subject = subject;
    }

    /**
     * Sends an email to an email client with the default subject, message body, and file attachment
     *  Sends to the specified recipient email
     * @param recipientEmails The email addresses of the recipients
     */
    public void sendEmail(String[] recipientEmails){
        // Set up the email to send
        Intent i = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        i.setType("message/rfc822");

        i.putExtra(Intent.EXTRA_EMAIL, recipientEmails);
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT, text);

        Uri u = Uri.fromFile(file);
        i.putExtra(Intent.EXTRA_STREAM, u);

        // Get user to select which mail client to use
        try{
            activity.startActivity(Intent.createChooser(i,"Choose an email client to send from:"));
        } catch (android.content.ActivityNotFoundException e){
            // Notify user that no client installed
            Toast.makeText(activity, "No email clients found", Toast.LENGTH_LONG).show();
        }

    }
}
