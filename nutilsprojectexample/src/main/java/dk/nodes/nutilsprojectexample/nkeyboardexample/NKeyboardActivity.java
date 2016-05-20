package dk.nodes.nutilsprojectexample.nkeyboardexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import dk.nodes.nutils.nkeyboardcontroller.NKeyboardController;
import dk.nodes.nutilsprojectexample.R;

public class NKeyboardActivity extends AppCompatActivity {

    TextView showingTv;
    EditText cancelableEt;
    Button toggleBtn;
    LinearLayout contentLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nkeyboard);
        setupPage();
    }

    private void setupPage() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showingTv = (TextView) findViewById(R.id.nkeyboard_showing_tv);
        cancelableEt = (EditText) findViewById(R.id.nkeyboard_et1_et);
        toggleBtn = (Button) findViewById(R.id.nkeyboard_toggle_btn);
        contentLl = (LinearLayout) findViewById(R.id.nkeyboard_content_ll);

        setupNKeyboardTest();
    }

    private void setupNKeyboardTest() {
        NKeyboardController.setCancelable(this, contentLl, true, cancelableEt);

        NKeyboardController.setOnKeyboardListener(this, new NKeyboardController.NKeyboardShowingListener() {
            @Override
            public void onKeyboardShown() {
                showingTv.setText("Keyboard showing");
            }

            @Override
            public void onKeyboardHidden() {
                showingTv.setText("Keyboard hidden");
            }
        });

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NKeyboardController.isKeyboardShowing(NKeyboardActivity.this)) {
                    NKeyboardController.hideKeyboard(NKeyboardActivity.this);
                } else {
                    NKeyboardController.showKeyboard(NKeyboardActivity.this, cancelableEt);
                }
            }
        });
    }

}
