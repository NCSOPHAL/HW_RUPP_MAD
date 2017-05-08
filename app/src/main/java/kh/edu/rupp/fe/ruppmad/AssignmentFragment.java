package kh.edu.rupp.fe.ruppmad;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.fe.ruppmad.Database.DBHelper;
import kh.edu.rupp.fe.ruppmad.adapter.Assignment;
import kh.edu.rupp.fe.ruppmad.adapter.AssignmentsAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentFragment extends Fragment {

    private RecyclerView recyclerViewAssignment;
    private AssignmentsAdapter assignmentsAdapter;
    private List<Assignment> assignmentsList;
    private DBHelper dbHelper;

    public AssignmentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assignment, container, false);

        recyclerViewAssignment = (RecyclerView) view.findViewById(R.id.rcl_assignment);
        assignmentsList = new ArrayList<>();
        dbHelper = new DBHelper(getContext());

        long timestampMillis = System.currentTimeMillis();
        String currentDateTimeString = String.valueOf(timestampMillis);

//        Insert To db
//        dbHelper.insertAssignment("CG", currentDateTimeString, "http://www.corelynx.com/sites/default/files/technologies/mobile-application.png");
//        dbHelper.insertAssignment("MAD", currentDateTimeString, "http://www.corelynx.com/sites/default/files/technologies/mobile-application.png");
//        dbHelper.insertAssignment("WEB", currentDateTimeString, "http://www.corelynx.com/sites/default/files/technologies/mobile-application.png");
//        dbHelper.insertAssignment("practicum", currentDateTimeString, "http://www.corelynx.com/sites/default/files/technologies/mobile-application.png");
//        End Insert To db

        if (dbHelper.getAssignmentData() != null) {
            assignmentsList = dbHelper.getAssignmentData();
        }

        assignmentsAdapter = new AssignmentsAdapter(getActivity(), assignmentsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewAssignment.setLayoutManager(layoutManager);
        recyclerViewAssignment.setAdapter(assignmentsAdapter);

        return view;
    }


}
