package com.example.webview

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.parseAsHtml
import com.example.webview.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import org.json.JSONStringer
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction().replace(R.id.place_holder, LoadingFragment.newInstance())
            .commit()

        if (checkFirstRun()) {sendGet()}
        else openContentFragment()

    }

    private fun sendGet() {
        GlobalScope.launch(Dispatchers.IO) {

            val url = URL("https://efs5i1ube5.execute-api.eu-central-1.amazonaws.com/prod")

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET
                var link = ""
                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        link += line
                    }
                }
                var stringParser =JSONObject(link)

                saveToPref("link", stringParser.get("link") as String)
                saveToPref("home",stringParser.get("home") as String)

                supportFragmentManager
                    .beginTransaction().replace(R.id.place_holder, ContentFragment.newInstance())
                    .commit()

            }
        }
    }

    private fun saveToPref(name:String, data: String){
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        sharedPref.edit().putString(name,data).commit()
    }
    private fun checkFirstRun(): Boolean
    {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getBoolean("firstRun", true)
    }
    private fun openContentFragment()
    {
        supportFragmentManager
            .beginTransaction().replace(R.id.place_holder, ContentFragment.newInstance())
            .commit()
    }


}