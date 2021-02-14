package com.example.ap

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class DownloadManager {

    companion object {
        suspend fun downloadApiResults() : List<String> {
            val client = OkHttpClient()
            val url = "https://randomuser.me/api/"
            val request = Request.Builder().url(url).build()
            val call = client.newCall(request)
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                    Log.e("GetAllPersonas", call.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                  CoroutineScope(Dispatchers.IO).launch {
                      val bodyInString = response.body?.string()
                      bodyInString?.let {
                          Log.w("GetALLPersonas",bodyInString)
                          val JsonObject = JSONObject(bodyInString)
                          val results = JsonObject.optJSONArray("results")
                          results?.let {
                              val gson = Gson()
                              val itemType = object : TypeToken<List<Personas>>() {}.type
                              val list = gson.fromJson<List<Personas>>(results.toString(),itemType)




                          }
                      }
                  }
                }

            })
            delay(3000)
            return listOf("String 1", "String 2", "String 3", "String 4", "String 5", "String 6", "String 1", "String 2", "String 3", "String 4", "String 5", "String 6", "String 1", "String 2", "String 3", "String 4", "String 5", "String 6", "String 1", "String 2", "String 3", "String 4", "String 5", "String 6","String 1", "String 2", "String 3", "String 4", "String 5", "String 6")
        }


        suspend fun downloadApiSingleResult(userChoice : String) : String {
            // CONEXION A INTERNET
            // OKHTTP....
            delay(3000)
            return when (userChoice.length) {
                1 -> "RESULTADO 1"
                2 -> "RESULTADO 2"
                else -> "OTROS RESULTADOS"
            }
        }
    }
}