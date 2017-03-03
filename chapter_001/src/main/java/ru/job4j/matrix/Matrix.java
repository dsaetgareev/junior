package ru.job4j.matrix;

/**
*Class Matrix has thread int[][] rotateLeft() and int[][] rotateRight()
*that rotate matrix.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 03.03.2017
*/

public class Matrix {

	/**
	*thread int[][] rotateLeft(int[][] value).
	*@param value - int[][]
	*@return value - changed matrix
	*/
	public int[][] rotateLeft(int[][] value) {
		/**
		*int var - temporary variable.
		*/
		int var;
		/**
		*int m - value length.
		*/
		int m = value.length;
		for (int i = 0; i != m / 2; i++) {
			for (int j = 0; j != m - 1 - i; j++) {
				var = value[i][j];
				value[i][j] = value[j][m - 1 - i];
				value[j][m - 1 - i] = value[m - 1 - i][m - 1 - j];
				value[m - 1 - i][m - 1 - j] = value[m - 1 - j][i];
				value[m - 1 - j][i] = var;
			}
		}
		return value;
	}

	/**
	*thread int[][] rotateRight(int[][] value).
	*@param value - int[][]
	*@return value - changed matrix
	*/
	public int[][] rotateRight(int[][] value) {
		/**
		*int var - temporary variable.
		*/
		int var;
		/**
		*int m - value length.
		*/
		int m = value.length;
		for (int i = 0; i != m / 2; i++) {
			for (int j = 0; j != m - 1 - i; j++) {
				var = value[i][j];
				value[i][j] = value[m - 1 - j][i];
				value[m - 1 - j][i] = value[m - 1 - i][m - 1 - j];
				value[m - 1 - i][m - 1 - j] = value[j][m - 1 - i];
				value[j][m - 1 - i] = var;
			}
		}
		return value;
	}
}