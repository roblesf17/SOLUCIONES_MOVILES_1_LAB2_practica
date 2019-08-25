package com.example.practicacalificada_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //decalraremos los objeo--------------
    public EditText txt_1 , txt_2 ;

    public Button btn_calcular ;

    public TextView txt_resultado_1 ;
    public TextView txt_resultado_2 ;
    public TextView txt_resultado_3 ;
    //-------------------------------------
    public EditText txt_3;
    public EditText txt_4;
    public EditText txt_5;

    public static String txt_nombre3 = "" ;
    public static String txt_nombre4 = "" ;
    public static String txt_nombre5 = "" ;

    //variables temporales--------------
    public static String txt_nombre1 = "" ;
    public static String txt_nombre2 = "" ;

    public TextView txt_resultado_4 ;
    public TextView txt_resultado_5 ;

    //-------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //importante definirlos---
        txt_resultado_1 = (EditText) findViewById(R.id.txt_texto3);
        txt_resultado_2 = (EditText) findViewById(R.id.txt_texto4);
        txt_resultado_3 = (EditText) findViewById(R.id.txt_texto5);
        btn_calcular = (Button)findViewById(R.id.btn_resultado);
        //------------------------

        //para mostrar los no guardados
        /*
        if(savedInstanceState != null){
            txt_nombre1 = savedInstanceState.getString("txt_nombre1");
            txt_resultado_1.setText(String.valueOf(txt_nombre1));

            txt_nombre2 = savedInstanceState.getString("txt_nombre2");
            txt_resultado_2.setText(String.valueOf(txt_nombre2));

            txt_nombre3 = savedInstanceState.getString("txt_nombre3");
            txt_resultado_3.setText(String.valueOf(txt_nombre3));

            txt_nombre4 = savedInstanceState.getString("txt_nombre4");
            txt_resultado_4.setText(String.valueOf(txt_nombre4));

            txt_nombre5 = savedInstanceState.getString("txt_nombre5");
            txt_resultado_5.setText(String.valueOf(txt_nombre5));
        }
        */
    }


    public void obtener_valores_de_txt()
    {
        //recogeremos los datos que se agregaron en el formulario
        txt_1 = (EditText) findViewById(R.id.txt_texto1);
        txt_nombre1 = txt_1.getText().toString();

        txt_2 = (EditText) findViewById(R.id.txt_texto2);
        txt_nombre2 = txt_2.getText().toString();
    }

    public void contar_vocales_cerradas_frase_1 ()
    {
        txt_1 = (EditText) findViewById(R.id.txt_texto1);
        txt_nombre1 = txt_1.getText().toString();

        int contador = 0 ;

        for (int i = 0 ; i < txt_nombre1.length() ; i++)
        {
            if ((txt_nombre1.charAt(i)=='i') ||(txt_nombre1.charAt(i)=='u') || (txt_nombre1.charAt(i)=='I') || (txt_nombre1.charAt(i)=='U'))
            {
                contador ++ ;
            }
        }



        String frase_1_tiene = getString(R.string.frase_1_tiene);
        String vocales_cerradas = getString(R.string.vocales_cerradas);
        txt_resultado_2.setText(frase_1_tiene + " " + contador + " "+vocales_cerradas);



    }

    public void mensaje_ejecutando()
    {
        Context context = getApplicationContext();
        String ejecutando_comando = getString(R.string.ejecutandocomando);
        CharSequence text = ejecutando_comando ;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context , text , duration);
        toast.show();
    }

    public void contar_vocales_cerradas_frase_2 ()
    {

        txt_2 = (EditText) findViewById(R.id.txt_texto2);
        txt_nombre2 = txt_2.getText().toString();

        int contador = 0 ;

        for (int i = 0 ; i < txt_nombre2.length() ; i++)
        {
            if ((txt_nombre2.charAt(i)=='i') ||(txt_nombre2.charAt(i)=='u') || (txt_nombre2.charAt(i)=='I') || (txt_nombre2.charAt(i)=='U'))
            {
                contador ++ ;
            }
        }

        String frase_2_tiene = getString(R.string.frase_2_tiene);
        String vocales_cerradas = getString(R.string.vocales_cerradas);
        txt_resultado_3.setText(frase_2_tiene + " "  + contador + " " + vocales_cerradas);

    }

    //EVENTO PRINCIPAL//
    public void onclic_evento_ejecutar (View v)
    {
        mensaje_ejecutando();

        obtener_valores_de_txt();

        if (!(txt_nombre1.equals("")) && !(txt_nombre2.equals("")) )
        {
            if (txt_nombre1.equals(txt_nombre2))
            {
                String iguales = getString(R.string.frasesiguales);
                txt_resultado_1.setText(iguales);
            }
            else
            {
                String noiguales = getString(R.string.frasesnoiguales);
                txt_resultado_1.setText(noiguales);
            }
            contar_vocales_cerradas_frase_1();
            contar_vocales_cerradas_frase_2();

            Context context = getApplicationContext();
            String exitoso = getString(R.string.exitoso);
            CharSequence text = exitoso ;
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context , text , duration);
            toast.show();
        }
        else
        {
            Context context = getApplicationContext();
            String complete_campos = getString(R.string.complete_campos);
            CharSequence text = complete_campos ;
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context , text , duration);
            toast.show();

            String text3 = getString(R.string.txt_texto_3);
            txt_resultado_1.setText(text3);
            String text4 = getString(R.string.txt_texto_4);
            txt_resultado_2.setText(text4);
            String text5 = getString(R.string.txt_texto_5);
            txt_resultado_3.setText(text5);
        }

    }

    /*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //recogeremos los datos que se agregaron en el formulario
        txt_1 = (EditText) findViewById(R.id.txt_texto1);
        txt_nombre1 = txt_1.getText().toString();
        txt_2 = (EditText) findViewById(R.id.txt_texto2);
        txt_nombre2 = txt_2.getText().toString();
        txt_3 = (EditText) findViewById(R.id.txt_texto3);
        txt_nombre3 = txt_3.getText().toString();
        txt_4 = (EditText) findViewById(R.id.txt_texto4);
        txt_nombre4 = txt_4.getText().toString();
        txt_5 = (EditText) findViewById(R.id.txt_texto5);
        txt_nombre5 = txt_5.getText().toString();

        outState.putString("txt_nombre1",txt_nombre1);
        outState.putString("txt_nombre2",txt_nombre2);
        outState.putString("txt_nombre3",txt_nombre3);
        outState.putString("txt_nombre4",txt_nombre4);
        outState.putString("txt_nombre5",txt_nombre5);

    }
    */

}
