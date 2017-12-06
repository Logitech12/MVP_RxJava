package com.bwie.qiaoxiaohui20171206.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.bwie.qiaoxiaohui20171206.R;
import com.bwie.qiaoxiaohui20171206.adapter.RvAdapter;
import com.bwie.qiaoxiaohui20171206.bean.ClassBean;
import com.bwie.qiaoxiaohui20171206.presenter.MainPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements IMainActivity {

    private MainPresenter mainPresenter = new MainPresenter(this);
    private XRecyclerView mXrv;
    private List<ClassBean.NewslistBean> list;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ActionBar bar = getSupportActionBar();
        bar.hide();
        mainPresenter.getData();
        mXrv.setLayoutManager(new LinearLayoutManager(this));
        //下拉刷新上拉加载
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            //刷新
            @Override
            public void onRefresh() {
                mainPresenter.getData();
                mXrv.refreshComplete();
            }
            //加载更多
            @Override
            public void onLoadMore() {
                mainPresenter.getMore();
                mXrv.refreshComplete();
            }
        });
    }
    private void initView() {
        mXrv = findViewById(R.id.xrv);
    }
    //展示数据
    @Override
    public void showrecy(final ClassBean bean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list = bean.getNewslist();
                adapter = new RvAdapter(MainActivity.this, list);
                mXrv.setAdapter(adapter);
            }
        });
    }
    //加载更多
    @Override
    public void showrecys(ClassBean bean) {
        list.addAll(bean.getNewslist());
        adapter.notifyDataSetChanged();
    }
}
