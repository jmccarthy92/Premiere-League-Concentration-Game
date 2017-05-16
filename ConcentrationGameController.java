import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import java.text.*;
import static java.util.Collections.*;
//import javax.swing.*;

public class ConcentrationGameController extends JFrame

{
	private Container contents;
	private int count ;
	private int clicks = 0;
	private Timer startTimer;
	private long seconds;
	private int firstClick, secondClick;
	private GridButton [][] squares;
	private ArrayList<Card> cards = new ArrayList<>();
	private GridButton selectedSquare = null;
	private GridButton s1 = null;
	private GridButton s2 = null;
	private ConcentrationGame game = new ConcentrationGame();
	private int sides = game.getSide();
	private JLabel numberOfTries,secondsCounter;
	private JButton startOver,pause;
	private ImageIcon DefaultPicture = new ImageIcon("th.jpg");

	private ImageIcon [] pictures = { new ImageIcon("manu.jpg"),
									  new ImageIcon("arse.jpg"),
									  new ImageIcon("asto.jpg"),
									  new ImageIcon("chel.jpg"),
									  new ImageIcon("crys.jpg"),
									  new ImageIcon("ever.jpg"),
									  new ImageIcon("leic.jpg"),
									  new ImageIcon("live.jpg"),
									  new ImageIcon("manc.jpg"),
									  new ImageIcon("newc.jpg"),
									  new ImageIcon("quee.jpg"),
									  new ImageIcon("sou.jpg"),
									  new ImageIcon("sund.jpg"),
  									  new ImageIcon("swan.jpg"),
  									  new ImageIcon("tott.jpg"),
									  new ImageIcon("west.jpg"),
									  new ImageIcon("read.jpg"),
									  new ImageIcon("blac.jpg")};
	private ArrayList<ImageIcon> picList = new ArrayList<>();
	private ArrayList<Integer> picValues = new ArrayList<>();
	private ImageIcon [][] picturesList;
	public ConcentrationGameController ( ConcentrationGame game )
	{
		super( " EPL Concentration Game " );
		setUpGameGUI( );
	}



	public void setUpGameGUI( )
	{
		int pairs = 18;
		ArrayList<ImageIcon> picVals = new ArrayList<>();
		ImageIcon[] pictureList;
		int used[] = new int[18];

		for ( int x = 0; x < pairs ; x++)
		{
			picVals.add(pictures[x]);
			picVals.add(pictures[x]);
		}
		System.out.println(picVals);
		Collections.shuffle(picVals);

		contents = getContentPane( );
		setArrayList();
		setValueArrayList();
		contents.setLayout( new GridLayout(7, 6) );

		squares = new GridButton [sides][sides];
		ButtonHandler bh = new ButtonHandler();
		int v = 0;
		for( int u = 0; u < sides; u++)
		{
			for( int i = 0; i < sides; i++)
			{
				squares[u][i] = new GridButton(game.getTiles()[u][i],u,i);
				squares[u][i].setIcon(picVals.get(v));
				v++;
				//contents.add(squares[u][i]);
				//contents.add( squares[u][i]);

				//v++;
			}
		}

		for (int i = 0; i < sides*sides/2; i++)
		       used[i] = 0;
		Random rand = new Random();
		int randNumber;
		for ( int j = 0; j < sides; j++)
		{

			for( int i = 0; i < sides; i++)
			{
				count = 0;
			//	ImageIcon jj = picVals.get(v);
				//squares[j][i].setIcon();
				//v++;
				//squares[j][i].setIcon(picList.get(v));
				squares[j][i] = new GridButton( game.getTiles( )[j][i], j, i);
				do {
					randNumber = rand.nextInt(sides*sides/2);
				} while (used[randNumber] == 2);
				squares[j][i].setId(randNumber);
				used[randNumber]++;

				contents.add( squares[j][i] );
				squares[j][i].addActionListener( bh );
				//squares[j][i].setIcon(picList.get(i));
			}

		}

		startTimer = new Timer(1000, new ActionListener(){
			@Override
		public void actionPerformed(ActionEvent e) {
		seconds++;
		secondsCounter.setText("Seconds : " + seconds);
				        							}
				    								});
		startTimer.start();

		startOver = new JButton( "Start Over");
		startOver.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				startTimer.stop();
				//startTimer.restart();
				seconds = 0;
				contents.removeAll();
				setUpGameGUI();

			}});
		contents.add(startOver);


		pause = new JButton( "Pause");
		pause.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				JButton button = ( JButton) ae.getSource( );
				if(ae.getSource() == (JButton)(pause))
				{
					clicks++;
					for( int i = 0; i < sides; i++)
					{
						for(int j = 0; j < sides; j++)
						{
							if(clicks % 2 != 0)
							{
							squares[i][j].setEnabled(false);
							startTimer.stop();
							}
							else
							{
							squares[i][j].setEnabled(true);
								if(squares[i][j].getMatched() == true)
								{
									squares[i][j].setEnabled(false);
								}
							startTimer.start();
							}
						}
					}
					//startTimer.stop();
				//	for( GridButton grid: squares)
				//	{
				//		grid.setEnabled(false);
				//	}
				}

			}
		});
		contents.add(pause);

		numberOfTries = new JLabel(" # of Tries:" +count );
		contents.add(numberOfTries);

	/*	startTimer = new Timer(1000, new ActionListener(){
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        seconds++;
		            secondsCounter.setText("Seconds : " + seconds);
		        }
		    });
		    startTimer.start();*/

		//numberOfTries.setText("Number of Tries:" + count );
		secondsCounter = new JLabel("Sec counter: "   );
		contents.add(secondsCounter);

		for ( ImageIcon pics: picList);
		{
		}
		/*for ( int k = 0; k < sides; k++)
		{
			squa*/
		setVisible( true );
	}

	public boolean isGameWon()
	{
		for( int i = 0; i < sides; i++)
		{
			for(int j = 0; j < sides; j++)
			{
				if(squares[i][j].getMatched()== false)
				{
					return false;
				}
			}
		}
				return true;


	}

	public void fillSetupGameGui()
	{

	}
	public void newGame()
	{
		new ConcentrationGame();
	}

	public void setArrayList()
	{
		for ( int i = 0; i < 2; i++)
		{
			for( int ii = 0; ii < pictures.length; ii++)
			{
				picList.add(pictures[ii]);
			}
		}
		shuffle(picList);
	}

	public void doTurn(){
		 //count++;
		 if (s1 == null && s2 == null){
	        	s1 = selectedSquare;
	           // s1.setText(String.valueOf(s1.getId()));
	            s1.setIcon(pictures [s1.getId()]);
	        }

	     else if (s1 != null && s1 != selectedSquare && s2 == null)
	     	{
	           	s2 = selectedSquare;
	            s2.setIcon(pictures [s2.getId()]);
	        //    t.start();
				  checkCards();


   		     }
   		 else if (s1 != null && s1 != s2 && s2 != null){
				s1.setIcon(DefaultPicture);
				s2.setIcon(DefaultPicture);
				s1 = null;
				s2 = null;
				// s1 = selectedSquare;
			}



		 }


	  public void checkCards(){
	        if (s1.getId() == s2.getId()){//match condition
	            s1.setEnabled(false); //disables the button
	            s2.setEnabled(false);
	            s1.setMatched(true); //flags the button as having been matched
	            s2.setMatched(true);
	             if (this.isGameWon()){
					 			Object[] options = {"yes", "no"};
					 			startTimer.stop();
				               Integer s = (Integer) JOptionPane.showConfirmDialog(this,( "You win!"
															+"\n" +"You did it in" +seconds+" seconds "+ count/2 +" tries "+ " " + " " + "New Game?")
				            //  	,	JOptionPane.YES_NO_OPTION
				            //  	,	JOptionPane.QUESTION_MESSAGE
				            //  	,	null
				            ///  	,	options
				            //  	,	options[0]

				                );
				                if( s == JOptionPane.YES_OPTION)
				                {
									startTimer.stop();
													//startTimer.restart();
									seconds = 0;
									contents.removeAll();
									setUpGameGUI();
								}
								else
								{
								System.exit(0);
								}

           		 }
	            s1 = null; //reset c1 and c2
	        	s2 = null;
	           /* if (this.isGameWon()){
	                JOptionPane.showMessageDialog(this, "You win!");
	                System.exit(0);
	            }*/
	        }



    }

	public void setValueArrayList()
	{
		int pairs = 18;
		for( int x=0; x < pairs; x++)
		{
			picValues.add(x);
		}

		for( int y = 0; y < pairs; y++)
		{
			picValues.add(y);
		}
		shuffle(picValues);
	}

	private class ButtonHandler implements ActionListener
	{

		public void actionPerformed( ActionEvent ae )
		{
			Random random = new Random( );
			boolean correct = true;
			setArrayList();
			GridButton button = ( GridButton ) ae.getSource( );

			count++;
			numberOfTries.setText("# of Tries:" + count/2 );
			//button.setIcon(pictures [button.getId()]);
			selectedSquare = button;
			doTurn();

			//	private ImageIcon DefaultPicture = new ImageIcon("th.jpg");

			//button.setEnabled(false);


		}
	}

}