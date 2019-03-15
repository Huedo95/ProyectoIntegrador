package com.example.alex_.proyectointegrador;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.alex_.proyectointegrador.javabean.PojoCrearEventos;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


public class CrearEventos extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imgvFotoEvento;
    private Button btnCrear, btnCancelar, btnCargarFoto;
    private EditText ettNombreEvento, ettUbicacion, ettDescripcionEvento, ettFechaInicio, ettFechaFin;
    private DatabaseReference dbR;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private Uri mImageUri;
    private ProgressBar Barra;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_eventos);

        imgvFotoEvento = (ImageView)findViewById(R.id.imgvFotoEvento);
        btnCrear = (Button)findViewById(R.id.btnCrear);

        Barra = findViewById( R.id.Barra );

        mStorageRef = FirebaseStorage.getInstance().getReference("Uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Uploads");

        ettNombreEvento = findViewById( R.id.etNombreEvento );
        ettUbicacion = findViewById( R.id.etUbicacion );
        ettFechaInicio = findViewById( R.id.etFechaInicio );
        ettDescripcionEvento = findViewById( R.id.etDescripcionEvento );
        ettFechaFin = findViewById( R.id.etFechaFin );


        imgvFotoEvento.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirGaleria();
            }
        } );

        btnCrear.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();

            }
        } );

    }
    private void AbrirGaleria(){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction( Intent.ACTION_GET_CONTENT );
        startActivityForResult( i, PICK_IMAGE_REQUEST );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
            && data != null && data.getData() != null){
            mImageUri = data.getData();

            /*StorageReference fotoRef = mStorageRef.child(mImageUri.getLastPathSegment());
            UploadTask ut = fotoRef.putFile(mImageUri);
            ut.addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> task = taskSnapshot.getStorage().getDownloadUrl();
                    task.addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            url = uri.toString();


                        }
                    });
                }
            });*/

            imgvFotoEvento.setImageURI( mImageUri );

        }

        }
        private String getFileExtension(Uri uri){
            ContentResolver cR = getContentResolver();
            MimeTypeMap mime = MimeTypeMap.getSingleton();
            return mime.getExtensionFromMimeType( cR.getType( uri ) );

        }
        public void cancelar(View v){
        finish();
        }
        private void uploadFile(){
            if(mImageUri != null){

                StorageReference fotoRef = mStorageRef.child(mImageUri.getLastPathSegment());
                UploadTask ut = fotoRef.putFile(mImageUri);
                ut.addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> task = taskSnapshot.getStorage().getDownloadUrl();
                        task.addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                url = uri.toString();

                                Toast.makeText( CrearEventos.this, "Subida Correcta", Toast.LENGTH_SHORT ).show();
                                PojoCrearEventos pce = new PojoCrearEventos(
                                        ettNombreEvento.getText().toString().trim(),
                                        ettDescripcionEvento.getText().toString().trim(),
                                        ettUbicacion.getText().toString().trim(),
                                        ettFechaInicio.getText().toString().trim(),
                                        ettFechaFin.getText().toString().trim(),
                                        url
                                );
                                String uploadId = mDatabaseRef.push().getKey();
                                mDatabaseRef.child( uploadId ).setValue( pce );

                            }
                        });
                    }
                })

                /*StorageReference fileReference = mStorageRef.child( System.currentTimeMillis()
                + "." + getFileExtension( mImageUri ));

                fileReference.putFile( mImageUri )
                        .addOnSuccessListener( new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                Handler handler = new Handler(  );
                                handler.postDelayed( new Runnable() {
                                    @Override
                                    public void run() {
                                        Barra.setProgress( 0 );
                                    }
                                }, 5000 );
                                Toast.makeText( CrearEventos.this, "Subida Correcta", Toast.LENGTH_SHORT ).show();
                                PojoCrearEventos pce = new PojoCrearEventos(
                                        ettNombreEvento.getText().toString().trim(),
                                        ettDescripcionEvento.getText().toString().trim(),
                                        ettUbicacion.getText().toString().trim(),
                                        ettFechaInicio.getText().toString().trim(),
                                        ettFechaFin.getText().toString().trim(),
                                        url
                                        );
                                String uploadId = mDatabaseRef.push().getKey();
                                mDatabaseRef.child( uploadId ).setValue( pce );
                            }
                        } )*/
                        .addOnFailureListener( new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText( CrearEventos.this, "Fallo", Toast.LENGTH_SHORT ).show();
                            }
                        } )
                        .addOnProgressListener( new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                                Barra.setProgress( (int) progress );
                            }
                        } );
            }else{
                Toast.makeText( this, "No se ha seleccionado imagen", Toast.LENGTH_SHORT ).show();
            }

        }
        public void hola(){

        }

    /*public void crear() {
        String Nombre = ettNombreEvento.getText().toString();
        String Ubicacion = ettUbicacion.getText().toString();
        String Descripcion = ettDescripcionEvento.getText().toString();
        String fechaInicio = ettFechaInicio.getText().toString();
        String fechaFin = ettFechaFin.getText().toString();

        if(Nombre.isEmpty() || Ubicacion.isEmpty() || Descripcion.isEmpty() || fechaFin.isEmpty() || fechaInicio.isEmpty()
                || Nombre.trim().equals("") || Ubicacion.trim().equals("") || Descripcion.trim().equals("")) {
            Toast.makeText(getBaseContext(), "Error en crear los datos", Toast.LENGTH_SHORT).show();
        } else {
            PojoCrearEventos pce = new PojoCrearEventos(Nombre, Ubicacion, Descripcion, fechaInicio, fechaFin);
            dbR.push().setValue(pce);
            startActivity(new Intent(CrearEventos.this, MisEventos.class));

        }

    }*/




    /*private void SubirPerfil() {

        StorageReference filepath = mStorage.child("fotos").child(uri.getLastPathSegment());

        UploadTask ut = filepath.putFile(uri);
        ut.addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> task = taskSnapshot.getStorage().getDownloadUrl();
                Picasso.


            }
        });

       /* String Nombre=etNombreEvento.getText().toString();
        String Ubicacion = etUbicacion.getText().toString();
        String Descripcion =etDescripcionEvento.getText().toString();
        String FechaInicio = etFechaInicio.getText().toString();
        String FechaFin = etFechaFin.getText().toString();


    }*/
/*
    private void openGallery() {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(gallery, PICK_IMAGE);


        }
        public void limpiar(){

        }*/


    }



