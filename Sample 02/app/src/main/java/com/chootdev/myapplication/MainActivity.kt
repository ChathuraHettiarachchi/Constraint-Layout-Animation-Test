package com.chootdev.myapplication

import android.animation.TimeInterpolator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.AutoTransition
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var show = false

        backgroundImage.setOnClickListener {
            show = if(show){
                hideComponents()

                false
            } else {
                showComponents()

                true
            }
        }
    }

    private fun showComponents(){
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_main_end)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f) as TimeInterpolator?
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(root, transition)

        constraintSet.applyTo(root)
    }

    private fun hideComponents(){
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_main)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(root, transition)

        constraintSet.applyTo(root)
    }
}
