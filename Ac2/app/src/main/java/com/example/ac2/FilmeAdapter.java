package com.example.ac2;

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

    private List<Filme> filmes;
    private Context context;

    public FilmeAdapter(List<Filme> filmes, Context context) {
        this.filmes = filmes;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_filme, parent, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.tituloFilme.setText(filme.getTitulo());
        holder.anoFilme.setText(String.valueOf(filme.getAno()));
        holder.diretorFilme.setText(filme.getDiretor());
        holder.imagemFilme.setImageResource(filme.getImagem());

        holder.botaoSinopse.setOnClickListener(v -> {
            Toast.makeText(context, filme.getSinopse(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder {
        TextView tituloFilme, anoFilme, diretorFilme;
        ImageView imagemFilme;
        Button botaoSinopse;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloFilme = itemView.findViewById(R.id.tituloFilme);
            anoFilme = itemView.findViewById(R.id.anoFilme);
            diretorFilme = itemView.findViewById(R.id.diretorFilme);
            imagemFilme = itemView.findViewById(R.id.imagemFilme);
            botaoSinopse = itemView.findViewById(R.id.botaoSinopse);
        }
    }
}
