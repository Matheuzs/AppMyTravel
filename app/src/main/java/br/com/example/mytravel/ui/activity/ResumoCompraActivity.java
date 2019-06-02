package br.com.example.mytravel.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.example.mytravel.R;
import br.com.example.mytravel.model.Pacote;
import br.com.example.mytravel.util.DataUtil;
import br.com.example.mytravel.util.MoedaUtil;
import br.com.example.mytravel.util.ResourceUtil;

import static br.com.example.mytravel.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    private static final String TITLE_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITLE_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        if (getIntent().hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) getIntent().getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraImagem(pacote);
        mostraLocal(pacote);
        mostraPeriodo(pacote);
        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView precoView = findViewById(R.id.resumo_compra_preco);
        String valorEmTexto = MoedaUtil.formataParaMoedaBrasileira(pacote.getPreco());
        precoView.setText(valorEmTexto);
    }

    private void mostraPeriodo(Pacote pacote) {
        TextView periodoView = findViewById(R.id.resumo_compra_periodo);
        String periodoEmTexto = DataUtil.periodoEmTexto(pacote.getDias());
        periodoView.setText(periodoEmTexto);
    }

    private void mostraLocal(Pacote pacote) {
        TextView localView = findViewById(R.id.resumo_compra_local);
        localView.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imageView = findViewById(R.id.resumo_compra_imagem_local);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imageView.setImageDrawable(drawable);
    }
}
