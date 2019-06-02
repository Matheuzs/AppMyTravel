package br.com.example.mytravel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.example.mytravel.R;
import br.com.example.mytravel.dao.PacoteDAO;
import br.com.example.mytravel.model.Pacote;
import br.com.example.mytravel.ui.adapter.ListaPacotesAdapter;

import static br.com.example.mytravel.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITLE_APPBAR);
        ListView viewDePacotes = findViewById(R.id.lista_pacotes_listview);
        configuraListView(viewDePacotes);
    }

    private void configuraListView(ListView listaDePacotes) {
        PacoteDAO dao = new PacoteDAO();
        final List<Pacote> pacotes = dao.lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteClicado = pacotes.get(position);
                vaiParaResumoPacoteActivity(pacoteClicado);
            }
        });
    }

    private void vaiParaResumoPacoteActivity(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }


}
