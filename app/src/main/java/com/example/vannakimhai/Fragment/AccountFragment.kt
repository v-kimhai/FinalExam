package com.example.vannakimhai.Fragment


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.vannakimhai.Model.Customer
import com.example.vannakimhai.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_account.*


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

        val url = "http://ite-rupp.ap-southeast-1.elasticbeanstalk.com/profile.php"
        val requestQueue = Volley.newRequestQueue(context)
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    val gson = Gson()
                    val customer: Customer = gson.fromJson<Customer>(response.toString(), Customer::class.java)
                    name.text = customer.name
                    phone.text = customer.phone
                    address.text = customer.province
                    profile_image.setImageURI(customer.profileImage)

                },
                Response.ErrorListener { error ->
                    // TODO: Handle error
                    Toast.makeText(context!!, "Load data error" + error, Toast.LENGTH_LONG).show()
                }
        )
        requestQueue.add(jsonObjectRequest)

    }


}
