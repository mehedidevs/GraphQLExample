package com.mehedi.countriesgraphql.data

import com.apollographql.apollo3.ApolloClient
import com.mehedi.countriesgraphql.CountriesQuery
import com.mehedi.countriesgraphql.CountryQuery
import com.mehedi.countriesgraphql.domain.CountryClient
import com.mehedi.countriesgraphql.domain.DetailCountry
import com.mehedi.countriesgraphql.domain.SimpleCountry


class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {


        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map {
                it.toSimpleCountry()
            } ?: emptyList()


    }

    override suspend fun getCountry(code: String): DetailCountry? {

        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailCountry()

    }
}