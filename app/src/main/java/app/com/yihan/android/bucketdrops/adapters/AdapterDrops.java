package app.com.yihan.android.bucketdrops.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.com.yihan.android.bucketdrops.R;

/**
 * Created by HanYi on 6/2/16.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder> {

    private LayoutInflater mInflater;

    public AdapterDrops(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mInflater.inflate(R.layout.row_drop, parent, false);
//        DropHolder holder = new DropHolder();

        return null;
    }

    @Override
    public void onBindViewHolder(DropHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class DropHolder extends RecyclerView.ViewHolder {

        public DropHolder(View itemView) {
            super(itemView);
        }
    }

}
