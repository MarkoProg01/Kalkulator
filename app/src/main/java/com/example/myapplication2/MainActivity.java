package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button Dnula,Djedan,Ddva,Dtri,Dcetiri,Dpet,Dsest,Dsedam,Dosam,Ddevet,Dplus,Dminus,Dputa,Dpodeljeno,Djednako,Dtacka,Dobrisi,Dzagrada,Dprocenat;
    TextView TVunos,TVrezultat;
    String proces;
    boolean proveriZagradu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dnula=findViewById(R.id.nula);
        Djedan=findViewById(R.id.jedan);
        Ddva=findViewById(R.id.dva);
        Dtri=findViewById(R.id.tri);
        Dcetiri=findViewById(R.id.cetiri);
        Dpet=findViewById(R.id.pet);
        Dsest=findViewById(R.id.sest);
        Dsedam=findViewById(R.id.sedam);
        Dosam=findViewById(R.id.osam);
        Ddevet=findViewById(R.id.devet);
        Dplus=findViewById(R.id.plus);
        Dminus=findViewById(R.id.minus);
        Dputa=findViewById(R.id.puta);
        Dpodeljeno=findViewById(R.id.podeljeno);
        Djednako=findViewById(R.id.jednako);
        Dtacka=findViewById(R.id.tacka);
        Dobrisi=findViewById(R.id.obrisi);
        Dprocenat=findViewById(R.id.procenat);
        Dzagrada=findViewById(R.id.zagrada);

        TVunos=findViewById(R.id.unos);
        TVrezultat=findViewById(R.id.rezultat);

        Dobrisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TVrezultat.setText("");
                TVunos.setText("");
            }
        });

        Dnula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"0");
            }
        });

        Djedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"1");
            }
        });

        Ddva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"2");
            }
        });

        Dtri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"3");
            }
        });

        Dcetiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"4");
            }
        });

        Dpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"5");
            }
        });

        Dsest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"6");
            }
        });

        Dsedam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"7");
            }
        });

        Dosam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"8");
            }
        });

        Ddevet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"9");
            }
        });

        //Znakovi

        Dplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"+");
            }
        });
        Dminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"-");
            }
        });
        Dputa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"x");
            }
        });
        Dpodeljeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"/");
            }
        });
        Dtacka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+".");
            }
        });
        Dprocenat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                TVunos.setText(proces+"%");
            }
        });
        Dzagrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(proveriZagradu){
                    proces=TVunos.getText().toString();
                    TVunos.setText(proces+")");
                    proveriZagradu=false;
                }else{
                    proces=TVunos.getText().toString();
                    TVunos.setText(proces+"(");
                    proveriZagradu=true;
                }
            }
        });

        Djednako.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proces=TVunos.getText().toString();
                proces=proces.replaceAll("x","*");
                proces=proces.replaceAll("%","/100");

                Context rhino=Context.enter();

                rhino.setOptimizationLevel(-1);

                String krajnjiRezultat="";

                try {
                    Scriptable scriptable=rhino.initStandardObjects();
                    krajnjiRezultat = rhino.evaluateString(scriptable,proces,"javascript",1,null).toString();
                }catch (Exception e){
                    krajnjiRezultat="0";

                }
                TVrezultat.setText(krajnjiRezultat);

            }
        });



    }


}