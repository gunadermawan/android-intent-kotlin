package com.gunder.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)
//        batas 1

        val btnDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnDataActivity.setOnClickListener(this)

//        batas 2
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity->{
                //            buat activity baru (MoveAcitivity)
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

//            batas 1
            R.id.btn_move_activity_data->{
//                buat activity baru dlu (MoveWithDataActivity), sampe sini lanjut ke acitivity yg bru dibuat
                val MoveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                MoveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Guna Dermawan")
                MoveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, "21")
                startActivity(MoveWithDataIntent)
            }
//            batas 2
            R.id.btn_dial_number-> {
                val phoneNumber = "1234556789"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}