package com.example.alex_.proyectointegrador.Perfil;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.alex_.proyectointegrador.Login.SignOffActivity;
import com.example.alex_.proyectointegrador.MisEventos;
import com.example.alex_.proyectointegrador.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Perfil extends AppCompatActivity {

    Button btnEnviar;
    RecyclerView rvFotos;
    ArrayList<PerfilPojo> datos;

    LinearLayoutManager llm;
    ImageView foto;
    Uri uri;
    private static final int PICK_IMAGE_REQUEST = 1;

    private DatabaseReference dbR;
    private ChildEventListener cel;


    // STORAGE
    private FirebaseStorage mFirebaseStorage;
    private StorageReference mFotoStorageRef;

    public static final int RC_PHOTO_ADJ = 2;

    // AUTENTICACION
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String remitente;
    public static final int RC_SIGN_IN = 1;
    private String idUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        mFirebaseStorage = FirebaseStorage.getInstance();
        mFotoStorageRef = mFirebaseStorage.getReference().child("fotos");
        dbR = FirebaseDatabase.getInstance().getReference().child("Perfil");
        foto = findViewById(R.id.fotoPerfil);

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirGaleria();
            }
        });
        mFirebaseAuth = FirebaseAuth.getInstance();
        idUsuario=mFirebaseAuth.getCurrentUser().getEmail();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null){
            uri = data.getData();
            StorageReference fotoRef = mFotoStorageRef.child(uri.getLastPathSegment());
            UploadTask ut = fotoRef.putFile(uri);
            ut.addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> task = taskSnapshot.getStorage().getDownloadUrl();
                    task.addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String id=getIntent().getStringExtra("id");
                            String user=getIntent().getStringExtra("user");
                            PerfilPojo fm = new PerfilPojo(user, uri.toString(),id);
                            Map<String, Object> mapa = new HashMap<String, Object>();
                            mapa.put(id, fm);
                         //   dbR.updateChildren(mapa);
                            Glide.with(foto.getContext())
                                    .load(fm.getFotoUrl())
                                    .into(foto);
                        }
                    });
                }
            });
            foto.setImageURI( uri );

        }


    }

    private void clearDatabase() {
        if (cel != null) {
            dbR.removeEventListener(cel);
            cel = null;
        }
    }

    public void enviarFoto(View v) {
        /*Foto msj = new Foto(null);
        String clave = dbR.push().getKey();
        dbR.child(clave).setValue(msj);
        */
        /*abrirá un selector de archivos para ayudarnos a elegir entre cualquier imagen JPEG almacenada localmente en el dispositivo */
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/jpeg");
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        startActivityForResult(Intent.createChooser(intent,
                "Complete la acción usando"), RC_PHOTO_ADJ);

    }

    public void ayuda(View v) {
        Intent i = new Intent( Perfil.this, MisEventos.class );
        startActivity(i);

    }

    public void acc(View v) {
        Intent intent = new Intent(Perfil.this, SignOffActivity.class);
        startActivity(intent);
        finish();
    }

    private void AbrirGaleria() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, PICK_IMAGE_REQUEST);
    }

}
