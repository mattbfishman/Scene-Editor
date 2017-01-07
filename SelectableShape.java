import java.awt.*;
import java.awt.geom.*;

/**
   A shape that manages its selection state.
*/
public abstract class SelectableShape implements SceneShape {
	private boolean selected;
	
   public void setSelected(boolean b) {
      selected = b;
   }

   public boolean isSelected() {
      return selected;
   }
}
