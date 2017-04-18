package info.rishi.learnc;

/**
 * Created by loverishi on 4/1/2017.
 */

public class IncompatibleRatioException extends RuntimeException {
     private static final long serialVersionId =    234608108593115395L;
    public IncompatibleRatioException() {
        super("Can't perform Ken Burns effect on rects with distinct aspect ratios!");
    }

}
