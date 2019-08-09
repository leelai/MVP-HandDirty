package com.mobotechnology.bipinpandey.mvp_hand_dirty.main_activity.model

/**
 * Created by bpn on 11/30/17.
 */

class User {

    var fullName = ""
    var email = ""

    constructor() {}

    constructor(fullName: String, email: String) {
        this.fullName = fullName
        this.email = email
    }

    override fun toString(): String {
        return "Email : $email\nFullName : $fullName"
    }
}
