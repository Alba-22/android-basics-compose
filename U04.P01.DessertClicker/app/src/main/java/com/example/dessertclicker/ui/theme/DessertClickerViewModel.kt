package com.example.dessertclicker.ui.theme

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(DessertClickerState())
    val uiState: StateFlow<DessertClickerState> = _uiState.asStateFlow()

    private val _allDesserts: List<Dessert> = Datasource.dessertList

    init {
        _uiState.update {
            it.copy(
                currentDessertImageId = _allDesserts[0].imageId,
                currentDessertPrice = _allDesserts[0].price,
            )
        }
    }

    fun onDessertClicked() {
        // Update the revenue
        _uiState.update {
            val dessertToShow = determineDessertToShow(
                _allDesserts,
                it.dessertsSold
            )
            it.copy(
                revenue = it.revenue + it.currentDessertPrice,
                dessertsSold = it.dessertsSold.inc(),
                currentDessertImageId = dessertToShow.imageId,
                currentDessertPrice = dessertToShow.price,
            )
        }
    }

    /**
     * Determine which dessert to show.
     */
    private fun determineDessertToShow(
        desserts: List<Dessert>,
        dessertsSold: Int
    ): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShow
    }
}
