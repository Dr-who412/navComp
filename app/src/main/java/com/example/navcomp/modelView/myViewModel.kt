package com.example.navcomp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmtask.Data.modeldata
import com.example.navcomp.apis.Client
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel : ViewModel() {


    //var data: MutableLiveData<Int> = MutableLiveData()
    var invalidNum: MutableLiveData<Int> = MutableLiveData()
    var invalidZero: MutableLiveData<Int> = MutableLiveData()


    var error_message: MutableLiveData<String> = MutableLiveData()
    var productDataList: MutableLiveData<ArrayList<modeldata>> = MutableLiveData()

    fun getProduct(): MutableLiveData<ArrayList<modeldata>> {
        return productDataList
    }

    fun getProducts() {
        Client.getMyApis( "https://api.punkapi.com/v2/")
            .call()
            .enqueue(object : Callback<ArrayList<modeldata>> {
                override fun onResponse(
                    call: Call<ArrayList<modeldata>>,
                    response: Response<ArrayList<modeldata>>
                ) {
                    when (response.code()) {
                        200 -> {
                            val data: ArrayList<modeldata> = response.body()!!
                            productDataList.postValue(data)

                        }

                        else -> {
                            val errorJsonString = response.errorBody()?.string()
                            val json: JSONObject = JSONObject(errorJsonString)
                            val msg = json.getString("message")
                            error_message.postValue(msg)
                        }
                    }

                }

                override fun onFailure(call: Call<ArrayList<modeldata>>, t: Throwable) {
                    error_message.postValue(t.message)
                }
            })
    }
}
