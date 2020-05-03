package com.example.reimbursementclaims;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pop extends Main4Activity {
    public static final int cameraRequestCode = 1;
    public static final int writeStorageRequestCode = 2;
    public static final int galleryRequestCode = 3;
    ImageView imageView;
    Button openCamera, openGallery;
    String capturedImagePath;


    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.popwindow);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.9),(int)(height*0.35));
        imageView = findViewById(R.id.photo);
        openCamera = findViewById(R.id.opencamera);
        openGallery = findViewById(R.id.opengallery);

        askForWriteStoragePermission();
        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askForCameraPermission();
            }
        });
        openGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, galleryRequestCode);
            }
        });
    }
    private void askForWriteStoragePermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {


            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, writeStorageRequestCode);

            }
        }
    }
    private void askForCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, cameraRequestCode);
        } else
            intentForCamera();
    }
    private void intentForCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            File imageFile = null;
            try {
                imageFile = createImageFile();
            } catch (Exception e) {

            }
            if (imageFile != null) {
                Uri imageUri = FileProvider.getUriForFile(this, "com.example.reimbursementclaims.fileprovider", imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(cameraIntent, cameraRequestCode);
            }
        }
    }
    private File createImageFile() throws Exception {
        String fileName = "JPEG" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                fileName, ".jpg", storageDirectory
        );
        capturedImagePath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == cameraRequestCode) {
            if (resultCode == Activity.RESULT_OK) {
//                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//                imageView.setImageBitmap(bitmap);
                File file = new File(capturedImagePath);
                imageView.setImageURI(Uri.fromFile(file));
                Intent mediaIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri uri = Uri.fromFile(file);
                mediaIntent.setData(uri);
                this.sendBroadcast(mediaIntent);
            }
        }

        if (requestCode == galleryRequestCode) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
        }

    }
}
