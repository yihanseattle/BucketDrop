package app.com.yihan.android.bucketdrops.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.com.yihan.android.bucketdrops.R;
import app.com.yihan.android.bucketdrops.beans.Drop;
import io.realm.RealmResults;

/**
 * Created by HanYi on 6/2/16.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder> {

    private static final String TAG = AdapterDrops.class.getSimpleName();
    private LayoutInflater mInflater;
    private RealmResults<Drop> mResult;

    public AdapterDrops(Context context, RealmResults<Drop> results) {
        mInflater = LayoutInflater.from(context);
        mResult = results;
    }


    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.row_drop, parent, false);
        DropHolder holder = new DropHolder(view);
        Log.d(TAG, "onCreateViewHolder: ");

        return holder;
    }

    @Override
    public void onBindViewHolder(DropHolder holder, int position) {
        Drop drop = mResult.get(position);
        holder.mTextWhat.setText(drop.getWhat());
        Log.d(TAG, "onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    public static class DropHolder extends RecyclerView.ViewHolder {

        TextView mTextWhat;

        public DropHolder(View itemView) {
            super(itemView);
            mTextWhat = (TextView) itemView.findViewById(R.id.tv_what);

        }
    }

}
