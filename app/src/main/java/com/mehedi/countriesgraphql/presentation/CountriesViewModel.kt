package com.mehedi.countriesgraphql.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.countriesgraphql.domain.DetailCountry
import com.mehedi.countriesgraphql.domain.GetCountriesUseCase
import com.mehedi.countriesgraphql.domain.GetCountryUseCase
import com.mehedi.countriesgraphql.domain.SimpleCountry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CountriesState())
    val state = _state

    init {
        viewModelScope.launch {

            _state.update {
                it.copy(isLoading = true)
            }

            _state.update {
                it.copy(
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }

    }

    fun selectCountry(code: String) {
        viewModelScope.launch {

            _state.update {
                it.copy(
                    selectedCountry = getCountryUseCase.execute(code)
                )
            }


        }


    }

    fun dismissCountryDialog() {
        _state.update {

            it.copy(
                selectedCountry = null
            )
        }
    }

    data class CountriesState(
        val countries: List<SimpleCountry> = emptyList(),
        val isLoading: Boolean = false,
        val selectedCountry: DetailCountry? = null
    )


}