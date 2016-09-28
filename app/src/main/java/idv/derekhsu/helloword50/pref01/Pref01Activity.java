package idv.derekhsu.helloword50.pref01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import idv.derekhsu.helloword50.R;

public class Pref01Activity extends AppCompatActivity {

    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_AMOUNT = "KEY_AMOUNT";
    private static final String KEY_VIP = "KEY_VIP";

    private EditText nameEdit;
    private SeekBar amountSeekbar;
    private TextView amountText;
    private CheckBox vipCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref01);

        this.processViews();
        this.processController();
    }

    private void processViews() {
        nameEdit = (EditText) findViewById(R.id.name_edit_pref01);
        amountSeekbar = (SeekBar) findViewById(R.id.amount_seekbar_pref01);
        amountText = (TextView) findViewById(R.id.amount_text_pref01);
        vipCheck = (CheckBox) findViewById(R.id.vip_check_pref01);
    }

    private void processController() {
        amountSeekbar.setOnSeekBarChangeListener(new AmountSeekBarChange());
    }

    private void savePref() {
        String nameValue = this.nameEdit.getText().toString();
        int amountValue = this.amountSeekbar.getProgress();
        boolean vipValue = this.vipCheck.isChecked();

        SharedPreferences sp =
                PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString(KEY_NAME, nameValue)
                .putInt(KEY_AMOUNT, amountValue)
                .putBoolean(KEY_VIP, vipValue)
                .apply();

    }

    private class NameTextChange implements EditText.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            savePref();
            return true;
        }
    }

    private class VipCheckClick implements  CheckBox.OnClickListener {
        @Override
        public void onClick(View v) {
            savePref();
        }
    }

    private class AmountSeekBarChange implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            amountText.setText(String.valueOf(progress));
            savePref();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
