package com.mehedi.countriesgraphql.domain

import com.mehedi.countriesgraphql.CountryQuery


data class SimpleCountry (
     val name: String,
     val code: String,
     val capital: String?,
     val emoji: String,


    )