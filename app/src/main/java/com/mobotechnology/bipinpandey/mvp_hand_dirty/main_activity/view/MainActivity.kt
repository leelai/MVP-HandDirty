package com.mobotechnology.bipinpandey.mvp_hand_dirty.main_activity.view

import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView

import com.mobotechnology.bipinpandey.mvp_hand_dirty.R
import com.mobotechnology.bipinpandey.mvp_hand_dirty.main_activity.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    private var presenter: MainActivityPresenter? = null
    private var myTextView: TextView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        presenter = MainActivityPresenter(this)

        myTextView = findViewById(R.id.myTextView)
        val userName = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        initProgressBar()


        userName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                presenter!!.updateFullName(s.toString())
            }

            override fun afterTextChanged(s: Editable) {
                hideProgressBar()
            }
        })

        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                presenter!!.updateEmail(s.toString())
            }

            override fun afterTextChanged(s: Editable) {
                hideProgressBar()
            }
        })

    }

    private fun initProgressBar() {
        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleSmall)
        progressBar!!.isIndeterminate = true
        val params = RelativeLayout.LayoutParams(Resources.getSystem().displayMetrics.widthPixels,
                250)
        params.addRule(RelativeLayout.CENTER_IN_PARENT)
        this.addContentView(progressBar, params)
        showProgressBar()
    }

    override fun updateUserInfoTextView(info: String) {
        myTextView!!.text = info
    }

    override fun showProgressBar() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar!!.visibility = View.INVISIBLE
    }
}
