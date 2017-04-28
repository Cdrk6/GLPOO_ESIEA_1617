package fr.esiea1617.glpoo.domain;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.collect.Lists;

import fr.esiea1617.glpoo.App;

public class ExtraFunctions {

	public static void SlayChild (Map map, int x, int y) {
		Child curChild = null;
		boolean modif = false;

		Iterator<Child> childrenIt = map.getChildren().iterator();
		while (childrenIt.hasNext() && !modif) {
			curChild = childrenIt.next();
			if (curChild.getX() == x && curChild.getY() == y) {
				childrenIt.remove();
				modif = true;
			}
		}

		if (modif)
			map.setChildren(Lists.newArrayList(childrenIt));
	}

	
	public static void Accelerate2x () {
		App.setMovingTime(App.getMovingTime()/2);
	}
	
	public static void Pause_Resume (AtomicLong base_time, AtomicLong intermediate_time) {
		
	}

}
