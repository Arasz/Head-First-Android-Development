package com.arasz.trenazer.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arasz.trenazer.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StopwatchFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StopwatchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener {

    /** Seconds amount measured by stopwatch **/
    private int seconds;

    /** Is stopwatch running **/
    private boolean isRunning;

    /** Was stopwatch running before fragemnt was paused **/
    private boolean wasRunning;

    private OnFragmentInteractionListener mListener;

    public StopwatchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment StopwatchFragment.
     */
    public static StopwatchFragment newInstance() {
        StopwatchFragment fragment = new StopwatchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restoreState(savedInstanceState);
    }

    /**
     * Restores stopwatch state
     * @param savedInstanceState saved state (on
     *
     */
    private void restoreState(Bundle savedInstanceState)
    {
        if(savedInstanceState == null)
            return;
        seconds = savedInstanceState.getInt("seconds");
        isRunning = savedInstanceState.getBoolean("isRunning");
        wasRunning = savedInstanceState.getBoolean("wasRunning");

        if(wasRunning)
            isRunning = wasRunning;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runStopwatch(view);

        Button startButton = (Button) view.findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        Button stopButton = (Button) view.findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);
        Button resetButton = (Button) view.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(this);

        return view;
    }

    public void onClickStart(View view)
    {
        isRunning = true;
    }

    public void onClickReset(View view)
    {
        isRunning = false;
        seconds = 0;
    }

    public void onClickStop(View view)
    {
        isRunning = false;
    }

    private String formatTime(int seconds)
    {
        int sec = seconds % 60;
        int min = (seconds/60)%60;
        int hours = (seconds/3600);
        return String.format("%d:%02d:%02d", hours, min, sec );
    }

    private void runStopwatch(View view)
    {
        final TextView timeView = (TextView) view.findViewById(R.id.time_view);
        final Handler handler  = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                timeView.setText(formatTime(seconds));
                if (isRunning)
                    seconds++;
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = isRunning;
    }

    @Override
    public void onResume() {
        super.onResume();
        isRunning = wasRunning;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("seconds", seconds);
        outState.putBoolean("isRunning", isRunning);
        outState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.start_button:
                onClickStart(view);
                break;

            case R.id.stop_button:
                onClickStop(view);
                break;

            case R.id.reset_button:
                onClickReset(view);
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
