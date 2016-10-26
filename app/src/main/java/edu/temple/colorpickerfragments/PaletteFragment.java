package edu.temple.colorpickerfragments;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaletteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PaletteFragment extends Fragment {

    private String[] colors = {"Red", "Cyan", "Yellow", "Green", "Blue", "Purple"};
    private OnFragmentInteractionListener mListener;
    private ColorPicker colorPicker;
    private Spinner colorPickerSpinner;
    private View v;
    private boolean init = false;
    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_palette, container, false);
        colorPickerSpinner = (Spinner) v.findViewById(R.id.color_picker);
        colorPicker =  new ColorPicker(getActivity(), colors);
        colorPickerSpinner.setAdapter(colorPicker);

        colorPickerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(init) {
                    mListener.pickColor(colors[position]);
                } else {
                    init = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }
    @Override
    public void onPause(){
        super.onPause();
        init = false;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;


        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void pickColor(String color);
    }
}
