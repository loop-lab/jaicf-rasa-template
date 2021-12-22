package com.justai.jaicf.template.activator.rasa.api

import kotlinx.serialization.Serializable

@Serializable
data class RasaParseMessageRequest(
    val text: String
)