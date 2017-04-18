package info.rishi.learnc;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * Created by PC on 4/1/2017.
 */

public class KenBurnsView extends ImageView {

    private static final long FRAME_DELAY =1000/60;
    private  final Matrix matrix = new Matrix();
    private TransitionGenerator mTransGen = new RandomTransitionGenerator();
    private TransitionListener mTransitionListener;
    private Transition mCurrTrans;
    private final RectF mViewPortRect = new RectF();
    private RectF mDrawbleRectF;
    private long mElapsedTime;
    private long mlastFrameTime;
    private boolean mpaused;
    private boolean mInitialized;


    public KenBurnsView(Context context) {
        this(context,null);
    }
    public KenBurnsView(Context context,AttributeSet attributeSet){
        this(context,attributeSet,0);

    }
    public KenBurnsView(Context context , AttributeSet attributeSet,int def){
        super(context,attributeSet,def);
        mInitialized=true;
        super.setScaleType(ScaleType.MATRIX);
    }

    public void setScaleType(ScaleType scaleType){

    }

    public void setVisibility(int visibility){
        super.setVisibility(visibility);
        switch (visibility){
            case VISIBLE:
                resume();
                break;
            default:
                pause();
                break;
        }
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        handleImageChange();
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        handleImageChange();
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        handleImageChange();
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        handleImageChange();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        restart();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable d  =  getDrawable();
        if(!mpaused&&d!=null){
            if(mDrawbleRectF.isEmpty()){
                updateDrawableBounds();
            }
            else if (hasBounds()){
                if (mCurrTrans==null){
                    startNewTransition();
                }

              if(mCurrTrans.getDestinyRect()!= null){
                  mElapsedTime += System.currentTimeMillis()-mlastFrameTime;
                  RectF currentRect = mCurrTrans.getInterpolatedRect(mElapsedTime);

                  float widthScale = mDrawbleRectF.width()/currentRect.width();
                  float heightScale = mDrawbleRectF.height()/currentRect.height();
                  float currentRectToDrwScale = Math.min(widthScale,heightScale);
                  float currentRectToVpScale = mViewPortRect.width()/currentRect.width();
                  float totalScale = currentRectToDrwScale*currentRectToVpScale;
                  float translx = totalScale*(mDrawbleRectF.centerX()-currentRect.left);
                  float transly = totalScale*(mDrawbleRectF.centerY()-currentRect.top);

                  matrix.reset();
                  matrix.postTranslate(-mDrawbleRectF.width()/2,-mDrawbleRectF.height()/2);
                  matrix.postScale(totalScale,totalScale);
                  matrix.postTranslate(translx,transly);

                  setImageMatrix(matrix);

                  if(mElapsedTime>=mCurrTrans.getDuration()){
                          fireTransitionEnd(mCurrTrans);
                      startNewTransition();
                  }
              }else{
                  fireTransitionEnd(mCurrTrans);
              }
            }
            mlastFrameTime  = System.currentTimeMillis();
            postInvalidateDelayed(FRAME_DELAY);
        }
        super.onDraw(canvas);
    }

    //start new transition
    private void startNewTransition(){
        if (!hasBounds()){
            throw new UnsupportedOperationException("can;t start the transition");

        }
        mCurrTrans = mTransGen.generateNextTransition(mDrawbleRectF,mViewPortRect);
        mElapsedTime = 0;
        mlastFrameTime = System.currentTimeMillis();
        fireTransitionStart(mCurrTrans);

    }

    //create new transition
    public void restart(){
        int width = getWidth();
        int height = getHeight();
        if(width==0||height==0){
            throw new UnsupportedOperationException("can't restart when view area is zero");

        }
        updateViewport(width,height);
        updateDrawableBounds();
        if(hasBounds()){
            startNewTransition();
        }
    }

    //check view has bound or not
    private boolean hasBounds(){
        return !mViewPortRect.isEmpty();
    }

    private void fireTransitionStart(Transition transition){
         if (mTransitionListener!=null&&transition!=null){
             mTransitionListener.onTransitionStart(transition);
         }
    }

    private void fireTransitionEnd(Transition transition){
        if(mTransitionListener!=null&&transition!=null){
            mTransitionListener.onTransitionEnd(transition);
        }

    }

    public void setTransitionGenerator(TransitionGenerator transgen){
        mTransGen = transgen;
        if(hasBounds()){
            startNewTransition();
        }

    }

    private void updateViewport(float width, float height){
        mViewPortRect.set(0,0,width,height);
    }

    private void updateDrawableBounds(){
        if(mDrawbleRectF==null){
            mDrawbleRectF = new RectF();
        }
        Drawable d = getDrawable();
        if(d!=null){
            mDrawbleRectF.set(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
        }
    }

    private void handleImageChange(){
        updateDrawableBounds();
        if(mInitialized&&hasBounds()){
            startNewTransition();
        }
    }

    public void setmTransitionListener(TransitionListener transitionListener){
        mTransitionListener = transitionListener;
    }

    public void pause(){
        mpaused = true;
    }

    public void resume(){
        mpaused = false;
        mlastFrameTime = System.currentTimeMillis();
        invalidate();
    }

    public interface TransitionListener{
        public void onTransitionStart(Transition transition);

        public void onTransitionEnd(Transition transition);
    }




}
