package dk.nodes.nutils.nscreenparameters;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by ConstantinTeodor on 20-May-16.
 */
public class NScreenParameters {

    private static String TAG = NScreenParameters.class.getName();

    private static int screenDensity;
    private static float screenDensityConstant;
    private static int screenWidth;
    private static int screenHeight;
    private static float screenRatio;
    private static float screenXCenter;
    private static float screenYCenter;
    private static String screenTypeName; //when set can be small/normal/large/x-large or N/A
    private static int screenType;

    private static boolean parametersInitialized = false;

    public static final int SMALL_SCREEN = 1;
    public static final int NORMAL_SCREEN = 2;
    public static final int LARGE_SCREEN = 3;
    public static final int X_LARGE_SCREEN = 4;

    /**
     * Use this method to calculate all screen parameters, and initialize the public static values
     *
     * @param mContext
     */
    private static void setScreenParameters(Context mContext) {

        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealMetrics(metrics);
        } else {
            display.getMetrics(metrics);
        }

        screenDensity = metrics.densityDpi;
        screenDensityConstant = (screenDensity) / (160f);

        Point size = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealSize(size);
        } else {
            display.getSize(size);
        }

        screenWidth = size.x;
        screenHeight = size.y;
        screenRatio = (float) screenHeight / (float) screenWidth;
        screenXCenter = screenWidth / 2f;
        screenYCenter = screenHeight / 2f;

        setScreenSizeMask(mContext);
    }

    private static void checkAndInitializeParameters(Context mContext) {
        if (!parametersInitialized) {
            setScreenParameters(mContext);
            parametersInitialized = true;
        }
    }

    public static void setScreenSizeMask(Context mContext) {
        Configuration config = mContext.getResources().getConfiguration();
        if ((config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL) {
            screenTypeName = "small";
            screenType = SMALL_SCREEN;
        } else if ((config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            screenTypeName = "normal";
            screenType = NORMAL_SCREEN;
        } else if ((config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            screenTypeName = "large";
            screenType = LARGE_SCREEN;
        } else if ((config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            screenTypeName = "x-large";
            screenType = X_LARGE_SCREEN;
        } else {
            screenTypeName = "N/A";
        }
    }

    public static int toPx(Context mContext, float dp) {
        checkAndInitializeParameters(mContext);
        return (int) (dp * screenDensityConstant);
    }

    public static int toDp(Context mContext, float pixels) {
        checkAndInitializeParameters(mContext);
        return (int) (pixels / screenDensityConstant);
    }

    public static void forceActivityPotrait(Activity mActivity) {
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public static void forceActivityLandscape(Activity mActivity) {
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public static int getScreenDensity(Context mContext) {
        checkAndInitializeParameters(mContext);
        return screenDensity;
    }

    public static float getScreenDensityConstant(Context mContext) {
        checkAndInitializeParameters(mContext);
        return screenDensityConstant;
    }

    public static int getScreenWidth(Context mContext) {
        checkAndInitializeParameters(mContext);
        return screenWidth;
    }

    public static int getScreenHeight(Context mContext) {
        checkAndInitializeParameters(mContext);
        return screenHeight;
    }

    public static float getScreenRatio(Context mContext) {
        checkAndInitializeParameters(mContext);
        return screenRatio;
    }

    public static float getScreenXCenter(Context mContext) {
        checkAndInitializeParameters(mContext);
        return screenXCenter;
    }

    public static float getScreenYCenter(Context mContext) {
        checkAndInitializeParameters(mContext);
        return screenYCenter;
    }

    public static String getScreenTypeName(Context mContext) {
        checkAndInitializeParameters(mContext);
        return screenTypeName;
    }

    public static int getScreenType(Context mContext) {
        checkAndInitializeParameters(mContext);
        return screenType;
    }
}
