package com.example.chessgame;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	private GameConf gameconfig;
	private GameControl gamecontrol;
	private GameView gameview;
	private Button StartButton;
	private Button EndButton;
	private boolean isPlaying;
	private int pieceChoosen;
	private Piece selected = null;
	private AlertDialog.Builder winDialog;
	private AlertDialog.Builder lostDialog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void init(){
    	gameconfig = new GameConf(8,8,1,1,6,6);
    	gameview = (GameView) findViewById(R.id.gameview);
    	
    	
    }
    
    public void StartChessGame(){
    	
    }
    
    public void EndChessGame(){
    	
    }
}
