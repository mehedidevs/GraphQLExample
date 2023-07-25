package com.mehedi.countriesgraphql.domain

import com.mehedi.countriesgraphql.CountryQuery

interface CountryClient {

    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code:String): DetailCountry?

}