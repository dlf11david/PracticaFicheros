package es.ua.eps.appficheros

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dir = filesDir

        findViewById<Button>(R.id.addBtn).setOnClickListener {

            val towrite = findViewById<EditText>(R.id.saveEt).text.toString()

            val fileStr = try {
                File(dir, "datos.txt").readText()
            } catch (error:Exception) {
                ""
            }

            if (fileStr.isEmpty()) {
                openFileOutput("datos.txt", Context.MODE_PRIVATE).bufferedWriter().use {
                    it.write(towrite)
                }
            } else {
                openFileOutput("datos.txt", Context.MODE_APPEND).bufferedWriter().use {
                    it.write("\n" + towrite)
                }
            }

            findViewById<EditText>(R.id.saveEt).setText("")

        }

        findViewById<Button>(R.id.ficheroBtn).setOnClickListener {
            Intent(this,ReadActivity::class.java).also {
                startActivity(it)
            }
        }


    }
}