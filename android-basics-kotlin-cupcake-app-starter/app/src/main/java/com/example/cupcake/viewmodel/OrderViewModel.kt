package com.example.cupcake.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.cupcake.utils.utils
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


class OrderViewModel:ViewModel() {

    val dateOptions = getPickOptions()

    private var _quantity = MutableLiveData<Int>()
    val quantity:LiveData<Int> = _quantity

    private var _flavor= MutableLiveData<String>()
    val flavor: LiveData<String> = _flavor

    private var _date = MutableLiveData<String>()
    val date:LiveData<String> = _date

    private var _price = MutableLiveData<Double>()
    val price:LiveData<String> = Transformations.map(_price){ price->
        NumberFormat.getCurrencyInstance().format(price)
    }

    init{
        resetOrder()
    }

    fun resetOrder(){
        _quantity.value=0
        _flavor.value=""
        _date.value=dateOptions[0]
        _price.value=0.0
    }

    fun setQuantity(numberCupcakes: Int){
        _quantity.value = numberCupcakes
        updatePrice()
    }

    fun setFlavor(desiredFlavor: String){
        _flavor.value = desiredFlavor
    }

    fun setDate(pickupDate: String){
        _date.value = pickupDate
        updatePrice()
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

    private fun updatePrice(){
        var calculatedPrice = (quantity.value?:0) * utils.PRICE_PER_CUPCAKE
        if (dateOptions[0] == _date.value){
            calculatedPrice += utils.PRICE_FOR_SAME_DAY_PICKUP
        }
        _price.value = calculatedPrice
    }

}