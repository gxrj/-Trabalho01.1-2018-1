package br.edu.iff.pooa20181.trabalho011_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtArea;
    private Button btnCalcular;
    private TextView opcao01, opcao02, opcao03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtArea = (EditText) findViewById(R.id.edtArea);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        opcao01 = (TextView) findViewById(R.id.tvOpcao1);
        opcao02 = (TextView) findViewById(R.id.tvOpcao2);
        opcao03 = (TextView) findViewById(R.id.tvOpcao3);

        opcao01.setVisibility(View.INVISIBLE);
        opcao02.setVisibility(View.INVISIBLE);
        opcao03.setVisibility(View.INVISIBLE);

        btnCalcular.setOnClickListener(this);
    }

    public void onClick(View v){
        float area = Float.parseFloat(txtArea.getText().toString());
        float areaCobertaLata = (float) 18*6, areaCobertaGalao = (float) 3.6*6, precoTotal, resto;
        int qtdeLatas, qtdeGaloes;

        String saida;

        if(area > 0) {

            qtdeLatas = (int) (area / areaCobertaLata);
            qtdeGaloes = (int) (area / areaCobertaGalao);

            if( qtdeLatas * areaCobertaLata < area)
                qtdeLatas++;
            if( qtdeGaloes * areaCobertaGalao < area)
                qtdeGaloes++;

            precoTotal = qtdeLatas * 80;
            saida = "Opcao 1: "+qtdeLatas+" lata(s) por "+precoTotal+" reais \n";

            opcao01.setText(saida);

            precoTotal = qtdeGaloes * 25;
            saida = "Opcao 2: "+qtdeGaloes+" galao(oes) por "+precoTotal+" reais \n";

            opcao02.setText(saida);

            qtdeLatas = (int) (area / areaCobertaLata);
            qtdeGaloes = 0;
            resto = area % areaCobertaLata;

            if(resto != 0)
            {
                qtdeGaloes = (int) (resto / areaCobertaGalao);

                if(qtdeGaloes == 0 || qtdeGaloes * areaCobertaGalao < area)
                    qtdeGaloes++;

                if(qtdeGaloes * 25 > 80)
                {
                    qtdeGaloes = 0;
                    qtdeLatas++;
                }

            }
            precoTotal = qtdeLatas * 80 + qtdeGaloes * 25;

            saida = "Opcao 3: "+qtdeLatas+" lata(s) mais "+qtdeGaloes+" galao(oes) por "+precoTotal+" reias \n";

            opcao03.setText(saida);

            opcao01.setVisibility(View.VISIBLE);
            opcao02.setVisibility(View.VISIBLE);
            opcao03.setVisibility(View.VISIBLE);
        }
        else
        {
            saida = "Número inválido!! \n";
            opcao01.setText(saida);
            opcao01.setVisibility(View.VISIBLE);
        }
    }
}
