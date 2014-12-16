package com.example.chessgame;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
        static ImageView[][] g_gameView = new ImageView[10][10];
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
	GenerateTable();                       //生成ImageView数组.
        init();
    }

    public void GenerateTable() {
        float scale;
        int iHeight;
        int iWidth;
        TableLayout gameView = (TableLayout)findViewById(R.id.GameView);
        scale = this.getResources().getDisplayMetrics().widthPixels;  
        iHeight = iWidth = (int) (scale / 9);
        for(int i = 0; i < 9; i++) {
        	TableRow row = new TableRow(this);
        	for(int j = 0; j < 9; j++) {
        		g_gameView[i][j] = new ImageView(this);
        		g_gameView[i][j].setMaxHeight(iHeight);
        		g_gameView[i][j].setMaxWidth(iWidth);
        		g_gameView[i][j].setAdjustViewBounds(true);
        		g_gameView[i][j].setImageResource(R.drawable.range);
        		row.addView(g_gameView[i][j]);
        	}
            gameView.addView(row);
        }
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
    	
    	gamecontrol = new GameControlImpl(gameconfig);
    	gameview.setGameControl(gamecontrol);
    	
    	StartButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				StartChessGame();
				
			}
		});
    	
    	EndButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EndChessGame();
				
			}
		});
    	
    	this.gameview.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(!isPlaying){
					return false;
				}
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					gameViewTouchDown(event);
				}
				if(event.getAction() == MotionEvent.ACTION_UP){
					gameViewTouchUp(event);
				}
				return true;
			}
		});
    }
    
    private void gameViewTouchDown(MotionEvent event) {
    	int turn = gamecontrol.getTurn();
    	Hero currentHero;
    	Hero enemy;
    	if(turn == 1){
    		currentHero = gamecontrol.getM_hero();
    		enemy = gamecontrol.getE_hero();
    	}
    	else{
    		currentHero = gamecontrol.getE_hero();
    		enemy = gamecontrol.getM_hero();
    	}
    	
    	float touchX = event.getX();
    	float touchY = event.getY();
    	Piece currentPiece = gamecontrol.findPiece(touchX, touchY);
    	if(currentPiece == null){
    		return;
    	}
    	else if(currentPiece.getFlag() == turn){
    		return;
    	}
    	else if(currentPiece.getFlag() == 0){
    		if(MoveMethod(currentHero,currentPiece,turn)){
    			gamecontrol.setTurn(3-turn);
    		}
    	}
    	else if(currentPiece.getFlag() == (3-turn)){
    		if(AttackMethod(currentHero, currentPiece,enemy)){
    			gamecontrol.setTurn(3-turn);
    		}
    	}
		
	}
    
    private Boolean MoveMethod(Hero hero,Piece piece,int turn){
    	if(calaLength(hero.getPosX(), hero.getPosY(), piece.getIndexX(), piece.getIndexY()) <= hero.getMove_range()){
    		Piece[][] pieces = gamecontrol.getPieces();
    		pieces[hero.getPosX()][hero.getPosY()].setFlag(0);
    		pieces[piece.getIndexX()][piece.getIndexY()].setFlag(turn);
    		hero.setPosX(piece.getIndexX());
    		hero.setPosY(piece.getIndexY());
    		return true;
    	}
    	else{ 
    		return false;
    	}
    }
    
    private Boolean AttackMethod(Hero hero,Piece piece,Hero attackedHero){
    	if(calaLength(hero.getPosX(), hero.getPosY(), piece.getIndexX(), piece.getIndexY()) <= hero.getAttack_range()){
    		attackedHero.Damage(hero.getAttack());
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public int calaLength(int x1,int y1,int x2,int y2){
    	return(Math.abs(x1-x2)+Math.abs(y1-y2));
    }
    
    private void gameViewTouchUp(MotionEvent event){
    	this.gameview.postInvalidate();
    }
    
    public void StartChessGame(){
    	gameview.StartGame();
    }
    
    public void EndChessGame(){
    	
    }
}
