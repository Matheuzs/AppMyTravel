package br.com.example.mytravel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.example.mytravel.R;
import br.com.example.mytravel.dao.PacoteDAO;
import br.com.example.mytravel.model.Pacote;
import br.com.example.mytravel.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITLE_APPBAR);
        ListView viewDePacotes = findViewById(R.id.lista_pacotes_listview);
        configuraListView(viewDePacotes);

        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        startActivity(intent);
    }

    private void configuraListView(ListView listaDePacotes) {
        PacoteDAO dao = new PacoteDAO();
        List<Pacote> pacotes = dao.lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }


}
