package app.com.yihan.android.bucketdrops.extras;

import android.view.View;

import java.util.List;

/**
 * Created by HanYi on 6/2/16.
 */
public class Util {

    public static void showViews(List<View> views) {
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views) {
        for (View view : views) {
            view.setVisibility(View.GONE);
        }
    }

}
