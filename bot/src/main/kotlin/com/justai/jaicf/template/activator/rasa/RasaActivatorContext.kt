package com.justai.jaicf.template.activator.rasa

import com.justai.jaicf.activator.intent.IntentActivatorContext
import com.justai.jaicf.template.activator.rasa.api.Entity
import com.justai.jaicf.template.activator.rasa.api.Intent
import com.justai.jaicf.context.ActivatorContext

data class RasaActivatorContext(
    val text: String,
    private val rasaIntent: Intent,
    private val entities: List<Entity>
): IntentActivatorContext(
    confidence = rasaIntent.confidence,
    intent = rasaIntent.name
) {
    val slots = entities.associateBy { it.entity }
}

val ActivatorContext.rasa
    get() = this as? RasaActivatorContext