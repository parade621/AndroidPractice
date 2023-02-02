/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lunchtray.data.DataSource
import java.text.NumberFormat
import java.util.*

class OrderViewModel : ViewModel() {

    // Map of menu items
    val menuItems = DataSource.menuItems

    // Default values for item prices
    private var previousEntreePrice = 0.0
    private var previousSidePrice = 0.0
    private var previousAccompanimentPrice = 0.0

    // Default tax rate
    private val taxRate = 0.08

    // Entree for the order
    // nullable
    private val _entree = MutableLiveData<MenuItem?>()
    val entree: LiveData<MenuItem?> = _entree

    // Side for the order
    // nullable
    private val _side = MutableLiveData<MenuItem?>()
    val side: LiveData<MenuItem?> = _side

    // Accompaniment for the order.
    // nullable
    private val _accompaniment = MutableLiveData<MenuItem?>()
    val accompaniment: LiveData<MenuItem?> = _accompaniment

    // Subtotal for the order
    private val _subtotal = MutableLiveData(0.0)
    val subtotal: LiveData<String> = Transformations.map(_subtotal) {
        NumberFormat.getCurrencyInstance(Locale.US).format(it)
    }

    // Total cost of the order
    private val _total = MutableLiveData(0.0)
    val total: LiveData<String> = Transformations.map(_total) {
        NumberFormat.getCurrencyInstance(Locale.US).format(it)
    }

    // Tax for the order
    private val _tax = MutableLiveData(0.0)
    val tax: LiveData<String> = Transformations.map(_tax) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    /**
     * Set the entree for the order.
     */
    fun setEntree(entree: String) {
        if (_entree.value != null ){
            previousEntreePrice = _entree.value!!.price
            _entree.value = menuItems[entree]
            updateSubtotal(-previousEntreePrice)
        }else{
            _entree.value = menuItems[entree]
        }
        updateSubtotal(_entree.value!!.price)
    }

    /**
     * Set the side for the order.
     */
    fun setSide(side: String) {
        if (_side.value != null){
            previousSidePrice = _side.value!!.price
            _side.value = menuItems[side]
            updateSubtotal(-previousSidePrice)
        }else{
            _side.value = menuItems[side]
        }
        updateSubtotal(_side.value!!.price)
    }

    /**
     * Set the accompaniment for the order.
     */
    fun setAccompaniment(accompaniment: String) {
        if (_accompaniment.value != null){
            previousAccompanimentPrice = _accompaniment.value!!.price
            _accompaniment.value = menuItems[accompaniment]
            updateSubtotal(-previousAccompanimentPrice)
        }else{
            _accompaniment.value = menuItems[accompaniment]
        }
        updateSubtotal(_accompaniment.value!!.price)
    }

    /**
     * Update subtotal value.
     */
    private fun updateSubtotal(itemPrice: Double) {
        var calculatedTotal = _subtotal.value!!
        if (_subtotal.value != null){
            calculatedTotal+=itemPrice
        }else{
            calculatedTotal = itemPrice
        }
        _subtotal.value = calculatedTotal
        calculateTaxAndTotal()
        Log.d("subTotal",_subtotal.value!!.toString())
    }

    /**
     * Calculate tax and update total.
     */
    fun calculateTaxAndTotal() {
        _tax.value = _subtotal.value!! * taxRate
        _total.value = _subtotal.value!! + _tax.value!!
    }

    /**
     * Reset all values pertaining to the order.
     */
    fun resetOrder() {
        previousEntreePrice = 0.0
        previousSidePrice= 0.0
        previousAccompanimentPrice= 0.0
        _entree.value=null
        _side.value=null
        _accompaniment.value=null
        _subtotal.value=0.0
        _tax.value=0.0
        _total.value=0.0
    }
}
