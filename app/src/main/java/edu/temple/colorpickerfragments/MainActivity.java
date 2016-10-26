package edu.temple.colorpickerfragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends Activity implements CanvasFragment.OnFragmentInteractionListener,
PaletteFragment.OnFragmentInteractionListener {
    private CanvasFragment canvasFragment;
    private PaletteFragment paletteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //We are in a smaller screen
        if(findViewById(R.id.selector_viewer)!=null){
            paletteFragment = new PaletteFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.selector_viewer, paletteFragment)
                    .commit();
        } else {
            //We are in land or a large screen
            paletteFragment = new PaletteFragment();
            canvasFragment = new CanvasFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.selector, paletteFragment)
                    .commit();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.colors, canvasFragment)
                    .commit();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){

        }
    }

    public void changeToPickedColor(String color){
        if(findViewById(R.id.selector_viewer)!=null){
            canvasFragment = new CanvasFragment();
            Bundle bundle = new Bundle();
            bundle.putString("color", color);
            canvasFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.selector_viewer, canvasFragment)
                    .addToBackStack(null)
                    .commit();
        }else {
            canvasFragment.changeBackgroundColor(color);
        }
    }



    public void pickColor(String color){
        changeToPickedColor(color);
    }
}
