package com.example.camera_gallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int CAMERA_REQUEST_CODE=22;
    public static final int GALLERY_REQUEST_CODE=33;
    Button b1,b2;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.camera_button);
        b2=findViewById(R.id.GalleryButton);
        iv=findViewById(R.id.imageView);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.camera_button:
                openCamera();
                break;
            case R.id.GalleryButton:
                openGallery();
                break;
        }
    }

    private void openGallery() {
        Intent i=new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i,GALLERY_REQUEST_CODE);
    }

    private void openCamera() {
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST_CODE){
            if(resultCode==RESULT_OK){
                Bitmap b=(Bitmap) data.getExtras().get("data"); //or Uri
                iv.setImageBitmap(b);
            }
        }
        if(requestCode==GALLERY_REQUEST_CODE){
            if(resultCode==RESULT_OK){
                Uri u=data.getData(); //or Bitmap
                iv.setImageURI(u);
            }
        }
    }
}