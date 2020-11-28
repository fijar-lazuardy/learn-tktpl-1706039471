package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_5.model

import com.google.gson.annotations.SerializedName

class WifiModel {
    @SerializedName("wifiName")
    var wifiName: String? = null
}

class ResponseModel {
    @SerializedName("success")
    val response: Boolean? = null
}