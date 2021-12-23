package com.justai.jaicf.template.scenario

import com.justai.jaicf.builder.Scenario
import com.justai.jaicf.template.activator.rasa.rasa

val MainScenario = Scenario {
    state("hello") {
        activators {
            intent("hello")
            regex("/start")
        }

        action {
            reactions.sayRandom("Привет!", "Дороу!", "Погнали!")
        }
    }

    state("myName") {
        activators {
            intent("myName")
        }

        action {
            val name = activator.rasa?.slots?.get("name")
            println(name.toString())
            if (name !== null)
                reactions.say("Тебя зовут ${name.value}")
            else
                reactions.say("Повтори, пожалуйста, как тебя зовут?")
        }
    }

    state("jock") {
        activators {
            intent("jock")
        }

        action {
            reactions.say("Я на сам деле программист в рабстве")
        }
    }

    state("goodbye") {
        activators {
            intent("goodbye")
        }

        action {
            reactions.sayRandom("Пока!", "Покеда!")
        }
    }

    fallback {
        reactions.run {

            sayRandom("Я тебя не понимаю =(", "Че? =/")
            say("Повтори, что ты сказал?")
        }
    }
}