package com.example.chessgame;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	private GameConf gameconfig;
	private GameControl gamecontrol;
	private GameView gameview;
	private Button StartButton;
	private Button EndButton;
	private Button ReplayButton;
	private TableLayout tableView;

	private TextView m_HeroName;
	private TextView e_HeroName;
	private TextView m_HeroHP;
	private TextView e_HeroHP;
	
	
	
	private boolean isPlaying;
	//private Piece selected = null;
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
    
    @SuppressLint("ClickableViewAccessibility")
	public void init(){

    	InitArgumentsAll();    	
    	
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
    	
    	ReplayButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Replay();
			}
		});
    	
    	this.tableView.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(!isPlaying){
					return false;
				}
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					gameViewTouchDown(event);
					gameview.UpdateAppearance();
					ShowHeroInfo();
					isGameOver();
				}
				if(event.getAction() == MotionEvent.ACTION_UP){
					gameViewTouchUp(event);
				}
				
				return true;
			}
		});
    
    	winDialog = createDialog("Success", "You win! Play again!", 
    								R.drawable.win);

    	winDialog.setNegativeButton("No",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				isPlaying = false;
				return;
			}
		});
    	winDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Replay();
			}
		});
    	
    	lostDialog = createDialog("Lost", "You Lose! Play again!", R.drawable.lose);

    	
    	lostDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				isPlaying = false;
				return;
			}
		});
    	lostDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Replay();
			}
		});
    }
    
    private void InitArgumentsAll() {
    	tableView = (TableLayout)findViewById(R.id.GameView);
    	SetGameConfig();  	
    	
    	gameview = new GameView(this,gamecontrol,tableView);
    	
    	StartButton = (Button) this.findViewById(R.id.StartButton);
    	EndButton = (Button) this.findViewById(R.id.EndButton);
    	ReplayButton = (Button) this.findViewById(R.id.Replay);
    	
    	m_HeroName = (TextView) this.findViewById(R.id.M_HeroName);
    	e_HeroName = (TextView) this.findViewById(R.id.E_HeroName);
    	m_HeroHP = (TextView) this.findViewById(R.id.M_HeroHP);
    	e_HeroHP = (TextView) this.findViewById(R.id.E_HeroHP);
	}
    
    private void SetGameConfig(){
    	gameconfig = new GameConf();  
    	gamecontrol = new GameControlImpl(gameconfig);
    }
    
    private void gameViewTouchUp(MotionEvent event) {
		
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
   
    
    public void StartChessGame() {
    	if(isPlaying){
    		return;
    	}
		isPlaying = true;
		this.gameview.UpdateAppearance();
		ShowHeroInfo();
	}
    
    public void EndChessGame(){
    	System.exit(0);
    }
    
    public void Replay() {
		ResetAll();
	}
    
    public void ResetAll() {
		isPlaying = true;
		gameview.ResetTable();
		gameconfig.SetMyHero();
		gameconfig.SetEnemyHero();
		gamecontrol.ResetAll(gameconfig);
		this.gameview.UpdateAppearance();
		ShowHeroInfo();
	}
    
    public void ShowHeroInfo(){
		String m_Name,e_Name;
		String m_HP,e_HP;
		
		m_Name = gamecontrol.getM_hero().getName();
		m_HP = "HP:"+gamecontrol.getM_hero().getHealth();
		e_Name = gamecontrol.getE_hero().getName();
		e_HP = "HP:"+gamecontrol.getE_hero().getHealth();
		
		m_HeroName.setText(m_Name);
		e_HeroName.setText(e_Name);
		
		m_HeroHP.setText(m_HP);
		e_HeroHP.setText(e_HP);
    }
    
    private void isGameOver(){
    	if(gamecontrol.getM_hero().isDead()){
    		this.lostDialog.show();
    		isPlaying = false;
    		return;
    	}
    	if(gamecontrol.getE_hero().isDead()){
    		this.winDialog.show();
    		isPlaying = false;
    		return;
    	}
    }
    
    private AlertDialog.Builder createDialog(String title,String message,int image){
    	return new AlertDialog.Builder(this).setTitle(title).setMessage(message).setIcon(image);
    }
}
