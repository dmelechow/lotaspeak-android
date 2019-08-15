package com.lotaspeak.speak.data.model

import com.lotaspeak.speak.data.model.base.Language
import com.lotaspeak.speak.data.model.base.Level
import com.lotaspeak.speak.view.threads.ThreadsAdapter
import java.io.Serializable
import java.util.*

class Thread : ThreadsAdapter.ThreadItemAdapter, Serializable {

    var title: String? = null

    var date: Date? = null

    var author: User? = null

    var level: Level? = null

    var language: Language? = null

    var numberSeats: String? = null

    var members: List<User>? = null

}