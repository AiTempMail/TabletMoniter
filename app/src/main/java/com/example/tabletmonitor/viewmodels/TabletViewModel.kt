package com.example.tabletmonitor.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tabletmonitor.database.Tablet
import com.example.tabletmonitor.database.TabletDatabase
import kotlinx.coroutines.launch

class TabletViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = TabletDatabase.getDatabase(application).tabletDao()
    val allTablets: LiveData<List<Tablet>> = dao.getAllTablets().asLiveData()

    private val _searchResults = MutableLiveData<List<Tablet>>()
    val searchResults: LiveData<List<Tablet>> = _searchResults

    fun addTablet(tablet: Tablet) = viewModelScope.launch {
        dao.insert(tablet)
    }

    fun updateTablet(tablet: Tablet) = viewModelScope.launch {
        dao.update(tablet)
    }

    fun deleteTablet(tablet: Tablet) = viewModelScope.launch {
        dao.delete(tablet.id) // Pass the tablet ID instead of the entire object
    }
}