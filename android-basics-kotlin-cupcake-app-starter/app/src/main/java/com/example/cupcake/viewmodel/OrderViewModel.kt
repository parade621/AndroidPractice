package com.example.cupcake.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel:ViewModel() {

    val dateOptions = getPickOptions()

    private var _quantity = MutableLiveData<Int>(0)
    val quantity:LiveData<Int> = _quantity

    private var _flavor= MutableLiveData<String>("")
    val flavor: LiveData<String> = _flavor

    private var _date = MutableLiveData<String>("")
    val date:LiveData<String> = _date

    private var _price = MutableLiveData<Double>(0.0)
    val price get()=_price

    fun setQuantity(numberCupcakes: Int){
        _quantity.value = numberCupcakes
    }

    fun setFlavor(desiredFlavor: String){
        _flavor.value = desiredFlavor
    }

    fun setDate(pickupDate: String){
        _date.value = pickupDate
    }

    fun hasNoFlavorSet():Boolean{
        return _flavor.value.isNullOrEmpty()
    }

    private fun getPickOptions(): List<String>{
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4){
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE,1)
        }
        return options
    }
}