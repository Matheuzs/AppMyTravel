package br.com.example.mytravel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.example.mytravel.R;
import br.com.example.mytravel.model.Pacote;
import br.com.example.mytravel.util.MoedaUtil;

import static br.com.example.mytravel.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITLE_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        if (getIntent().hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) getIntent().getSerializableExtra(CHAVE_PACOTE);
            mostraPreco(pacote);
            Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
            configuraBotaoFinalizaCompra(pacote, botaoFinalizaCompra);

        }
    }

    private void configuraBotaoFinalizaCompra(final Pacote pacote, Button botaoFinalizaCompra) {
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompraActivity(pacote);
            }
        });
    }

    private void vaiParaResumoCompraActivity(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView precoView = findViewById(R.id.pagamento_preco);
        String valor = MoedaUtil.formataParaMoedaBrasileira(pacote.getPreco());
        precoView.setText(valor);
    }
}
