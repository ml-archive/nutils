package dk.nodes.nutils.nimageurlresizer;

import android.view.View;

/**
 * Created by joaoalves on 03/10/2016.
 */

public class NImageUrlResizer {

    /**
     *
     * @param view this is needed to get width and height for params
     * @param baseUrl this is needed
     * @return url with view width and height params
     */
    public static String imageUrlResize(View view, String baseUrl) {
        return imageUrlResize(view.getWidth(), view.getHeight(), baseUrl);
    }

    /**
     *
     * @param width this is needed
     * @param height this is needed
     * @param baseUrl this is needed
     * @return url with view width and height params
     */
    public static String imageUrlResize(int width, int height, String baseUrl) {
        return baseUrl + "?" + getUrlParamsEncoded(width, height);
    }

    /**
     *
     * @param width this is needed
     * @param height this is needed
     * @return url params
     *
     */
    public static String getUrlParamsEncoded(int width, int height) {
        return "w="+width+"&h="+height;
    }

}


