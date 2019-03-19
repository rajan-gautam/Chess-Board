import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChessBoard {

	//private static Square [][] board = new Square[8][8];

	public static void main(String args[]) {
		int[] alreadyClicked = new int[64];
		int row =0;
		int column = 0;

		JFrame mainFrame = new JFrame("Knights Table"); //Jframe

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout mainGrid = new GridLayout(8,8);
		mainFrame.setLayout(mainGrid);
		mainFrame.setSize(600,600);

		for(int i =0 ; i < 64; i++){	        	
			JButton button = new JButton(); //create btn
			button.setActionCommand(Integer.toString(i));
			button.addActionListener(new ActionListener() { //action listener
				@Override
				public void actionPerformed(ActionEvent e) {
					button.setBackground(Color.GREEN);

					int j = 0;
					boolean cont = true;
					while(cont)
					{
						//check if number exists in array
						if(alreadyClicked[j] == Integer.parseInt(e.getActionCommand()))                     {
							System.out.println(e.getActionCommand() + " is already clicked");
							j = 0;
							cont = false;
						}
						else{
							if(alreadyClicked[j] == 0){
								alreadyClicked[j] = Integer.parseInt(e.getActionCommand());
								cont = false;
							}
							j++;
						}
					}
					
				}
			});
				//when it reaches the end of row, resets to 0 and next column
			if(row == 8) 
			{
				column++;
				row = 0;
			}

			//setting tile color
			if(column %2 == 0){					
				if(row %2 ==0) button.setBackground(Color.WHITE);
				else button.setBackground(Color.BLACK);
			}
			else
			{if(row %2 !=0)
					button.setBackground(Color.WHITE);
				else
					button.setBackground(Color.BLACK);
			}
			row++;
			mainFrame.add(button);
		}

		System.out.println(alreadyClicked);
		mainFrame.setVisible(true);



	}
}






