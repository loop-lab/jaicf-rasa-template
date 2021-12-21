package com.justai.jaicf.template.scenario

import com.justai.jaicf.builder.Scenario

val MainScenario = Scenario {
    state("main") {
        activators {
            intent("hello")
            regex("/start")
        }

        action {
            reactions.run {
                sayRandom("Hi there!", "Hello!", "Good day!")
            }
        }
    }

    state("bye") {
        activators {
            intent("goodbye")
        }

        action {
            reactions.sayRandom("Bye bye!", "See you latter!")
        }
    }

    fallback {
        reactions.run {
            sayRandom("Sorry, I didn't get that...", "Looks like it's something new for me...")
            say("Could you repeat please?")
        }
    }
}