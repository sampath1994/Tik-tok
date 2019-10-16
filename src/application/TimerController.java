package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TimerController {
	@FXML
	private Button set;

	@FXML
	private Button pause;
	@FXML
	private Button reset;
	@FXML
	private Button minimize;
	@FXML
	private Button close;
	
	@FXML
	private TextField time;
 
	Thread thread;
	boolean stp = false;
	
	public void initialize() {

		// TODO (don't really need to do anything here).

	}

	public void set(){
        stp = false;  
		time.getText();
		//time.setDisable(true);
		 thread = new Thread(){
			    public void run(){
			    	int i = 0;
			     while(!stp) {
			    	 System.out.println("run!");
			    	 try {
			    		 i++;
			    		 int minute = i/60;
			    		 int seconds = i%60;
			    		 setTime((minute==0?"0":String.valueOf(minute))+":"+(seconds==0?"0":String.valueOf(seconds)));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			     }
			    }
			  };

			  thread.start();
			  set.setDisable(true);
	}
	public void pause(){
		stp = true;
		set.setDisable(false);
	}
	public void reset(){
		System.out.println("clicked!!");
	}
	public void minimize(){
		System.out.println("clicked!!");
	}
	public void close(){
		System.exit(0);
	}
	
	private void setTime(String t) {
		synchronized (this) {
			time.setText(t);
		}
	}
}
