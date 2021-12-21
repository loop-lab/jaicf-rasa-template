package com.justai.jaicf.template

import com.justai.jaicf.BotEngine
import com.mongodb.client.MongoClients
import com.justai.jaicf.activator.rasa.api.RasaApi
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.template.scenario.MainScenario
import com.justai.jaicf.activator.rasa.RasaIntentActivator
import com.justai.jaicf.activator.catchall.CatchAllActivator
import com.justai.jaicf.context.manager.mongo.MongoBotContextManager

private val rasaApi = RasaApi("http://localhost:5005")
private val clientMongo = MongoClients.create("mongodb+srv://admin:admin@cluster0.npvsz.mongodb.net/myFirstDatabase?retryWrites=true&w=majority")
private val contextManager = MongoBotContextManager(clientMongo.getDatabase("jaicf").getCollection("contexts"))

val templateBot = BotEngine(
    scenario = MainScenario,
    defaultContextManager = contextManager,
    activators = arrayOf(
        RegexActivator,
        RasaIntentActivator.Factory(rasaApi),
        CatchAllActivator
    )
)