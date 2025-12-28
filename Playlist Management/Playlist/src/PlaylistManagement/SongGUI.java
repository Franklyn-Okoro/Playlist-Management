package PlaylistManagement;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SongGUI extends JFrame implements ActionListener{
	
	JLabel songlb, durationlb, statisticlb, statisticlb2;
	JTextField songtf, durationtf;
	JCheckBox option1, option2;
	ButtonGroup group;
	JPanel toppnl, centerpnl, bottompnl;
	JTextArea textarea;
	JButton addbtn, statisticbtn, clearAllbtn;
	
	ArrayList<Song> songs = new ArrayList<Song>();
	
	public SongGUI() {
		super("Playlist Management");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		songlb = new JLabel("Song Name");
		durationlb = new JLabel("Duration");
		statisticlb = new JLabel("Duration of the playlist is 0.0 ");
	
		option1 = new JCheckBox("Pop");
		option2 = new JCheckBox("Rock");
		songtf= new JTextField(20);
		durationtf = new JTextField(15);
		
		option1.setSelected(true);
		
		addbtn = new JButton("Add Song");
		statisticbtn = new JButton("Statistic");
		clearAllbtn = new JButton("Clear All");
		
		toppnl = new JPanel();
		centerpnl = new JPanel();
		bottompnl = new JPanel();	
		
		centerpnl.setBorder(new TitledBorder("Playlist : "));
		toppnl.add(songlb);
		toppnl.add(songtf);
		toppnl.add(durationlb);
		toppnl.add(durationtf);
		toppnl.add(option1);
		toppnl.add(option2);
		toppnl.add(addbtn);
		
		textarea = new JTextArea(10,80);
		JScrollPane pane = new JScrollPane(textarea);
		centerpnl.add(pane);
		
		bottompnl.add(clearAllbtn);
		bottompnl.add(statisticbtn);
		bottompnl.add(statisticlb);
		
		add(toppnl, BorderLayout.NORTH);
		add(centerpnl, BorderLayout.CENTER);
		add(bottompnl, BorderLayout.SOUTH);
		
		addbtn.addActionListener(this);
		statisticbtn.addActionListener(this);
		clearAllbtn.addActionListener(this);
		
		this.pack();
		this.setVisible(true);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SongGUI win = new SongGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Add Song")) {
			if ((!songtf.getText().isEmpty()) && (!durationtf.getText().isEmpty())) {
				String cat = "";
				if (option1.isSelected()==true)
					cat = cat + option1.getText();
				if (option2.isSelected()==true)
					if (!cat.isEmpty())
						cat = cat+ " & " + option2.getText();
					else
						cat = option2.getText();
				
				Song song = new Song(songtf.getText(), Double.parseDouble(durationtf.getText()), cat);
				songs.add(song);
				
				textarea.append(song.toString() + "\n");
				
				songtf.setText("");
				durationtf.setText("");
				option1.setSelected(true);	
			}
			
		}else if (e.getActionCommand().equals("Statistic")) {//statistic
			double total =0;
			int count =0;
			for (Song t: songs) {
				
					total = total + t.getDuration();
					
				}
				
			statisticlb.setText("Duration of the playlist is " + String.valueOf(total));
			} else {// clear all
				textarea.setText("");
				songs.clear();
				option1.setSelected(true);
				option2.setSelected(false);
				statisticlb.setText("Duration of the playlist is 0.0");		
			}
		}
	}


