package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.emergency.EmergencyNumber;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //緊急連絡人
    public void processEmergencyCall(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("緊急聯絡機制");
        builder.setMessage("請問您是否發生緊急狀況?");

        builder.setNegativeButton("確定", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendEmergencyCall();
            }
        });

        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }
    //報案
    public void processPolice(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("緊急聯絡機制");
        builder.setMessage("請問您是否需要報案?");

        builder.setNegativeButton("確定", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendPolice();
            }
        });

        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    //救難
    public void processRescue(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("緊急聯絡機制");
        builder.setMessage("請問您是否需要救難?");

        builder.setNegativeButton("確定", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendRescue();
            }
        });

        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }




    //緊急連絡人
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void sendEmergencyCall() {
        Uri uri = Uri.parse("tel:0978832158");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if(checkSelfPermission( Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            int myCallRequestCode = 911;
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},myCallRequestCode);
            return;
        }
        startActivity(intent);
    }

    //報案
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void sendPolice() {
        Uri uri = Uri.parse("tel:110");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if(checkSelfPermission( Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            int myCallRequestCode = 911;
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},myCallRequestCode);
            return;
        }
        startActivity(intent);
    }

    //救難
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void sendRescue() {
        Uri uri = Uri.parse("tel:119");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if(checkSelfPermission( Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            int myCallRequestCode = 911;
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},myCallRequestCode);
            return;
        }
        startActivity(intent);
    }



    public void onRequestPermissionsResult(int requestCode, String[] premission, int[] grantResults){
        if (requestCode == 911){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Access Permitted", Toast.LENGTH_SHORT).show();
            }else{
                        Toast.makeText(MainActivity.this, "Access Denied", Toast.LENGTH_SHORT).show();
                        return;
            }
        }
    }




}
