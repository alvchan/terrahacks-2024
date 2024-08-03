import java.util.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class IceCap extends JFrame{
	private Vec2[] points = {
		new Vec2(19, 71),
		new Vec2(48, 101),
		new Vec2(78, 120),
		new Vec2(114, 110),
		new Vec2(124, 91),
		new Vec2(125, 68),
		new Vec2(141, 48),
		new Vec2(174, 25),
		new Vec2(214, 28),
		new Vec2(248, 42),
		new Vec2(278, 52),
		new Vec2(306, 60),
		new Vec2(321, 82),
		new Vec2(328, 105),
		new Vec2(324, 130),
		new Vec2(342, 148),
		new Vec2(347, 176),
		new Vec2(350, 210),
		new Vec2(340, 230),
		new Vec2(323, 262),
		new Vec2(309, 283),
		new Vec2(285, 304),
		new Vec2(251, 310),
		new Vec2(209, 312),
		new Vec2(196, 301),
		new Vec2(204, 282),
		new Vec2(204, 264),
		new Vec2(190, 266),
		new Vec2(168, 258),
		new Vec2(150, 255),
		new Vec2(139, 262),
		new Vec2(109, 264),
		new Vec2(86, 244),
		new Vec2(77, 249),
		new Vec2(70, 223),
		new Vec2(64, 201),
		new Vec2(50, 201),
		new Vec2(44, 179),
		new Vec2(50, 147),
		new Vec2(59, 137),
		new Vec2(40, 141),
		new Vec2(34, 131),
		new Vec2(35, 114),
		new Vec2(24, 110),
		new Vec2(16, 95),
	};

	public boolean isInside(Vec2 point) {
		// TODO: fill this out
		;
	}

	public Vec2 getCenter() {
		double sumX = 0;
		double sumY = 0;
		int n = 0;

		for (Vec2 point : points) {
			sumX += point.x;
			sumY += point.y;
			n++;
		}

		return new Vec2(sumX/n, sumY/n);
	}

	public void shrink() {
		Vec2 center = getCenter();

		for (Vec2 point : points) {
			point = center.sub(point);
			point.normalize();
			point.mult(scale);
		}
	}
}
