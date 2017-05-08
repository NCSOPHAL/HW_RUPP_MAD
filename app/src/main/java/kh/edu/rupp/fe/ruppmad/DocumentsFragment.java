package kh.edu.rupp.fe.ruppmad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.rupp.fe.ruppmad.adapter.Document;
import kh.edu.rupp.fe.ruppmad.adapter.DocumentsAdapter;
import kh.edu.rupp.fe.ruppmad.adapter.RecyclerViewItemClickListener;

/**
 * RUPPMAD
 * Created by leapkh on 7/3/17.
 */

public class DocumentsFragment extends Fragment implements RecyclerViewItemClickListener {

    private RecyclerView rclDocuments;
    private DocumentsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_documents, container, false);

        // Reference to RecyclerView
        rclDocuments = (RecyclerView)fragmentView.findViewById(R.id.rcl_documents);

        // Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rclDocuments.setLayoutManager(layoutManager);

        // Adapter
        adapter = new DocumentsAdapter(loadDocuments());
        adapter.setRecyclerViewItemClickListener(this);
        rclDocuments.setAdapter(adapter);

        return fragmentView;
    }

    // Temporary List of Documents
    private Document[] loadDocuments(){
        Document d1 = new Document("Ch. 1: Introduction to Mobile App Dev", "", 1);
        Document d2 = new Document("Ch. 2: Google Play Store", "", 2);
        Document d3 = new Document("Ch. 3: Android Studio", "", 1);
        Document d4 = new Document("Ch. 4: Drawer Layout", "", 3);
        Document d5 = new Document("Ch. 5: Recycler View", "", 2);
        Document[] documents = {d1, d2, d3, d4, d5};
        return documents;
    }

    @Override
    public void onRecyclerViewItemClick(int position) {
        Log.d("rupp", "Recycler item click: " + position);
    }
}
