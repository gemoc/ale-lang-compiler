package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.BlockAspectBlockAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Block;

@SuppressWarnings("all")
public class BlockAspectBlockAspectContext {
  public final static BlockAspectBlockAspectContext INSTANCE = new BlockAspectBlockAspectContext();
  
  public static BlockAspectBlockAspectProperties getSelf(final Block _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.BlockAspectBlockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Block, BlockAspectBlockAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Block, org.tetrabox.minijava.xminijava.aspects.BlockAspectBlockAspectProperties>();
  
  public Map<Block, BlockAspectBlockAspectProperties> getMap() {
    return map;
  }
}
