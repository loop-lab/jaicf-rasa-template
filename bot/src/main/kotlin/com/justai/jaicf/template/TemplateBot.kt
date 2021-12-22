package com.justai.jaicf.template

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.template.scenario.MainScenario
import com.justai.jaicf.activator.catchall.CatchAllActivator
import com.justai.jaicf.context.manager.InMemoryBotContextManager
import com.justai.jaicf.template.activator.rasa.RasaIntentActivator
import com.justai.jaicf.template.activator.rasa.api.RasaApi

private val rasaApi = RasaApi("http://0.0.0.0:5005")
private val contextManager = InMemoryBotContextManager

val templateBot = BotEngine(
    scenario = MainScenario,
    defaultContextManager = contextManager,
    activators = arrayOf(
        RegexActivator,
        RasaIntentActivator.Factory(rasaApi),
        CatchAllActivator
    )
)