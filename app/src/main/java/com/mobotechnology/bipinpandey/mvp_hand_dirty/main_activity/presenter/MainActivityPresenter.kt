package com.mobotechnology.bipinpandey.mvp_hand_dirty.main_activity.presenter

import com.mobotechnology.bipinpandey.mvp_hand_dirty.main_activity.model.User

/**
 * Created by bpn on 11/30/17.
 *
 * 0. In MVP the presenter assumes the functionality of the "middle-man". All presentation logic is pushed to the presenter.
 * 1. Listens to user action and model updates
 * 2. Updates model and view
 */

class MainActivityPresenter(private val view: View) {

    private val user: User

    init {
        this.user = User()
    }

    fun updateFullName(fullName: String) {
        user.fullName = fullName
        view.updateUserInfoTextView(user.toString())

    }

    fun updateEmail(email: String) {
        user.email = email
        view.updateUserInfoTextView(user.toString())

    }

    interface View {

        fun updateUserInfoTextView(info: String)
        fun showProgressBar()
        fun hideProgressBar()

    }
}
