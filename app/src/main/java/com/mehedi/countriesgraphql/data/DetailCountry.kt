package com.mehedi.countriesgraphql.data

import com.mehedi.countriesgraphql.CountryQuery


data class DetailCountry (
    public val name: String,
    public val code: String,
    public val capital: String?,
    public val emoji: String,
    public val currencies: List<String>,
    public val languages: List<CountryQuery.Language>,
    public val continent: CountryQuery.Continent,


    )