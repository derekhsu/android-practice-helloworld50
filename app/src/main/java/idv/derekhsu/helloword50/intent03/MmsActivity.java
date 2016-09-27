package idv.derekhsu.helloword50.intent03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;

import idv.derekhsu.helloword50.R;

public class MmsActivity extends AppCompatActivity {

    private EditText email,phone;
    private Button btnMms, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mms);
        this.processView();
        this.processControllers();
    }

    private void processView() {
        email = (EditText) findViewById(R.id.email_mms);
        phone = (EditText) findViewById(R.id.phone_mms);
        btnEmail = (Button) findViewById(R.id.btn_email);
        btnMms = (Button) findViewById(R.id.btn_mms);
    }

    private void processControllers() {

        btnEmail.setOnClickListener(new SendEmailController());
        btnMms.setOnClickListener(new SendMmsController());
    }

    private class SendEmailController implements ViewStub.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();

            final String[] emailAddrs = new String[] { email.getText().toString() };

            intent.setAction(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, emailAddrs);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Test");

            startActivity(Intent.createChooser(intent, "Send Email"));
        }
    }

    private class SendMmsController implements ViewStub.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();

            Uri uri = Uri.parse("smsto:" + phone.getText().toString());
            intent.setData(uri);
            intent.putExtra("sms_body", "This is a sms text.");
            intent.setAction(Intent.ACTION_SENDTO);

            startActivity(intent);
        }
    }
}
