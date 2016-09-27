package idv.derekhsu.helloword50.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import idv.derekhsu.helloword50.R;

public class Dialog01Activity extends AppCompatActivity {

    private Button btnDialog01;
    private Button btnDialog02;
    private Button btnDialog03;

    private String[] items = { "Coffee", "Tea", "Water" };
    private Button btnDialog04;
    private int choice = -1;

    private View dialogView;
    private Button btnDialog05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog01);

        LayoutInflater inflater = getLayoutInflater();
        this.dialogView = inflater.inflate(R.layout.dialog_sigin, null);

        processView();
        processController();
    }

    private void processView() {
        btnDialog01 = (Button) findViewById(R.id.btn_dialog_01);
        btnDialog02 = (Button) findViewById(R.id.btn_dialog_02);
        btnDialog03 = (Button) findViewById(R.id.btn_dialog_03);
        btnDialog04 = (Button) findViewById(R.id.btn_dialog_04);
        btnDialog05 = (Button) findViewById(R.id.btn_dialog_05);


    }

    private void processController() {
        btnDialog01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this,
                        android.R.style.Theme_Material_Light_Dialog_Alert);

                d.setTitle("Demo");
                d.setMessage("Dialog01Activity");
                d.show();
            }
        });

        btnDialog02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this,
                        android.R.style.Theme_Material_Light_Dialog_Alert);

                d.setTitle("Demo")
                        .setMessage("Are you hungry")
                        .setCancelable(false);

                d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btnDialog02.setText("Yes");
                    }
                });

                d.setNeutralButton("Maybe", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btnDialog02.setText("Maybe");
                    }
                });

                d.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btnDialog02.setText("No");
                    }
                });

                d.show();
            }
        });

        btnDialog03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this,
                        android.R.style.Theme_Material_Light_Dialog_Alert);

                d.setTitle("Select...")
                        .setCancelable(false);

                d.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btnDialog03.setText(items[which]);
                    }
                });

                d.show();

            }
        });

        btnDialog04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this);

                d.setTitle("Select...");

                d.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choice = which;
                    }
                });

                d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (choice != -1) {
                            btnDialog04.setText(items[choice]);
                        }
                    }
                });

                d.setNegativeButton("Cancel", null);

                d.show();

            }
        });

        btnDialog05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this);
                d.setView(dialogView)
                        .setTitle("Sign in");

                d.setPositiveButton("Signin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText username = (EditText) dialogView.findViewById(R.id.username);
                        EditText password = (EditText) dialogView.findViewById(R.id.password);
                        btnDialog05.setText("username: " + username.getText() + " : " +
                            password.getText());
                    }
                });

                d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btnDialog05.setText("Cancel");
                    }
                });

                d.show();
            }
        });
    }
}
