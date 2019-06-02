package br.com.example.mytravel.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.example.mytravel.R;
import br.com.example.mytravel.model.Pacote;
import br.com.example.mytravel.util.DataUtil;
import br.com.example.mytravel.util.DiasUtil;
import br.com.example.mytravel.util.MoedaUtil;
import br.com.example.mytravel.util.ResourceUtil;

import static br.com.example.mytravel.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITLE_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        if (getIntent().hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) getIntent().getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos(pacote);
            configuraBotaoRealizaPagamento(pacote);
        }
    }

    private void configuraBotaoRealizaPagamento(final Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);
        botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamentoActivity(pacote);
            }
        });
    }

    private void vaiParaPagamentoActivity(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraPreco(pacote);
        mostraDias(pacote);
        mostraData(pacote);
    }

    private void mostraData(Pacote pacote) {
        TextView dataView = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaEmTexto = DataUtil.periodoEmTexto(pacote.getDias());
        dataView.setText(dataFormatadaEmTexto);
    }


    private void mostraPreco(Pacote pacote) {
        TextView precoView = findViewById(R.id.resumo_pacote_preco);
        String precoEmTexto = MoedaUtil.formataParaMoedaBrasileira(pacote.getPreco());
        precoView.setText(precoEmTexto);
    }

    private void mostraDias(Pacote pacote) {
        TextView diasView = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataDiasEmTexto(pacote.getDias());
        diasView.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imageView = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imageView.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacote pacote) {
        TextView localView = findViewById(R.id.resumo_pacote_local);
        localView.setText(pacote.getLocal());
    }

}
