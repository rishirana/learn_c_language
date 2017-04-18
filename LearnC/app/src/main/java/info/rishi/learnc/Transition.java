package info.rishi.learnc;

/**
 * Created by PC on 4/16/2017.
 */

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.Interpolator;
public class Transition  {

    private RectF mSrcRect;
    private RectF mDstRect;
    private final RectF mCurrentRect = new RectF();
    private float mWidthDiff;
    private float mHeightDiff;
    private float mCenterXDiff;
    private float mCenterYDiff;
    private long mDuration;
    private Interpolator mInterpolator;

    public Transition(RectF srcRect,RectF dstRect ,long Duration , Interpolator interpolator){
        if(!MathUtils.haveSameAspectRatio(srcRect,dstRect)){
            throw new info.rishi.learnc.IncompatibleRatioException();
        }
        mSrcRect = srcRect;
        mDstRect = dstRect;
        mDuration = Duration;
        mInterpolator = interpolator;

        mWidthDiff = dstRect.width()-srcRect.width();
        mHeightDiff = dstRect.height()-srcRect.height();
        mCenterXDiff = dstRect.centerX()-srcRect.centerX();
        mCenterYDiff = dstRect.centerY()-srcRect.centerY();

    }

    public RectF getSourceRect(){
        return mSrcRect;
    }
    public RectF getDestinyRect(){
        return mDstRect;
    }
    public RectF getInterpolatedRect(long elapsedTime){
        float elapsedTimeFraction = elapsedTime/(float)mDuration;
        float interpolationProgress = Math.min(elapsedTimeFraction,1);
        float interpolation = mInterpolator.getInterpolation(interpolationProgress);
        float mCurrentWidth = mSrcRect.width() + (interpolation*mWidthDiff);
        float mCurrentHeight = mSrcRect.height() + (interpolation*mHeightDiff);

        float mCurrentCenterX = mSrcRect.centerX() + (interpolation*mCenterXDiff);
        float mCurrentCenterY = mSrcRect.centerY() +(interpolation*mCenterYDiff);

        float left  = mCurrentCenterX - (mCurrentWidth/2);
        float top =  mCurrentCenterY - (mCurrentHeight/2);
        float right = left + mCurrentWidth;
        float bottom = top + mCurrentHeight;

        mCurrentRect.set(left,top,right,bottom);

        return mCurrentRect;

    }

    public long getDuration(){
        return mDuration;
    }

}
