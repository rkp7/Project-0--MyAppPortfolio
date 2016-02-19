package com.example.android.myappportfolio;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout and apply to the fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Obtain the Linear Layout at the top of the hierarchy
        LinearLayout parentLinearLayout = (LinearLayout) rootView.findViewById(R.id.parent_linear_layout);
        // Retrieve the child count of the Linear Layout
        int noOfChildLinearLayouts = parentLinearLayout.getChildCount();

        // Loop through each child of the Linear Layout
        for(int i=0; i<noOfChildLinearLayouts; i++) {
            View child = (View) parentLinearLayout.getChildAt(i);

            // Check if the child belongs to class of Linear Layouts
            if(child instanceof LinearLayout) {

                // Get the child Linear Layout object
                LinearLayout childLinearLayout = (LinearLayout) parentLinearLayout.getChildAt(i);
                // Retrieve count of buttons in each child Linear Layout
                int noOfButtons = childLinearLayout.getChildCount();

                // Loop through each button belonging to the current child Linear Layout
                for (int j = 0; j < noOfButtons; j++) {
                    // Store the object in a variable of class Button
                    Button button = (Button) childLinearLayout.getChildAt(j);
                    // Retrieve the application name assigned to the current button
                    final CharSequence appName = button.getText();

                    // Set listeners for clicking action
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            // Create and display a toast denoting a message
                            Toast.makeText(getActivity(), "This button will launch the " + appName,
                                    Toast.LENGTH_SHORT).show();
                        }

                    });
                }
            }
        }

        return rootView;
    }
}
