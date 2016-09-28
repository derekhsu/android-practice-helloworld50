package idv.derekhsu.helloword50.file01;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import idv.derekhsu.helloword50.R;

public class File01Activity extends AppCompatActivity {

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file01);

        myAdapter = new MyAdapter(this);
    }

    private void processViews() {

    }

    private void processImages() {
        File imagePath = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES).getAbsolutePath());

        File[] files = imagePath.listFiles();

        if (files == null || files.length == 0) {
            String message = "Transfer images file to [" +
                    imagePath.getAbsolutePath() + "]";

        }
    }
}
