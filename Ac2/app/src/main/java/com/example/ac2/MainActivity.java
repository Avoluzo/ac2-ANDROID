package com.example.ac2;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private FilmeAdapter filmeAdapter;
    private List<Filme> filmeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        filmeList = new ArrayList<>();

        filmeList.add(new Filme("Cars", 2006,
                "Um carro de corrida encontra-se perdido em uma cidade pequena.",
                "John Lasseter", R.mipmap.cars_img));
        filmeList.add(new Filme("Spider-Man", 2002,
                "Um jovem ganha poderes especiais e luta contra o crime.",
                "Sam Raimi", R.mipmap.spiderman_img));
        filmeList.add(new Filme("Star Wars", 1977,
                "A luta entre o bem e o mal em uma galáxia distante.",
                "George Lucas", R.mipmap.starwars_img));

        Log.d("MainActivity", "Total de filmes: " + filmeList.size());

        filmeAdapter = new FilmeAdapter(filmeList, this);
        viewPager.setAdapter(filmeAdapter);
    }
}
