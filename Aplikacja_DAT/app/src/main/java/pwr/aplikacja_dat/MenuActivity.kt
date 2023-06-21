package pwr.aplikacja_dat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MenuActivity : AppCompatActivity(){

    private lateinit var myStatistics: Intent
    private lateinit var myDevices: Intent

    // Define ApiService interface outside onCreate
    interface ApiService {
        @GET("/data")
        fun getData(): Call<List<DataModel>>
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val myLogin = Intent(this, LoginActivity::class.java)
        myStatistics = Intent(this, StatisticsActivity::class.java)
        myDevices = Intent(this, DevicesActivity::class.java)
// Create Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.137.1:5000/sprawdz_urzadzenie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


// Create ApiService instance
        val apiService = retrofit.create(ApiService::class.java)

        val call = apiService.getData()
        call.enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null && data.isNotEmpty()) {
                        val firstData = data[0] // Pobierz pierwszy element z listy danych
                        val nazwaTextView = findViewById<TextView>(R.id.name)
                        val statusTextView = findViewById<TextView>(R.id.status)
                        val zuzyteDaneTextView = findViewById<TextView>(R.id.dane)

                        // Przypisz wartości do TextView
                        nazwaTextView.text = "sadaadasda"
                        statusTextView.text = firstData.status
                        zuzyteDaneTextView.text = firstData.zuzyteDane
                    }
                } else {
                    val nazwaTextView = findViewById<TextView>(R.id.name)
                    nazwaTextView.text = "sadaadasda"
                    Log.d("MenuActivity", "Error response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                // Handle network failure
                // Print error message or perform error handling
            }
        })
        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            startActivity(myLogin)
        }
    }
}