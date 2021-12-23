package com.justai.jaicf.template.channel

import com.justai.jaicf.template.templateBot
import com.justai.jaicf.channel.telegram.TelegramChannel

fun main() {
    TelegramChannel(templateBot, "token").run()
}