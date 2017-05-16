import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;


import javax.swing.JButton;

public class GridButton extends JButton
{
 private int row;
 private int column;
 private int id;
 private boolean matched = false;

 public GridButton( ImageIcon title, int newRow, int newColumn )
 {
  super( title );
  setRow( newRow );
  setColumn( newColumn );
 }

 public void setMatched( boolean matched)
 {
	 this.matched = matched;
 }

 public boolean getMatched()
 {
	 return this.matched;
 }


 public void setId( int id)
 {
	 this.id = id;
 }

 public int getId()
 {
	return this.id;
 }

 public int getRow( )
 {
   return row;
 }

 public int getColumn( )
 {
   return column;
 }

 public void setRow( int newRow )
 {
   if ( newRow >= 0 )
     row = newRow;
 }

 public void setColumn( int newColumn )
 {
   if ( newColumn >= 0 )
     column = newColumn;
 }
}