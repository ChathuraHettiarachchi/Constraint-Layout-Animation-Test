package com.chootdev.sample

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintSet
import android.transition.AutoTransition
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAnimations()
    }

    private fun setupAnimations() {
        askSize.setOnClickListener {
            updateConstraints(R.layout.activity_main_end)
            askSize.setText("ADD TO CART - 1234 INR")
        }

        close.setOnClickListener {
            updateConstraints(R.layout.activity_main)
            askSize.setText("SELECT SIZE")
        }
    }


    fun updateConstraints(@LayoutRes id: Int) {
        val newConstraintSet = ConstraintSet()
        newConstraintSet.clone(this, id)
        newConstraintSet.applyTo(root)

        val transition = AutoTransition()
        transition.duration = 700
        transition.interpolator = OvershootInterpolator()
        TransitionManager.beginDelayedTransition(root, transition)
    }
}
