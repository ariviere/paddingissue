package com.ar.modifypaddingissue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by antoine on 5/26/16.
 */
public class MyFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyRecyclerAdapter adapter;
    private Listener listener;

    public static MyFragment newInstance(Listener listener) {
        MyFragment fragment = new MyFragment();
        fragment.setListener(listener);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        String[] dataset = { "Test 1", "test 2", "test 3", "test 4", "test 2", "test 3", "test 4", "test 2", "test 2", "test 3", "test 4", "test 2", "test 3", "test 4", "test 2", "test 2", "test 3", "test 4", "test 2", "test 3", "test 4", "test 2", "test 2", "test 3", "test 4", "test 2", "test 3", "test 4", "test 2", "test 3", "test 4", "test 2", "test 3", "test 4", "test 2", "test 3", "test 4", "test 2", "test 3", "test 4"};
        adapter = new MyRecyclerAdapter(dataset);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (listener != null) {
                    listener.onScrollY(dy);
                }
            }
        });

    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void onScrollY(int y);
    }
}
