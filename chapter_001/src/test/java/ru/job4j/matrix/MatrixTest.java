package ru.job4j.matrix;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Class MatrixTest checking threads int[][] rotateLeft() and int[][] rotateRigtht().
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 03.03.2017
*/
public class MatrixTest {

	/**
	*thread void whenMatrixThenRotateLeftMatrix().
	*/
	@Test
	public void whenMatrixThenRotateLeftMatrix() {
		Matrix matrix = new Matrix();
		int[][] value = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] afterRotateLeft = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
		assertThat(matrix.rotateLeft(value), is(afterRotateLeft));
	}
	/**
	*thread void whenMatrixThenRotateRightMatrix().
	*/
	@Test
	public void whenMatrixThenRotateRightMatrix() {
		Matrix matrix = new Matrix();
		int[][] value = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] afterRotateRight = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertThat(matrix.rotateRight(value), is(afterRotateRight));
	}
}