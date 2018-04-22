package com.bignerdranch.android.personaltrainer;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewCustomerActivity extends AppCompatActivity {

    UserDBHelper userDB;

    Button btnAdd;
    EditText etName, etAge, etCreditCard;
    private ImageView mPhotoCapturedImageView;
    private Button mPhotoButton;
    private ImageView mPhotoView;
    private String mImageFileLocation = "";
    private static int ACTIVITY_START_CAMERA_APP = 0;

    private static final int REQUEST_PHOTO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcustomer);

        userDB = new UserDBHelper(this);

        etName = (EditText) findViewById(R.id.NameEditText);
        etAge = (EditText) findViewById(R.id.AgeEditText);
        etCreditCard = (EditText) findViewById(R.id.CreditCardEditText);

        btnAdd = (Button) findViewById(R.id.SubmitButton);

        mPhotoButton = (Button) findViewById(R.id.TakePhotoButton);
        mPhotoCapturedImageView = (ImageView) findViewById(R.id.capturePhotoImageView);

        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callCameraApplicationIntent = new Intent();
                callCameraApplicationIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                callCameraApplicationIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));

                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());

                startActivityForResult(callCameraApplicationIntent, ACTIVITY_START_CAMERA_APP);
            }
        });

        AddData();
    }

    File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "Image_" + timeStamp + "_";
        File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(imageFileName, ".jpg", storageDirectory);
        mImageFileLocation = image.getAbsolutePath();

        return image;
    }



    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_START_CAMERA_APP && resultCode == RESULT_OK) {
            Toast.makeText(this, "Picture taken successfully", Toast.LENGTH_SHORT).show();
            Bitmap photoCapturedBitmap = BitmapFactory.decodeFile(mImageFileLocation);
            Bundle extras = data.getExtras();
            mPhotoCapturedImageView.setImageBitmap(photoCapturedBitmap);
        }
    }



    public void AddData() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String creditCard = etCreditCard.getText().toString();

                boolean insertData = userDB.addData(name, age, creditCard);

                if (insertData == true) {
                    Toast.makeText(NewCustomerActivity.this, "Data successfully inserted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(NewCustomerActivity.this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
                }



            }
        });
    }

}


