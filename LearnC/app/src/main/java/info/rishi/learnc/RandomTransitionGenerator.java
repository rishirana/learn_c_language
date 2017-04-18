package info.rishi.learnc;

/**
 * Created by PC on 4/16/2017.
 */

import android.graphics.RectF;
//import android.transition.Transition;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import info.rishi.learnc.Transition;

public class RandomTransitionGenerator implements info.rishi.learnc.TransitionGenerator  {

    public static final int DEFAULT_TRANSITION_DURATION = 10000;
    public static final float min_rect_fact = 0.75f;

    private final Random mrandom = new Random(System.currentTimeMillis());
    private long mtransitionDuration;
    private Interpolator mTransitionInterpolator;
    private Transition mLastGenTrans;
    private RectF mLastDrawableBounds;

    public RandomTransitionGenerator(){
        this(DEFAULT_TRANSITION_DURATION,new AccelerateDecelerateInterpolator());

    }
    public RandomTransitionGenerator(long transitionDuration,Interpolator transitionInterpolator){

        setTransitionDuration(transitionDuration);
        setTransitionInterpolator(transitionInterpolator);
    }

    public Transition generateNextTransition(RectF drawableBounds,RectF viewPort){
        boolean firstTransition = mLastGenTrans == null;
        boolean drawableBoundsChange = true;
        boolean viewPortRatioChange = true;

        RectF srcRect = null;
        RectF dstRect = null;

        if(!firstTransition){
            dstRect = mLastGenTrans.getDestinyRect();
            drawableBoundsChange = !drawableBounds.equals(mLastDrawableBounds);
            viewPortRatioChange = !MathUtils.haveSameAspectRatio(dstRect,viewPort);

        }

        if(dstRect==null ||drawableBoundsChange||viewPortRatioChange){
            srcRect = generateRandomRect(drawableBounds,viewPort);
        }
        else {
            srcRect = dstRect;
        }

        dstRect = generateRandomRect(drawableBounds,viewPort);
        mLastGenTrans = new Transition(srcRect,dstRect,mtransitionDuration,mTransitionInterpolator);
        mLastDrawableBounds = drawableBounds;
        return mLastGenTrans;


    }

    private RectF generateRandomRect(RectF drawableBounds , RectF viewportRect){
        float  drawableRatio = MathUtils.getRectRatio(drawableBounds);
        float viewPortRectRatio = MathUtils.getRectRatio(viewportRect);
        RectF maxCrop;

        if (drawableRatio > viewPortRectRatio){
            float r = (drawableBounds.height()/viewportRect.height())*viewportRect.width();
            float b = drawableBounds.height();

            maxCrop = new RectF(0,0,r,b);
        }
        else{
            float r = drawableBounds.width();
            float b = (drawableBounds.width()/viewportRect.width())*viewportRect.height();
            maxCrop = new RectF(0,0,r,b);

        }

        float randomFloat = MathUtils.truncate(mrandom.nextFloat(),2);
        float factor = min_rect_fact + ((1-min_rect_fact)*randomFloat);
        float width =  factor*maxCrop.width();
        float height = factor*maxCrop.height();
        int widthdiff = (int)(drawableBounds.width()-width);
        int heightdiff = (int)(drawableBounds.height()-height);
        int left = widthdiff >0 ? mrandom.nextInt(widthdiff):0;
        int top = heightdiff  > 0 ? mrandom.nextInt(heightdiff) : 0;

        return new RectF(left, top , left+width,top+height);
    }

    public void setTransitionDuration(long transitionDuration){
        mtransitionDuration = transitionDuration;
    }

    public void setTransitionInterpolator(Interpolator interpolator){
        mTransitionInterpolator = interpolator;
    }

}
