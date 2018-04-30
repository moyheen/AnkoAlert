package com.moyinoluwa.ankoalert

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.contentView
import org.jetbrains.anko.ctx
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun displayFeedbackDialog(view: View) {
        val feedbackDialogUi by lazy {
            contentView?.let {
                FeedbackDialog(AnkoContext.create(ctx, it))
            }
        }

        feedbackDialogUi?.okButton?.setOnClickListener {
            val feedback = feedbackDialogUi.feedbackText.text.toString()
            toast(getString(R.string.confirmation, feedback))

            feedbackDialogUi.dialog.dismiss()
        }

        feedbackDialogUi?.cancelButton?.setOnClickListener {
            feedbackDialogUi.dialog.dismiss()
        }
    }
}