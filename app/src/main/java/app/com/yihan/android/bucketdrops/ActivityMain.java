package app.com.yihan.android.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import app.com.yihan.android.bucketdrops.adapters.AdapterDrops;
import app.com.yihan.android.bucketdrops.adapters.Divider;
import app.com.yihan.android.bucketdrops.beans.Drop;
import app.com.yihan.android.bucketdrops.widgets.BucketRecyclerView;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class ActivityMain extends AppCompatActivity {

    private static final String TAG = ActivityMain.class.getSimpleName();
    Toolbar mToolbar;
    Button mBtnAdd;
    BucketRecyclerView mRecyclerView;
    Realm mRealm;
    RealmResults<Drop> mResults;
    AdapterDrops mAdapter;
    View mEmptyView;

    // listener for the database
    private RealmChangeListener mChangeListener = new RealmChangeListener() {
        @Override
        public void onChange() {
            Log.d(TAG, "onChange: was called");
            mAdapter.update(mResults);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAdd();
            }
        });
        setSupportActionBar(mToolbar);
        initBackgroundImage();

        mRecyclerView = (BucketRecyclerView) findViewById(R.id.rv_drops);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        mRealm = Realm.getDefaultInstance();
        mResults = mRealm.where(Drop.class).findAllAsync();
        mAdapter = new AdapterDrops(this, mResults);
        mRecyclerView.setAdapter(mAdapter);

        mEmptyView = findViewById(R.id.empty_drop);
        mRecyclerView.hideIfEmpty(mToolbar);
        mRecyclerView.showIfEmpty(mEmptyView);
        mRecyclerView.addItemDecoration(new Divider(this, LinearLayoutManager.VERTICAL));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mResults.addChangeListener(mChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mResults.removeChangeListener(mChangeListener);
    }

    private void showDialogAdd() {
        DialogAdd dialog = new DialogAdd();

        dialog.show(getSupportFragmentManager(), "Add");
    }

    private void initBackgroundImage() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this)
                .load(R.drawable.background)
                .centerCrop()
                .into(background);
    }
}
