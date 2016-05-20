package dk.nodes.nutilsprojectexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import dk.nodes.nutilsprojectexample.nkeyboardexample.NKeyboardActivity;
import dk.nodes.nutilsprojectexample.nscreenparamsexample.NScreenParametersActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPage();
    }

    private void setupPage() {
        Button nKeyboardBtn = (Button) findViewById(R.id.landing_nkeyboard_btn);
        Button nScreenParamsBtn = (Button) findViewById(R.id.landing_nscreenparams_btn);

        if (nKeyboardBtn != null) {
            nKeyboardBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, NKeyboardActivity.class);
                    startActivity(myIntent);
                }
            });
        }

        if (nScreenParamsBtn != null) {
            nScreenParamsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, NScreenParametersActivity.class);
                    startActivity(myIntent);
                }
            });
        }
    }
}
