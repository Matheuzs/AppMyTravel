package br.com.example.mytravel.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.example.mytravel.R;
import br.com.example.mytravel.model.Pacote;
import br.com.example.mytravel.util.DiasUtil;
import br.com.example.mytravel.util.MoedaUtil;
import br.com.example.mytravel.util.ResourceUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_listview_pacotes, parent, false);
        Pacote pacote = pacotes.get(position);

        setImagem(viewCriada, pacote);
        setLocal(viewCriada, pacote);
        setDias(viewCriada, pacote);
        setPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void setImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void setLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }

    private void setDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String textoQntdDias = DiasUtil.formataDiasEmTexto(pacote.getDias());
        dias.setText(textoQntdDias);
    }

    private void setPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String textoPreco = MoedaUtil.formataParaMoedaBrasileira(pacote.getPreco());
        preco.setText(textoPreco);
    }

}
