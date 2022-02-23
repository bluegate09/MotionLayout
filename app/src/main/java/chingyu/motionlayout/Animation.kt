package chingyu.motionlayout

interface Animation {

    fun execute(vector: Float)
    fun runTowardLeft()
    fun runTowardRight()
    fun idle()
}