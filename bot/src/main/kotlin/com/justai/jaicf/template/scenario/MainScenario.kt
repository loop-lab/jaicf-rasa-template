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
            reactions.sayRandom("Привет!", "Дороу!", "Поехали!")
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