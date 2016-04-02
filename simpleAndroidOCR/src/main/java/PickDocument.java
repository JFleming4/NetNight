import android.app.Activity;

import java.io.File;

/**
 *
 * Created by Craig on 02/04/2016.
 * Some code used from: https://rogerkeays.com/simple-android-file-chooser
 */
public class PickDocument {
    private String selectedFile;

    public PickDocument (Activity activity){
        new FileChooser(activity).setFileListener(new FileChooser.FileSelectedListener() {
            @Override public void fileSelected(final File file) {
                selectedFile = file.getAbsolutePath();
            }}).showDialog();
    }

}
