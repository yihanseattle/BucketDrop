package app.com.yihan.android.bucketdrops;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import app.com.yihan.android.bucketdrops.adapters.AdapterDrops;

public class ActivityMain extends AppCompatActivity {

    Toolbar mToolbar;
    Button mBtnAdd;
    RecyclerView mRecyclerView;

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
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_drops);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(new AdapterDrops(this));

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
