package com.underpressure.boardtonote

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.content_edit.*


class EditActivity : AppCompatActivity() {

    private lateinit var btnClass: BTNClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("EditActivity", "onCreate")

        setContentView(R.layout.activity_edit)
        setSupportActionBar(toolbar)

        val intent = intent
        val dirName = intent.getStringExtra("dirName")
        if (dirName == null) {
            Toast.makeText(this, "An Error Occurred : pictureUri does not exist.", Toast.LENGTH_SHORT)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            btnClass = BTNClass(this, dirName)
            try {
                pictureView.setImageBitmap(btnClass.oriPic)
            } catch (e: Exception) {
                Toast.makeText(this, "An Error Occurred : Can't open Picture.", Toast.LENGTH_SHORT)
            }
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Menu_Save -> {
                true
            }
            R.id.Menu_Share -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
