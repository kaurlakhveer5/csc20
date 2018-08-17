import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class transcations implements Serializable{String MyDate; int MyCheckNo; int MytrnasType; String Description; double myAmount;}
	
public class final1 implements ActionListener{
	static JTextField callAccountName;
	static JTextField callBalance;
	static JButton callCreateNewA;
	static JButton callLoadTrans;
	static JButton callAddNewTrans;
	static JButton callSearchTrans;
	static JButton callSortTrans;
	static JButton callViewDelTrans;
	static JButton callSaveToFileTrans;
	static JButton callExit;
	static JTextField callInitialBalance;
	static JTextField callAccNameInNewAcc;
	static JButton callCreateInNewAcc;
	static JButton callCancelInNewAcc;
	static JTextField callAccNameInLaodTrans;
	static JButton callCancelInLoadTrans;
	static JButton callLoadInLoadTrans;
	static JTextField callDateInLoadTrans2;
	static JComboBox callTypeInLoadTrans2;
	static JTextField callCheckNoInLoadTrans2;
	static JTextField callDescripInLoadTrans2;
	static JTextField callDebitInLoadTrans2;
	static JTextField callCreditInLoadTrans2;
	static JButton callSaveInLoadTrans;
	static JButton callTopMenuInLoadTreans;
	static JTextField callSearchTransBy;
	static JButton callSerchTrans_Search;
	static JButton callSearchTrans_TopMenu;
	static JButton callSortTrans_Sort;
	static JButton callSortTrans_TopMenu;
	static JRadioButton callSortByType;
	static JRadioButton callSortByDate;
	static JButton callTransCurrently_Dalete;
	static JButton callTransCurrently_TopMenu;
	static CardLayout contentPaneLayout;
	static JPanel contentPane;
	static JTable abtable;
	static JScrollPane scrollpane = new JScrollPane();
	static transcations [] TA = new transcations[100];
	static String[] columns = new String[] {"Date", "Trans. Type", "Check No.", "Trans Description", "Payment/Debit(-)", "Deposit/Credit(+)", "Balance"};
	static int num = 0;
	static double balance = 0;
	static String[] trnasType = {"Deposit", "Automatic Deposit", "ATM Withdrawal", "Check", "Debit Card"};
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == callCreateNewA) {contentPaneLayout.show(contentPane, "Menu2"); return;}	
		if(source == callLoadTrans) {contentPaneLayout.show(contentPane,  "Menu3"); return; }
		if(source == callAddNewTrans) {contentPaneLayout.show(contentPane, "Menu4"); return;}
		if(source == callSearchTrans) {contentPaneLayout.show(contentPane, "Menu5"); return;}
		if(source == callSortTrans) {contentPaneLayout.show(contentPane, "Menu6"); return;}
		if(source == callViewDelTrans){
			String[][] data = new String[num][7];
			//if(callInitialBalance.getText() == "")
				balance = 0;
			// How to add Initial Balance in my sheet?? else balance = Double.parseDouble(callInitialBalance.getText());
			for(int i = 0; i<num; i++) {
				data[i][0] = TA[i].MyDate;
				data[i][1] = trnasType[TA[i].MytrnasType];
				
				if(TA[i].MytrnasType == 3) 
					data[i][2] = ""+TA[i].MyCheckNo;
				else data[i][2] = "";
				
				data[i][3] = TA[i].Description;
				
				if(TA[i].MytrnasType <= 1) {
					balance+= TA[i].myAmount;
					data[i][5] = ""+ TA[i].myAmount;
					data[i][4] = "";
				}
				else {
					balance-= TA[i].myAmount;
					data[i][4] = ""+  TA[i].myAmount;
					data[i][5] = "";
				}
				
				data[i][6] = ""+ balance;
				
			}
			 abtable = new JTable(data,columns); 
			JScrollPane tmp = new JScrollPane(abtable); 
			scrollpane.setViewport(tmp.getViewport());
			contentPaneLayout.show(contentPane, "Menu7");
			return;
		}
			
			if(source == callTransCurrently_Dalete){
				 
				int selectedRow = abtable.getSelectedRow();
				System.out.println("" + selectedRow);
					for(int j = selectedRow; j<num-1; j++){
						TA[j] = TA[j+1] ;
					}
					num--;
					String[][] data = new String[num][7];
						balance = 0;
					for(int i = 0; i<num; i++) {
						data[i][0] = TA[i].MyDate;
						data[i][1] = trnasType[TA[i].MytrnasType];
						
						if(TA[i].MytrnasType == 3) 
							data[i][2] = ""+TA[i].MyCheckNo;
						else data[i][2] = "";
						
						data[i][3] = TA[i].Description;
						
						if(TA[i].MytrnasType <= 1) {
							balance+= TA[i].myAmount;
							data[i][5] = ""+ TA[i].myAmount;
							data[i][4] = "";
						}
						else {
							balance-= TA[i].myAmount;
							data[i][4] = ""+  TA[i].myAmount;
							data[i][5] = "";
						}
						
						data[i][6] = ""+ balance;
						
					}
					 abtable = new JTable(data,columns); 
					JScrollPane tmp = new JScrollPane(abtable); 
					scrollpane.setViewport(tmp.getViewport());
					contentPaneLayout.show(contentPane, "Menu7");
					
					
					return;
			}
				
			
			
			
			
		
		if(source == callExit) {System.exit(0); return;}
		if(source == callCancelInLoadTrans) {contentPaneLayout.show(contentPane, "Menu1"); return;}
		if(source == callCancelInNewAcc) {contentPaneLayout.show(contentPane, "Menu1"); return;}
		if(source == callTopMenuInLoadTreans) {contentPaneLayout.show(contentPane, "Menu1"); return;}
		if(source == callSearchTrans_TopMenu) {contentPaneLayout.show(contentPane, "Menu1"); return;}
		if(source == callSortTrans_TopMenu) {contentPaneLayout.show(contentPane, "Menu1"); return;}
		if(source == callTransCurrently_TopMenu) {contentPaneLayout.show(contentPane, "Menu1"); return;}
		
		if(source == callCreateInNewAcc) { callAccountName.setText(callAccNameInNewAcc.getText());
			callBalance.setText(callInitialBalance.getText());
			balance = Double.parseDouble(callInitialBalance.getText());
			transcations T  = new transcations(); T.Description = " Intial Balance"; T.myAmount = balance; T.MytrnasType = 0; T.MyDate = ""; num = 1; 
			TA[0] = T;
			contentPaneLayout.show(contentPane, "Menu1");
			
			return;
		}
		if(source == callSaveInLoadTrans) {
			transcations T = new transcations();
			T.MyDate = callDateInLoadTrans2.getText();
			T.MytrnasType = callTypeInLoadTrans2.getSelectedIndex();
			if(T.MytrnasType <= 1){
				T.myAmount = Double.parseDouble(callCreditInLoadTrans2.getText());}
			else {T.myAmount =  Double.parseDouble(callDebitInLoadTrans2.getText());} 
			
			
			
			if(T.MytrnasType == 3)
					T.MyCheckNo = (int)(Double.parseDouble(callCheckNoInLoadTrans2.getText()));
			T.Description = callDescripInLoadTrans2.getText();
			TA[num++] = T;
			callDateInLoadTrans2.setText(""); 
			callCreditInLoadTrans2.setText("");
			callDebitInLoadTrans2.setText("");
			callCheckNoInLoadTrans2.setText("");
			callDescripInLoadTrans2.setText(""); return;	
		}
	
		if(source == callSaveToFileTrans){
			try {	
				FileOutputStream fos = new FileOutputStream (callAccountName.getText(), false);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for (int i = 0 ; i < num; i++){
					oos.writeObject(TA[i]);}
					oos.close();
			} catch(FileNotFoundException e1){ System.out.println(e1.toString());
			} catch(IOException e1){ e1.printStackTrace();}
			return;
		}
	

				
			
			
	if(source == callLoadInLoadTrans){
		transcations T;
		try {
			FileInputStream fis = new FileInputStream (callAccNameInLaodTrans.getText());
			ObjectInputStream ois = new ObjectInputStream(fis);
				num = 0; balance = 0;
				while (true) {
					T = (transcations) ois.readObject();
					
				
					TA[num] = T; if(T.MytrnasType <= 1){ balance += T.myAmount;} else {balance -= T.myAmount;} num ++;
				}		
				
				
		}catch(EOFException e2){callAccountName.setText(callAccNameInLaodTrans.getText()); callBalance.setText("" + balance);
		} catch(Exception e2){ e2.printStackTrace();
		}
	
		contentPaneLayout.show(contentPane, "Menu1"); return;
	
	}
	
}
	
	public static void main(String[] args) { 
		ActionListener AL = new final1 ();
		JFrame frame = new JFrame("CheckBook");
		contentPane = (JPanel)frame.getContentPane();
		
		contentPane.setLayout(contentPaneLayout = new CardLayout());
		
		
		JPanel menu1 = new JPanel(new BorderLayout());
		menu1.add(new JLabel("<html><font size=5><b> Use the Buttons below to Manage the Transcations </b></html>", JLabel.CENTER), BorderLayout.NORTH);
		JPanel centeraPane = new JPanel(new FlowLayout());
		
		centeraPane.add( new JLabel("Account Name"));
		centeraPane.add(callAccountName = new JTextField("", 10)); 
		centeraPane.add(new JLabel("Balance: ")); 
		centeraPane.add(callBalance = new JTextField("", 10)); 
		callBalance.setHorizontalAlignment(JTextField.RIGHT);
		JPanel southPane = new JPanel(new GridLayout(2, 4, 2, 2));
		southPane.add(callCreateNewA = new JButton("Create New Account")); callCreateNewA.addActionListener(AL);
		southPane.add(callLoadTrans = new JButton("Load Trans from a file")); callLoadTrans.addActionListener(AL);
		southPane.add(callAddNewTrans = new JButton("Add new Transcation")); callAddNewTrans.addActionListener(AL);
		southPane.add(callSearchTrans = new JButton("Search Transcation")); callSearchTrans.addActionListener(AL);
		southPane.add(callSortTrans = new JButton("Sort Transcations")); callSortTrans.addActionListener(AL);
		southPane.add(callViewDelTrans = new JButton("View/Delete Transcations")); callViewDelTrans.addActionListener(AL);
		southPane.add(callSaveToFileTrans = new JButton("Save Trans to a file")); callSaveToFileTrans.addActionListener(AL);
		southPane.add(callExit = new JButton("Exit")); callExit.addActionListener(AL);
		menu1.add(centeraPane, BorderLayout.CENTER);
		menu1.add(southPane, BorderLayout.SOUTH);
		
		contentPane.add("Menu1" , menu1);
		contentPaneLayout.show(contentPane, "Menu1");
		//*************************Menu1 Done*****************************************************
		//*************************Menu1 Done*****************************************************
		
		JPanel menu2 = new JPanel(new GridLayout(0, 1));
		menu2.add(new JLabel("<html><font size=4><b> Create a New Account </b></html>", JLabel.CENTER));
		JPanel Pane21 = new JPanel(new FlowLayout());
		Pane21.add( new JLabel("Account Name:"));
		Pane21.add(callAccNameInNewAcc = new JTextField("", 10)); callAccNameInNewAcc.addActionListener(AL);
		JPanel Pane22 = new JPanel(new FlowLayout());
		Pane22.add(new JLabel("Initial Balance: "));
		Pane22.add(callInitialBalance = new JTextField("", 10)); callInitialBalance.addActionListener(AL);
		JPanel twoButtons = new JPanel(new FlowLayout());
		twoButtons.add(callCreateInNewAcc = new JButton("Create")); callCreateInNewAcc.addActionListener(AL);
		twoButtons.add(callCancelInNewAcc = new JButton("Cancel")); callCancelInNewAcc.addActionListener(AL);
		menu2.add(Pane21);
		menu2.add(Pane22);
		menu2.add(twoButtons);
		contentPane.add("Menu2" , menu2);
		//*************************Menu2 Done*****************************************************
		//*************************Menu2 Done*****************************************************
		
		JPanel menu3 = new JPanel(new GridLayout(0, 1));
		menu3.add(new JLabel("<html><font size=4><b> Load Transcations From a File </b></html>", JLabel.CENTER));
		JPanel Pane31 = new JPanel(new FlowLayout());
		Pane31.add( new JLabel("Account Name:"));
		Pane31.add(callAccNameInLaodTrans = new JTextField("", 10)); callAccNameInLaodTrans.addActionListener(AL);
		JPanel twoButtons3 = new JPanel(new FlowLayout());
		twoButtons3.add(callLoadInLoadTrans = new JButton("Load")); callLoadInLoadTrans.addActionListener(AL);
		twoButtons3.add(callCancelInLoadTrans = new JButton("Cancel")); callCancelInLoadTrans.addActionListener(AL);
		menu3.add(Pane31);
		menu3.add(twoButtons3);
		contentPane.add("Menu3" , menu3);
		//*************************Menu3 Done*****************************************************
		//*************************Menu3 Done*****************************************************
		
		JPanel menu4 = new JPanel(new GridLayout(2, 1));
		JPanel east4 = new JPanel(new GridLayout(0,1));
		JPanel east42 = new JPanel(new GridLayout(0,1));
		east4.add(new JLabel("Date", SwingConstants.RIGHT)); 
		east42.add(callDateInLoadTrans2 = new JTextField("", 20)); callDateInLoadTrans2.addActionListener(AL);
		east4.add(new JLabel("Trans.Type", SwingConstants.RIGHT));
		
		east42.add(callTypeInLoadTrans2 = new JComboBox(trnasType));
		callTypeInLoadTrans2.setSelectedIndex(4);
		east4.add(new JLabel("Check No.", SwingConstants.RIGHT)); 
		east42.add(callCheckNoInLoadTrans2 = new JTextField("", 20)); callCheckNoInLoadTrans2.addActionListener(AL);
		east4.add(new JLabel("Trans. Description", SwingConstants.RIGHT));
		east42.add(callDescripInLoadTrans2 = new JTextField("", 20)); callDescripInLoadTrans2.addActionListener(AL);
		east4.add(new JLabel("Payment/Debit(-)", SwingConstants.RIGHT));
		east42.add(callDebitInLoadTrans2 = new JTextField("", 20)); callDebitInLoadTrans2.addActionListener(AL);
		east4.add(new JLabel("Deposit/Credit(+)", SwingConstants.RIGHT));
		east42.add(callCreditInLoadTrans2 = new JTextField("", 20)); callCreditInLoadTrans2.addActionListener(AL);
		JPanel twoButtons4 = new JPanel(new FlowLayout());
		twoButtons4.add(callSaveInLoadTrans = new JButton("Save New Transaction")); callSaveInLoadTrans.addActionListener(AL);
		twoButtons4.add(callTopMenuInLoadTreans = new JButton("Top Menu")); callTopMenuInLoadTreans.addActionListener(AL);
		
		menu4.add(east4);
		menu4.add(east42);
		menu4.add(twoButtons4);
		contentPane.add("Menu4" , menu4);
		
		//*************************Menu4 Done*****************************************************
		//*************************Menu4 Done*****************************************************
		
		JPanel menu5 = new JPanel(new BorderLayout());
		menu5.add(new JLabel("<html><font size=4><b> Search Transcations by Transcation Date/Type/Check No./Description </b></html>", JLabel.CENTER), BorderLayout.NORTH);
		
		//Object[][] Data = new Object[1][7];
		//JTable heading = new JTable();
		menu5.add(scrollpane,BorderLayout.CENTER);
		JPanel Pane51 = new JPanel(new FlowLayout());
		Pane51.add(new JLabel("Search String:"));
		Pane51.add(callSearchTransBy = new JTextField("", 20));callSearchTransBy.addActionListener(AL);
		JPanel twoButtons5 = new JPanel(new FlowLayout());
		twoButtons5.add(callSerchTrans_Search = new JButton("Search"));callSerchTrans_Search.addActionListener(AL);
		twoButtons5.add(callSearchTrans_TopMenu = new JButton("Top Menu"));callSearchTrans_TopMenu.addActionListener(AL);
		Pane51.add(twoButtons5);
		
		menu5.add(scrollpane,BorderLayout.CENTER);
		menu5.add(Pane51, BorderLayout.SOUTH);
		contentPane.add("Menu5" , menu5);
		
		//*************************Menu5 Done*****************************************************
		//*************************Menu5 Done*****************************************************
				
		JPanel menu6 = new JPanel(new GridLayout(0, 1));
		menu6.add(new JLabel("<html><font size=5><b> Sort Transcations </b></html>", JLabel.CENTER));
		JPanel Pane61 = new JPanel(new FlowLayout());
		Pane61.add(callSortByType = new JRadioButton("By Type"));callSortByType.addActionListener(AL);
		Pane61.add(callSortByType = new JRadioButton("By Date"));callSortByType.addActionListener(AL);
		JPanel twoButtons6 = new JPanel(new FlowLayout());
		twoButtons6.add(callSortTrans_Sort = new JButton("Sort"));callSortTrans_Sort.addActionListener(AL);
		twoButtons6.add(callSortTrans_TopMenu = new JButton("Top Menu"));callSortTrans_TopMenu.addActionListener(AL);
		menu6.add(Pane61);
		menu6.add(twoButtons6);
		contentPane.add("Menu6" , menu6);
		//*************************Menu6 Done*****************************************************
		//*************************Menu6 Done*****************************************************
		
		JPanel menu7 = new JPanel(new BorderLayout());
		menu7.add(new JLabel("<html><font size=5><b> Transcations Currently in The Checkbook </b></html>", JLabel.CENTER), BorderLayout.NORTH);		
		menu7.add(scrollpane,BorderLayout.CENTER);
		
		JPanel twoButtons7 = new JPanel(new FlowLayout());
		
		twoButtons7.add(callTransCurrently_Dalete = new JButton("Delete Selected"));callTransCurrently_Dalete.addActionListener(AL);
		twoButtons7.add(callTransCurrently_TopMenu = new JButton("Top Menu"));callTransCurrently_TopMenu.addActionListener(AL);
		
		
		menu7.add(twoButtons7,BorderLayout.SOUTH);
		contentPane.add("Menu7" , menu7);
		//*************************Menu7 Done*****************************************************
		//*************************Menu7 Done*****************************************************
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 300);
		frame.pack();
	}
}
