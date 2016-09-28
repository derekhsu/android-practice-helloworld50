package idv.derekhsu.helloword50.file01;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import idv.derekhsu.helloword50.R;

public class File01Activity extends AppCompatActivity {

    private static final int REQUEST_STORAGE_PERMISSION = 100;
    private MyAdapter myAdapter;
    private TextView infoText;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file01);

        this.processViews();

        myAdapter = new MyAdapter(this);
        gridView.setAdapter(myAdapter);
    }

    private void processViews() {
        infoText = (TextView) findViewById(R.id.info_file01);
        gridView = (GridView) findViewById(R.id.gridview);
    }

    private void processImages() {
        File imagePath = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES).getAbsolutePath());

        File[] files = imagePath.listFiles();

        if (files == null || files.length == 0) {
            String message = "Transfer images file to [" +
                    imagePath.getAbsolutePath() + "]";
            infoText.setText(message);
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                myAdapter.add(file.getAbsolutePath());
            }
        }

        myAdapter.notifyDataSetChanged();
    }

    public void loadImage(View view) {
        this.requestStoragePermission();
    }

    private void requestStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int hasPermission =
                    checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);

            if (hasPermission != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_STORAGE_PERMISSION);
                return;
            }
        }

        processImages();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_STORAGE_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                processImages();
            } else {
                Toast.makeText(this, "No permission to use external stroage", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
