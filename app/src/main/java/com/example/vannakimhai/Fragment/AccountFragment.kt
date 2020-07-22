package com.example.vannakimhai.Fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.vannakimhai.R
import org.json.JSONArray
import org.json.JSONObject



/**
 * A simple [Fragment] subclass.
 */
class AccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fetchingProfile()
    }

    fun fetchingProfile() {
        Log.d("log init", "init" )
        val requestQueue = Volley.newRequestQueue(context)
        val url = "http://ite-rupp.ap-southeast-1.elasticbeanstalk.com/profile.php"
        val request = JsonArrayRequest(url, Response.Listener { response ->
            val object = JSONObject(response)
            val jsonArray: JSONArray = object.getJSONArray("result")
            val jsonObject = jsonArray.getJSONObject(0)
        }, Response.ErrorListener { error ->
            Toast.makeText(context!!, "Load data error." + error.message, Toast.LENGTH_LONG).show()
            Log.d("log data", "Load data error: " + error.message)
        })


        // Add request to Queue
        requestQueue.add(request)
    }


}
