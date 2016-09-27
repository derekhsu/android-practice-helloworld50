package idv.derekhsu.helloword50.intent02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import idv.derekhsu.helloword50.R;

public class Intent02Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent02);
    }

    /**
     * Call home
     * @param view
     */
    public void callHome(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);

        Uri uri = Uri.parse("tel:073858458");
        intent.setData(uri);

        startActivity(intent);
    }
}
