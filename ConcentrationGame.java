import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class ConcentrationGame
{

	private ImageIcon [][] tiles;
	private static int side = 6;



	private ImageIcon DefaultPicture = new ImageIcon("th.jpg");


	public ConcentrationGame(	)
	{
			setUpGame ( side );

	}

	public void newGame( )
	{
		new ConcentrationGame();
	}

	public void setUpGame( int side )
	{
		tiles = new ImageIcon [side][side];

		for ( int j = 0; j < side; j++ )
		{
			for( int i = 0; i < side; i++ )
			{
				tiles[j][i] = DefaultPicture;
			}
		}


	}


	public int getSide( )
	{
		side = 6;
		return side;
	}

	public ImageIcon[][] getTiles( )
	{
		ImageIcon[][] copyOfTiles = new ImageIcon[side][side];

		for ( int j = 0; j < side; j++)
		{
			for ( int i = 0; i < side; i++)
			{
				copyOfTiles[i][j] = tiles[i][j];
			}
		}
		return copyOfTiles;
	}

	public boolean tryToPlay ( int row, int col )
	{
		return true;
	}

}