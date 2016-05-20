package dk.nodes.nutilsprojectexample.nscreenparamsexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dk.nodes.nutils.nscreenparameters.NScreenParameters;
import dk.nodes.nutilsprojectexample.R;

public class NScreenParametersActivity extends AppCompatActivity {

    TextView screenDensityTv, screenDensityConstantTv, screenWidthTv, screenHeightTv, screenRatioTv,
            screenXCenterTv, screenYCenterTv, screenSizeTypeTv, pxTodpResultTv, dpTopxResultTv;

    EditText pxTodpInputEt, dpTopxInputEt;

    Button pxTodpBtn, dpTopxBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nscreen_parameters);

        setupPage();
        setupNScreenText();
    }


    private void setupPage() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        screenDensityTv = (TextView) findViewById(R.id.nparams_screendensity_tv);
        screenDensityConstantTv = (TextView) findViewById(R.id.nparams_screendensity_constant_tv);
        screenWidthTv = (TextView) findViewById(R.id.nparams_screenwidth_tv);
        screenHeightTv = (TextView) findViewById(R.id.nparams_screenheight_tv);
        screenRatioTv = (TextView) findViewById(R.id.nparams_screenratio_tv);
        screenXCenterTv = (TextView) findViewById(R.id.nparams_screenxcenter_tv);
        screenYCenterTv = (TextView) findViewById(R.id.nparams_screenycenter_tv);
        screenSizeTypeTv = (TextView) findViewById(R.id.nparams_screensize_type_tv);
        pxTodpResultTv = (TextView) findViewById(R.id.nparams_frompxtodp_result_tv);
        dpTopxResultTv = (TextView) findViewById(R.id.nparams_fromdptopx_result_tv);

        pxTodpInputEt = (EditText) findViewById(R.id.nparams_frompxtodp_et);
        dpTopxInputEt = (EditText) findViewById(R.id.nparams_fromdptopx_et);

        pxTodpBtn = (Button) findViewById(R.id.nparams_frompxtodp_btn);
        dpTopxBtn = (Button) findViewById(R.id.nparams_fromdptopx_btn);
    }

    private void setupNScreenText() {

        screenDensityTv.setText("Screen density: " + Integer.toString(NScreenParameters.getScreenDensity(this)));
        screenDensityConstantTv.setText("Screen density constant: " + Float.toString(NScreenParameters.getScreenDensityConstant(this)));
        screenWidthTv.setText("Screen width: " + Integer.toString(NScreenParameters.getScreenWidth(this)));
        screenHeightTv.setText("Screen height: " + Integer.toString(NScreenParameters.getScreenHeight(this)));
        screenRatioTv.setText("Screen ratio: " + Float.toString(NScreenParameters.getScreenRatio(this)));
        screenXCenterTv.setText("Screen xcenter: " + Float.toString(NScreenParameters.getScreenXCenter(this)));
        screenYCenterTv.setText("Screen ycenter: " + Float.toString(NScreenParameters.getScreenYCenter(this)));
        screenSizeTypeTv.setText("Screen size type: " + Integer.toString(NScreenParameters.getScreenType(this)));

        pxTodpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float localFloat = Float.parseFloat(pxTodpInputEt.getText().toString());
                    pxTodpResultTv.setText(Integer.toString(NScreenParameters.toDp(NScreenParametersActivity.this, localFloat)));
                } catch (Exception ex) {

                }
            }
        });

        dpTopxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float localFloat = Float.parseFloat(dpTopxInputEt.getText().toString());
                    dpTopxResultTv.setText(Integer.toString(NScreenParameters.toPx(NScreenParametersActivity.this, localFloat)));
                } catch (Exception ex) {

                }
            }
        });
    }
}
