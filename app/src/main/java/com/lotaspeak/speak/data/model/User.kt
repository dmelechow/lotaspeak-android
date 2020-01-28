package com.lotaspeak.speak.data.model

import com.lotaspeak.speak.data.model.base.Language
import com.lotaspeak.speak.data.model.base.Level
import java.io.Serializable

class User : Serializable{
    var hobby: String? = null

    var googleID: String? = null

    var email: String? = null

    var firstName: String? = null

    var lastName: String? = null

    var image: String? = null

    var bio: String? = null

    var username: String? = null

}

class Languages {
    var language: Language? = null

    var level: Level? = null
}