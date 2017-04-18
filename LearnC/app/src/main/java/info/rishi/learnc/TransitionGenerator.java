package info.rishi.learnc;

/**
 * Created by PC on 4/16/2017.
 */

import android.graphics.RectF;
import android.transition.*;

public interface TransitionGenerator {

    public Transition generateNextTransition(RectF drawableBounds,RectF viewPorts);
}
