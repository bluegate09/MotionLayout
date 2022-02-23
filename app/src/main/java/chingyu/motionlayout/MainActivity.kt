package chingyu.motionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.text.DecimalFormat
import java.text.NumberFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mL = findViewById<MotionLayout>(R.id.motionLayout)
        val catAnimation = CatAnimation(this)


        mL.addTransitionListener(object: MotionLayout.TransitionListener{

            private var vector = 0.0f
            private var prevProgress = 0.0f

            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {}

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                vector = progress - prevProgress
                catAnimation.execute(vector)
                prevProgress = progress
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                catAnimation.execute(0.0f)
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {}

        })



    }
}