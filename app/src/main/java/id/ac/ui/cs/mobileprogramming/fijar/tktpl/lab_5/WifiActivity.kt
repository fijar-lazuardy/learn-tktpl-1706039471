package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_5

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Build
//import androidx.appcompat.app.AppCompatActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R
import kotlinx.android.synthetic.main.activity_wifi.*
//import android.app.
import org.w3c.dom.Text

class WifiActivity : AppCompatActivity() {
    private lateinit var wifiManager: WifiManager
    private lateinit var mScanResult: List<ScanResult>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)
        wifiManager = getSystemService(Context.WIFI_SERVICE) as WifiManager
        val btn: Button = findViewById(R.id.button)
        val txt: TextView = findViewById(R.id.textView)


        val wifiScanReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action!! == WifiManager.SCAN_RESULTS_AVAILABLE_ACTION) {
                    mScanResult = wifiManager.scanResults
                }
                val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
                if (success) {
                    scanSuccess()
                } else {
                    scanFail()
                }
            }
        }
        if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 87);
        }
        val intentFilter = IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        registerReceiver(wifiScanReceiver, intentFilter)
        wifiManager.isWifiEnabled = true
        wifiManager.startScan()

        btn.setOnClickListener {

        }
    }

    private fun scanSuccess() {
        val result = wifiManager.scanResults
        val txt: TextView = findViewById(R.id.textView)
        var str = ""
        for (res in result) {
            str+= res.SSID + "\n"
        }
        txt.text = str
    }

    private fun scanFail() {
    }
}