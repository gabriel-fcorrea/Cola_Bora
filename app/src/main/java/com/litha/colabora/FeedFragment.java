package com.litha.colabora;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FeedFragment extends Fragment {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<String> items;

    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // You can initialize other components here if necessary
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_layout, container, false);

        recyclerView = view.findViewById(R.id.recview_feed);
        items = new ArrayList<>();
        items.add("Buraco na via");
        items.add("Via interditada");
        items.add("Alagamento");
        items.add("Risco de queda de árvore");
        items.add("Acidente de trânsito");
        items.add("Hospital sem recursos");


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
