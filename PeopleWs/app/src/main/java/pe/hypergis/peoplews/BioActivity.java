package pe.hypergis.peoplews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BioActivity extends AppCompatActivity {
    TextView nombre;
    TextView dni;
    TextView bio;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (TextView) findViewById(R.id.nombre);
        dni = (TextView) findViewById(R.id.dni);
        bio = (TextView) findViewById(R.id.biografia);
        imagen = (ImageView) findViewById(R.id.imagen);

        nombre.setText(getIntent().getExtras().getString("curNombre"));
        dni.setText("DNI: " + getIntent().getExtras().getString("curDni"));
        bio.setText(getIntent().getExtras().getString("curBio"));

        //imagen.setImageResource(getIntent().getExtras().getInt("curImagen"));

        Picasso.with(imagen.getContext())
                .load(getIntent().getExtras().getString("curImagen")).into(imagen);
    }

}
