package com.example.scorekeeper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GamePage extends Fragment {

    private int ko;
    private int p1Streak=0;
    private int p2Streak=0;
    private String p1Name;
    private String p2Name;
    private ScoreData myData=new ScoreData();
    public EditText p1round;
    public EditText p2round;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)

    {
        View rootView = inflater.inflate(R.layout.fragment_gamepage, container, false);

        Bundle bundle = getArguments();
        String first = bundle.getString("player1");
        String second = bundle.getString("player2");
        ko = bundle.getInt("ko");

        boolean isKo=myData.setKo(ko);

        if(first != null && !first.isEmpty() && !first.equals("null") && second != null && !second.isEmpty() && !second.equals("null")){
            myData.setP1Name(first);
            myData.setP2Name(second);
        }

        final TextView firstText = (TextView)rootView.findViewById(R.id.first);
        final TextView secondText = (TextView)rootView.findViewById(R.id.second);
        final EditText p1round=(EditText)rootView.findViewById(R.id.p1Round);
        final EditText p2round=(EditText)rootView.findViewById(R.id.p2Round);
        final TextView p1Total=(TextView)rootView.findViewById(R.id.firstTotal);
        final TextView p2Total=(TextView)rootView.findViewById(R.id.secondTotal);

        final Button p1_neg_32 = (Button)rootView.findViewById(R.id.p1_neg_32);
        final Button p2_neg_32 = (Button)rootView.findViewById(R.id.p2_neg_32);
        final Button butt_validate=(Button)rootView.findViewById(R.id.butt_validate);
        final Button butt_cancel=(Button)rootView.findViewById(R.id.butt_cancel);


        p1Name=myData.getP1Name();
        p2Name=myData.getP2Name();
        if (isKo){
            ko=myData.getKo();
        }else{
            ko=150;
        }

        firstText.setText(p1Name);
        secondText.setText(p2Name);



        p1_neg_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1round.setText("-32");
            }
        });

        p2_neg_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2round.setText("-32");
            }
        });

        butt_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1total;
                int p2total;
                int p1score=Integer.parseInt(p1round.getText().toString());
                int p2score=Integer.parseInt(p2round.getText().toString());
                myData.setP1PrevScore(myData.getP1Total());
                myData.setP2PrevScore(myData.getP2Total());

                if(p1score>0){
                    p2Streak++;
                }else{
                    p1Streak++;
                }
                if (p1score!=streakBonus(p1Streak,p1score)) {
                    p1score = streakBonus(p1Streak, p1score);
                    p1Streak=0;
                    p2Streak=0;
                }

                if(p2score!=streakBonus(p2Streak,p2score)){
                    p2score=streakBonus(p2Streak,p2score);
                    p1Streak=0;
                    p2Streak=0;
                }



                p1total=addPoint(p1score,myData.getP1Total());
                p2total=addPoint(p2score,myData.getP2Total());
                myData.setP1Total(p1total);
                myData.setP2Total(p2total);
                p1Total.setText(Integer.toString(myData.getP1Total()));
                p2Total.setText(Integer.toString(myData.getP2Total()));
                p1round.setText("0");
                p2round.setText("0");

                if(p1total>=ko){
                    p1round.setText("KO");
                    p2round.setText("WINNER");
                }else if (p2total>=ko){
                    p2round.setText("KO");
                    p1round.setText("WINNER");
                }
            }
        });


        butt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myData.setP1Total(myData.getP1PrevScore());
                myData.setP2Total(myData.getP2PrevScore());

                p1round.setText("0");
                p2round.setText("0");

                p1Total.setText(Integer.toString(myData.getP1Total()));
                p2Total.setText(Integer.toString(myData.getP2Total()));
            }
        });




        return rootView;
    }


    public int addPoint(int oldScore , int newScore){
        return oldScore+newScore;
    }

    public int streakBonus(int streak,int score){
        if(streak==3)
            score-=10;
        return score;
    }

}
