package ru.job4j.paint;

/**
*Class Paint has method piramid(int h)
*that create piramid.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 28.02.2017
*/

public class Paint {

	/**
	*method String piramid(int h).
	*@param h - height.
	*@return build.toString().
	*/

	public String piramid(int h) {
		StringBuilder build = new StringBuilder();
		for (int i = 1; i <= h; i++) {
			if ((h - i) > 0) {
				for (int j = 0; j < (h - i); j++) {
					build.append(" ");
				}
			}
			for (int k = 0; k < i; k++) {
				build.append(" ^");
			}
		}
			return build.toString();
	}
}