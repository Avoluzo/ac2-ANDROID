package com.example.filme;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {

    private List<Filme> listaFilmes;
    private Context context;

    public FilmeAdapter(List<Filme> listaFilmes, Context context) {
        this.listaFilmes = listaFilmes;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = listaFilmes.get(position);
        holder.tituloFilme.setText(filme.getTitulo());
        holder.anoFilme.setText("Ano: " + filme.getAno());
        holder.diretorFilme.setText("Diretor: " + filme.getDiretor());
        holder.imagemFilme.setImageResource(filme.getImagem());

        holder.btnSinopse.setOnClickListener(v ->
                Toast.makeText(context, filme.getSinopse(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder {
        TextView tituloFilme, anoFilme, diretorFilme;
        ImageView imagemFilme;
        Button btnSinopse;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloFilme = itemView.findViewById(R.id.tituloFilme);
            anoFilme = itemView.findViewById(R.id.anoFilme);
            diretorFilme = itemView.findViewById(R.id.diretorFilme);
            imagemFilme = itemView.findViewById(R.id.imagemFilme);
            btnSinopse = itemView.findViewById(R.id.btnSinopse);
        }
    }
}
