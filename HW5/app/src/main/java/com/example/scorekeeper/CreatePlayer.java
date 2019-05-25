package com.example.scorekeeper;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class CreatePlayer extends Fragment
        implements View.OnClickListener{
    EditText player1,player2,rad_edit_text;
    Button create_btn;
    RadioGroup ko_rad_butt;
    RadioButton rad_default,rad_200, rad_250, rad_edit;

    public interface OnNextClickListener {
        void OnMainFragmentNextClick(CreatePlayer fragment);
    }

    OnNextClickListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnNextClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " must implement OnMainFragmentNextClick");
        }
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//    }

    public void onClick(View view) {
        if (listener != null) {
            listener.OnMainFragmentNextClick(this);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_createplayer, container, false);

        player1 = rootView.findViewById(R.id.p1);
        player2 = rootView.findViewById(R.id.p2);
        create_btn=rootView.findViewById(R.id.button_create);
        ko_rad_butt=rootView.findViewById(R.id.radio_ko);

        ko_rad_butt.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast toast;
                // find which radio button is selected
                if(checkedId == R.id.but_default) {
                    toast=Toast.makeText(getContext(),"Default Selected (150)",Toast.LENGTH_SHORT);
                    toast.show();
                } else if(checkedId == R.id.twoHundred) {
                    toast=Toast.makeText(getContext(),"Ko 200",Toast.LENGTH_SHORT);
                    toast.show();

                } else if(checkedId == R.id.twofifty) {
                    toast=Toast.makeText(getContext(),"Ko 250",Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast.makeText(getContext(), "Enter the Ko",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        create_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                int selectedKo=ko_rad_butt.getCheckedRadioButtonId();
                rad_default=rootView.findViewById(R.id.but_default);
                rad_200=rootView.findViewById(R.id.twoHundred);
                rad_250=rootView.findViewById(R.id.twofifty);
                rad_edit=rootView.findViewById(R.id.edit);
                rad_edit_text=rootView.findViewById(R.id.edit_ko);
                String first=player1.getText().toString();
                String second=player2.getText().toString();
                int ko=0;

                if(selectedKo==rad_200.getId()){
                    ko=200;
                }else if(selectedKo==rad_250.getId()){
                    ko=250;
                }else if(selectedKo==rad_edit.getId()){
                    ko=Integer.parseInt(rad_edit_text.getText().toString());
                }
                Bundle bundle = new Bundle();
                bundle.putString("player1", first);
                bundle.putString("player2",second);
                bundle.putInt("ko",ko);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();





                GamePage gamePage = new GamePage();
                gamePage.setArguments(bundle);

                fragmentTransaction.replace(R.id.host_fragment, gamePage);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });

        return rootView;
    }




}
