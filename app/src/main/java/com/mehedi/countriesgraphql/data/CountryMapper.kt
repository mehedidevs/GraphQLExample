package com.mehedi.countriesgraphql.data

import com.mehedi.countriesgraphql.CountriesQuery
import com.mehedi.countriesgraphql.CountryQuery
import com.mehedi.countriesgraphql.domain.DetailCountry
import com.mehedi.countriesgraphql.domain.SimpleCountry

fun CountryQuery.Country.toDetailCountry(): DetailCountry {
    return DetailCountry(
        name = this.name,
        code = this.code,
        emoji = this.emoji,
        capital = this.capital,
        currencies = this.currencies,
        languages = this.languages.map {
            it.name
        },
        continent = this.continent.name,


        )


}


fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        name = this.name,
        code = this.code,
        emoji = this.emoji,
        capital = this.capital,
    )


}