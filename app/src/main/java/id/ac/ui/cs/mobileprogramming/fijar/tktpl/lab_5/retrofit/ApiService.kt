package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_5.retrofit

import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_5.model.ResponseModel
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_5.model.WifiModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/")
    suspend fun submitWifiList(@Body wifiList: List<WifiModel>): Response<ResponseModel>
}