package com.mehedi.countriesgraphql.data

import com.mehedi.countriesgraphql.CountryQuery


data class SimpleCountry (
    public val name: String,
    public val code: String,
    public val capital: String?,
    public val emoji: String,


    )