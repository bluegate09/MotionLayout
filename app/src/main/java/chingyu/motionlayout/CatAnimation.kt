package chingyu.motionlayout

import android.util.Log
import android.widget.ImageView

class CatAnimation(activity: MainActivity): Animation {

    private val catImage = activity.findViewById<ImageView>(R.id.cat)

    override fun execute(vector: Float){
        when {
            vector > 0 -> {
                runTowardRight()
            }
            vector < 0 -> {
                runTowardLeft()
            }
            else -> {
                idle()
            }
        }
    }

    override fun runTowardLeft() {
        catImage.setImageResource(R.drawable.cat_run_left_1)
    }

    override fun runTowardRight() {
        catImage.setImageResource(R.drawable.cat_run_right_1)
    }

    override fun idle() {
        catImage.setImageResource(R.drawable.cat_sit)
    }
}