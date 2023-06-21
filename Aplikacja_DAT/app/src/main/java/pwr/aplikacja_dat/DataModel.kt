package pwr.aplikacja_dat

import com.google.gson.annotations.SerializedName

public class DataModel {
        @SerializedName("nazwa")
        var nazwa: String? = null

        @SerializedName("status")
        var status: String? = null

        @SerializedName("zuzyte_dane")
        var zuzyteDane: String? = null
}