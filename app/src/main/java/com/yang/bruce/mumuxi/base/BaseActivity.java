package com.yang.bruce.mumuxi.base;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yang.bruce.mumuxi.R;
import com.yang.bruce.mumuxi.view.activity.AboutActivity;
import com.yang.bruce.mumuxi.view.activity.AboutMeActivity;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-06-27 13:36
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class BaseActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener
        , RecyclerArrayAdapter.OnLoadMoreListener {

    public void initViews() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about_me:
                Intent intent = new Intent(getApplicationContext(), AboutMeActivity.class);
                startActivity(intent);
                break;
            case R.id.what_to_do:
                new MaterialDialog.Builder(this)
                        .title("What to do")
                        .items(R.array.what_to_do)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                                Toast.makeText(BaseActivity.this, "text: " + text, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show(); // 不要忘记show!!!
                break;
            case R.id.about:
                Intent intent2 = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent2);
                break;
            // toolbar 返回键对应 id
            case android.R.id.home:
                onBackPressed();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }
}
