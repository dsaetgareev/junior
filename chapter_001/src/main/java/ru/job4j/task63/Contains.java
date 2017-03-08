package ru.job4j.task63;

/**
*Class Contains checking string origin contains sub.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 07.03.2017
*/

public class Contains {
	
	/**
	*method boolean contains(String origin, String sub),
	*checking String origin contains String sub.
	*@param origin - string
	*@param sub - string
	*/
	public boolean contains(String origin, String sub) {
		char[] arOrigin = origin.toCharArray();
		char[] arSub = sub.toCharArray();
		int count = 0;
		int m = 0;
		for (int i = 0; i <= arOrigin.length - arSub.length; i++) {
			count = 0;
			if (arOrigin[i] == (arSub[0])) {
				m = i;
				for (int j = 0; j < arSub.length; j++, m++) {
					if (arSub[j] == arOrigin[m]) {
						count++;
					}
				}
				if (arSub.length == count) {
				return true;			
				}				
			}			
		}
		
		return false;
	}
}