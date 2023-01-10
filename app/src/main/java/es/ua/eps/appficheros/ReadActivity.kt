package es.ua.eps.appficheros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.File

class ReadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        val fileStr = try {
            File(filesDir, "datos.txt").readText()
        } catch (error:Exception) {
            ""
        }
        findViewById<TextView>(R.id.readTv).text = fileStr
        findViewById<Button>(R.id.volverBtn).setOnClickListener {
            finish()
        }
    }
}