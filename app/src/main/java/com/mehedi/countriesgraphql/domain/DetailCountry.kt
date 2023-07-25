package com.mehedi.countriesgraphql.domain


data class DetailCountry(
    val name: String,
    val code: String,
    val capital: String?,
    val emoji: String,
    val currencies: List<String>,
    val languages: List<String>,
    val continent: String,


    )