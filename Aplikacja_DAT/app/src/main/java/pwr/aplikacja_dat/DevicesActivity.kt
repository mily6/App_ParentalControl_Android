package pwr.aplikacja_dat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class DevicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devices)

        val items = listOf("1min","5min","10min","15min","20min","30min","40min","50min","1h","1h 10min","1h 20min","1h 30min","1h 40min","1h 50min","2h")

        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(this,R.layout.list_item,items)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this,"item: $itemSelected",Toast.LENGTH_SHORT).show()

        }
        val back = findViewById<Button>(R.id.button3)
        val myIntent = Intent(this, MenuActivity::class.java)
        back.setOnClickListener {
            startActivity(myIntent)
        }
    }

}