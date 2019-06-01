package com.example.iteradmin.kotlin_bluetooth

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
private val REQUEST_CODE:Int =108
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bt1=findViewById<Button>(R.id.button)
        val bt2=findViewById<Button>(R.id.button2)
        val badp:BluetoothAdapter=BluetoothAdapter.getDefaultAdapter()
        bt1.setOnClickListener{
            if(badp==null){
                Toast.makeText(this,"no bluetooth",Toast.LENGTH_LONG).show()
            }
            else{
                if(badp.isEnabled==false)
                {
                    val intent=Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                    startActivityForResult(intent,REQUEST_CODE)
                }else{
                    Toast.makeText(this,"bluetooth is found",Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==REQUEST_CODE && resultCode== RESULT_OK) {
            Toast.makeText(this, "susccess", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
        }
    }
}
