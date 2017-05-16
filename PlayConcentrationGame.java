

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class PlayConcentrationGame extends JFrame
{
 public static void main ( String [] args )
 {

  ConcentrationGame game = new ConcentrationGame();
  System.out.println(game.getSide());
  ConcentrationGameController gameGui = new ConcentrationGameController( game );
  gameGui.setSize( 800,800 );
  gameGui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
 }