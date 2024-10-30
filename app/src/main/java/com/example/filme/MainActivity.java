package com.example.filme;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FilmeAdapter filmeAdapter;
    private List<Filme> listaFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaFilmes = new ArrayList<>();
        listaFilmes.add(new Filme("Inception", 2010, "Um ladrão especializado em invadir sonhos...", "Christopher Nolan", R.mipmap.poster_inception));
        listaFilmes.add(new Filme("The Matrix", 1999, "Um programador descobre a verdade sobre sua realidade...", "Wachowski", R.mipmap.poster_matrix));
        listaFilmes.add(new Filme("Interstellar", 2014, "Uma equipe de exploradores viaja através de um buraco de minhoca...", "Christopher Nolan", R.mipmap.poster_interstellar));

        filmeAdapter = new FilmeAdapter(listaFilmes, this);
        recyclerView.setAdapter(filmeAdapter);
    }
}
