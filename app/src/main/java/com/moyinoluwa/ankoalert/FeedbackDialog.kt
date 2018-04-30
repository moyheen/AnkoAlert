package com.moyinoluwa.ankoalert

import android.content.DialogInterface
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.Gravity
import android.view.View
import android.view.ViewManager
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.alert
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.customView
import org.jetbrains.anko.dip
import org.jetbrains.anko.horizontalGravity
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.padding
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView
import org.jetbrains.anko.topPadding
import org.jetbrains.anko.verticalLayout

private const val ACTIVITY_PADDING = 16

class FeedbackDialog(ui: AnkoContext<View>) {

    lateinit var dialog: DialogInterface
    lateinit var feedbackText: TextInputEditText
    lateinit var cancelButton: TextView
    lateinit var okButton: TextView

    init {
        with(ui) {
            dialog = alert {

                customView {
                    verticalLayout {
                        padding = dip(ACTIVITY_PADDING)

                        textView(R.string.some_title) {
                            textSize = 24f
                            textColor = context.getColor(R.color.black)
                        }.lparams {
                            bottomMargin = dip(ACTIVITY_PADDING)
                        }

                        textView(R.string.some_message).lparams {
                            bottomMargin = dip(ACTIVITY_PADDING)
                        }

                        textInputLayout {
                            hint = context.getString(R.string.hint)
                            feedbackText = textInputEditText {
                                textSize = 16f
                            }
                        }

                        linearLayout {
                            topPadding = dip(24)
                            orientation = LinearLayout.HORIZONTAL
                            horizontalGravity = Gravity.END

                            cancelButton = textView(R.string.cancel_label) {
                                textSize = 14f
                                textColor = context.getColor(R.color.colorAccent)
                            }.lparams {
                                marginEnd = dip(ACTIVITY_PADDING)
                            }

                            okButton = textView(R.string.submit) {
                                textSize = 14f
                                textColor = context.getColor(R.color.colorAccent)
                            }
                        }
                    }
                }
            }.show()
        }
    }
}

inline fun ViewManager.textInputEditText(theme: Int = 0, init: TextInputEditText.() -> Unit) =
        ankoView({ TextInputEditText(it) }, theme, init)
inline fun ViewManager.textInputLayout(theme: Int = 0, init: TextInputLayout.() -> Unit) =
        ankoView({ TextInputLayout(it) }, theme, init)