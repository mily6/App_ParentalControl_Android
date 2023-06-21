package pwr.aplikacja_dat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StatisticsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val todayStatistics = Intent(this, TodayActivity::class.java)

        val today = findViewById<Button>(R.id.btn3)

        today.setOnClickListener {
            startActivity(todayStatistics)
        }
    }
}